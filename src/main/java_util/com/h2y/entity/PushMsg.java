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
public class PushMsg{
	
	private String title;//结果标识（0：失败、1：成功）
	private String describtion; //结果信息
	private String body; //结果信息
	private String datasourceId;//小达快报id
	private String datasourceType;//数据源类型（订单、小达快报:news）
	
	public PushMsg(){
		super();
	}
	
	public PushMsg(String title,String describtion){
		super();
		this.title = title;
		this.describtion = describtion;
	}
	
	public PushMsg(String title,String describtion,String body){
		super();
		this.title = title;
		this.describtion = describtion;
		this.body = body;
	}
	
	public PushMsg(String title, String describtion, String body,
			String datasourceId, String datasourceType) {
		super();
		this.title = title;
		this.describtion = describtion;
		this.body = body;
		this.datasourceId = datasourceId;
		this.datasourceType = datasourceType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDatasourceId() {
		return datasourceId;
	}

	public void setDatasourceId(String datasourceId) {
		this.datasourceId = datasourceId;
	}

	public String getDatasourceType() {
		return datasourceType;
	}

	public void setDatasourceType(String datasourceType) {
		this.datasourceType = datasourceType;
	}

	@Override
	public String toString() {
		return "PushMsg [title=" + title + ", describtion=" + describtion
				+ ", body=" + body + ", datasourceId=" + datasourceId
				+ ", datasourceType=" + datasourceType + "]";
	}
}