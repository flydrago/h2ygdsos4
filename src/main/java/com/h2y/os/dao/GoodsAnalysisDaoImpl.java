package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IGoodsAnalysisDaoR;
import com.h2y.os.dao.write.IGoodsAnalysisDaoW;
import com.h2y.os.entity.GoodsAnalysis;

@Service("goodsAnalysisDao")
public class GoodsAnalysisDaoImpl implements IGoodsAnalysisDao{
	
	@Autowired
	protected IGoodsAnalysisDaoR goodsAnalysisDaoR;
	
	@Autowired
	protected IGoodsAnalysisDaoW goodsAnalysisDaoW;

	public int add(GoodsAnalysis goodsAnalysis) {
		return goodsAnalysisDaoW.add(goodsAnalysis);
	}

	public int update(GoodsAnalysis goodsAnalysis) {
		return goodsAnalysisDaoW.update(goodsAnalysis);
	}

	public int deleteById(long id) {
		return goodsAnalysisDaoW.deleteById(id);
	}

	public GoodsAnalysis get(long id) {
		return goodsAnalysisDaoR.get(id);
	}

	public List<Map<String, Object>> getGoodsAnalysisListByUser(
			Map<String, Object> map) {
		return goodsAnalysisDaoR.getGoodsAnalysisListByUser(map);
	}

	public List<Map<String, Object>> getGoodsAnalysisListAll(
			Map<String, Object> map) {
		return goodsAnalysisDaoR.getGoodsAnalysisListAll(map);
	}

	public List<Map<String, Object>> getGoodsAnalysisListByUser9(
			Map<String, Object> map) {
		return goodsAnalysisDaoR.getGoodsAnalysisListByUser9(map);
	}

	public List<Map<String, Object>> getZoneListByCode(Map<String, Object> map) {
		return goodsAnalysisDaoR.getZoneListByCode(map);
	}

	public List<Map<String, Object>> getGoodsAnalysisListAll2(
			Map<String, Object> map) {
		return goodsAnalysisDaoR.getGoodsAnalysisListAll2(map);
	}

}
