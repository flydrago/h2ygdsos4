package com.h2y.os.dao;



import java.util.List;
import java.util.Map;


import com.h2y.os.entity.GoodsAnalysis;

/**
 * GoodsAnalysisDaoInterface,order CRUD ;CRUD:Create,Retrieve/Read,Update,Delete
 * @author hwttnet
 * version:1.2
 * time:2015-06-30
 * email:info@hwttnet.com
 */
public interface IGoodsAnalysisDao{

	/**
	 * add
	 */
	public int add(GoodsAnalysis goodsAnalysis);

	/**
	 * update
	 */
	public int update(GoodsAnalysis goodsAnalysis);

	/**
	 * delete
	 */
	public int deleteById(long id);

	/**
	 * deleteByIds
	 */
	//public void deleteByIds(List<long> ids);

	/**
	 * get
	 * @return
	 */
	public GoodsAnalysis get(long id);



	/**
	 * 获取猜你喜欢列表前几条信息
	 * @param map
	 * {memberId:会员id,
	 * zoneCode:区域编码,
	 * analysisNum:前几条}
	 * @return
	 */
	public List<Map<String,Object>> getGoodsAnalysisListByUser(Map<String,Object> map);

	/**
	 * 根据用户获取猜你喜欢
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getGoodsAnalysisListAll(Map<String,Object> map);

	/**
	 * 获取猜你喜欢列表 用来凑够9条数据
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getGoodsAnalysisListByUser9(Map<String,Object> map);


	/**
	 * 获取当前区域信息  判断该区域是否开通
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getZoneListByCode(Map<String,Object> map);
	
	
	/**
	 * 获取指定区域，点击量头几名的商品列表
	 * @param map
	 * {zoneCode:区域编码,
	 * analysisNum:商品记录数,
	 * goodsPriceId:商品定价id 用逗点分隔 （null时不做判断）}
	 * @return
	 */
	public List<Map<String,Object>> getGoodsAnalysisListAll2(Map<String,Object> map);


}