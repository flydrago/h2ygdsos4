package com.h2y.os.entity;

import java.util.List;

/**
 * 微活动参数
 * 作者：侯飞龙
 * 时间：2014年12月17日上午11:32:31
 * 邮件：1162040314@qq.com
 */
public class WechatActivityParams{

    private int resultFlag;
    private String resultMsg;
    private MemberUser memberUser;
    private List<WechatActivityPrize> prizeList;
    
	public WechatActivityParams(){
		super();
	}

    public int getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(int resultFlag) {
		this.resultFlag = resultFlag;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public MemberUser getMemberUser() {
		return memberUser;
	}

	public void setMemberUser(MemberUser memberUser) {
		this.memberUser = memberUser;
	}

	public List<WechatActivityPrize> getPrizeList() {
		return prizeList;
	}

	public void setPrizeList(List<WechatActivityPrize> prizeList) {
		this.prizeList = prizeList;
	}

	public String toString(){
		return "resultFlag:"+resultFlag+"\t"+"resultMsg:"+resultMsg+"\t"+
				"memberUser:"+memberUser+"\t"+"prizeList:"+prizeList;
    }
}