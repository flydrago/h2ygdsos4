package com.h2y.os.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.os.services.ILocalServiceService;

/**
 * 生活+
 * @author sunfj
 *
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/localService")
public class LocalServiceController extends BaseController{
	@Autowired
	protected ILocalServiceService localServiceService;

	/**
	 * 本地服务分类列表
	 */
	@RequestMapping(value = "/getSortList")
	public void getSortList() {
		outJson(localServiceService.getSortList(getReqMap()));
	}

	/**
	 * 获取门店列表
	 */
	@RequestMapping(value = "/getShopListBySort")
	public void getShopListBySort(){
		outJson(localServiceService.getShopListBySort(getReqMap()));
	}


	/**
	 * 根据门店列表获取商品
	 */
	@RequestMapping(value = "/getGoodsListByShopId")
	public void getGoodsListByShopId(){
		outJson(localServiceService.getGoodsListByShopId(getReqMap()));
	}




	/**
	 * appv=2.1
	 * 生活+列表
	 */
	@RequestMapping(value = "/getLifeShopList2_1")
	public void getLifeShopList2_1(){
		outJson(localServiceService.getLifeShopList2_1(getReqMap()));
	}

	/**
	 * appv=2.1
	 * 生活+ 商品列表
	 */
	@RequestMapping(value = "/getLifeShopGoodsList2_1")
	public void getLifeShopGoodsList2_1(){
		outJson(localServiceService.getLifeShopGoodsList2_1(getReqMap()));
	}


	/**
	 * 获取筛选条件
	 */
	@RequestMapping(value = "/getConditionList2_1")
	public void getConditionList2_1(){
		outJson(localServiceService.getConditionList2_1(getReqMap()));
	}


}
