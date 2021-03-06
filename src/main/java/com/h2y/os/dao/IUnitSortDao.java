package com.h2y.os.dao;

import java.util.List;
import java.util.Map;




/**
 * 
 * @author sunfj
 *
 */
public interface IUnitSortDao{

	//获取列表
	public List<Map<String,Object>> getListMap(Map<String,Object> map);


	public List<Map<String,Object>> getShopListBySort(Map<String,Object> map);

	//生活+列表
	public List<Map<String,Object>> getLifeShopList2_1(Map<String,Object> map);

	//获取筛选条件列表
	public List<Map<String,Object>> getConditionListMap(Map<String,Object> map);


}