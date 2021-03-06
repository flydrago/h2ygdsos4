package com.h2y.os.dao.read;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.GoodsFocus;

/**
 * GoodsFocusDaoInterface,order CRUD ;CRUD:Create,Retrieve/Read,Update,Delete
 * 
 * @author hwttnet version:1.2 time:2015-04-10 email:info@hwttnet.com
 */
@Component
public interface IGoodsFocusDaoR {

	

	/**
	 * get
	 * 
	 * @return
	 */
	public GoodsFocus get(long id);

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
	 * 得到会员关注商品的数量（用于判断会员是否关注指定商品）
	 * @param map
	 * {goodsPriceId:商品定价id,
	 * memberId:会员id}
	 * @return
	 */
	public long getMemberFocusGoodsRows(Map<String,Object> map);
}