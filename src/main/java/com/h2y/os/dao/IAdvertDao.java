package com.h2y.os.dao;

import java.util.List;
import java.util.Map;



import com.h2y.os.entity.AdvertColumn;

/**
 * 项目名称：h2ybmg2  
 * 类名称：IAdvertDao  
 * 类描述：广告数据库操作接口 （广告栏位、广告主题）
 * 创建人：侯飞龙  
 * 创建时间：2015年4月7日 上午9:18:47  
 * 修改人：侯飞龙
 * 修改时间：2015年4月7日 上午9:18:47  
 * 修改备注：  
 * @version
 */

public interface IAdvertDao{

	/**
	 * 得到单位对应的广告栏位的列表
	 * @param unitId 单位id
	 * @return
	 */
	public List<AdvertColumn> getAdvertColumnListMap(long unitId);


	/**
	 * 得到广告栏位主题
	 * @param map
	 * {columnId:栏位id,
	 * unitId:单位id,
	 * os:系统 （ios:苹果、android：安卓、wechat:微信）,
	 * url:广告栏  宣传页面跳转url}
	 * @return
	 */
	public List<Map<String,Object>> getAdvertColumnSubject(Map<String,Object> map);

	/**
	 * 得到广告主题商品列表
	 * @param map
	 * {subjectId:主题id,
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public List<Map<String,Object>> getAdvertSubjectGoodsList(Map<String,Object> map);


	/**
	 * 根据主题id，得到对应的商品定价id（适用于主题类型为商品详细的情况）
	 * @param subjectId 主题id
	 * @return
	 */
	public Long getGoodsPriceIdBySubjectId(long subjectId);


	/**
	 * 得到广告栏位主题
	 * @param id  栏位主题id
	 * @return
	 */
	public Map<String,Object> getAdvertColumnSubjectById(long id);

	/**
	 * 根据主题id，获取对应的活动列表
	 * @param subjectId 广告主题id
	 * @return
	 */
	public List<Map<String,Object>> getActivityListBySubjectId(long subjectId);


	/**
	 * 根据id，获取广告主题
	 * @param id 主题id
	 * @return
	 */
	public Map<String,Object> getAdvertSubjectById(long id);

	/**
	 * 由主题id获取主题头部图片
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> getAdvertSubjectHeadImg(Map<String,Object> map);

}