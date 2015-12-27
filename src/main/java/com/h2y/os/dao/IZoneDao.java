package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import com.h2y.os.entity.Zone;


public interface IZoneDao {
	
	/**
	 * 根据id，获取区域信息
	 * @param id 主键
	 * @return
	 */
	public Zone get(long id);
	
	/**
	 * 根据区域编码，得到区域的信息
	 * @param zoneCode 区域编码
	 * @return
	 */
	public Zone getByZoneCode(String zoneCode);
	
	
	/**
	 * 根据区域名称，得到开设区域代理的区域信息
	 * @param zoneName 区域名称（区县或城市名）
	 * @return
	 */
	public List<Zone> getListByName(String zoneName);
	
	/**
	 * 得到审核通过的区域代理的区域信息列表
	 * @return
	 */
	public List<Map<String,Object>> getCheckZoneList();
	
	/**
	 * 得到区域列表
	 * @param map
	 * {code:父级编码}
	 * @return
	 */
	public List<Map<String,Object>> getZoneList(Map<String,Object> map);
}
