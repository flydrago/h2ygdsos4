package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IZoneDaoR;
import com.h2y.os.entity.Zone;

@Service("zoneDao")
public class ZoneDaoImpl implements IZoneDao{
	@Autowired
	protected IZoneDaoR zoneDaoR;

	public Zone get(long id) {
		return zoneDaoR.get(id);
	}

	public Zone getByZoneCode(String zoneCode) {
		return zoneDaoR.getByZoneCode(zoneCode);
	}

	public List<Zone> getListByName(String zoneName) {
		return zoneDaoR.getListByName(zoneName);
	}

	public List<Map<String, Object>> getCheckZoneList() {
		return zoneDaoR.getCheckZoneList();
	}

	public List<Map<String, Object>> getZoneList(Map<String, Object> map) {
		return zoneDaoR.getZoneList(map);
	}

}
