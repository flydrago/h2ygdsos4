package com.h2y.os.dao.read;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.ShoppingCart;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IShoppingCartDao  
 * 类描述：购物车数据库操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 下午3:24:51  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 下午3:24:51  
 * 修改备注：  
 * @version
 */
@Component
public interface IShoppingCartDaoR{


	/**
	 * get
	 * @return
	 */
	public ShoppingCart get(long id);
	
	/**
	 * 根据定价id和会员Id，得到对应的购物车信息
	 * @param map
	 * {goodsPriceId:商品定价id,
	 * memberId:会员id,
	 * buyType:购买类型 0：购买 1：酒库}
	 * @return
	 */
	public ShoppingCart getByGoodsPriceIdAndMemberId(Map<String,Object> map);
	
	/**
	 * 得到会员的购物车列表
	 * @param map
	 * {memberId:会员id,
	 * zoneCode:区域编码 （过滤sql注入）}
	 * @return
	 */
	public List<Map<String,Object>> getListMap(Map<String,Object> map);
	
	/**
	 * 得到会员的购物车列表数量
	 * @param map
	 * {memberId:会员id,
	 * zoneCode:区域编码 （过滤sql注入）}
	 * @return
	 */
	public long getListRows(Map<String,Object> map);
	
	/**
	 * 得到未登录时，的购物车列表
	 * @param map
	 * {goodsPriceInfos:{goodsPriceId:商品定价id}}
	 * @return
	 */
	public List<Map<String,Object>> getUnLoginListMap(Map<String,Object> map);
	
	
	/**
	 * 得到要移除的购物车列表（删除的购物车、已经提交订单的），预防数据量大所以进行分页处理
	 * @param map 
	 * {page:页码,
	 * pagesize:页显示最大记录数}
	 * @return 分页的购物车列表
	 */
	public List<ShoppingCart> getShoppingCartRemoveList(Map<String,Object> map);
	
}