package com.h2y.os.dao.read;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.GoodsPrice;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IGoodsPriceDao  
 * 类描述：商品定价数据库操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月1日 上午9:03:55  
 * 修改人：侯飞龙
 * 修改时间：2015年4月1日 上午9:03:55  
 * 修改备注：  
 * @version
 */
@Component
public interface IGoodsDaoR{


	/**
	 * 得到商品定价信息
	 * @return
	 */
	public GoodsPrice get(long id);


	/**
	 * 获取商品列表 
	 * @param map
	 * {unitId:单位Id，
	 * unitType:单位类型（0：区域代理、1：旗舰店、3：其他），
	 * goodsTypeId:商品类型Id（null时，不做判断），
	 * keyWord:关键字 模糊查询，
	 * sortname:排序字段，
	 * sortorder:排序方式，
	 * page:页码，
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public List<Map<String,Object>> getListMap(Map<String,Object> map);

	/**
	 * 获取商品标签信息
	 * @param map
	 * {markInfoIds:标签信息}
	 * @return
	 */
	public List<Map<String,Object>> getGoodsMarkInfo(Map<String,Object> map);

	/**
	 * 得到商品的快照信息Id集合
	 * @param map
	 * {dataId:定价Id，
	 * dataVersion:定价版本号}
	 * @return
	 */
	public List<Map<String,Object>> getGoodsImgList(Map<String,Object> map);

	/**
	 * 根据父级Id，得到子级商品类型列表
	 * @param parentId 父级Id
	 * @return
	 */
	public List<Map<String,Object>> getGoodsTypeListByParentId(long parentId);

	/**
	 * 根据版本号和商品Id，得到对应的商品详细（商品介绍、规格）
	 * @param map
	 * {dataId:数据Id（dataType为0时为商品Id、1：定价商品Id）,
	 * version:版本号（dataType为0时为商品版本号、1：定价商品版本号）,
	 * dataType:0：商品、1：定价商品详细}
	 * @return
	 */
	public Map<String,Object> getGoodsInfo(Map<String,Object> map);


	/**
	 * 得到赠品列表
	 * @param map
	 * {unitId:单位Id，
	 * unitType:单位类型（0：区域代理、1：旗舰店、3：其他），
	 * goodsPriceId:商品定价Id（null时，不做判断），
	 * version:商品版本号}
	 * @return
	 */
	public List<Map<String,Object>> getGiftListMap(Map<String,Object> map);

	/**
	 * 得到我的酒爱列表
	 * @param map
	 * {unitId:单位Id,
	 * unitType:单位类型（0：区域代理、1：旗舰店、3：其他）,
	 * memberId:会员id,
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public List<Map<String,Object>> getMyLoveListMap(Map<String,Object> map);

	/**
	 * 获取
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getRelationListMap(Map<String,Object> map);


	


	/**
	 * 根据父级Id，得到二级分类列表（标签列表）
	 * @param parentId 父级Id
	 * @return
	 */
	public List<Map<String,Object>> getGoodsMarkByTypeId(long goodsTypeId);


	/**
	 * 根据父级Id，得到二级分类列表（标签详细列表）
	 * @param parentId 父级Id
	 * @return
	 */
	public List<Map<String,Object>> getGoodsMarkInfoByMarkId(Map<String,Object> map);


	/**
	 * 获取商品列表 
	 * @param map
	 * {unitId:单位Id，
	 * unitType:单位类型（0：区域代理、1：旗舰店、3：其他），
	 * goodsTypeId:商品类型Id（null时，不做判断），
	 * keyWord:关键字 模糊查询，
	 * sortname:排序字段，
	 * sortorder:排序方式，
	 * page:页码，
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public List<Map<String,Object>> getListMap2_2(Map<String,Object> map);


	/**
	 * 获取当前公司标签id
	 * @param unitId
	 * @return
	 */
	public List<Long> getGoodsMarkInfoIdList(long unitId);


	/**
	 * 获取拥有这些标签的商品id
	 * @param unitId
	 * @return
	 */
	public List<Long> getGoodsIdList(Map<String,Object> map);


}