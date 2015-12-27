package com.h2y.os.services;

import java.util.Map;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IReceiveAddressService  
 * 类描述：收货地址业务操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:24:10  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:24:10  
 * 修改备注：  
 * @version
 */
public interface IReceiveAddressService{
	
	
	/**
	 * 添加收货地址
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * receiverZoneCode:收获地址区域编码,
	 * receiverZoneDetail:收货地址详细,
	 * receiverZoneName:收货地址名称,
	 * longitude:收货地址经度,
	 * latitude:收货地址纬度,
	 * receiverName:收货地址名称,
	 * receiverMobile:收货地址手机号码,
	 * receiverTelephone:收货地址固话,
	 * receiverMail:收货地址邮件,
	 * isDefault:是否为默认地址（0：否、1：是）
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> add(Map<String,Object> reqMap);
	
	/**
	 * 修改收货地址
	 * @param reqMap
	 * postData={
	 * id:收货地址主键id,
	 * receiverZoneCode:收获地址区域编码,
	 * memberId:会员id,
	 * receiverZoneDetail:收货地址详细,
	 * receiverZoneName:收货地址名称,
	 * longitude:收货地址经度,
	 * latitude:收货地址纬度,
	 * receiverName:收货地址名称,
	 * receiverMobile:收货地址手机号码,
	 * receiverTelephone:收货地址固话,
	 * receiverMail:收货地址邮件,
	 * isDefault:是否为默认地址（0：否、1：是）
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> update(Map<String,Object> reqMap);
	
	/**
	 * 设置默认收货地址
	 * @param reqMap
	 * postData={
	 * id:收货地址主键id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> setDefault(Map<String,Object> reqMap);
	
	/**
	 * 设置默认收货地址
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * page:页码,
	 * pagesize:也显示最大记录数}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:地址列表信息}
	 */
	public Map<String,Object> getList(Map<String,Object> reqMap);
	
	/**
	 * 设置默认收货地址
	 * @param reqMap
	 * postData={id:收货地址主键id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> delete(Map<String,Object> reqMap);
	
	
	/**
	 * 设置默认收货地址
	 * @param reqMap
	 * postData={id:收货地址主键id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public Map<String,Object> get(Map<String,Object> reqMap);
	
}
