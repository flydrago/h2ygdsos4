package com.h2y.os.entity;

import java.util.Date;

import com.h2y.object.BaseObject;


/**
 * 项目名称：h2ygdsos  
 * 类名称：ClickRate  
 * 类描述：点击量  
 * 创建人：侯飞龙  
 * 创建时间：2015年6月3日 下午2:24:26  
 * 修改人：侯飞龙
 * 修改时间：2015年6月3日 下午2:24:26  
 * 修改备注：  
 * @version
 */
public class ClickRate extends BaseObject{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;	
    public static final String key = "keyClickRate";
    private long id;
    private String account;
    private long goodsId;
    private Date createDate;
    private String zoneCode;
    private long goodsPriceId;

	public ClickRate(){
		super();
	}

	public ClickRate(long id){
		super();
		this.id = id;
	}

	public ClickRate(long id,String account,long goodsId,Date createDate,String zoneCode,long goodsPriceId){
		super();
		this.id = id;
		this.account = account;
		this.goodsId = goodsId;
		this.createDate = createDate;
		this.zoneCode = zoneCode;
		this.goodsPriceId = goodsPriceId;
	}
  
    public long getId(){
      return id;
    }
    
    public void setId(long id){
      this.id = id;
    }

    public String getAccount(){
      return account;
    }
    
    public void setAccount(String account){
      this.account = account;
    }


    public long getGoodsId(){
      return goodsId;
    }
    
    public void setGoodsId(long goodsId){
      this.goodsId = goodsId;
    }


    public Date getCreateDate(){
      return createDate;
    }
    
    public void setCreateDate(Date createDate){
      this.createDate = createDate;
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

    public String toString(){
	return "id:"+id+"\t"+"account:"+account+"\t"+"goodsId:"+goodsId+"\t"+"createDate:"+createDate+"\t"+"zoneCode:"+zoneCode+"\t"+"goodsPriceId:"+goodsPriceId;
    }
}