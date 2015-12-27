package com.h2y.os.dao.write;

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
public interface IShoppingCartDaoW{

	/**
	 * add
	 */
	public void add(ShoppingCart shoppingCart);
	
	
	/**
	 * 批量添加购物车历史
	 */
	public void addBatchHis(List<ShoppingCart> list);
	
	/**
	 * update
	 */
	public void update(ShoppingCart shoppingCart);
	
	/**
	 * 更新购物车的状态
	 * @param map
	 * {ids:购物车id集合,
	 * status:状态（-1：删除、0：正常）}
	 */
	public void updateStatusByIds(Map<String,Object> map);
	
	/**
	 * delete
	 */
	public void deleteById(long id);
	
	
	/**
	 * 根据购物车列表删除购物车
	 * @param map
	 * {list:购物车对象列表}
	 */
	public void deleteByShoppingCarts(Map<String,Object> map);

	
	
}