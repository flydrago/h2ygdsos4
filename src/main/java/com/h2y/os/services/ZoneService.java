package com.h2y.os.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.entity.SysUnits;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.JSONUtil;

@Service("zoneService")
public class ZoneService implements IZoneService{
	
	private final static Logger logger = Logger.getLogger(ZoneService.class);
	@Autowired
	protected ICommonDao commonDao;

	public Map<String, Object> getZoneCode(Map<String,Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			//城市名称
			String zoneCode = paraMap.get("zoneCode")+"";
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {//当前单位不是区域代理
				return DataResponseUtil.getResultData(reqMap, 0 , "当前单位不合法！");
			}
			result = DataResponseUtil.getResultData(reqMap, 1, "获取单位信息成功！", sysUnits);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "获取单位信息失败，出现异常！");
		}
		return result;
	}
}
