package com.h2y.os.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.os.services.IGoodsService;

/**
 * 项目名称：h2ygdsos 类名称：GoodsController 类描述： 商品os服务（商品列表、详细、商品类型列表） 创建人：侯飞龙
 * 创建时间：2015年4月1日 上午11:47:31 修改人：侯飞龙 修改时间：2015年4月1日 上午11:47:31 修改备注：
 * 
 * @version
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/server/goods")
public class GoodsController extends BaseController {

	@Autowired
	protected IGoodsService goodsService;

	/**
	 * 获取H2Y自营的商品
	 */
	@RequestMapping(value = "/selfList")
	public void selfList() {

		outJson(goodsService.getSelfList(getReqMap()));


	}

	/**
	 * 获取商品详细
	 */
	@RequestMapping(value = "/getDetail")
	public void getDetail() {
		outJson(goodsService.getGoodsDetail(getReqMap()));

	}

	/**
	 * 获取商品类型列表
	 */
	@RequestMapping(value = "/getGoodsTypeList")
	public void getGoodsTypeList() {

		outJson(goodsService.getGoodsTypeList(getReqMap()));
	}

	/**
	 * 获取关注列表
	 */
	@RequestMapping(value = "/getGoodsFocusList")
	public void getGoodsFocusList(HttpServletRequest request,
			HttpServletResponse response) {

		outJson(goodsService.getGoodsFocusList(getReqMap()));

	}

	/**
	 * 关注商品
	 */
	@RequestMapping(value = "/addGoodsFocus")
	public void addGoodsFocus() {

		outJson(goodsService.addGoodsFocus(getReqMap()));


	}

	/**
	 * 取消关注
	 */
	@RequestMapping(value = "/cancelGoodsFocus")
	public void cancelGoodsFocus() {

		outJson(goodsService.cancelGoodsFocus(getReqMap()));

	}

	/**
	 * 获取规格列表
	 */
	@RequestMapping(value = "/getRelationList")
	public void getRelationList(){

		outJson(goodsService.getRelationList(getReqMap()));
	}

}
