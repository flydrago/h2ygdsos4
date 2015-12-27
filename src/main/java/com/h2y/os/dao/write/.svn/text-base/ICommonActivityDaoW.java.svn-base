package com.h2y.os.dao.write;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 类描述：一般活动（白酒促销、红酒促销等）数据库操作   
 * 作者：侯飞龙
 * 时间：2015年1月9日下午5:37:10
 * 邮件：1162040314@qq.com
 */
@Component
public interface ICommonActivityDaoW{

	

	/**
	 * 更新商品价格表，活动价格和活动标识
	 * @param map
	 * isActivity：商品是否参与活动（1：参与、0：不参与）
	 * activityPrice：商品活动价格
	 * activityGoodsId：一般活动商品关联Id
	 * activityType：活动类型（0：一般活动eg:白酒促销等）
	 * id：商品价格主键Id
	 */
	public void updateGoodsPrize(Map<String,Object> map);

	

}