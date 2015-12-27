package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.ICommonDaoR;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.entity.SysUnits;
import com.h2y.os.entity.Zone;

@Service("commonDao")
public class CommonDaoImpl implements ICommonDao{
	
	@Autowired
	protected ICommonDaoR commonDaoR;
	

	public SysUnits getSysUnitsById(long id) {
		return commonDaoR.getSysUnitsById(id);
	}
	
	public SysUnits getSysUnitsByDomain(String domain) {
		return commonDaoR.getSysUnitsByDomain(domain);
	}

	public List<SysUnits> getListByZoneCodeAndUnitType(Map<String, Object> map) {
		return commonDaoR.getListByZoneCodeAndUnitType(map);
	}

	public Zone getZoneByCode(String code) {
		return commonDaoR.getZoneByCode(code);
	}

	public MemberUser getMemberUser(long id) {
		return commonDaoR.getMemberUser(id);
	}

	public MemberUser getMemberByAccount(String account) {
		return commonDaoR.getMemberByAccount(account);
	}

	public MemberUser getMemberByUuid(String uuid) {
		return commonDaoR.getMemberByUuid(uuid);
	}

}
