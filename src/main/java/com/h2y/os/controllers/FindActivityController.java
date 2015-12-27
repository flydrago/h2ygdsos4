package com.h2y.os.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.h2y.os.basic.BaseController;
import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.services.IFindActivityService;
import com.h2y.os.util.SysBaseUtil;


/**
 * 小达快报
 * @author sunfj
 *
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/server/findActivity")
public class FindActivityController extends BaseController {

	@Autowired
	protected IFindActivityService findActivityService;

	/**
	 * 获取消息列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findActivityList")
	public ModelAndView findActivityList() {

		ModelAndView view = new ModelAndView();

		String zoneCode = request.getParameter(JydKeys.zoneCode.value());
		long unitId = this.findActivityService.getUnitByZoneCode(zoneCode);
		String pageNum = request.getParameter("page");
		int pagesize = 10;
		int page = 1;

		Map<String, Object> paramsMap = new HashMap<String, Object>();

		if (null != pageNum && !"".equals(pageNum)) {
			page = Integer.parseInt(pageNum);
		}

		paramsMap.put("unitId", unitId);
		paramsMap.put("pagesize", pagesize);
		paramsMap.put("page", page);

		List<Map<String, Object>> dataList = this.findActivityService
				.getListMap(paramsMap);

		if (null == dataList || dataList.isEmpty()) {

			view.addObject("title", "提示消息");
			view.addObject("msg", "暂无数据！");
			view.setViewName("server/error");
			return view;
		}
		view.addObject("page", page);
		view.addObject("zoneCode", zoneCode);
		view.addObject("pagesize", pagesize);
		view.addObject("dataList", dataList);
		view.addObject("fpUrl", SysBaseUtil.FP_URL);
		view.addObject("listCount", findActivityService.getListCount(paramsMap));
		view.setViewName("server/findactivity/findList");
		return view;
	}

	@RequestMapping(value = "/findActivityListJson")
	public void findActivityListJson() {

		String zoneCode = request.getParameter(JydKeys.zoneCode.value());
		long unitId = this.findActivityService.getUnitByZoneCode(zoneCode);
		String pageNum = request.getParameter("page");
		int pagesize = 10;
		int page = 1;

		Map<String, Object> paramsMap = new HashMap<String, Object>();

		if (null != pageNum && !"".equals(pageNum)) {
			page = Integer.parseInt(pageNum);
		}

		paramsMap.put("unitId", unitId);
		paramsMap.put("pagesize", pagesize);
		paramsMap.put("page", page);

		List<Map<String, Object>> dataList = this.findActivityService
				.getListMap(paramsMap);

		outJson(dataList);

	}

	/**
	 * 获取消息详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findActivityDetail")
	public ModelAndView findActivityDetail() {

		ModelAndView view = new ModelAndView();

		String id = request.getParameter("id");
		if (null != id && !"".equals(id)) {
			List<Map<String, Object>> dataList = findActivityService.get(Long
					.valueOf(id));
			if (null != dataList && !dataList.isEmpty()) {
				view.addObject("findDetail", dataList.get(0));
			} else {
				view.addObject("findDetail", new HashMap<String, Object>());
			}
			view.addObject("fpUrl", SysBaseUtil.FP_URL);
			view.setViewName("server/findactivity/findDetail");
		} else {
			view.addObject("title", "提示消息");
			view.addObject("msg", "数据加载失败！");
			view.setViewName("server/error");
			return view;
		}

		return view;
	}

}
