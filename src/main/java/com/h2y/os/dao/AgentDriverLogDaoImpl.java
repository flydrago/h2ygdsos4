package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IAgentDriverLogDaoR;
import com.h2y.os.dao.write.IAgentDriverLogDaoW;
import com.h2y.os.entity.AgentDriverLog;

@Service("agentDriverLogDao")
public class AgentDriverLogDaoImpl implements IAgentDriverLogDao{
	
	@Autowired
	protected IAgentDriverLogDaoR agentDriverLogDaoR;
	
	@Autowired
	protected IAgentDriverLogDaoW agentDriverLogDaoW;

	public void add(AgentDriverLog agentDriverLog) {
		agentDriverLogDaoW.add(agentDriverLog);
	}

	public void update(AgentDriverLog agentDriverLog) {
		agentDriverLogDaoW.update(agentDriverLog);
	}

	public void deleteById(long id) {
		agentDriverLogDaoW.deleteById(id);
	}

	public AgentDriverLog get(long id) {
		return agentDriverLogDaoR.get(id);
	}

	public List<AgentDriverLog> getList(AgentDriverLog agentDriverLog) {
		return agentDriverLogDaoR.getList(agentDriverLog);
	}

	public List<AgentDriverLog> getListPage(Map<String, Object> map) {
		return agentDriverLogDaoR.getListPage(map);
	}

	public Long getRows(Map<String, Object> map) {
		return agentDriverLogDaoR.getRows(map);
	}

}
