package com.h2y.os.entity;



import java.util.Date;

/**
 * GoodsAnalysis Model create
 * @author hwttnet
 * version:1.2
 * time:2015-06-30
 * email:info@hwttnet.com
 */

public class GoodsAnalysis{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
	public static final String key = "keyGoodsAnalysis";
	private long id;
	private long memberId;
	private String zoneCode;
	private long goodsPriceId;
	private long goodsTypeId;
	private Date createDate;
	private Date updateDate;
	private String memo;
	private long ord;
	private long clickCount;
	private String reverse1;
	private String reverse2;
	private String reverse3;
	private String reverse4;

	public GoodsAnalysis(){
		super();
	}

	public GoodsAnalysis(long id){
		super();
		this.id = id;
	}

	public GoodsAnalysis(long id,long memberId,String zoneCode,long goodsPriceId,long goodsTypeId,Date createDate,Date updateDate,String memo,long ord,long clickCount,String reverse1,String reverse2,String reverse3,String reverse4){
		super();
		this.id = id;
		this.memberId = memberId;
		this.zoneCode = zoneCode;
		this.goodsPriceId = goodsPriceId;
		this.goodsTypeId = goodsTypeId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.memo = memo;
		this.ord = ord;
		this.clickCount = clickCount;
		this.reverse1 = reverse1;
		this.reverse2 = reverse2;
		this.reverse3 = reverse3;
		this.reverse4 = reverse4;
	}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getUserId(){
		return memberId;
	}

	public void setUserId(long memberId){
		this.memberId = memberId;
	}


	public String getZoneCode(){
		return zoneCode;
	}

	public void setZoneCode(String zoneCode){
		this.zoneCode = zoneCode;
	}


	public long getGoodsPriceId(){
		return goodsPriceId;
	}

	public void setGoodsPriceId(long goodsPriceId){
		this.goodsPriceId = goodsPriceId;
	}


	public long getGoodsTypeId(){
		return goodsTypeId;
	}

	public void setGoodsTypeId(long goodsTypeId){
		this.goodsTypeId = goodsTypeId;
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


	public long getOrd(){
		return ord;
	}

	public void setOrd(long ord){
		this.ord = ord;
	}


	public long getClickCount(){
		return clickCount;
	}

	public void setClickCount(long clickCount){
		this.clickCount = clickCount;
	}


	public String getReverse1(){
		return reverse1;
	}

	public void setReverse1(String reverse1){
		this.reverse1 = reverse1;
	}


	public String getReverse2(){
		return reverse2;
	}

	public void setReverse2(String reverse2){
		this.reverse2 = reverse2;
	}


	public String getReverse3(){
		return reverse3;
	}

	public void setReverse3(String reverse3){
		this.reverse3 = reverse3;
	}


	public String getReverse4(){
		return reverse4;
	}

	public void setReverse4(String reverse4){
		this.reverse4 = reverse4;
	}

	public String toString(){
		return "id:"+id+"\t"+"memberId:"+memberId+"\t"+"zoneCode:"+zoneCode+"\t"+"goodsPriceId:"+goodsPriceId+"\t"+"goodsTypeId:"+goodsTypeId+"\t"+"createDate:"+createDate+"\t"+"updateDate:"+updateDate+"\t"+"memo:"+memo+"\t"+"ord:"+ord+"\t"+"clickCount:"+clickCount+"\t"+"reverse1:"+reverse1+"\t"+"reverse2:"+reverse2+"\t"+"reverse3:"+reverse3+"\t"+"reverse4:"+reverse4;
	}
}