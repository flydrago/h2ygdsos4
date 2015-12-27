package com.h2y.os.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.basic.WbsKeys.UnitKeys;
import com.h2y.os.dao.ICommonActivityDao;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.dao.IGoodsDao;
import com.h2y.os.entity.SysUnits;
import com.h2y.os.util.SysBaseUtil;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.JSONUtil;

/**
 * 类描述：一般活动业务接口实现类（白酒促销、红酒促销等）      
 * 作者：侯飞龙
 * 时间：2015年1月9日下午3:40:45
 * 邮件：1162040314@qq.com
 */
@Service("commonActivityService")
public class CommonActivityServiceImpl implements ICommonActivityService {

	@Autowired
	protected ICommonActivityDao commonActivityDao;

	@Autowired
	protected ICommonDao commonDao;

	@Autowired
	protected IGoodsDao goodsDao;

	@Autowired
	protected IGoodsService goodsService;

	private static final Logger logger = Logger.getLogger(CommonActivityServiceImpl.class);


	/**
	 * 得到活动列表
	 */
	public Map<String,Object> getList(Map<String,Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			String os = reqMap.get(SInvokeKeys.os.value())+"";
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String zoneCode = paraMap.get(JydKeys.zoneCode.value())+"";


			Map<String,Object> corpParams = new HashMap<String, Object>();
			corpParams.put("unitType", 0);
			corpParams.put("zoneCode", zoneCode);
			List<SysUnits> unitsList = commonDao.getListByZoneCodeAndUnitType(corpParams);

			if (null==unitsList || unitsList.isEmpty()) {//没有当前单位

				return DataResponseUtil.getResultData(reqMap, 0 , "当前区域暂不支持此服务！");
			}

			SysUnits sysUnits = unitsList.get(0);
			if (sysUnits.getUnitType()!=0) {//当前单位不是区域代理

				return DataResponseUtil.getResultData(reqMap, 0 , "当前单位不是区域代理！");
			}


			//获取活动列表
			Map<String,Object> activityMap = new HashMap<String, Object>();
			activityMap.put("activityType", paraMap.get("activityType"));
			activityMap.put("unitId", sysUnits.getId());
			List<Map<String,Object>> activityList = commonActivityDao.getAcitivityListMap(activityMap);

			if (null!=activityList && !activityList.isEmpty()) {

				Map<String,Object> params = new HashMap<String, Object>();
				params.put("page", 1);
				params.put("pagesize", 3);
				params.put("unitId", sysUnits.getId());
				params.put("unitType", sysUnits.getUnitType());
				params.put("dataType", 0);
				params.put("os", os);
				params.put("url", SysBaseUtil.BASE_PATH+"/server/commonactivity/detail.htm?id=");

				for (int i = 0; i < activityList.size();) {

					Map<String, Object> map = activityList.get(i);

					params.put("dataId", map.get("id"));
					params.put("activityId", map.get("id"));

					//图片主题
					if((map.get("dataType")+"").equals("1")){

						//活动主题下面的主题列表
						List<Map<String,Object>> subjectList = commonActivityDao.getSubjectList(params);
						if (null==subjectList || subjectList.isEmpty()) {
							activityList.remove(i);
							continue;
						}
						map.put("subjectList", subjectList);
					}else {
						if(!(map.get("isAllData")+"").equals("1")){//查询前三条数据
							//商品列表
							List<Map<String,Object>> goodsList = commonActivityDao.getGoodsListByActivityId(params);
							if (null==goodsList || goodsList.isEmpty()) {
								activityList.remove(i);
								continue;
							}
							map.put("goodsList", goodsList);
						}

					}
					i++;
				}
			}

			result = DataResponseUtil.getResultData(reqMap, 1 , "首页促销活动列表获取成功！",activityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0 , "首页促销活动列表获取失败，出现异常！");
		}
		return result;
	}


	/**
	 * 得到活动列表 2.1以上版本
	 */
	public Map<String,Object> getList2_1(Map<String,Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			String os = reqMap.get(SInvokeKeys.os.value())+"";
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String zoneCode = paraMap.get(JydKeys.zoneCode.value())+"";

			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {//当前单位不是区域代理
				return DataResponseUtil.getResultData(reqMap, 0 , "当前单位不合法！");
			}


			//获取活动列表
			Map<String,Object> activityMap = new HashMap<String, Object>();
			activityMap.put("activityType", paraMap.get("activityType"));
			activityMap.put("unitId", sysUnits.getId());
			List<Map<String,Object>> activityList = commonActivityDao.getAcitivityListMap(activityMap);

			if (null!=activityList && !activityList.isEmpty()) {

				Map<String,Object> params = new HashMap<String, Object>();
				params.put("page", 1);
				params.put("pagesize", 3);
				params.put("unitId", sysUnits.getId());
				params.put("dataType", 0);
				params.put("os", os);
				params.put("url", SysBaseUtil.BASE_PATH+"/server/commonactivity/detail.htm?id=");

				for (int i = 0; i < activityList.size();) {

					Map<String, Object> map = activityList.get(i);

					params.put("dataId", map.get("id"));
					params.put("activityId", map.get("id"));

					//图片主题
					if((map.get("dataType")+"").equals("1")){

						//活动主题下面的主题列表
						List<Map<String,Object>> subjectList = commonActivityDao.getSubjectList(params);
						if (null==subjectList || subjectList.isEmpty()) {
							activityList.remove(i);
							continue;
						}
						map.put("subjectList", subjectList);
					}else {
						if((map.get("isAllData")+"").equals("1")){//查询所有  新版本设计2.1以上
							params.put("pagesize", 20);							
						}else{
							params.put("pagesize", 2);
						}
						//商品列表
						List<Map<String,Object>> goodsList = commonActivityDao.getGoodsListByActivityId(params);
						if (null==goodsList || goodsList.isEmpty()) {
							activityList.remove(i);
							continue;
						}
						map.put("goodsList", goodsList);
					}
					i++;
				}
			}
			result = DataResponseUtil.getResultData(reqMap, 1 , "首页促销活动列表获取成功！",activityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0 , "首页促销活动列表获取失败，出现异常！");
		}
		return result;
	}


	/**
	 * 得到活动商品列表数据
	 */
	public Map<String,Object> getGoodsList(Map<String,Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String sortname = paraMap.get("sortname")+"";//排序字段 sellRate:销量、price:价格
			String sortorder = paraMap.get("sortorder")+"";//排序方式 asc desc
			//0：活动、1：主题
			int dataType = Integer.parseInt(paraMap.get("dataType")+"");
			//区域编码
			String zoneCode = paraMap.get(JydKeys.zoneCode.value())+"";

			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (sysUnits.getUnitType()!=0) {//当前单位不是区域代理

				return DataResponseUtil.getResultData(reqMap, 0 , "当前单位不是区域代理！");
			}

			//获取活动商品列表
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("page", Integer.parseInt(paraMap.get("page")+""));
			params.put("pagesize", Integer.parseInt(paraMap.get("pagesize")+""));
			params.put("unitId", sysUnits.getId());
			params.put("dataType", dataType);
			params.put("dataId", paraMap.get("dataId"));

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
			List<Map<String,Object>> goodsList = commonActivityDao.getGoodsListByActivityId(params);

			if(null == goodsList || goodsList.isEmpty()){
				result = DataResponseUtil.getResultData(reqMap, 2, "暂无数据！", goodsList);
			}else{
				result = DataResponseUtil.getResultData(reqMap, 1, "促销活动获取商品列表成功！", goodsList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "促销活动获取商品列表失败！");
		}
		return result;
	}

	public Map<String,Object> getGoodsDetail(Map<String,Object> reqMap){

		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			//主题ID
			long subjectId = Long.valueOf(paraMap.get("id")+"");
			String memberId = paraMap.get(JydKeys.memberId.value())+"";
			String zoneCode = paraMap.get(UnitKeys.zoneCode.value())+"";

			Map<String,Object> params = new HashMap<String, Object>();
			params.put("dataId", subjectId);
			params.put("dataType", 1);
			List<Map<String,Object>> activityGoodsList = commonActivityDao.getCommonActivityGoodsList(params);

			if (null==activityGoodsList || activityGoodsList.isEmpty()) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前促销主题下面没有商品！");
			}

			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}
			
			Map<String,Object> goodsDetail = goodsService.getGoodsDetail(Long.valueOf(activityGoodsList.get(0).get("goodsPriceId")+""), memberId,sysUnits);
			result = DataResponseUtil.getResultData(reqMap, 1, "促销活动主题获取商品详细成功！",goodsDetail);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "促销活动主题获取商品详细失败！");
		}
		return result;
	}

	/**
	 * 更新活动商品价格及标识
	 */
	@Transactional(rollbackFor=Exception.class)
	public void updateActivityGoodsPrize() {

		logger.debug("更新活动商品价格及标识扫描开始！");

		//将要开始的活动商品列表
		List<Map<String,Object>> startList = commonActivityDao.getStartAcitivityGoodsListMap();

		if (startList!=null && !startList.isEmpty()) {

			for (Map<String, Object> map : startList) {

				//更新商品价格表，活动价格和活动标识
				updateGoodsPrize(1,map);
			}
		}

		//将要结束的活动商品列表
		List<Map<String,Object>> endList = commonActivityDao.getEndAcitivityGoodsListMap();

		if (endList!=null && !endList.isEmpty()) {

			for (Map<String, Object> map : endList) {

				//更新商品价格表，活动价格和活动标识
				updateGoodsPrize(0,map);
			}
		}
		logger.debug("更新活动商品价格及标识扫描结束！");
	}


	/**
	 * 更新商品价格表，活动价格和活动标识
	 * @param isActivity 是否参与活动（1：参与、0：不参与）
	 * @param map
	 */
	private void updateGoodsPrize(int isActivity,Map<String,Object> map){

		Map<String,Object> prizeData = new HashMap<String, Object>();
		prizeData.put("isActivity", isActivity);
		prizeData.put("activityPrice", isActivity==0?0:map.get("activity_price"));
		prizeData.put("activityGoodsId", isActivity==0?0:map.get("id"));
		prizeData.put("activityType", 0);
		prizeData.put("id", map.get("price_id"));
		prizeData.put("data_id", isActivity==0?0:map.get("data_id"));
		prizeData.put("data_type", isActivity==0?"":map.get("data_type"));
		commonActivityDao.updateGoodsPrize(prizeData);
	}
}
