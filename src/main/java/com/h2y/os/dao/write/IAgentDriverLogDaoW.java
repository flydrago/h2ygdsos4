package com.h2y.os.dao.write;


import org.springframework.stereotype.Component;

import com.h2y.os.entity.AgentDriverLog;

/**
 * AgentDriverLogDaoInterface,order CRUD ;CRUD:Create,Retrieve/Read,Update,Delete
 * @author hwttnet
 * version:1.2
 * time:2015-05-22
 * email:info@hwttnet.com
 */
@Component
public interface IAgentDriverLogDaoW{

	/**
	 * add
	 */
	public void add(AgentDriverLog agentDriverLog);

	/**
	 * update
	 */
	public void update(AgentDriverLog agentDriverLog);

	/**
	 * delete
	 */
	public void deleteById(long id);

	
}