package com.h2y.os.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.h2y.os.basic.BaseController;
import com.h2y.os.dao.ICommonActivityDao;
import com.h2y.os.services.ICommonActivityService;

/**
 * 类描述：一般活动（白酒促销、红酒促销等）维护os服务Controller   
 * 作者：侯飞龙
 * 时间：2015年1月9日上午10:08:42
 * 邮件：1162040314@qq.com
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/commonactivity")
public class CommonActivityController extends BaseController{

	private final static Logger logger = Logger.getLogger(CommonActivityController.class);

	@Autowired
	protected ICommonActivityService commonActivityService;

	@Autowired
	protected ICommonActivityDao commonActivityDao;

	/**
	 * 获取活动列表
	 */
	@RequestMapping(value="/getList")
	public void getList(){

		outJson(commonActivityService.getList2_1(getReqMap()));
	}


	/**
	 * 获取活动列表 2.1以上版本
	 */
	@RequestMapping(value="/getList2_1")
	public void getList2_1(){

		outJson(commonActivityService.getList2_1(getReqMap()));
	}

	/**
	 * 获取活动商品列表
	 */
	@RequestMapping(value="/getGoodsList")
	public void getGoodsList(){

		outJson(commonActivityService.getGoodsList(getReqMap()));
	}


	/**
	 * 获取活动主题对应的商品详细
	 */
	@RequestMapping(value="/getGoodsDetail")
	public void getGoodsDetail(){

		outJson(commonActivityService.getGoodsDetail(getReqMap()));
	}

	/**
	 * 更新活动商品价格及标识
	 */
	@RequestMapping(value="/updateGoods")
	public void updateGoods(){

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result", 1);
		try {

			commonActivityService.updateActivityGoodsPrize();
		} catch (Exception e) {
			map.put("result", 0);
			logger.error(e.getMessage(),e);
		}
		outJson(map);
	}


	/**
	 * 促销主题 宣传页面跳转
	 * @param id 主题id
	 * @return
	 */
	@RequestMapping(value = "/detail")
	public ModelAndView detail(long id) {

		ModelAndView view = new ModelAndView();
		view.setViewName("server/detail/detail");
		Map<String,Object> dataMap = commonActivityDao.getCommonSubjectById(id);
		view.addObject("title",dataMap.get("subject_name"));
		view.addObject("content", dataMap.get("subject_content"));
		return view;
	}

}
