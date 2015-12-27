package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.ISysShopInfoDaoR;

@Service("sysShopInfoDao")
public class SysShopInfoDaoImpl implements ISysShopInfoDao{

	@Autowired
	protected ISysShopInfoDaoR sysShopInfoDaoR;

	public Map<String, Object> getShopInfoByShopId(long shopId) {
		return sysShopInfoDaoR.getShopInfoByShopId(shopId);
	}

	public Map<String, Object> getDepartmentById(long id) {
		return sysShopInfoDaoR.getDepartmentById(id);
	}

	public List<Map<String, Object>> getFileList(long shopId) {
		return sysShopInfoDaoR.getFileList(shopId);
	}

}
