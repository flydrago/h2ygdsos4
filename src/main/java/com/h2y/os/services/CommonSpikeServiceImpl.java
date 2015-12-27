package com.h2y.os.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.basic.WbsKeys.SpikeKeys;
import com.h2y.os.dao.ICommonActivityDao;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.entity.SysUnits;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.JSONUtil;

/**
 * 秒杀活动
 * @author sunfj
 *
 */
@Service("commonSpikeService")
public class CommonSpikeServiceImpl implements ICommonSpikeService{

	@Autowired
	private ICommonDao commonDao;

	@Autowired
	private ICommonActivityDao commonActivityDao;

	private final static Logger logger = Logger.getLogger(CommonSpikeServiceImpl.class);




	/**
	 * 获取秒杀活动商品列表
	 * 若商品不限制购买总数量，查询语句默认处理总数量和剩余数量为99，若需修改可以修改查询语句
	 * spikeEvent 0当场秒杀  1下场秒杀
	 */
	public Map<String, Object> getCommonSpikeGoodsList(
			Map<String, Object> reqMap) {

		//返回结果
		Map<String,Object> result = new HashMap<String, Object>();

		//结果
		Map<String,Object> resultMap = new HashMap<String, Object>();

		//请求参数
		Map<String,Object> params = new HashMap<String, Object>();

		//当前活动
		Map<String,Object> activityMap = new HashMap<String, Object>();

		//倒计时map
		Map<String,Object> countdownMap = new HashMap<String, Object>();

		try{

			List<Map<String,Object>> commonSpikeGoodsList = new ArrayList<Map<String,Object>>();

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			//区域
			String zoneCode = paraMap.get(JydKeys.zoneCode.value())+"";

			//0本场秒杀 1下场预告
			String spikeEvent=paraMap.get(SpikeKeys.spikeEvent.value())+"";

			String sortname = paraMap.get("sortname")+"";//排序字段 sellRate:销量、price:价格
			String sortorder = paraMap.get("sortorder")+"";//排序方式 asc desc

			int page = 1;
			int pagesize = 20;
			if(null != paraMap.get("page") && !"".equals(paraMap.get("page")+"")){
				page = Integer.parseInt(paraMap.get("page")+"");
			}		
			if(null != paraMap.get("pagesize") && !"".equals(paraMap.get("pagesize")+"")){
				pagesize = Integer.parseInt(paraMap.get("pagesize")+"");
			}


			//获取单位信息
			Map<String,Object> corpParams = new HashMap<String, Object>();
			corpParams.put("unitType", 0);
			corpParams.put("zoneCode", zoneCode);
			//判断当前区域是否开通
			List<SysUnits> unitsList = commonDao.getListByZoneCodeAndUnitType(corpParams);

			if (null==unitsList || unitsList.isEmpty()) {//没有当前单位
				return DataResponseUtil.getResultData(reqMap, 0 , "当前区域暂不支持此服务！");
			}

			SysUnits sysUnits = unitsList.get(0);
			if (sysUnits.getUnitType()!=0) {//当前单位不是区域代理
				return DataResponseUtil.getResultData(reqMap, 0 , "当前单位不是区域代理！");
			}


			//获取当前秒杀活动
			params.put("page",page);
			params.put("pagesize", pagesize);
			params.put("unitId", sysUnits.getId());
			params.put("unitType", sysUnits.getUnitType());
			params.put("dataType", 0);//0：活动、1：主题

			//防注入处理
			if (!sortname.equals("sellRate") && !sortname.equals("price")) {
				sortname = null;
			}else {
				sortname = sortname.equals("sellRate")?"gp.sell_rate":"gp.activity_price";
			}

			if (!sortorder.equals("desc") && !sortorder.equals("asc")) {
				sortorder = null;
			}else {
				sortorder = sortorder.equals("desc")?"desc":"asc";
			}
			params.put("sortname", sortname);
			params.put("sortorder", sortorder);

			List<Map<String,Object>> list = commonActivityDao.getCommonSpikeList(params);		
			if(null == list || list.isEmpty() || list.size() == 0){
				return DataResponseUtil.getResultData(reqMap, 2 , "暂时无秒杀活动！",resultMap);
			}else{
				//当前时间
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String timeNow=format.format(date);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				//当前时间
				Date now = df.parse(timeNow);
				Date start = null;
				Date end = null;
				long t;


				if(null != spikeEvent && !"".equals(spikeEvent) && "1".equals(spikeEvent)){
					if(list.size()>1){
						//获取下场秒杀活动商品列表
						activityMap = list.get(1);
						params.put("dataId", activityMap.get("id"));
						commonSpikeGoodsList = commonActivityDao.getCommonNextSpikeGoodsList(params);
					}else{
						return DataResponseUtil.getResultData(reqMap, 2 , "暂无下场预告！",resultMap);
					}

				}else{
					//获取当前秒杀活动商品列表
					activityMap = list.get(0);
					params.put("dataId", activityMap.get("id"));

					//活动即将开始 可能获取不到商品列表
					commonSpikeGoodsList = commonActivityDao.getCommonSpikeGoodsList(params);

					//开始时间
					start=df.parse(format.format(activityMap.get("startDate")));
					//结束时间
					end = df.parse(format.format(activityMap.get("endDate")));

					//活动即将开始					
					if(start.getTime() > now.getTime()){
						t=(start.getTime()-now.getTime())/1000;
						//活动即将开始  秒杀活动将显示两天以内的 商品列表
						if((null == commonSpikeGoodsList || commonSpikeGoodsList.isEmpty()) && t/3600 <= 48){
							commonSpikeGoodsList = commonActivityDao.getCommonNextSpikeGoodsList(params);
						}
					}

				}


				//开始时间
				start=df.parse(format.format(activityMap.get("startDate")));
				//结束时间
				end = df.parse(format.format(activityMap.get("endDate")));
				//如果活动开始则获取距本场结束时间		   	
				if (start.getTime() < now.getTime() && end.getTime() >= now.getTime()) {
					countdownMap.put("title", activityMap.get("title"));
					t=end.getTime()-now.getTime();
					countdownMap.put("timeText", "距结束");
					countdownMap.put("timeFlag", "1");
				} else {//活动开始则获取距本场开始时间
					countdownMap.put("title", activityMap.get("title"));
					t=start.getTime()-now.getTime();
					countdownMap.put("timeText", "距开始");
					countdownMap.put("timeFlag", "0");
				}


				if(t<0){
					t = 0;
				}

				countdownMap.put("timeCount", t/1000);
				resultMap.put("countdownMap", countdownMap);


				if(null == commonSpikeGoodsList || commonSpikeGoodsList.isEmpty() || commonSpikeGoodsList.size()==0){
					return DataResponseUtil.getResultData(reqMap, 2 , "暂无数据！",resultMap);
				}else{
					resultMap.put("commonSpikeGoodsList", commonSpikeGoodsList);
					result = DataResponseUtil.getResultData(reqMap, 1 , "数据获取成功！",resultMap);
				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0 , "数据获取失败！",resultMap);
		}


		return result;
	}



}
