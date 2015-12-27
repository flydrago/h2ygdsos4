package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

public interface IFindServiceDao {


	//获取公共发现服务列表
	public List<Map<String,Object>> getPublicServiceList2_1(Map<String,Object> map);

	//获取发现服务列表
	public List<Map<String,Object>> getPrivateServiceList(Map<String,Object> map);

	//获取公共发现服务列表 new
	public List<Map<String,Object>> getPublicServiceList(Map<String,Object> map);



	/**
	 * 适用于2.2
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getPublicServiceList2_2(Map<String,Object> map);

}
