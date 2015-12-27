package com.h2y.os.dao;



import java.util.List;
import java.util.Map;


public interface ISysShopInfoDao{



	//获取门店详细
	public Map<String,Object> getShopInfoByShopId(long shopId);

	//获取门店
	public Map<String,Object> getDepartmentById(long id);

	//获取图片列表
	public List<Map<String,Object>> getFileList(long shopId);

}