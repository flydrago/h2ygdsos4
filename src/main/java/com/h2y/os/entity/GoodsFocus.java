package com.h2y.os.entity;

import java.util.Date;

/**
 * GoodsFocus Model create
 * 
 * @author hwttnet version:1.2 time:2015-04-10 email:info@hwttnet.com
 */

public class GoodsFocus {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	public static final String key = "keyGoodsFocus";
	private long id;
	private String zoneCode;
	private long goodsId;
	private long goodsPriceId;
	private String memberId;
	private Date focusDate;
	private Date updateDate;
	private int goodsSource;
	private int status;
	private int goodsPriceVersion;
	private long goodsTypeId;
	private String gdsCode;
	private long shopId;
	private long unitId;
	private int focusType;

	public GoodsFocus() {
		super();
	}

	public GoodsFocus(long id) {
		super();
		this.id = id;
	}

	public GoodsFocus(long id, String zoneCode, long goodsId,
			long goodsPriceId, String memberId, Date focusDate, Date updateDate,
			int goodsSource, int status, int goodsPriceVersion,
			long goodsTypeId, String gdsCode, long shopId, long unitId,
			int focusType) {
		super();
		this.id = id;
		this.zoneCode = zoneCode;
		this.goodsId = goodsId;
		this.goodsPriceId = goodsPriceId;
		this.memberId = memberId;
		this.focusDate = focusDate;
		this.updateDate = updateDate;
		this.goodsSource = goodsSource;
		this.status = status;
		this.goodsPriceVersion = goodsPriceVersion;
		this.goodsTypeId = goodsTypeId;
		this.gdsCode = gdsCode;
		this.shopId = shopId;
		this.unitId = unitId;
		this.focusType = focusType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public long getGoodsPriceId() {
		return goodsPriceId;
	}

	public void setGoodsPriceId(long goodsPriceId) {
		this.goodsPriceId = goodsPriceId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getFocusDate() {
		return focusDate;
	}

	public void setFocusDate(Date focusDate) {
		this.focusDate = focusDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getGoodsSource() {
		return goodsSource;
	}

	public void setGoodsSource(int goodsSource) {
		this.goodsSource = goodsSource;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getGoodsPriceVersion() {
		return goodsPriceVersion;
	}

	public void setGoodsPriceVersion(int goodsPriceVersion) {
		this.goodsPriceVersion = goodsPriceVersion;
	}

	public long getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(long goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getGdsCode() {
		return gdsCode;
	}

	public void setGdsCode(String gdsCode) {
		this.gdsCode = gdsCode;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public int getFocusType() {
		return focusType;
	}

	public void setFocusType(int focusType) {
		this.focusType = focusType;
	}

	public String toString() {
		return "id:" + id + "\t" + "zoneCode:" + zoneCode + "\t" + "goodsId:"
				+ goodsId + "\t" + "goodsPriceId:" + goodsPriceId + "\t"
				+ "memberId:" + memberId + "\t" + "focusDate:" + focusDate
				+ "\t" + "updateDate:" + updateDate + "\t" + "goodsSource:"
				+ goodsSource + "\t" + "status:" + status + "\t"
				+ "goodsPriceVersion:" + goodsPriceVersion + "\t"
				+ "goodsTypeId:" + goodsTypeId + "\t" + "gdsCode:" + gdsCode
				+ "\t" + "shopId:" + shopId + "\t" + "unitId:" + unitId + "\t"
				+ "focusType:" + focusType;
	}
}