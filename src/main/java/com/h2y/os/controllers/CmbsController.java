package com.h2y.os.controllers;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.util.DataRequestUtil;
import com.h2y.util.JSONUtil;

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
@RequestMapping(value="/cmbs/{moduleName}")
public class CmbsController extends BaseController{
	
	@RequestMapping(value="/{methodName}")
	public void getList(@PathVariable(value="moduleName") String moduleName,@PathVariable(value="methodName") String methodName){
		
		String postDataJson = request.getParameter("postData");
		Map<String,Object> postData = JSONUtil.getMap(postDataJson);
		String result = DataRequestUtil.getRequestResultStr(moduleName+"/"+methodName+".htm", postData);
		out(result);
	}
	
}
