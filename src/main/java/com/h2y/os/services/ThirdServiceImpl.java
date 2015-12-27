package com.h2y.os.services;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.ILogDao;
import com.h2y.os.entity.AgentDriverLog;
import com.h2y.os.entity.RoomLog;
import com.h2y.os.util.SysBaseUtil;
import com.h2y.util.DateUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;
import com.h2y.util.StringUtil;

/**
 * 类描述：第三方接口业务实现类
 * 作者：侯飞龙
 * 时间：2014年12月31日下午3:13:51
 * 邮件：1162040314@qq.com
 */
@Service("thirdService")
public class ThirdServiceImpl implements IThirdService{
	
	private final static Logger logger = Logger.getLogger(ThirdServiceImpl.class);
	
	@Autowired
	protected ILogDao logDao;
	

	public String agentDriver(HttpServletRequest request) {
		
		String resultMsg = "{\"result\":\"0\"}";
		
		try {
			
			String postData = request.getParameter("postData");
			logger.debug("参数："+postData);
			Map<String,Object> paraMap = JSONUtil.getMap(postData);
			paraMap.put("ver", "2.8.2");
			paraMap.put("agentID", "DB0AB0EA370C4559B52E0383A661A302");
			paraMap.put("yuYueTime", 0);
			paraMap.put("endAddress", "");
			paraMap.put("accuracy", "0");
			resultMsg = HttpTookit.doPost(SysBaseUtil.AGENT_DRIVER_URL, paraMap);
			
			Map<String,Object> resultMap = JSONUtil.getMap(resultMsg);
			paraMap.put("result", resultMap.get("result"));
			saveAgentDriverLog(paraMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		return resultMsg;
	}
	
	public String dingFang(HttpServletRequest request) {
		
		String resultMsg = "{\"result\":\"0\"}";
		
		try {
			
			String postData = request.getParameter("postData");
			Map<String,Object> paraMap = JSONUtil.getMap(postData);
			RoomLog roomLog = new RoomLog();
			roomLog.setCreateDate(DateUtil.getSystemTime());
			roomLog.setMobile(paraMap.get("mobile")+"");
			roomLog.setUserAccount(paraMap.get("account")+"");
			logDao.addRoomLog(roomLog);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			resultMsg = "{\"result\":\"0\"}";
		}
		return resultMsg;
	}
	
	
	/**
	 * 添加代驾日志
	 * @param paraMap
	 */
	private void saveAgentDriverLog(Map<String,Object> paraMap) {

		AgentDriverLog agentDriverLog = new AgentDriverLog();
		agentDriverLog.setAccount(paraMap.get("account")+"");
		agentDriverLog.setAccuracy(Integer.parseInt(paraMap.get("accuracy")+""));
		agentDriverLog.setAgentId(paraMap.get("agentID")+"");
		agentDriverLog.setClientTel(paraMap.get("clientTel")+"");
		agentDriverLog.setClientType(paraMap.get("clientType")+"");
		agentDriverLog.setContactName(StringUtil.objectToString(paraMap.get("contactName")));
		agentDriverLog.setContactTel(paraMap.get("contactTel")+"");
		agentDriverLog.setCreateDate(DateUtil.getSystemTime());
		agentDriverLog.setDriverCount(Integer.parseInt(paraMap.get("driverCount")+""));
		agentDriverLog.setEndAddress(StringUtil.objectToString(paraMap.get("endAddress")));
		agentDriverLog.setGpsLatitude(Double.valueOf(paraMap.get("lat")+""));
		agentDriverLog.setGpsLongitude(Double.valueOf(paraMap.get("lon")+""));
		agentDriverLog.setMemberId(Long.valueOf(paraMap.get("memberId")+""));
		agentDriverLog.setNickName(StringUtil.objectToString(paraMap.get("nickName")));
		agentDriverLog.setRealName(paraMap.get("realName")+"");
		agentDriverLog.setResult(paraMap.get("result")+"");
		agentDriverLog.setStartAddress(paraMap.get("startAddress")+"");
		agentDriverLog.setVersion(paraMap.get("ver")+"");
		agentDriverLog.setYuYueTime(paraMap.get("yuYueTime")+"");
		logDao.addAgentDriverLog(agentDriverLog);
	}
}