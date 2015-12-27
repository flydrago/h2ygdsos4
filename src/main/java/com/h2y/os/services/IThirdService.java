package com.h2y.os.services;

import javax.servlet.http.HttpServletRequest;

/**
 * 类描述：第三方接口   
 * 作者：侯飞龙
 * 时间：2015年1月16日下午3:23:26
 * 邮件：1162040314@qq.com
 */
public interface IThirdService{
	
	/**
	 * 代驾下单
	 * @param request
	 * @return
	 */
	public String agentDriver(HttpServletRequest request);
	
	
	/**
	 * 代驾下单
	 * @param request
	 * @return
	 */
	public String dingFang(HttpServletRequest request);
}
