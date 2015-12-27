package com.h2y.os.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.h2y.object.BaseObject;

/**
 * 项目名称：h2ygdsos  
 * 类名称：ReceiveAddress  
 * 类描述：收货地址模型  
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:12:09  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:12:09  
 * 修改备注：  
 * @version
 */
public class ReceiveAddress extends BaseObject{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
    public static final String key = "keyReceiveAddress";
    private long id;
    private String memberId;
    private long zoneId;
    private String zoneCode;
    private String zoneName;
    private String zoneDetail;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String receiverName;
    private String receiverMobile;
    private String receiverTelephone;
    private String receiverMail;
    private Date createDate;
    private Date updateDate;
    private String memo;
    private int isDefault;
    private int status;

	public ReceiveAddress(){
		super();
	}

	public ReceiveAddress(long id){
		super();
		this.id = id;
	}

	public ReceiveAddress(long id,String memberId,long zoneId,String zoneCode,String zoneName,String zoneDetail,BigDecimal longitude,BigDecimal latitude,String receiverName,String receiverMobile,String receiverTelephone,String receiverMail,Date createDate,Date updateDate,String memo,int isDefault,int status){
		super();
		this.id = id;
		this.memberId = memberId;
		this.zoneId = zoneId;
		this.zoneCode = zoneCode;
		this.zoneName = zoneName;
		this.zoneDetail = zoneDetail;
		this.longitude = longitude;
		this.latitude = latitude;
		this.receiverName = receiverName;
		this.receiverMobile = receiverMobile;
		this.receiverTelephone = receiverTelephone;
		this.receiverMail = receiverMail;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.memo = memo;
		this.isDefault = isDefault;
		this.status = status;
	}
  
    public long getId(){
      return id;
    }
    
    public void setId(long id){
      this.id = id;
    }

    public String getMemberId(){
      return memberId;
    }
    
    public void setMemberId(String memberId){
      this.memberId = memberId;
    }


    public long getZoneId(){
      return zoneId;
    }
    
    public void setZoneId(long zoneId){
      this.zoneId = zoneId;
    }


    public String getZoneCode(){
      return zoneCode;
    }
    
    public void setZoneCode(String zoneCode){
      this.zoneCode = zoneCode;
    }


    public String getZoneName(){
      return zoneName;
    }
    
    public void setZoneName(String zoneName){
      this.zoneName = zoneName;
    }


    public String getZoneDetail(){
      return zoneDetail;
    }
    
    public void setZoneDetail(String zoneDetail){
      this.zoneDetail = zoneDetail;
    }


    public BigDecimal getLongitude(){
      return longitude;
    }
    
    public void setLongitude(BigDecimal longitude){
      this.longitude = longitude;
    }


    public BigDecimal getLatitude(){
      return latitude;
    }
    
    public void setLatitude(BigDecimal latitude){
      this.latitude = latitude;
    }


    public String getReceiverName(){
      return receiverName;
    }
    
    public void setReceiverName(String receiverName){
      this.receiverName = receiverName;
    }


    public String getReceiverMobile(){
      return receiverMobile;
    }
    
    public void setReceiverMobile(String receiverMobile){
      this.receiverMobile = receiverMobile;
    }


    public String getReceiverTelephone(){
      return receiverTelephone;
    }
    
    public void setReceiverTelephone(String receiverTelephone){
      this.receiverTelephone = receiverTelephone;
    }


    public String getReceiverMail(){
      return receiverMail;
    }
    
    public void setReceiverMail(String receiverMail){
      this.receiverMail = receiverMail;
    }


    public Date getCreateDate(){
      return createDate;
    }
    
    public void setCreateDate(Date createDate){
      this.createDate = createDate;
    }


    public Date getUpdateDate(){
      return updateDate;
    }
    
    public void setUpdateDate(Date updateDate){
      this.updateDate = updateDate;
    }


    public String getMemo(){
      return memo;
    }
    
    public void setMemo(String memo){
      this.memo = memo;
    }


    public int getIsDefault(){
      return isDefault;
    }
    
    public void setIsDefault(int isDefault){
      this.isDefault = isDefault;
    }


    public int getStatus(){
      return status;
    }
    
    public void setStatus(int status){
      this.status = status;
    }

    public String toString(){
	return "id:"+id+"\t"+"memberId:"+memberId+"\t"+"zoneId:"+zoneId+"\t"+"zoneCode:"+zoneCode+"\t"+"zoneName:"+zoneName+"\t"+"zoneDetail:"+zoneDetail+"\t"+"longitude:"+longitude+"\t"+"latitude:"+latitude+"\t"+"receiverName:"+receiverName+"\t"+"receiverMobile:"+receiverMobile+"\t"+"receiverTelephone:"+receiverTelephone+"\t"+"receiverMail:"+receiverMail+"\t"+"createDate:"+createDate+"\t"+"updateDate:"+updateDate+"\t"+"memo:"+memo+"\t"+"isDefault:"+isDefault+"\t"+"status:"+status;
    }
}