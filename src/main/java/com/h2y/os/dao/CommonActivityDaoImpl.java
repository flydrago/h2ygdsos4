package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.ICommonActivityDaoR;
import com.h2y.os.dao.write.ICommonActivityDaoW;


@Service("commonActivityDao")
public class CommonActivityDaoImpl implements ICommonActivityDao{
	
	@Autowired
	protected ICommonActivityDaoR commonActivityDaoR;
	
	@Autowired
	protected ICommonActivityDaoW commonActivityDaoW;

	public List<Map<String, Object>> getAcitivityListMap(Map<String, Object> map) {
		return commonActivityDaoR.getAcitivityListMap(map);
	}

	public List<Map<String, Object>> getGoodsListByActivityId(
			Map<String, Object> map) {
		return commonActivityDaoR.getGoodsListByActivityId(map);
	}

	public List<Map<String, Object>> getStartAcitivityGoodsListMap() {
		return commonActivityDaoR.getStartAcitivityGoodsListMap();
	}

	public List<Map<String, Object>> getEndAcitivityGoodsListMap() {
		return commonActivityDaoR.getEndAcitivityGoodsListMap();
	}

	public void updateGoodsPrize(Map<String, Object> map) {
		commonActivityDaoW.updateGoodsPrize(map);
	}

	public List<Map<String, Object>> getSubjectList(Map<String, Object> map) {
		return commonActivityDaoR.getSubjectList(map);
	}

	public Map<String, Object> getCommonActivityGoodsById(long id) {
		return commonActivityDaoR.getCommonActivityGoodsById(id);
	}

	public List<Map<String, Object>> getCommonActivityGoodsList(
			Map<String, Object> map) {
		return commonActivityDaoR.getCommonActivityGoodsList(map);
	}

	public Map<String, Object> getCommonSubjectById(long id) {
		return commonActivityDaoR.getCommonSubjectById(id);
	}

	public List<Map<String, Object>> getCommonSpikeList(Map<String, Object> map) {
		return commonActivityDaoR.getCommonSpikeList(map);
	}

	public List<Map<String, Object>> getCommonSpikeGoodsList(
			Map<String, Object> map) {
		return commonActivityDaoR.getCommonSpikeGoodsList(map);
	}

	public List<Map<String, Object>> getCommonNextSpikeGoodsList(
			Map<String, Object> map) {
		return commonActivityDaoR.getCommonNextSpikeGoodsList(map);
	}

	public Map<String, Object> getCommonAcitivityById(Map<String, Object> map) {
		return commonActivityDaoR.getCommonAcitivityById(map);
	}

}
