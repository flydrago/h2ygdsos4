package com.h2y.os.dao.write;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.ClickRate;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IClickRateDao  
 * 类描述：点击率数据库操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年6月4日 下午2:36:18  
 * 修改人：侯飞龙
 * 修改时间：2015年6月4日 下午2:36:18  
 * 修改备注：  
 * @version
 */
@Component
public interface IClickRateDaoW{

	/**
	 * add
	 */
	public void add(ClickRate clickRate);
}