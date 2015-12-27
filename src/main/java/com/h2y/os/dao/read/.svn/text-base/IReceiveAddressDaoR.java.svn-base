package com.h2y.os.dao.read;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.ReceiveAddress;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IReceiveAddressDao  
 * 类描述：收货地址数据库操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:16:16  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:16:16  
 * 修改备注：  
 * @version
 */
@Component
public interface IReceiveAddressDaoR{

	
	/**
	 * get
	 * @return
	 */
	public ReceiveAddress get(long id);
	
	/**
	 * 根据会员Id，得到对应的收货地址列表
	 * @param map
	 * {memberId 会员id,
	 * zoneId:当前区域id,
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public List<Map<String,Object>> getListMap(Map<String,Object> map);
	
}