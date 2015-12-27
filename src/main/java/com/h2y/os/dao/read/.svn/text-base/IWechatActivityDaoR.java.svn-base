package com.h2y.os.dao.read;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.h2y.os.entity.WechatActivity;
import com.h2y.os.entity.WechatActivityPrize;

/**
 * 类描述：微活动数据库操作接口   
 * 作者：侯飞龙
 * 时间：2014年12月17日上午11:33:49
 * 邮件：1162040314@qq.com
 */
@Component
public interface IWechatActivityDaoR{

	/**
	 * 得到活动规则明细
	 * @return
	 */
	public WechatActivity getWechatActivity(long id);
	
	
	/**
	 * 得到开始的微活动
	 * @param map
	 * key1:activityType value1:活动类型
	 * key2:unitId value2:单位Id
	 * @return
	 */
	public List<Map<String,Object>> getStartWechatActivity(Map<String,Object> map);
	
	
	
	/**
	 * 根据活动Id，得到活动对应的奖项列表
	 * @param activityId 活动Id
	 * @return 倒序列表
	 */
	public List<WechatActivityPrize> getPrizeListByActivityId(long activityId);
	
	/**
	 * 根据活动Id，得到显示的活动对应的奖项列表
	 * @param activityId 活动Id
	 * @return 倒序列表
	 */
	public List<WechatActivityPrize> getShowPrizeListByActivityId(long activityId);
	
	/**
	 * 得到用户参与活动的次数，根据活动限制类型
	 * @param map
	 * key1:activityId value1:活动ID
	 * key2:memberId value2:会员Id
	 * key4:limitFlag value4:限制类型 0：当天参与次数
	 * @return
	 */
	public long getActivityHisRowsByLimitType(Map<String,Object> map);
	
	
	/**
	 * 得到活动抽中奖品的数量
	 * @param map
	 * key1:activityId value1:活动Id
	 * key2:prizeId value2:奖品Id
	 * @return
	 */
	public long getHitPrizeRowsByActivityId(Map<String,Object> map);
	
	/**
	 * 得到第一个活动信息
	 * @param map
	 * key1:activityType value1:活动类型
	 * key2:unitId value2:单位Id
	 * @return
	 */
	public WechatActivity getOneStartWechatActivity(Map<String,Object> map);
}