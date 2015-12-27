package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IFindActivityDaoR;

@Service("findActivityDao")
public class FindActivityDaoImpl implements IFindActivityDao{
	
	@Autowired
	protected IFindActivityDaoR findActivityDaoR;
	

	public List<Map<String, Object>> getListMap(Map<String, Object> map) {
		return findActivityDaoR.getListMap(map);
	}

	public List<Map<String, Object>> getUnitByZoneCode(String zoneCode) {
		return findActivityDaoR.getUnitByZoneCode(zoneCode);
	}

	public List<Map<String, Object>> get(long id) {
		return findActivityDaoR.get(id);
	}

	public long getListCount(Map<String, Object> map) {
		return findActivityDaoR.getListCount(map);
	}

}
