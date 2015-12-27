package com.h2y.os.services;

import java.util.List;
import java.util.Map;

public interface IFindActivityService {

	/**
	 * 获取列表
	 * unitId  公司id
	 * page 分页
	 * pagesize 分页
	 * @return
	 */
	public List<Map<String, Object>> getListMap(Map<String, Object> map);

	/**
	 * 根据区域码获取公司信息
	 * @param zoneCode
	 * @return
	 */
	long getUnitByZoneCode(String zoneCode);

	/**
	 * 获取当前快报详情
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> get(long id);

	/**
	 * 获取总记录数
	 * unitId 公司id
	 * @param map
	 * @return
	 */
	public long getListCount(Map<String, Object> map);

}
