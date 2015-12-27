package com.h2y.os.dao.write;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.GoodsFocus;

/**
 * GoodsFocusDaoInterface,order CRUD ;CRUD:Create,Retrieve/Read,Update,Delete
 * 
 * @author hwttnet version:1.2 time:2015-04-10 email:info@hwttnet.com
 */
@Component
public interface IGoodsFocusDaoW {

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
	 * 取消关注
	 * 
	 * @param request
	 * @return
	 */
	public void cancelGoodsFocus(Map<String, Object> map);
	
	
}