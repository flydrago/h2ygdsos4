package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IShoppingCartDaoR;
import com.h2y.os.dao.write.IShoppingCartDaoW;
import com.h2y.os.entity.ShoppingCart;

@Service("shoppingCartDao")
public class ShoppingCartDaoImpl implements IShoppingCartDao{
	
	@Autowired
	protected IShoppingCartDaoR shoppingCartDaoR;
	
	@Autowired
	protected IShoppingCartDaoW shoppingCartDaoW;

	public void add(ShoppingCart shoppingCart) {
		shoppingCartDaoW.add(shoppingCart);
	}

	public void addBatchHis(List<ShoppingCart> list) {
		shoppingCartDaoW.addBatchHis(list);
	}

	public void update(ShoppingCart shoppingCart) {
		shoppingCartDaoW.update(shoppingCart);
	}

	public void updateStatusByIds(Map<String, Object> map) {
		shoppingCartDaoW.updateStatusByIds(map);
	}

	public void deleteById(long id) {
		shoppingCartDaoW.deleteById(id);
	}

	public void deleteByShoppingCarts(Map<String, Object> map) {
		shoppingCartDaoW.deleteByShoppingCarts(map);
	}

	public ShoppingCart get(long id) {
		return shoppingCartDaoR.get(id);
	}

	public ShoppingCart getByGoodsPriceIdAndMemberId(Map<String, Object> map) {
		return shoppingCartDaoR.getByGoodsPriceIdAndMemberId(map);
	}

	public List<Map<String, Object>> getListMap(Map<String, Object> map) {
		return shoppingCartDaoR.getListMap(map);
	}

	public List<Map<String, Object>> getUnLoginListMap(Map<String, Object> map) {
		return shoppingCartDaoR.getUnLoginListMap(map);
	}

	public List<ShoppingCart> getShoppingCartRemoveList(Map<String, Object> map) {
		return shoppingCartDaoR.getShoppingCartRemoveList(map);
	}

	public long getListRows(Map<String, Object> map) {
		return shoppingCartDaoR.getListRows(map);
	}

}
