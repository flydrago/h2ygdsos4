package com.h2y.os.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.os.services.IReceiveAddressService;

/**
 * 项目名称：h2ygdsos  
 * 类名称：ReceiveAddressController  
 * 类描述：收货地址服务接口（添加、修改、删除等）  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:21:54  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:21:54  
 * 修改备注：  
 * @version
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/receiveaddress")
public class ReceiveAddressController extends BaseController{
	
	@Autowired
	protected IReceiveAddressService receiveAddressService;
	
	/**
	 * 添加收货地址
	 */
	@RequestMapping(value="/add")
	public void add(){
		
		outJson(receiveAddressService.add(getReqMap()));
	}
	
	/**
	 * 修改收货地址
	 */
	@RequestMapping(value="/update")
	public void update(){
		
		outJson(receiveAddressService.update(getReqMap()));
	}
	
	/**
	 * 设置默认地址
	 */
	@RequestMapping(value="/setDefault")
	public void setDefault(){
		
		outJson(receiveAddressService.setDefault(getReqMap()));
	}
	
	/**
	 * 得到默认地址列表
	 */
	@RequestMapping(value="/getList")
	public void getList(){
		
		outJson(receiveAddressService.getList(getReqMap()));
	}
	
	
	/**
	 * 删除收货地址
	 */
	@RequestMapping(value="/delete")
	public void delete(){
		
		outJson(receiveAddressService.delete(getReqMap()));
	}
	
	
	/**
	 * 得到收货地址
	 */
	@RequestMapping(value="/get")
	public void get(){
		
		outJson(receiveAddressService.get(getReqMap()));
	}
}
