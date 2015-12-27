package com.h2y.os.services;

import java.util.Map;

public interface ILocalServiceService {

	public Map<String,Object> getSortList(Map<String,Object> map);

	//根据分类获取店铺
	public Map<String,Object> getShopListBySort(Map<String,Object> map);

	//根据店铺id获取商品
	public Map<String, Object> getGoodsListByShopId(Map<String, Object> reqMap);


	//生活+列表
	public Map<String,Object> getLifeShopList2_1(Map<String,Object> map);

	//生活+ 商品列表
	public Map<String, Object> getLifeShopGoodsList2_1(Map<String, Object> reqMap);

	//获取筛选条件
	public Map<String, Object> getConditionList2_1(Map<String, Object> reqMap);



}
