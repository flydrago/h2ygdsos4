package com.h2y.os.dao;



import java.util.List;
import java.util.Map;


import com.h2y.os.entity.AgentDriverLog;

/**
 * AgentDriverLogDaoInterface,order CRUD ;CRUD:Create,Retrieve/Read,Update,Delete
 * @author hwttnet
 * version:1.2
 * time:2015-05-22
 * email:info@hwttnet.com
 */

public interface IAgentDriverLogDao{

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

	/**
	 * deleteByIds
	 */
	//public void deleteByIds(List<long> ids);

	/**
	 * get
	 * @return
	 */
	public AgentDriverLog get(long id);


	/**
	 * getList
	 * @return
	 */
	public List<AgentDriverLog> getList(AgentDriverLog agentDriverLog);


	/**
	 * getListPage
	 * 
	 * page,pagesize,key
	 * @return
	 */
	public List<AgentDriverLog> getListPage(Map<String,Object> map);

	/**
	 * getRows
	 * @param map
	 * @return  id desc,name ,date asc
	 */  
	public Long getRows(Map<String,Object> map);
}