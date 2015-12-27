package com.h2y.os.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.basic.WbsKeys.FindServiceKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.dao.IFindServiceDao;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.StringUtil;

/**
 * 服务管理
 * @author sunfj
 *
 */
@Service("findServiceService")
public class FindServiceServiceImpl implements IFindServiceService{

	@Autowired
	protected IFindServiceDao findServiceDao;

	private final static Logger logger = Logger.getLogger(FindServiceServiceImpl.class);

	/**
	 * 获取发现列表
	 * @param map
	 * os 系统
	 * zoneCode 区域编码
	 * parentId 父级id
	 * @return
	 */
	public Map<String, Object> getPrivateServiceList(Map<String,Object> reqMap){

		//元数据
		List<Map<String, Object>> typeList = new ArrayList<Map<String, Object>>();

		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

		Map<String,Object> paramsMap = new HashMap<String,Object>();

		//服务
		Map<String,Object> resultMap = new HashMap<String,Object>();

		try{

			String os = reqMap.get(SInvokeKeys.os.value())+"";//请求类型  android、ios、微信
			String zoneCode = StringUtil.objectToString(paraMap.get(FindServiceKeys.zoneCode.value()));
			String parentId = StringUtil.objectToString(paraMap.get(FindServiceKeys.parentId.value()));

			if (null == zoneCode || "".equals(zoneCode)) {
				return DataResponseUtil.getResultData(reqMap, 0, "区域编码不能为空！");
			}

			if (null == parentId || "".equals(parentId)) {
				return DataResponseUtil.getResultData(reqMap, 0, "父级id不能为空！");
			}

			paramsMap.put("os", os);
			paramsMap.put("zoneCode", zoneCode);
			paramsMap.put("parentId", parentId);
			paramsMap.put("dataType", 0);

			//元数据
			typeList = this.findServiceDao.getPrivateServiceList(paramsMap);
			paramsMap.remove("dataType");

			for(int i =0;i<typeList.size();){

				Map<String,Object> typeData = typeList.get(i);
				paramsMap.put("parentId", typeData.get("id"));
				//服务列表
				List<Map<String,Object>> serviceList = this.findServiceDao.getPrivateServiceList(paramsMap);
				if (null!=serviceList && !serviceList.isEmpty()) {
					typeData.put("serviceList", serviceList);
					i++;
				}else {
					typeList.remove(i);
				}
			}

			if (null != typeList && typeList.size() > 0) {		
				resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", typeList);
			} else {
				resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", typeList);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0 , "数据获取失败！",resultMap);
		}

		return resultMap;
	}


	/**
	 * ios 发现列表
	 */
	public Map<String, Object> getPrivateServiceListIOS(Map<String,Object> reqMap){

		//元数据
		List<Map<String, Object>> typeList = new ArrayList<Map<String, Object>>();

		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

		Map<String,Object> paramsMap = new HashMap<String,Object>();

		//服务
		Map<String,Object> resultMap = new HashMap<String,Object>();


		String os = reqMap.get(SInvokeKeys.os.value())+"";
		String zoneCode = StringUtil.objectToString(paraMap.get(FindServiceKeys.zoneCode.value()));
		String parentId = StringUtil.objectToString(paraMap.get(FindServiceKeys.parentId.value()));

		if (null == zoneCode || "".equals(zoneCode)) {
			return DataResponseUtil.getResultData(reqMap, 0, "区域编码不能为空！");
		}

		if (null == parentId || "".equals(parentId)) {
			return DataResponseUtil.getResultData(reqMap, 0, "父级id不能为空！");
		}

		paramsMap.put("os", os);
		paramsMap.put("zoneCode", zoneCode);
		paramsMap.put("parentId", parentId);
		paramsMap.put("dataType", 0);

		//元数据
		typeList = this.findServiceDao.getPrivateServiceList(paramsMap);
		paramsMap.remove("dataType");

		//返回数据
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();

		for(int i =0;i<typeList.size();i++){
			dataList.add(typeList.get(i));
			paramsMap.put("parentId", typeList.get(i).get("id"));
			//服务列表
			List<Map<String,Object>> serviceList = this.findServiceDao.getPrivateServiceList(paramsMap);
			for(int j =0;j<serviceList.size();j++){
				dataList.add(serviceList.get(j));
			}
		}

		if (null != dataList && dataList.size() > 0) {		
			resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", dataList);
		} else {
			resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", dataList);
		}

		return resultMap;
	}

	/**
	 * 获取首页分类服务
	 */
	public Map<String, Object> getPublicServiceList(Map<String,Object> reqMap){
		List<Map<String, Object>> serviceList = new ArrayList<Map<String, Object>>();

		Map<String,Object> resultMap = new HashMap<String,Object>();

		try{

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String os = reqMap.get(SInvokeKeys.os.value())+"";
			String zoneCode = StringUtil.objectToString(paraMap.get(FindServiceKeys.zoneCode.value()));

			//服务类型：0：元数据 1：正常服务
			paraMap.put("dataType", 1);
			paraMap.put("os", os);
			paraMap.put("zoneCode", zoneCode);

			//2.2以上版本按单位获取服务
			serviceList = this.findServiceDao.getPublicServiceList2_2(paraMap);

			if (null != serviceList && serviceList.size() > 0) {			
				resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", serviceList);
			} else {
				//如果该单位未分配服务 则取公共服务
				serviceList = this.findServiceDao.getPublicServiceList(paraMap);
				if (null != serviceList && serviceList.size() > 0) {			
					resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", serviceList);
				} else {
					resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", serviceList);
				}

			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0 , "数据获取失败！",serviceList);
		}

		return resultMap;
	}


	/**
	 * 获取首页分类服务
	 * 适用于2.1以上版本
	 */
	public Map<String, Object> getPublicServiceList2_1(Map<String,Object> reqMap){
		List<Map<String, Object>> serviceList = new ArrayList<Map<String, Object>>();

		Map<String,Object> resultMap = new HashMap<String,Object>();

		try{

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String os = reqMap.get(SInvokeKeys.os.value())+"";

			//服务类型：0：元数据 1：正常服务
			paraMap.put("dataType", 1);
			paraMap.put("os", os);

			serviceList = this.findServiceDao.getPublicServiceList2_1(paraMap);

			if (null != serviceList && serviceList.size() > 0) {			
				resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", serviceList);
			} else {
				resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", serviceList);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0 , "数据获取失败！",serviceList);
		}

		return resultMap;
	}





}
