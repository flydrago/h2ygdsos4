package com.h2y.os.services;

import java.util.Map;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IShopingCartService  
 * 类描述：购物车业务操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 下午3:29:16  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 下午3:29:16  
 * 修改备注：  
 * @version
 */
public interface IShoppingCartService{
	
	/**
	 * 添加购物车商品数量
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * goodsPriceId:商品定价id,
	 * goodsId:商品id（暂不使用）,
	 * buyType:购买类型（0：购买、1：酒库）}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> add(Map<String,Object> reqMap);
	
	/**
	 * 批量添加购物车商品数量
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * goodsList:[{
	 * goodsPriceId:商品定价id,
	 * goodsId:商品id（暂不使用）,
	 * count:商品数量,
	 * buyType:购买类型（0：购买、1：酒库）}]}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> addBatch(Map<String,Object> reqMap);
	
	
	/**
	 * 减少购物车商品数量
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * goodsPriceId:商品定价id,
	 * goodsId:商品id（暂不使用） }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> reduce(Map<String,Object> reqMap);
	
	
	/**
	 * 修改购物车商品数量
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * goodsPriceId:商品定价id,
	 * goodsCount:商品数量,
	 * goodsId:商品id（暂不使用） }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> update(Map<String,Object> reqMap);
	
	/**
	 * 删除购物车商品
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * goodsPriceId:商品定价id,
	 * goodsId:商品id（暂不使用） }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> delete(Map<String,Object> reqMap);
	
	
	/**
	 * 同步购物车商品
	 * @param reqMap
	 * postData=[{memberId:会员id,
	 * goodsPriceId:商品定价id,
	 * goodsId:商品id（暂不使用） ,
	 * goodsCount:定价商品数量}]
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> syn(Map<String,Object> reqMap);
	
	/**
	 * 获取购物车列表
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * zoneCode:区域编码}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:购物车列表信息}
	 */
	public Map<String,Object> getList(Map<String,Object> reqMap);
	
	
	/**
	 * 获取购物车未登录列表
	 * @param reqMap
	 * postData={
	 * zoneCode:区域编码,
	 * goodsPriceInfos:[goodsPriceId:商品定价id,goodsPriceId:商品定价id]
	 * }
	 * @return
	 */
	public Map<String,Object> getUnLoginList(Map<String,Object> reqMap);
	
	/**
	 * 清除购物车中已删除和已提交的数据到历史表中
	 * @param reqMap
	 * @return
	 */
	public Map<String,Object> clear(Map<String,Object> reqMap);
	
	
	/**
	 * 获取购物车列表行数
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * zoneCode:区域编码}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:行数}
	 */
	public Map<String,Object> getListRows(Map<String,Object> reqMap);
}
