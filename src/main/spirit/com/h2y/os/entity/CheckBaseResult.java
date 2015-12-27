package com.h2y.os.entity;

/**
 * 项目名称：h2ygdsos  
 * 类名称：CheckBaseResult  
 * 类描述：  验证模型基类
 * 创建人：侯飞龙  
 * 创建时间：2015年6月11日 下午2:12:58  
 * 修改人：侯飞龙
 * 修改时间：2015年6月11日 下午2:12:58  
 * 修改备注：  
 * @version
 */
public class CheckBaseResult extends BaseResult{

    private MemberUser memberUser;
    private String zoneCode;
    private int page;
    private int pagesize;
    
	public CheckBaseResult() {
		super();
	}
	public CheckBaseResult(int resultFlag) {
		super(resultFlag);
		// TODO Auto-generated constructor stub
	}
	public CheckBaseResult(int resultFlag, String resultMsg, Object resultData) {
		super(resultFlag, resultMsg, resultData);
	}
	public CheckBaseResult(int resultFlag, String resultMsg) {
		super(resultFlag, resultMsg);
		// TODO Auto-generated constructor stub
	}
	public MemberUser getMemberUser() {
		return memberUser;
	}
	public void setMemberUser(MemberUser memberUser) {
		this.memberUser = memberUser;
	}
	public String getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	@Override
	public String toString() {
		return "BaseCheckResult [memberUser=" + memberUser + ", zoneCode="
				+ zoneCode + ", page=" + page + ", pagesize=" + pagesize + "]";
	}
}