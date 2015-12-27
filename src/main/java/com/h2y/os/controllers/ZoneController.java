package com.h2y.os.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.os.services.IZoneService;
import com.h2y.util.DataResponseUtil;

/**
 * 项目名称：h2ygdsos  
 * 类名称：ZoneController  
 * 类描述：区域服务Controller  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月1日 下午4:21:31  
 * 修改人：侯飞龙
 * 修改时间：2015年4月1日 下午4:21:31  
 * 修改备注：  
 * @version
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/zone")
public class ZoneController extends BaseController{
	
	@Autowired
	protected IZoneService zoneService;
	
	/**
	 * 根据客户端定位信息，得到对应的区域编码
	 */
	@RequestMapping(value = "/getZoneCode")
	public void getZoneCode(){
		outJson(zoneService.getZoneCode(getReqMap()));
	}
}
