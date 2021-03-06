package com.h2y.os.dao.read;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.MemberUser;
import com.h2y.os.entity.SysUnits;
import com.h2y.os.entity.Zone;


/**
 * 常见的数据库操作

 * 作者：侯飞龙

 * 时间：2014-10-13 上午11:31:51

 * 电子邮件：1162040314@qq.com
 */
@Component
public interface ICommonDaoR{
	
	/**
	 * 根据id，得到单位对象
	 * @param id
	 * @return
	 */
	public SysUnits getSysUnitsById(long id);
	
	/**
	 * 根据id，得到单位对象
	 * @param id
	 * @return
	 */
	public SysUnits getSysUnitsByDomain(String domain);
	
	/**
	 * 根据区域编码和单位类型得到单位列表
	 * @param map
	 * {zoneCode:区域编码,
	 * unitType:单位类型（0：区域代理、1：旗舰店、3：其他）}
	 * @return
	 */
	public List<SysUnits> getListByZoneCodeAndUnitType(Map<String,Object> map);
	
	/**
	 * 根据区域编码得到区域信息
	 * @param code 区域编码
	 * @return
	 */
	public Zone getZoneByCode(String code);
	
	/**
	 * 根据id，得到对应的会员信息
	 * @param id 会员id
	 * @return
	 */
	public MemberUser getMemberUser(long id);
	
	/**
	 * 根据account，得到对应的会员信息
	 * @param account
	 * @return
	 */
	public MemberUser getMemberByAccount(String account);
	
	/**
	 * 根据uuid，得到对应的会员信息
	 * @param uuid uuid
	 * @return
	 */
	public MemberUser getMemberByUuid(String uuid);
}