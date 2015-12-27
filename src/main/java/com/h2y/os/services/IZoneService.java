package com.h2y.os.services;

import java.util.Map;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IZoneService  
 * 类描述：区域业务操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月1日 下午4:11:23  
 * 修改人：侯飞龙
 * 修改时间：2015年4月1日 下午4:11:23  
 * 修改备注：  
 * @version
 */
public interface IZoneService {

	/**
	 * 根据当前位置信息，得到对应的区域编码信息
	 * @param reqMap
	 * postdata={
	 * countyName:区县,
	 * cityName:城市名
	 * }
	 * @return
	 */
	public Map<String, Object> getZoneCode(Map<String,Object> reqMap);
}
