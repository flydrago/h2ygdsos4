package com.h2y.os.services;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 类描述：一般活动业务接口（白酒促销、红酒促销等）   
 * 作者：侯飞龙
 * 时间：2015年1月9日下午3:38:42
 * 邮件：1162040314@qq.com
 */
public interface ICommonActivityService{


	/**
	 * 得到活动列表
	 * @param reqMap
	 * paraData={
	 * zoneCode:区域编码,
	 * activityType:活动类型（index:主页、other:其他）
	 * }
	 * @return
	 */
	public Map<String,Object> getList(Map<String,Object> reqMap);


	/**
	 * 得到活动列表 2.1以上版本
	 * @param reqMap
	 * paraData={
	 * zoneCode:区域编码,
	 * activityType:活动类型（index:主页、other:其他）
	 * }
	 * @return
	 */
	public Map<String,Object> getList2_1(Map<String,Object> reqMap);


	/**
	 * 得到活动商品列表
	 * @param reqMap
	 * paradata={
	 * zoneCode:区域编码,
	 * dataId:活动或主题Id,
	 * dataType:数据类型（0：活动、1：主题）
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public Map<String,Object> getGoodsList(Map<String,Object> reqMap);


	/**
	 * 得到主题对应的商品详细
	 * @param reqMap
	 * paradata={
	 * id:主题Id,
	 * memberId:会员id（未登录时可以不传）}
	 * @return
	 */
	public Map<String,Object> getGoodsDetail(Map<String,Object> reqMap);


	/**
	 * 更新活动商品价格及标识
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	public void updateActivityGoodsPrize();

}
