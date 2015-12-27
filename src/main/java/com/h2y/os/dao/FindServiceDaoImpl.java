package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IFindServiceDaoR;

@Service("findServiceDao")
public class FindServiceDaoImpl implements IFindServiceDao{
	
	@Autowired
	protected IFindServiceDaoR findServiceDaoR;
	

	public List<Map<String, Object>> getPublicServiceList2_1(
			Map<String, Object> map) {
		return findServiceDaoR.getPublicServiceList2_1(map);
	}

	public List<Map<String, Object>> getPrivateServiceList(
			Map<String, Object> map) {
		return findServiceDaoR.getPrivateServiceList(map);
	}

	public List<Map<String, Object>> getPublicServiceList(
			Map<String, Object> map) {
		return findServiceDaoR.getPublicServiceList(map);
	}

	public List<Map<String, Object>> getPublicServiceList2_2(
			Map<String, Object> map) {
		return findServiceDaoR.getPublicServiceList2_2(map);
	}

}
