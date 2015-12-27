package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IGoodsFocusDaoR;
import com.h2y.os.dao.write.IGoodsFocusDaoW;
import com.h2y.os.entity.GoodsFocus;

@Service("goodsFocusDao")
public class GoodsFocusDaoImpl implements IGoodsFocusDao{
	
	@Autowired
	protected IGoodsFocusDaoR goodsFocusDaoR;
	
	@Autowired
	protected IGoodsFocusDaoW goodsFocusDaoW;

	public int add(GoodsFocus goodsFocus) {
		return goodsFocusDaoW.add(goodsFocus);
	}

	public int update(GoodsFocus goodsFocus) {
		return goodsFocusDaoW.update(goodsFocus);
	}

	public void deleteById(long id) {
		goodsFocusDaoW.deleteById(id);
	}

	public GoodsFocus get(long id) {
		return goodsFocusDaoR.get(id);
	}

	public long getListRowsByMemberId(Map<String, Object> map) {
		return goodsFocusDaoR.getListRowsByMemberId(map);
	}

	public List<Map<String, Object>> getListPage(Map<String, Object> map) {
		return goodsFocusDaoR.getListPage(map);
	}

	public Long getRows(Map<String, Object> map) {
		return goodsFocusDaoR.getRows(map);
	}

	public List<Map<String, Object>> getGoodsFocusList(Map<String, Object> map) {
		return goodsFocusDaoR.getGoodsFocusList(map);
	}

	public void cancelGoodsFocus(Map<String, Object> map) {
		goodsFocusDaoW.cancelGoodsFocus(map);
	}

	public long getMemberFocusGoodsRows(Map<String, Object> map) {
		return goodsFocusDaoR.getMemberFocusGoodsRows(map);
	}

}
