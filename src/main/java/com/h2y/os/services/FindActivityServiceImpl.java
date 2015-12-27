package com.h2y.os.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.IFindActivityDao;

/**
 * 小达快报
 * @author sunfj
 *
 */
@Service("findActivityService")
public class FindActivityServiceImpl implements IFindActivityService {

	@Autowired
	protected IFindActivityDao findActivityDao;

	/**
	 * 获取当前区域公司id
	 */
	public long getUnitByZoneCode(String zoneCode) {
		List<Map<String, Object>> list = findActivityDao
				.getUnitByZoneCode(zoneCode);
		if (null != list && list.size() > 0) {
			return (Long) list.get(0).get("id");
		} else {
			return 0;
		}

	}

	/**
	 * 获取小达快报列表
	 * unitId  公司id
	 * page 分页
	 * pagesize 分页
	 */
	public List<Map<String, Object>> getListMap(Map<String, Object> map) {
		return findActivityDao.getListMap(map);
	}

	/**
	 * 获取当前快报详情
	 * id  快报id
	 */
	public List<Map<String, Object>> get(long id) {
		return findActivityDao.get(id);
	}

	/**
	 * 获取总记录数
	 * unitId 公司id
	 */
	public long getListCount(Map<String, Object> map) {
		return this.findActivityDao.getListCount(map);
	}

}
