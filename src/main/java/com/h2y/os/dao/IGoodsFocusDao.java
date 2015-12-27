package com.h2y.os.dao;

import java.util.List;
import java.util.Map;


import com.h2y.os.entity.GoodsFocus;

/**
 * GoodsFocusDaoInterface,order CRUD ;CRUD:Create,Retrieve/Read,Update,Delete
 * 
 * @author hwttnet version:1.2 time:2015-04-10 email:info@hwttnet.com
 */

public interface IGoodsFocusDao {

	/**
	 * add
	 */
	public int add(GoodsFocus goodsFocus);

	/**
	 * update
	 */
	public int update(GoodsFocus goodsFocus);

	/**
	 * delete
	 */
	public void deleteById(long id);

	/**
	 * deleteByIds
	 */
	// public void deleteByIds(List<long> ids);

	/**
	 * get
	 * 
	 * @return
	 */
	public GoodsFocus get(long id);

	/**
	 * getList
	 * 
	 * @return
	 */
	public long getListRowsByMemberId(Map<String, Object> map);

	/**
	 * getListPage
	 * 
	 * page,pagesize,key
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getListPage(Map<String, Object> map);

	/**
	 * getRows
	 * 
	 * @param map
	 * @return id desc,name ,date asc
	 */
	public Long getRows(Map<String, Object> map);

	/**
	 * 获取关注列表
	 * 
	 * @param request
	 * @return
	 */
	public List<Map<String, Object>> getGoodsFocusList(Map<String, Object> map);

	/**
	 * 根据会员id，删除商品关注
	 * @param map
	 * {goodsPriceId:商品定价id,
	 * memberId:会员id,
	 * unitId:单位id}
	 */
	public void cancelGoodsFocus(Map<String, Object> map);
	
	/**
	 * 得到会员关注商品的数量（用于判断会员是否关注指定商品）
	 * @param map
	 * {goodsPriceId:商品定价id,
	 * memberId:会员id}
	 * @return
	 */
	public long getMemberFocusGoodsRows(Map<String,Object> map);
	
}