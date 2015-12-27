package com.h2y.os.entity;


import java.util.Date;

import com.h2y.object.BaseObject;

/**
 * 项目名称：h2ygdsos  
 * 类名称：RoomLog  
 * 类描述：订房模型  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月24日 下午2:59:13  
 * 修改人：侯飞龙
 * 修改时间：2015年4月24日 下午2:59:13  
 * 修改备注：  
 * @version
 */
public class RoomLog extends BaseObject{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
    public static final String key = "keyRoomLog";
    private long id;
    private String mobile;
    private long userId;
    private String userAccount;
    private Date createDate;

	public RoomLog(){
		super();
	}

	public RoomLog(long id){
		super();
		this.id = id;
	}

	public RoomLog(long id,String mobile,long userId,String userAccount,Date createDate){
		super();
		this.id = id;
		this.mobile = mobile;
		this.userId = userId;
		this.userAccount = userAccount;
		this.createDate = createDate;
	}
  
    public long getId(){
      return id;
    }
    
    public void setId(long id){
      this.id = id;
    }

    public String getMobile(){
      return mobile;
    }
    
    public void setMobile(String mobile){
      this.mobile = mobile;
    }


    public long getUserId(){
      return userId;
    }
    
    public void setUserId(long userId){
      this.userId = userId;
    }


    public String getUserAccount(){
      return userAccount;
    }
    
    public void setUserAccount(String userAccount){
      this.userAccount = userAccount;
    }


    public Date getCreateDate(){
      return createDate;
    }
    
    public void setCreateDate(Date createDate){
      this.createDate = createDate;
    }

    public String toString(){
	return "id:"+id+"\t"+"mobile:"+mobile+"\t"+"userId:"+userId+"\t"+"userAccount:"+userAccount+"\t"+"createDate:"+createDate;
    }
}