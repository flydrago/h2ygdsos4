package com.h2y.os.services;

import java.util.Map;

import com.h2y.os.entity.SysUnits;


/**
 * 项目名称：h2ygdsos  
 * 类名称：IGoodsService  
 * 类描述：商品业务操作接口
 * 创建人：侯飞龙  
 * 创建时间：2015年3月31日 下午4:07:15  
 * 修改人：侯飞龙
 * 修改时间：2015年3月31日 下午4:07:15  
 * 修改备注：  
 * @version
 */
public interface IGoodsService {

	/**
	 * 得到自营的商品列表
	 * @param reqMap
	 * postdata={
	 * zoneCode:区域编码,
	 * keyWord:关键字模糊查询（null时不做判断）,
	 * goodsTypeId:商品类型Id（null时不做判断）,
	 * page:页码,
	 * pagesize:页显示最大记录数,
	 * appVersion:app版本号,
	 * appSystem:（android:安卓、ios:苹果、wechat:微信）
	 * }
	 * @return
	 */
	public Map<String, Object> getSelfList(Map<String,Object> reqMap);

	/**
	 * 获取商品详细
	 * @param reqMap
	 * postdata={
	 * id:商品定价id,
	 * appVersion:app版本号,
	 * appSystem:（android:安卓、ios:苹果、wechat:微信）
	 * }
	 * @return
	 */
	public Map<String,Object> getGoodsDetail(Map<String,Object> reqMap);

	/**
	 * 获取商品类型列表
	 * @param reqMap
	 * postdata={
	 * appVersion:app版本号,
	 * appSystem:（android:安卓、ios:苹果、wechat:微信）
	 * }
	 * @return
	 */
	public Map<String,Object> getGoodsTypeList(Map<String,Object> reqMap);

	/**
	 * 获取关注列表
	 * @param request
	 * @return
	 */
	public Map<String,Object> getGoodsFocusList(Map<String,Object> reqMap);

	/**
	 * 新增关注
	 * @param request
	 * @return
	 */
	public Map<String,Object> addGoodsFocus(Map<String,Object> reqMap);


	/**
	 * 取消关注
	 * @param request
	 * @return
	 */
	public Map<String,Object> cancelGoodsFocus(Map<String,Object> reqMap);

	/**
	 * 获取商品数据
	 * @param goodsPriceId
	 * @param memberId
	 * @return
	 */
	public Map<String,Object> getGoodsDetail(Long goodsPriceId,String memberId,SysUnits sysUnits);

	/**
	 * 获取关联商品
	 * @param reqMap
	 * @return
	 */
	public Map<String,Object> getRelationList(Map<String,Object> reqMap);
	
}
