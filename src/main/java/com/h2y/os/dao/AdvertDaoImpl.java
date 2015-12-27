package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IAdvertDaoR;
import com.h2y.os.entity.AdvertColumn;


@Service("advertDao")
public class AdvertDaoImpl implements IAdvertDao{

	@Autowired
	protected IAdvertDaoR advertDaoR;


	public List<AdvertColumn> getAdvertColumnListMap(long unitId) {
		return advertDaoR.getAdvertColumnListMap(unitId);
	}

	public List<Map<String, Object>> getAdvertColumnSubject(Map<String, Object> map) {
		return advertDaoR.getAdvertColumnSubject(map);
	}

	public List<Map<String, Object>> getAdvertSubjectGoodsList(
			Map<String, Object> map) {
		return advertDaoR.getAdvertSubjectGoodsList(map);
	}

	public Long getGoodsPriceIdBySubjectId(long subjectId) {
		return advertDaoR.getGoodsPriceIdBySubjectId(subjectId);
	}

	public Map<String, Object> getAdvertColumnSubjectById(long id) {
		return advertDaoR.getAdvertColumnSubjectById(id);
	}

	public List<Map<String, Object>> getActivityListBySubjectId(long subjectId) {
		// TODO Auto-generated method stub
		return advertDaoR.getActivityListBySubjectId(subjectId);
	}

	public Map<String, Object> getAdvertSubjectById(long id) {
		// TODO Auto-generated method stub
		return advertDaoR.getAdvertSubjectById(id);
	}

	public List<Map<String, Object>> getAdvertSubjectHeadImg(Map<String,Object> map) {
		return advertDaoR.getAdvertSubjectHeadImg(map);
	}

}
