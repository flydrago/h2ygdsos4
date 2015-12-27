package com.h2y.os.dao.read;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 类描述：一般活动（白酒促销、红酒促销等）数据库操作   
 * 作者：侯飞龙
 * 时间：2015年1月9日下午5:37:10
 * 邮件：1162040314@qq.com
 */
@Component
public interface ICommonActivityDaoR{

	/**
	 * 得到活动列表
	 * @param map
	 * unitId:单位Id
	 * activityType:活动类型
	 * @return
	 */
	public List<Map<String,Object>> getAcitivityListMap(Map<String,Object> map);

	/**
	 * 根据活动Id或主题Id，得到对应的商品列表
	 * @param map
	 * {dataId：活动、主题Id,
	 * dataType：（0:活动，1:主题），
	 * unitId：单位Id，
	 * unitType：单位类型，
	 * goodsTypeId：商品类型Id（null时，不做判断），
	 * keyWord：关键字 模糊查询（null时，不做判断），
	 * sortname：排序字段，
	 * sortorder：排序方式，
	 * page：页码，
	 * pagesize：页显示最大记录数}
	 * @return
	 */
	public List<Map<String,Object>> getGoodsListByActivityId(Map<String,Object> map);

	/**
	 * 得到商品价格标识未更新，但已开始的活动商品
	 * @return
	 */
	public List<Map<String,Object>> getStartAcitivityGoodsListMap();


	/**
	 * 得到商品价格标识未更新，但已结束的活动商品
	 * @return
	 */
	public List<Map<String,Object>> getEndAcitivityGoodsListMap();


	/**
	 * 得到促销活动主题列表
	 * @param map
	 * {activityId:活动Id,
	 * unitId:单位Id,
	 * os:系统 （ios:苹果、android：安卓、wechat:微信）,
	 * url:宣传页面跳转url}
	 */
	public List<Map<String,Object>> getSubjectList(Map<String,Object> map);

	/**
	 * 根据id，得到活动商品详细
	 * @param id 主键
	 * @return
	 */
	public Map<String,Object> getCommonActivityGoodsById(long id);

	/**
	 * 得到促销活动商品列表
	 * @param map
	 * {dataId:数据id （促销活动id、促销主题id),
	 * dataType:数据类型 （0：促销活动id，1：促销主题id）}
	 * @return
	 */
	public List<Map<String,Object>> getCommonActivityGoodsList(Map<String,Object> map);

	/**
	 * 根据id，得到促销主题信息
	 * @param id 促销主题id
	 * @return
	 */
	public Map<String,Object> getCommonSubjectById(long id);


	/**
	 * 获取秒杀活动列表
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getCommonSpikeList(Map<String,Object> map);


	/**
	 * 获取秒杀活动商品列表
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getCommonSpikeGoodsList(Map<String,Object> map);

	/**
	 * 获取下场预告
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getCommonNextSpikeGoodsList(Map<String,Object> map);


	/**
	 * 根据id获取当前活动数据
	 * @param map
	 * @return
	 */
	public Map<String,Object> getCommonAcitivityById(Map<String,Object> map);

}