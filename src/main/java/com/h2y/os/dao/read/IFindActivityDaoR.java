package com.h2y.os.dao.read;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * FindActivityDaoInterface,order CRUD ;CRUD:Create,Retrieve/Read,Update,Delete
 * 
 * @author hwttnet version:1.2 time:2014-12-10 email:info@hwttnet.com
 */
@Component
public interface IFindActivityDaoR {

	/**
	 * 得到分页列表
	 * 
	 * @param map
	 *            key1:unitId value1:单位Id key2:ifQuery value2:查询条件 null时：不做判断
	 *            key3:sortname、sortorder value3:排序字段、排序方式 key4:page、pagesize
	 *            value4:页码、页显示最大记录数
	 * @return
	 */
	public List<Map<String, Object>> getListMap(Map<String, Object> map);

	/**
	 * 根据zoneCode获取公司信息
	 * 
	 * @param zoneCode
	 * @return
	 */
	public List<Map<String, Object>> getUnitByZoneCode(String zoneCode);

	/**
	 * 获取当前快报详情
	 * 
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> get(long id);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public long getListCount(Map<String, Object> map);

}