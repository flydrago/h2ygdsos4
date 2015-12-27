package com.h2y.entity;

/**
 * 项目名称：h2yorsos  
 * 类名称：BaseCheck  
 * 类描述：  推送模型
 * 创建人：侯飞龙  
 * 创建时间：2015年4月15日 上午9:29:15  
 * 修改人：侯飞龙
 * 修改时间：2015年4月15日 上午9:29:15  
 * 修改备注：  
 * @version
 */
public class PushToData{
	
	private String loginType;//推送推向标识
	private String mto; //结果信息
	private String pushcode; //结果信息
	private String tag; //结果信息 按照标签推送
	
	public PushToData(){
		super();
	}
	
	public PushToData(String loginType,String mto){
		super();
		this.loginType = loginType;
		this.mto = mto;
	}
	
	public PushToData(String loginType,String mto,String pushcode){
		super();
		this.loginType = loginType;
		this.mto = mto;
		this.pushcode = pushcode;
	}
	
	public PushToData(String loginType,String mto,String pushcode,String tag){
		super();
		this.loginType = loginType;
		this.mto = mto;
		this.pushcode = pushcode;
		this.tag = tag;
	}
	

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getMto() {
		return mto;
	}

	public void setMto(String mto) {
		this.mto = mto;
	}

	public String getPushcode() {
		return pushcode;
	}

	public void setPushcode(String pushcode) {
		this.pushcode = pushcode;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String toString(){
		
		return "loginType:"+loginType+"\t"+"mto:"+mto+"\t"+
				"pushcode:"+pushcode+"\t"+"tag:"+tag;
    }
}