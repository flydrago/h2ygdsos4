package com.h2y.os.services;

import java.util.Map;

public interface IFindServiceService {


	/**
	 * 我的》发现--获取服务列表
	 * @param 
	 * zoneCode 区域编码
	 * parentId 父级id
	 * @return
	 */
	public Map<String,Object> getPrivateServiceList(Map<String,Object> map);

	/**
	 * 获取首页服务分类
	 * @param 
	 * zoneCode 区域编码
	 * @return
	 */
	public Map<String,Object> getPublicServiceList(Map<String,Object> map);

	/**
	 * 获取首页服务分类--适用于ios
	 * @param map
	 * @return
	 */
	public Map<String, Object> getPrivateServiceListIOS(Map<String,Object> map);

	/**
	 * 获取首页服务分类--适用于2.1以上版本
	 * @param map
	 * @return
	 */
	public Map<String,Object> getPublicServiceList2_1(Map<String,Object> map);


}
