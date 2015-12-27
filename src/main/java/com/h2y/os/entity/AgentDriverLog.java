package com.h2y.os.entity;

import java.util.Date;

import com.h2y.object.BaseObject;

/**
 * 类描述： 代驾日志   
 * 作者：侯飞龙
 * 时间：2014年12月31日上午11:51:17
 * 邮件：1162040314@qq.com
 */
public class AgentDriverLog extends BaseObject{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
	public static final String key = "keyAgentDriverLog";
	private long id;
	private long memberId;
	private String account;
	private String realName;
	private String nickName;
	private Date createDate;
	private String clientType;
	private String agentType;
	private String version;
	private String clientTel;
	private String agentId;
	private String startAddress;
	private String endAddress;
	private String yuYueTime;
	private int driverCount;
	private String contactName;
	private String contactTel;
	private Double gpsLongitude;
	private Double gpsLatitude;
	private int accuracy;
	private String result;

	public AgentDriverLog(){
		super();
	}

	public AgentDriverLog(long id){
		super();
		this.id = id;
	}

	public AgentDriverLog(long id,long memberId,String account,String realName,String nickName,Date createDate,String clientType,String agentType,String version,String clientTel,String agentId,String startAddress,String endAddress,String yuYueTime,int driverCount,String contactName,String contactTel,Double gpsLongitude,Double gpsLatitude,int accuracy,String result){
		super();
		this.id = id;
		this.memberId = memberId;
		this.account = account;
		this.realName = realName;
		this.nickName = nickName;
		this.createDate = createDate;
		this.clientType = clientType;
		this.agentType = agentType;
		this.version = version;
		this.clientTel = clientTel;
		this.agentId = agentId;
		this.startAddress = startAddress;
		this.endAddress = endAddress;
		this.yuYueTime = yuYueTime;
		this.driverCount = driverCount;
		this.contactName = contactName;
		this.contactTel = contactTel;
		this.gpsLongitude = gpsLongitude;
		this.gpsLatitude = gpsLatitude;
		this.accuracy = accuracy;
		this.result = result;
	}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getMemberId(){
		return memberId;
	}

	public void setMemberId(long memberId){
		this.memberId = memberId;
	}


	public String getAccount(){
		return account;
	}

	public void setAccount(String account){
		this.account = account;
	}


	public String getRealName(){
		return realName;
	}

	public void setRealName(String realName){
		this.realName = realName;
	}


	public String getNickName(){
		return nickName;
	}

	public void setNickName(String nickName){
		this.nickName = nickName;
	}


	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}


	public String getClientType(){
		return clientType;
	}

	public void setClientType(String clientType){
		this.clientType = clientType;
	}


	public String getAgentType(){
		return agentType;
	}

	public void setAgentType(String agentType){
		this.agentType = agentType;
	}


	public String getVersion(){
		return version;
	}

	public void setVersion(String version){
		this.version = version;
	}


	public String getClientTel(){
		return clientTel;
	}

	public void setClientTel(String clientTel){
		this.clientTel = clientTel;
	}


	public String getAgentId(){
		return agentId;
	}

	public void setAgentId(String agentId){
		this.agentId = agentId;
	}


	public String getStartAddress(){
		return startAddress;
	}

	public void setStartAddress(String startAddress){
		this.startAddress = startAddress;
	}


	public String getEndAddress(){
		return endAddress;
	}

	public void setEndAddress(String endAddress){
		this.endAddress = endAddress;
	}


	public String getYuYueTime(){
		return yuYueTime;
	}

	public void setYuYueTime(String yuYueTime){
		this.yuYueTime = yuYueTime;
	}


	public int getDriverCount(){
		return driverCount;
	}

	public void setDriverCount(int driverCount){
		this.driverCount = driverCount;
	}


	public String getContactName(){
		return contactName;
	}

	public void setContactName(String contactName){
		this.contactName = contactName;
	}


	public String getContactTel(){
		return contactTel;
	}

	public void setContactTel(String contactTel){
		this.contactTel = contactTel;
	}


	public Double getGpsLongitude(){
		return gpsLongitude;
	}

	public void setGpsLongitude(Double gpsLongitude){
		this.gpsLongitude = gpsLongitude;
	}


	public Double getGpsLatitude(){
		return gpsLatitude;
	}

	public void setGpsLatitude(Double gpsLatitude){
		this.gpsLatitude = gpsLatitude;
	}


	public int getAccuracy(){
		return accuracy;
	}

	public void setAccuracy(int accuracy){
		this.accuracy = accuracy;
	}


	public String getResult(){
		return result;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String toString(){
		return "id:"+id+"\t"+"memberId:"+memberId+"\t"+"account:"+account+"\t"+"realName:"+realName+"\t"+"nickName:"+nickName+"\t"+"createDate:"+createDate+"\t"+"clientType:"+clientType+"\t"+"agentType:"+agentType+"\t"+"version:"+version+"\t"+"clientTel:"+clientTel+"\t"+"agentId:"+agentId+"\t"+"startAddress:"+startAddress+"\t"+"endAddress:"+endAddress+"\t"+"yuYueTime:"+yuYueTime+"\t"+"driverCount:"+driverCount+"\t"+"contactName:"+contactName+"\t"+"contactTel:"+contactTel+"\t"+"gpsLongitude:"+gpsLongitude+"\t"+"gpsLatitude:"+gpsLatitude+"\t"+"accuracy:"+accuracy+"\t"+"result:"+result;
	}
}