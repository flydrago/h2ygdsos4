package com.h2y.os.services;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 类描述：微活动业务Service接口   
 * 作者：侯飞龙
 * 时间：2014年12月17日上午11:34:30
 * 邮件：1162040314@qq.com
 */
public interface IWechatActivityService{
	
	
	/**
	 * 微活动页面初始化
	 * @param request 访问对象
	 * {zoneCode:区域编码,
	 * memberId: 会员Id}
	 * @param activityType 活动类型（wheel:大转盘、card:刮刮卡等）
	 * @return
	 */
	public Map<String,Object> init(HttpServletRequest request,String activityType);
	
	/**
	 * 微活动抽奖保存操作
	 * @param reqMap
	 * postData={
	 * zoneCode:区域编码,
	 * memberId:会员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:抽中的奖品信息（未抽中时，返回null）}
	 */
	public Map<String,Object> save(Map<String,Object> reqMap);
}
