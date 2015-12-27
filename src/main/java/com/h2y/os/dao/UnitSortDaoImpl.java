package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IUnitSortDaoR;

@Service("unitSortDao")
public class UnitSortDaoImpl implements IUnitSortDao{

	@Autowired
	protected IUnitSortDaoR unitSortDaoR;
	
	public List<Map<String, Object>> getListMap(Map<String, Object> map) {
		return unitSortDaoR.getListMap(map);
	}

	public List<Map<String, Object>> getShopListBySort(Map<String, Object> map) {
		return unitSortDaoR.getShopListBySort(map);
	}

	public List<Map<String, Object>> getLifeShopList2_1(Map<String, Object> map) {
		return unitSortDaoR.getLifeShopList2_1(map);
	}

	public List<Map<String, Object>> getConditionListMap(Map<String, Object> map) {
		return unitSortDaoR.getConditionListMap(map);
	}

}
