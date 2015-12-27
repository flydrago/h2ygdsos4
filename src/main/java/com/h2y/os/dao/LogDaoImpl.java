package com.h2y.os.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.write.ILogDaoW;
import com.h2y.os.entity.AgentDriverLog;
import com.h2y.os.entity.RoomLog;

@Service("logDao")
public class LogDaoImpl implements ILogDao{
	
	@Autowired
	protected ILogDaoW logDaoW;

	public void addAgentDriverLog(AgentDriverLog agentDriverLog) {
		logDaoW.addAgentDriverLog(agentDriverLog);
	}

	public void addRoomLog(RoomLog roomLog) {
		logDaoW.addRoomLog(roomLog);
	}

}
