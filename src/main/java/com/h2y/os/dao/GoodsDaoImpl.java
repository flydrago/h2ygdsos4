package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IGoodsDaoR;
import com.h2y.os.dao.write.IGoodsDaoW;
import com.h2y.os.entity.GoodsPrice;

@Service("goodsDao")
public class GoodsDaoImpl implements IGoodsDao{
	
	@Autowired
	protected IGoodsDaoR goodsDaoR;
	
	@Autowired
	protected IGoodsDaoW goodsDaoW;

	public GoodsPrice get(long id) {
		return goodsDaoR.get(id);
	}

	public List<Map<String, Object>> getListMap(Map<String, Object> map) {
		return goodsDaoR.getListMap(map);
	}

	public List<Map<String, Object>> getGoodsMarkInfo(Map<String, Object> map) {
		return goodsDaoR.getGoodsMarkInfo(map);
	}

	public List<Map<String, Object>> getGoodsImgList(Map<String, Object> map) {
		return goodsDaoR.getGoodsImgList(map);
	}

	public List<Map<String, Object>> getGoodsTypeListByParentId(long parentId) {
		return goodsDaoR.getGoodsTypeListByParentId(parentId);
	}

	public Map<String, Object> getGoodsInfo(Map<String, Object> map) {
		return goodsDaoR.getGoodsInfo(map);
	}

	public List<Map<String, Object>> getGiftListMap(Map<String, Object> map) {
		return goodsDaoR.getGiftListMap(map);
	}

	public List<Map<String, Object>> getMyLoveListMap(Map<String, Object> map) {
		return goodsDaoR.getMyLoveListMap(map);
	}

	public List<Map<String, Object>> getRelationListMap(Map<String, Object> map) {
		return goodsDaoR.getRelationListMap(map);
	}

	public void updateClickRateByGoodsPriceId(long id) {
		goodsDaoW.updateClickRateByGoodsPriceId(id);
	}

	public List<Map<String, Object>> getGoodsMarkByTypeId(long goodsTypeId) {
		return goodsDaoR.getGoodsMarkByTypeId(goodsTypeId);
	}

	public List<Map<String, Object>> getGoodsMarkInfoByMarkId(
			Map<String, Object> map) {
		return goodsDaoR.getGoodsMarkInfoByMarkId(map);
	}

	public List<Map<String, Object>> getListMap2_2(Map<String, Object> map) {
		return goodsDaoR.getListMap2_2(map);
	}

	public List<Long> getGoodsMarkInfoIdList(long unitId) {
		return goodsDaoR.getGoodsMarkInfoIdList(unitId);
	}

	public List<Long> getGoodsIdList(Map<String, Object> map) {
		return goodsDaoR.getGoodsIdList(map);
	}

}
