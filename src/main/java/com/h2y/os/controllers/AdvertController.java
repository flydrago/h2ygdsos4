package com.h2y.os.controllers;


import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.h2y.os.basic.BaseController;
import com.h2y.os.dao.IAdvertDao;
import com.h2y.os.services.IAdvertService;

/**
 * 项目名称：h2ygdsos  
 * 类名称：AdvertController  
 * 类描述：广告服务  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月23日 上午11:58:58  
 * 修改人：侯飞龙
 * 修改时间：2015年4月23日 上午11:58:58  
 * 修改备注：  
 * @version
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/advert")
public class AdvertController extends BaseController{

	@Autowired
	protected IAdvertService advertService;

	@Autowired
	protected IAdvertDao advertDao;

	@RequestMapping(value="/getList")
	public void getList(){

		outJson(advertService.getList(getReqMap()));
	}

	@RequestMapping(value="/getGoodsList")
	public void getGoodsList(){

		outJson(advertService.getGoodsList(getReqMap()));
	}


	@RequestMapping(value="/getGoodsDetail")
	public void getGoodsDetail(){

		outJson(advertService.getGoodsDetail(getReqMap()));
	}

	/**
	 * 广告主题 宣传页面跳转
	 * @param id 广告栏位主题id
	 * @return
	 */
	@RequestMapping(value = "/detail")
	public ModelAndView detail() {

		ModelAndView view = new ModelAndView();
		Map<String,Object> initData = advertService.getDetail(request);
		for (Entry<String, Object> entry : initData.entrySet()) {
			view.addObject(entry.getKey(), entry.getValue());
		}
		view.setViewName("server/advert/detail");
		return view;
	}


	@RequestMapping(value="/getPosterActivityData")
	public void getActivityData(){

		outJson(advertService.getPosterActivityDataBySubjectId(getReqMap()));
	}

}
