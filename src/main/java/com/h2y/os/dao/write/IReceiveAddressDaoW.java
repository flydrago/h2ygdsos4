package com.h2y.os.dao.write;

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
public interface IReceiveAddressDaoW{

	/**
	 * add
	 */
	public void add(ReceiveAddress receiveAddress);
	
	/**
	 * update
	 */
	public void update(ReceiveAddress receiveAddress);
	
	/**
	 * 根据会员id，修改其对应的默认收货地址为一般地址
	 * @param memberId 会员Id
	 */
	public void updateUnDefaultByMemberId(String memberId);
	
	/**
	 * delete
	 */
	public void deleteById(long id);
	
	
	
}