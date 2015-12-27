package com.h2y.os.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.basic.WbsKeys.UnitKeys;
import com.h2y.os.dao.IAdvertDao;
import com.h2y.os.dao.ICommonActivityDao;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.entity.AdvertColumn;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.entity.SysUnits;
import com.h2y.os.util.SysBaseUtil;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.MatcherUtil;
import com.h2y.util.StringUtil;

/**
 * 类描述：广告栏位业务逻辑接口实现类
 * 作者：侯飞龙
 * 时间：2015年1月9日下午3:40:45
 * 邮件：1162040314@qq.com
 */
@Service("advertService")
public class AdvertServiceImpl implements IAdvertService {

	private static final Logger logger = Logger.getLogger(AdvertServiceImpl.class);

	@Autowired
	protected ICommonDao commonDao;

	@Autowired
	protected IAdvertDao advertDao;

	@Autowired
	protected IGoodsService goodsService;

	@Autowired
	protected ICommonActivityDao commonActivityDao;


	public Map<String,Object> getList(Map<String,Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			String os = reqMap.get(SInvokeKeys.os.value())+"";
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String zoneCode = StringUtil.objectToString(paraMap.get(JydKeys.zoneCode.value()));

			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null == sysUnits) {// 没有当前单位
				return DataResponseUtil.getResultData(reqMap, 0, "没有当前单位！");				
			}
			
			List<Map<String,Object>> subjectList = new ArrayList<Map<String,Object>>();
			List<AdvertColumn> columnList = advertDao.getAdvertColumnListMap(sysUnits.getId());
			
			
			Map<String,Object> subjectParams = new HashMap<String, Object>();
			subjectParams.put("unitId", sysUnits.getId());
			subjectParams.put("os", os);
			subjectParams.put("url", SysBaseUtil.BASE_PATH+"/server/advert/detail.htm?id=");
			List<Map<String,Object>> subjectDataList = advertDao.getAdvertColumnSubject(subjectParams);
			Map<String,Map<String,Object>> dataMap = new HashMap<String,Map<String,Object>>();
			if (null!=subjectDataList) {
				for (Map<String, Object> map : subjectDataList) {
					dataMap.put(map.get("columnId")+"", map);
				}
			}
			
			if (null!=columnList) {
				for (AdvertColumn advertColumn : columnList) {
					if (dataMap.get(advertColumn.getId()+"")!=null){
						subjectList.add(dataMap.get(advertColumn.getId()+""));
					}
				}
			}
			
			result = DataResponseUtil.getResultData(reqMap, 1 , "获取广告栏位列表数据成功！",subjectList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0 , "获取广告栏位列表数据失败，出现异常！");
		}
		return result;
	}


	public Map<String, Object> getGoodsList(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			long subjectId = Long.valueOf(paraMap.get("id")+"");
			int page = Integer.parseInt(paraMap.get("page")+"");
			int pagesize = Integer.parseInt(paraMap.get("pagesize")+"");
			String sortname = paraMap.get("sortname")+"";//排序字段 sellRate:销量、price:价格
			String sortorder = paraMap.get("sortorder")+"";//排序方式 asc desc

			Map<String,Object> params1 = new HashMap<String, Object>();
			params1.put("subjectId", subjectId);
			params1.put("page", page);
			params1.put("pagesize", pagesize);

			//防注入处理
			if (!sortname.equals("sellRate") && !sortname.equals("price")) {
				sortname = null;
			}else {
				sortname = sortname.equals("sellRate")?"gpl.sell_rate":"gpl.single_price";
			}

			if (!sortorder.equals("desc") && !sortorder.equals("asc")) {
				sortorder = null;
			}else {
				sortorder = sortorder.equals("desc")?"desc":"asc";
			}
			params1.put("sortname", sortname);
			params1.put("sortorder", sortorder);
			List<Map<String,Object>> goodsList = advertDao.getAdvertSubjectGoodsList(params1);
			result = DataResponseUtil.getResultData(reqMap, 1 , "获取广告栏位商品列表数据成功！",goodsList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0 , "获取广告栏位商品列表数据失败，出现异常！");
		}
		return result;
	}


	public Map<String, Object> getGoodsDetail(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			long subjectId = Long.valueOf(paraMap.get("id")+"");
			String memberId = paraMap.get(JydKeys.memberId.value())+"";
			Long goodsPriceId = advertDao.getGoodsPriceIdBySubjectId(subjectId);
			String zoneCode = paraMap.get(UnitKeys.zoneCode.value())+"";
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}
			if (null==goodsPriceId) {
				return DataResponseUtil.getResultData(reqMap, 0 , "当前广告栏位下面没有商品！");
			}

			Map<String,Object> goodsData = goodsService.getGoodsDetail(goodsPriceId, memberId,sysUnits);
			result = DataResponseUtil.getResultData(reqMap, 1 , "获取广告栏位商品详细数据成功！",goodsData);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0 , "获取广告栏位商品详细失败，出现异常！");
		}
		return result;
	}


	public Map<String,Object> getDetail(HttpServletRequest request) {

		Map<String,Object> result = new HashMap<String, Object>();

		String id = request.getParameter("id");//广告主题id
		Map<String,Object> advertSubject = advertDao.getAdvertColumnSubjectById(Long.valueOf(id));
		result.put("advertSubject", advertSubject);

		//参数回传信息
		Enumeration<String> names=(Enumeration<String>)request.getParameterNames();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			result.put(name, request.getParameter(name));
		}
		return result;
	}


	public Map<String,Object> getPosterActivityDataBySubjectId(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			long subjectId = Long.valueOf(paraMap.get("id")+"");

			Map<String,Object> subjectMap = advertDao.getAdvertSubjectById(subjectId);
			long unitId = Long.valueOf(subjectMap.get("unitId")+"");
			SysUnits sysUnits = commonDao.getSysUnitsById(unitId);

			List<Map<String,Object>> activityDataList = advertDao.getActivityListBySubjectId(subjectId);
			if (null!=activityDataList && !activityDataList.isEmpty()) {
				for (int i = 0; i < activityDataList.size(); ) {

					Map<String,Object> activityMap = activityDataList.get(i);

					Map<String,Object> params = new HashMap<String,Object>();
					params.put("dataId", activityMap.get("id"));
					params.put("dataType", 0);
					params.put("unitId", unitId);
					params.put("unitType", sysUnits.getUnitType());
					params.put("page", 1);
					params.put("pagesize", 50);
					List<Map<String,Object>> goodsDataList = commonActivityDao.getGoodsListByActivityId(params);
					if (null==goodsDataList || goodsDataList.isEmpty()) {
						activityDataList.remove(i);
					}else {
						activityMap.put("goodsData", goodsDataList);
						i++;
					}
				}
			}else {
				activityDataList = new ArrayList<Map<String,Object>>();
			}
			result = DataResponseUtil.getResultData(reqMap, 1 , "获取海报促销活动数据成功！",activityDataList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0 , "获取海报促销活动失败，出现异常！");
		}
		return result;
	}

}
