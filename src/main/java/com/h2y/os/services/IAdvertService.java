package com.h2y.os.services;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 类描述：广告栏位业务接口
 * 作者：侯飞龙
 * 时间：2015年1月9日下午3:38:42
 * 邮件：1162040314@qq.com
 */
public interface IAdvertService{
	
	
	/**
	 * 得到广告栏位列表
	 * @param reqMap
	 * paraData={
	 * zoneCode:区域编码
	 * }
	 * @return
	 */
	public Map<String,Object> getList(Map<String,Object> reqMap);
	
	/**
	 * 得到广告栏位商品列表
	 * @param reqMap
	 * paradata={
	 * zoneCode:区域编码,
	 * id:栏位主题Id,
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public Map<String,Object> getGoodsList(Map<String,Object> reqMap);
	
	/**
	 * 得到广告栏位对应的商品详细
	 * @param reqMap
	 * paradata={
	 * id:栏位主题Id,
	 * memberId:会员id}
	 * @return
	 */
	public Map<String,Object> getGoodsDetail(Map<String,Object> reqMap);
	
	/**
	 * 得到广告详细数据
	 * @param request
	 * @return
	 */
	public Map<String,Object> getDetail(HttpServletRequest request);

	/**
	 * 根据主题id，获取对应的促销商品数据
	 * @param reqMap
	 * paradata={id:栏位主题Id}
	 * @return
	 */
	public Map<String,Object> getPosterActivityDataBySubjectId(Map<String, Object> reqMap);
}
