package com.h2y.os.controllers;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.h2y.os.basic.BaseController;
import com.h2y.os.basic.WbsKeys.EAgentDriverKeys;
import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.dao.IAgentDriverLogDao;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.entity.AgentDriverLog;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.services.IFindServiceService;
import com.h2y.os.util.SysBaseUtil;
import com.h2y.util.DateUtil;
import com.h2y.util.StringUtil;

/**
 * 首页+发现
 * @author sunfj
 *
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/findService")
public class FindServiceController extends BaseController{


	@Autowired
	protected IFindServiceService findServiceService;

	@Autowired
	protected ICommonDao commonDao;

	@Autowired
	protected IAgentDriverLogDao agentDriverLogDao;

	/**
	 * 获取发现列表
	 */
	@RequestMapping(value = "/getList")
	public void getList() {
		outJson(findServiceService.getPrivateServiceList(getReqMap()));

	}


	/**
	 * 获取发现列表IOS
	 */
	@RequestMapping(value = "/getListIOS")
	public void getListIOS() {
		outJson(findServiceService.getPrivateServiceListIOS(getReqMap()));

	}


	/**
	 * 获取首页6个分类
	 */
	@RequestMapping(value = "/getPublicServiceList")
	public void getPublicServiceList() {
		outJson(findServiceService.getPublicServiceList(getReqMap()));

	}


	/**
	 * 获取首页8个分类
	 */
	@RequestMapping(value = "/getPublicServiceList2_1")
	public void getPublicServiceList2_1() {
		outJson(findServiceService.getPublicServiceList2_1(getReqMap()));

	}

	/**
	 * e代驾页面初始化
	 */
	@RequestMapping(value="/eAgentDriver")
	public void eAgentDriver(){

		AgentDriverLog agentDriverLog = new AgentDriverLog();

		try {
			String memberId = StringUtil.objectToString(request.getParameter(JydKeys.memberId.value()));
			String longitude = StringUtil.objectToString(request.getParameter(EAgentDriverKeys.locationLongitude.value()));//经度
			String latitude = StringUtil.objectToString(request.getParameter(EAgentDriverKeys.locationLatitude.value()));//纬度
			String clientType = StringUtil.objectToString(request.getParameter(EAgentDriverKeys.clientType.value()));//客户端类型：android:安卓、ios:苹果客户端
			String locationAddress=StringUtil.objectToString(request.getParameter(EAgentDriverKeys.locationAddress.value()));
			//e代驾地址
			String eUrl = SysBaseUtil.EAGENT_URL;

			if (null != longitude && !"".equals(longitude) && !"null".equals(longitude)) {
				if(longitude.length()-longitude.indexOf(".") > 7 ){
					longitude = longitude.substring(0, longitude.indexOf(".")+7);
				}			
				agentDriverLog.setGpsLongitude(new Double(longitude));
				eUrl = eUrl + "&lng="+longitude;
			}

			if (null != latitude && !"".equals(latitude) && !"null".equals(latitude)) {
				if(latitude.length()-latitude.indexOf(".") > 7){
					latitude = latitude.substring(0, latitude.indexOf(".")+7);
				}			
				agentDriverLog.setGpsLatitude(new Double(latitude));
				eUrl = eUrl + "&lat="+latitude;
			}		
			if (null != clientType && !"".equals(clientType) && !"null".equals(clientType)) {
				agentDriverLog.setClientType(clientType);
			}

			if (null != locationAddress && !"".equals(locationAddress) && !"null".equals(locationAddress)) {
				locationAddress = new String(request.getParameter(EAgentDriverKeys.locationAddress.value()).getBytes("iso-8859-1"), "utf-8");
				agentDriverLog.setStartAddress(locationAddress);
			}

			if(null != memberId && !"".equals(memberId) && !"null".equals(memberId)){
				MemberUser memberUser = commonDao.getMemberUser(Long.valueOf(memberId));
				if (null!=memberUser) {
					eUrl = eUrl + "&phone="+memberUser.getAccount();

					agentDriverLog.setAccount(memberUser.getAccount());
					agentDriverLog.setCreateDate(DateUtil.getSystemTime());				
//					agentDriverLog.setMemberId(memberUser.getId()+"");
					agentDriverLog.setNickName(memberUser.getNickName());
					agentDriverLog.setRealName(memberUser.getRealName());

					//代驾类型 e代驾:1、609代驾:2
					agentDriverLog.setAgentType("1");
					//新增代驾日志
					agentDriverLogDao.add(agentDriverLog);
				}
			}

			response.sendRedirect(eUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	/**
	 * 代驾页面初始化
	 */
	@RequestMapping(value="/agentDriver")
	public ModelAndView agentDriver(){

		ModelAndView view = new ModelAndView();
		long memberId = Long.valueOf(request.getParameter(JydKeys.memberId.value()));
		MemberUser memberUser = commonDao.getMemberUser(memberId);

		if (null==memberUser) {

			view.addObject("title", "提示消息");
			view.addObject("msg", "当前会员不存在！");
			view.setViewName("server/error");
			return view;
		}

		view.addObject("memberUser", memberUser);
		view.addObject("zoneCode", request.getParameter("zoneCode"));
		view.addObject("locationAddress", request.getParameter("locationAddress"));
		view.addObject("locationLatitude", request.getParameter("locationLatitude"));
		view.addObject("locationLongitude", request.getParameter("locationLongitude"));
		view.addObject("os", request.getParameter("os"));
		view.setViewName("server/findservice/agentDriver");
		return view;
	}





	/**
	 * 订房页面初始化
	 */
	@RequestMapping(value="/dingFang")
	public ModelAndView dingFang(){

		ModelAndView view = new ModelAndView();
		long memberId = Long.valueOf(request.getParameter(JydKeys.memberId.value()));
		MemberUser memberUser = commonDao.getMemberUser(memberId);

		if (null==memberUser) {

			view.addObject("title", "提示消息");
			view.addObject("msg", "当前会员不存在！");
			view.setViewName("server/error");
			return view;
		}
		view.addObject("memberUser", memberUser);
		view.setViewName("server/findservice/dingFang");
		return view;
	}

	/**
	 * 通用发现维护页面
	 * @param functionMs
	 * @return
	 * @update：2015年8月14日 下午2:12:01
	 */
	@RequestMapping(value="/finds/{functionMs}")
	public ModelAndView findService(@PathVariable(value="functionMs") String functionMs){

		ModelAndView view = new ModelAndView();
		long memberId = Long.valueOf(request.getParameter(JydKeys.memberId.value()));
		MemberUser memberUser = commonDao.getMemberUser(memberId);

		if (null==memberUser) {

			view.addObject("title", "提示消息");
			view.addObject("msg", "当前会员不存在！");
			view.setViewName("server/error");
			return view;
		}
		view.addObject("memberUser", memberUser);
		view.setViewName("server/findservice/"+functionMs);
		return view;
	}
}
