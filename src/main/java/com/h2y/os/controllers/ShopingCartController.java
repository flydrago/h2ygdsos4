package com.h2y.os.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.os.services.IShoppingCartService;

/**
 * 项目名称：h2ygdsos  
 * 类名称：ReceiveAddressController  
 * 类描述：购物车服务接口（添加、减少、修改、删除、列表等）  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:21:54  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:21:54  
 * 修改备注：  
 * @version
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/shopingcart")
public class ShopingCartController extends BaseController{
	
	@Autowired
	protected IShoppingCartService shopingCartService;
	
	/**
	 * 添加购物车商品
	 */
	@RequestMapping(value="/add")
	public void add(){
		
		outJson(shopingCartService.add(getReqMap()));
	}
	
	
	/**
	 * 添加购物车商品
	 */
	@RequestMapping(value="/addBatch")
	public void addBatch(){
		
		outJson(shopingCartService.addBatch(getReqMap()));
	}
	
	/**
	 * 减少购物车商品数量
	 */
	@RequestMapping(value="/reduce")
	public void reduce(){
		
		outJson(shopingCartService.reduce(getReqMap()));
	}
	
	
	
	/**
	 * 修改购物车商品数量
	 */
	@RequestMapping(value="/update")
	public void update(){
		
		outJson(shopingCartService.update(getReqMap()));
	}
	

	/**
	 * 得到购物车列表
	 */
	@RequestMapping(value="/getList")
	public void getList(){
		
		outJson(shopingCartService.getList(getReqMap()));
	}
	
	/**
	 * 得到未登录的购物车列表
	 */
	@RequestMapping(value="/getUnLoginList")
	public void getUnLoginList(){
		
		outJson(shopingCartService.getUnLoginList(getReqMap()));
	}
	
	/**
	 * 删除购物车商品
	 */
	@RequestMapping(value="/delete")
	public void delete(){
		
		outJson(shopingCartService.delete(getReqMap()));
	}
	
	
	/**
	 * 同步购物车商品
	 */
	@RequestMapping(value="/syn")
	public void syn(){
		
		outJson(shopingCartService.syn(getReqMap()));
	}
	
	/**
	 * 清除购物车商品
	 */
	@RequestMapping(value="/clear")
	public void clear(){
		
		outJson(shopingCartService.clear(getReqMap()));
	}
	
	
	/**
	 * 得到购物车列表总数
	 */
	@RequestMapping(value="/getListRows")
	public void getListRows(){
		
		outJson(shopingCartService.getListRows(getReqMap()));
	}
}
