package com.h2y.os.services;



import java.util.Map;





/**
 * 
 * @author hwttnet
 * version:1.2
 * time:2015-06-30
 * email:info@hwttnet.com
 * 
 * Service Interface
 */
public interface IGoodsAnalysisService{

	/**
	 * 获取猜你喜欢列表
	 * @param map
	 * @return
	 */
	public Map<String,Object> getGoodsAnalysisList(Map<String,Object> map);

	/**
	 * 添加猜你喜欢
	 * @param map
	 * @return
	 */
	public Map<String,Object> addGoodsAnalysis(Map<String,Object> map);



}
