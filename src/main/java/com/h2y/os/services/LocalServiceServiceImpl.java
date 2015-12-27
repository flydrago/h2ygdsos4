package com.h2y.os.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.LocalServiceKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.dao.IGoodsDao;
import com.h2y.os.dao.ISysShopInfoDao;
import com.h2y.os.dao.IUnitSortDao;
import com.h2y.os.entity.SysUnits;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.StringUtil;

/**
 * 本地服务（生活+）
 * @author sunfj
 *
 */
@Service("localServiceService")
public class LocalServiceServiceImpl implements ILocalServiceService{

	@Autowired
	protected IUnitSortDao unitSortDao;

	@Autowired
	protected ICommonDao commonDao;

	@Autowired
	protected IGoodsDao goodsDao;

	@Autowired
	protected ISysShopInfoDao sysShopInfoDao;

	private final static Logger logger = Logger.getLogger(LocalServiceServiceImpl.class);


	/**
	 * 获取分类列表
	 */
	public Map<String, Object> getSortList(Map<String, Object> reqMap) {

		//返回结果
		Map<String,Object> resultMap = new HashMap<String,Object>();

		Map<String,Object> paramsMap = new HashMap<String,Object>();

		try{

			paramsMap.put("parentId", 0);
			List<Map<String,Object>> parentSortList =  unitSortDao.getListMap(paramsMap);


			for(int i =0;i<parentSortList.size();){

				Map<String,Object> typeData = parentSortList.get(i);
				paramsMap.put("parentId", typeData.get("id"));
				//服务列表
				List<Map<String,Object>> childSortList = unitSortDao.getListMap(paramsMap);
				if (null!=childSortList && !childSortList.isEmpty()) {
					typeData.put("childSortList", childSortList);
					i++;
				}else {
					parentSortList.remove(i);
				}
			}


			if (null != parentSortList && parentSortList.size() > 0) {		
				resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", parentSortList);
			} else {
				resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", parentSortList);
			}

		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "获取数据失败");
		}

		return resultMap;
	}




	/**
	 * 根据分类获取店铺列表
	 */
	public Map<String,Object> getShopListBySort(Map<String,Object> reqMap){
		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

		Map<String,Object> paramsMap = new HashMap<String,Object>();
		//本地服务
		Map<String,Object> resultMap = new HashMap<String,Object>();

		try{

			String parentId = StringUtil.objectToString(paraMap.get(LocalServiceKeys.parentId.value()));
			if(null == parentId || "".equals(parentId)){
				parentId = "0";
			}

			String sortId = StringUtil.objectToString(paraMap.get(LocalServiceKeys.sortId.value()));
			if(null == sortId || "".equals(sortId)){
				sortId = "0";
			}

			String sortname = StringUtil.objectToString(paraMap.get("sortname"));//排序字段 distance
			String sortorder = StringUtil.objectToString(paraMap.get("sortorder"));//排序方式 asc desc

			paramsMap.put("parentId", parentId);
			paramsMap.put("sortId", sortId);

			String longitude = StringUtil.objectToString(paraMap.get(LocalServiceKeys.longitude.value()));//经度
			String latitude = StringUtil.objectToString(paraMap.get(LocalServiceKeys.latitude.value()));//收货地址纬度
			String shopName = StringUtil.objectToString(paraMap.get(LocalServiceKeys.shopName.value()));//店铺名称		
			String zoneCode = StringUtil.objectToString(paraMap.get(JydKeys.zoneCode.value()));//区域编码

			//paramsMap.put("zoneCode", zoneCode);

			if (null != longitude && !"".equals(longitude)) {
				paramsMap.put("longitude", new BigDecimal(longitude));
			}

			if (null != latitude && !"".equals(latitude)) {
				paramsMap.put("latitude", new BigDecimal(latitude));
			}

			if(null != shopName && !"".equals(shopName)){
				paramsMap.put("shopName", "%" + shopName + "%");
			}

			if(null != zoneCode && !"".equals(zoneCode)){
				paramsMap.put("zoneCode", zoneCode + "%");
			}

			//分页数据
			paramsMap.put("page", Integer.parseInt(paraMap.get("page") + ""));
			paramsMap.put("pagesize", Integer.parseInt(paraMap.get("pagesize") + ""));

			//排序
			if(null != sortorder){
				if (!sortorder.equals("desc") && !sortorder.equals("asc")) {
					sortorder = null;
				}else {
					sortorder = sortorder.equals("desc")?"desc":"asc";
				}
			}

			paramsMap.put("sortname", sortname);
			paramsMap.put("sortorder", sortorder);

			List<Map<String,Object>> shopList =  unitSortDao.getShopListBySort(paramsMap);

			if(null != shopList && shopList.size() >0){
				resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", shopList);
			} else {
				resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", shopList);
			}

		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "获取数据失败");
		}

		return resultMap;
	}

	/**
	 * 根据店铺id获取店铺商品
	 * @param reqMap
	 * @return
	 */
	public Map<String, Object> getGoodsListByShopId(Map<String, Object> reqMap) {
		List<Map<String, Object>> goodsList = new ArrayList<Map<String, Object>>();

		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

		Map<String,Object> resultMap = new HashMap<String, Object>();

		try {

			String sortname = paraMap.get("sortname")+"";//排序字段 sellRate:销量、price:价格
			String sortorder = paraMap.get("sortorder")+"";//排序方式 asc desc
			String unitId = StringUtil.objectToString(paraMap.get(LocalServiceKeys.unitId.value()));
			if (null == unitId || "".equals(unitId)) {
				return DataResponseUtil.getResultData(reqMap, 0, "公司id不能为空！");
			}


			Map<String, Object> goodsParams = new HashMap<String, Object>();
			goodsParams.put("unitId", unitId);
			goodsParams.put("unitType", 1);
			if (null != paraMap.get("keyWord") && !"".equals(paraMap.get("keyWord") + "")) {
				goodsParams.put("keyWord", "%" + paraMap.get("keyWord") + "%");
			}

			//分页数据
			goodsParams.put("page", Integer.parseInt(paraMap.get("page") + ""));
			goodsParams.put("pagesize", Integer.parseInt(paraMap.get("pagesize") + ""));


			//商品类型
			String goodsTypeId = paraMap.get("goodsTypeId")+"";
			if(null != paraMap.get("goodsTypeId") && !"".equals(goodsTypeId) ){
				goodsParams.put("goodsTypeId", paraMap.get("goodsTypeId"));
			}


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
			goodsParams.put("sortname", sortname);
			goodsParams.put("sortorder", sortorder);
			goodsList = goodsDao.getListMap(goodsParams);

			if (null != goodsList && goodsList.size() > 0) {	
				resultMap = DataResponseUtil.getResultData(reqMap, 1, "获取数据成功", goodsList);
			} else {
				resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据",goodsList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "获取数据失败");
		}


		return resultMap;
	}



	/**
	 * appv=2.1
	 * 生活+列表
	 */
	public Map<String,Object> getLifeShopList2_1(Map<String,Object> reqMap){
		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

		Map<String,Object> paramsMap = new HashMap<String,Object>();
		//本地服务
		Map<String,Object> resultMap = new HashMap<String,Object>();

		try{

			String parentId = StringUtil.objectToString(paraMap.get(LocalServiceKeys.parentId.value()));
			if(null == parentId || "".equals(parentId)){
				parentId = "0";
			}

			String sortId = StringUtil.objectToString(paraMap.get(LocalServiceKeys.sortId.value()));
			if(null == sortId || "".equals(sortId)){
				sortId = "0";
			}

			String sortname = StringUtil.objectToString(paraMap.get("sortname"));//排序字段 distance
			String sortorder = StringUtil.objectToString(paraMap.get("sortorder"));//排序方式 asc desc

			paramsMap.put("parentId", parentId);
			paramsMap.put("sortId", sortId);

			String longitude = StringUtil.objectToString(paraMap.get(LocalServiceKeys.longitude.value()));//经度
			String latitude = StringUtil.objectToString(paraMap.get(LocalServiceKeys.latitude.value()));//收货地址纬度
			String shopName = StringUtil.objectToString(paraMap.get(LocalServiceKeys.shopName.value()));//店铺名称		
			String zoneCode = StringUtil.objectToString(paraMap.get(JydKeys.zoneCode.value()));//区域编码


			String isReservation = StringUtil.objectToString(paraMap.get(LocalServiceKeys.isReservation.value()));//是否预约
			String isJyd = StringUtil.objectToString(paraMap.get(LocalServiceKeys.isJyd.value()));//H2Y合作
			String isWifi = StringUtil.objectToString(paraMap.get(LocalServiceKeys.isWifi.value()));//是否提供wifi		
			String isPark = StringUtil.objectToString(paraMap.get(LocalServiceKeys.isPark.value()));//是否停车
			String isApprove = StringUtil.objectToString(paraMap.get(LocalServiceKeys.isApprove.value()));//小编认证
			String isSpread = StringUtil.objectToString(paraMap.get(LocalServiceKeys.isSpread.value()));//是否推广

			paramsMap.put("isReservation", isReservation);
			paramsMap.put("isJyd", isJyd);
			paramsMap.put("isWifi", isWifi);
			paramsMap.put("isPark", isPark);
			paramsMap.put("isApprove", isApprove);
			paramsMap.put("isSpread", isSpread);

			if (null != longitude && !"".equals(longitude)) {
				paramsMap.put("longitude", new BigDecimal(longitude));
			}

			if (null != latitude && !"".equals(latitude)) {
				paramsMap.put("latitude", new BigDecimal(latitude));
				//经纬度不为空可根据距离排序
				String distance = StringUtil.objectToString(paraMap.get("distance"));//距离
				if(null != distance && !"".equals(distance)){
					paramsMap.put("distance", new BigDecimal(distance));
				}
			}

			if(null != shopName && !"".equals(shopName)){
				paramsMap.put("shopName", "%" + shopName + "%");
			}

			if(null != zoneCode && !"".equals(zoneCode)){
				paramsMap.put("zoneCode", zoneCode + "%");
			}

			//分页数据
			paramsMap.put("page", Integer.parseInt(paraMap.get("page") + ""));
			paramsMap.put("pagesize", Integer.parseInt(paraMap.get("pagesize") + ""));

			//排序
			if(null != sortorder){
				if (!sortorder.equals("desc") && !sortorder.equals("asc")) {
					sortorder = null;
				}else {
					sortorder = sortorder.equals("desc")?"desc":"asc";
				}
			}

			paramsMap.put("sortname", sortname);
			paramsMap.put("sortorder", sortorder);

			List<Map<String,Object>> shopList =  unitSortDao.getLifeShopList2_1(paramsMap);
			List<Map<String,Object>> newShopList = new ArrayList<Map<String,Object>>();
			for(int i=0;i<shopList.size();i++){
				Map<String,Object> map = shopList.get(i);
				if(null != map.get("person_cost") && !"".equals(map.get("person_cost")+"")){
					map.put("person_cost", "人均"+map.get("person_cost")+"元");				
				}else{
					map.put("person_cost", "");
				}

				if(null == map.get("sort_name") || "null".equals(map.get("sort_name"))){
					map.put("sort_name", "");
				}
				newShopList.add(map);
			}

			if(null != shopList && shopList.size() >0){
				resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", shopList);
			} else {
				resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", shopList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "获取数据失败");
		}

		return resultMap;
	}

	/**
	 * appv=2.1
	 * 生活+ 商品列表
	 */
	public Map<String, Object> getLifeShopGoodsList2_1(Map<String, Object> reqMap) {
		List<Map<String, Object>> goodsList = new ArrayList<Map<String, Object>>();

		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

		Map<String,Object> resultMap = new HashMap<String, Object>();

		Map<String,Object> dataMap = new HashMap<String, Object>();

		try {
			//获取门店id
			String id = paraMap.get("id")+"";//获取门店id
			if("null".equals(id) ||null == id || "".equals(id)){
				return DataResponseUtil.getResultData(reqMap, 0, "门店id不能为空！");
			}
			//获取门店
			Map<String,Object> deptMap = sysShopInfoDao.getDepartmentById(Long.valueOf(id));
			//获取门店详细
			Map<String,Object> shopMap = sysShopInfoDao.getShopInfoByShopId(Long.valueOf(id));
			//获取图片
			List<Map<String,Object>> fileList =  sysShopInfoDao.getFileList(Long.valueOf(id));

			SysUnits sysUnits = this.commonDao.getSysUnitsById(Long.valueOf(deptMap.get("unitId")+""));
			shopMap.put("unitKind", sysUnits.getUnitKind());
			dataMap.put("deptMap", deptMap);
			dataMap.put("shopMap", shopMap);
			dataMap.put("fileList", fileList);

			//经营性质为销售类 可查询经营商品
			if(sysUnits.getUnitKind() == 0){
				String sortname = paraMap.get("sortname")+"";//排序字段 sellRate:销量、price:价格
				String sortorder = paraMap.get("sortorder")+"";//排序方式 asc desc
				String unitId = StringUtil.objectToString(paraMap.get(LocalServiceKeys.unitId.value()));
				if (null == unitId || "".equals(unitId)) {
					return DataResponseUtil.getResultData(reqMap, 0, "公司id不能为空！");
				}


				Map<String, Object> goodsParams = new HashMap<String, Object>();
				goodsParams.put("unitId", unitId);
				goodsParams.put("unitType", 1);
				if (null != paraMap.get("keyWord") && !"".equals(paraMap.get("keyWord") + "")) {
					goodsParams.put("keyWord", "%" + paraMap.get("keyWord") + "%");
				}

				//分页数据
				goodsParams.put("page", Integer.parseInt(paraMap.get("page") + ""));
				goodsParams.put("pagesize", Integer.parseInt(paraMap.get("pagesize") + ""));


				//商品类型
				String goodsTypeId = paraMap.get("goodsTypeId")+"";
				if(null != paraMap.get("goodsTypeId") && !"".equals(goodsTypeId) ){
					goodsParams.put("goodsTypeId", paraMap.get("goodsTypeId"));
				}


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
				goodsParams.put("sortname", sortname);
				goodsParams.put("sortorder", sortorder);
				//获取商品信息 
				goodsList = goodsDao.getListMap(goodsParams);			
				dataMap.put("goodsList", goodsList);

			}else{//服务类店铺无商品
				dataMap.put("goodsList", goodsList);
			}

			resultMap = DataResponseUtil.getResultData(reqMap, 1, "获取数据成功", dataMap);	

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "获取数据失败");
		}

		return resultMap;
	}



	/**
	 * 获取分类筛选条件例：500m 1000m
	 */
	public Map<String, Object> getConditionList2_1(Map<String, Object> reqMap) {
		Map<String,Object> paramsMap = new HashMap<String,Object>();

		Map<String,Object> dataMap = new HashMap<String,Object>();

		Map<String,Object> resultMap = new HashMap<String,Object>();

		try{

			//获取分类
			paramsMap.put("parentId", 0);
			List<Map<String,Object>> parentSortList =  unitSortDao.getListMap(paramsMap);

			for(int i =0;i<parentSortList.size();){

				Map<String,Object> typeData = parentSortList.get(i);
				paramsMap.put("parentId", typeData.get("id"));			
				List<Map<String,Object>> childSortList = unitSortDao.getListMap(paramsMap);
				if (null!=childSortList && !childSortList.isEmpty()) {
					typeData.put("childSortList", childSortList);
					i++;
				}else {
					parentSortList.remove(i);
				}
			}

			dataMap.put("parentSortList", parentSortList);


			//获取筛选条件 距离列表
			paramsMap.remove("parentId");
			paramsMap.put("parentId", 0);
			paramsMap.put("conditionValue", "condition_distance");
			//根据conditionValue获取父级
			List<Map<String,Object>> parentDistanceList =  unitSortDao.getConditionListMap(paramsMap);
			paramsMap.remove("conditionValue");
			for(int i =0;i<parentDistanceList.size();){
				Map<String,Object> typeData = parentDistanceList.get(i);
				paramsMap.put("parentId", typeData.get("id"));

				List<Map<String,Object>> childDistanceList = unitSortDao.getConditionListMap(paramsMap);
				if (null!=childDistanceList && !childDistanceList.isEmpty()) {
					typeData.put("childDistanceList", childDistanceList);
					i++;
				}else {
					parentDistanceList.remove(i);
				}
			}

			dataMap.put("parentDistanceList", parentDistanceList);

			//获取筛选条件 排序列表
			paramsMap.remove("parentId");
			paramsMap.put("parentId", 0);
			paramsMap.put("conditionValue", "condition_ord");
			List<Map<String,Object>> parentOrdList =  unitSortDao.getConditionListMap(paramsMap);
			paramsMap.remove("conditionValue");
			for(int i =0;i<parentOrdList.size();){

				Map<String,Object> typeData = parentOrdList.get(i);
				paramsMap.put("parentId", typeData.get("id"));

				List<Map<String,Object>> childOrdList = unitSortDao.getConditionListMap(paramsMap);
				if (null!=childOrdList && !childOrdList.isEmpty()) {
					typeData.put("childOrdList", childOrdList);
					i++;
				}else {
					parentOrdList.remove(i);
				}
			}

			dataMap.put("parentOrdList", parentOrdList);


			if (null != dataMap && !dataMap.isEmpty()) {		
				resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", dataMap);
			} else {
				resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", dataMap);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "获取数据失败");
		}

		return resultMap;
	}


}
