package com.h2y.os.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.os.services.IThirdService;

/**
 * 类描述：第三方接口   
 * 作者：侯飞龙
 * 时间：2015年1月16日下午3:21:04
 * 邮件：1162040314@qq.com
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/third")
public class ThirdController extends BaseController{
	
	@Autowired
	protected IThirdService thirdService;
	
	@RequestMapping(value="/agentDriver")
	public void agentDriver(){
		
		out(thirdService.agentDriver(request));
	}
	
	
	@RequestMapping(value="/dingFang")
	public void dingFang(){
		
		out(thirdService.agentDriver(request));
	}
}
