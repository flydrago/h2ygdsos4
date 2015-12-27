package com.h2y.os.controllers;

import java.util.Enumeration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.h2y.os.basic.BaseController;

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
@RequestMapping(value="/server/{moduleName}")
public class CommonController extends BaseController{
	
	/**
	 * 通用跳转
	 * @return
	 */
	@RequestMapping(value = "/{methodName}")
	public ModelAndView detail(@PathVariable(value="moduleName") String moduleName,@PathVariable(value="methodName") String methodName) {

		ModelAndView view = new ModelAndView();
		
		Enumeration<String> names=(Enumeration<String>)request.getParameterNames();
	    while(names.hasMoreElements()){
	          String name=names.nextElement();
	          view.addObject(name, request.getParameter(name));
	    }
		view.setViewName("server/"+moduleName+"/"+methodName);
		return view;
	}
	
}
