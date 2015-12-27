package com.h2y.os.controllers;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.h2y.os.basic.BaseController;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.services.IWechatActivityService;


/**
 * 项目名称：h2ygdsos  
 * 类名称：WechatActivityController  
 * 类描述：  微活动Controller
 * 创建人：侯飞龙  
 * 创建时间：2015年5月12日 上午11:12:45  
 * 修改人：侯飞龙
 * 修改时间：2015年5月12日 上午11:12:45  
 * 修改备注：  
 * @version
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/wechatactivity")
public class WechatActivityController extends BaseController{

	@Autowired
	protected IWechatActivityService wechatActivityService;

	/**
	 * 页面初始化
	 */
	@RequestMapping(value="/init")
	public ModelAndView init(String activityType){
		
		ModelAndView view = new ModelAndView();
		Map<String,Object> resultMap = wechatActivityService.init(request, activityType);
		
		if ("0".equals(resultMap.get(SInvokeKeys.resultFlag.value())+"")) {
			view.addObject("title", "游戏提示消息");
			view.addObject("msg", resultMap.get(SInvokeKeys.resultMsg.value()));
			view.setViewName("server/error");
			return view;
		}
		
		Map<String,Object> resultData = (Map<String, Object>) resultMap.get(SInvokeKeys.resultData.value());
		for (Entry<String, Object> entry : resultData.entrySet()) {
			view.addObject(entry.getKey(), entry.getValue());
        }  
		view.setViewName("server/wechatactivity/"+activityType);
		return view;
	}
	
	
	/**
	 * 保存操作
	 */
	@RequestMapping(value="/save")
	public void save(){
		
		outJson(wechatActivityService.save(getReqMap()));
	}
}
