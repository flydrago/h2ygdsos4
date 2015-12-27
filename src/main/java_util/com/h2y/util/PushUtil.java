package com.h2y.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.h2y.entity.PushMsg;
import com.h2y.entity.PushToData;
import com.h2y.os.util.FreeMarkerUtil;


/**
 * 项目名称：h2yorsos  
 * 类名称：OrderUtil  
 * 类描述：  订单工具类
 * 创建人：侯飞龙  
 * 创建时间：2015年5月19日 上午10:22:37  
 * 修改人：侯飞龙
 * 修改时间：2015年5月19日 上午10:22:37  
 * 修改备注：  
 * @version
 */
public class PushUtil {
	
	/**
	 * 得到消息体
	 * @param msgType 消息类型
	 * @param isLogin 点击推送消息，是否需要登录（0：否、1：是）
	 * @param datas 业务数据 data1 data2 等
	 * @return
	 */
    public static String getBody(String msgType,int isLogin,Object ... datas) { //使用…声明参数
    	
    	Map<String,Object> map = new HashMap<String, Object>();
    	map.put("msgType", msgType);
    	map.put("isLogin", isLogin);
    	int i = 1;
    	for (Object obj : datas) {
    		map.put("data"+i, obj);
    		i++;
		}
        return JSONUtil.getJson(map);
    }	
    
    
    /**
   	 * 批量推送
   	 * @param title 标题
   	 * @param body 对象
   	 * @param describtion 描述
   	 * @param tag 标签
   	 * @param targetList 推送目标列表
   	 * @param unitId 单位id
   	 * @return
   	 */
   	public static Map<String,Object> doPush(PushMsg pushMsg,List<PushToData> toDatas){
   		
   		Map<String,Object> postData = new HashMap<String, Object>();
   		postData.put("mmsg", pushMsg);
   		postData.put("toData", toDatas);
   		
   		//执行推送
   		return DataRequestUtil.getRequestData("msg/sendmsg.htm", postData);
   	}
   	
   	
   	/**
   	 * 指定推送
   	 * @param title 标题
   	 * @param body 对象
   	 * @param describtion 描述
   	 * @param tag 标签
   	 * @param targetList 推送目标列表
   	 * @param unitId 单位id
   	 * @return
   	 */
   	public static Map<String,Object> doPush(PushMsg pushMsg,PushToData toData){
   		
   		Map<String,Object> postData = new HashMap<String, Object>();
   		postData.put("mmsg", pushMsg);
   		List<PushToData> toDatas = new ArrayList<PushToData>();
   		toDatas.add(toData);
   		postData.put("toData", toDatas);
   		
   		//执行推送
   		return DataRequestUtil.getRequestData("msg/sendmsg.htm", postData);
   	}
   	
   	
   	
   	/**
	 * 类描述：推送登录类型（1、Android配送端，2、Android App，3、IOS配送端，4、IOS App，5、pc）
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum PushLoginType{
		
		/**
		 * Android配送端
		 */
		androidDelivery("1"),
		
		/**
		 * Android App
		 */
		androidApp("2"),
		
		/**
		 * ios 配送端
		 */
		iosDelivery("3"),
		
		/**
		 * ios App
		 */
		iosApp("4"),
		
		/**
		 * pc App
		 */
		pcApp("5");
		
		public final String value;
		private PushLoginType(String value){
			this.value = value;
		}
	}
	
	
	/**
	 * 类描述：推送消息类型  app根据不同的类型执行不同的操作
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum PushMsgType{
		
		/**
		 * 提交订单
		 */
		submitOrder("submitOrder","订单消息","您有一个订单需要需要受理，订单编号为：${order.orderNo!''}"),
		
		/**
		 * 抢单订单
		 */
		grabOrder("grabOrder","订单消息","您的订单已受理，订单编号为：${order.orderNo!''}，配送员为：${deliveryUser.name!''}，请注意订单配送进度！"),
		
		
		/**
		 * 酒库推送消息
		 */
		spiritRoom("spiritRoom","酒库消息","您收到一个商品，请查看酒库！"),
		
		
		/**
		 * 优惠劵
		 */
		coupons("coupons","优惠劵消息","您收到优惠劵，请查看优惠劵！"),
		
		/**
		 * 小达快报
		 */
		xiaoDaNews("xiaoDaNews","小达快报","小达快报给您问安，${findActivity.title!''}");
		
		public final String value;
		public final String text;
		public final String title;
		private PushMsgType(String value,String title,String text){
			this.value = value;
			this.title = title;
			this.text = text;
		}
	}
	
	
	/**
	 * 得到推送消息
	 * @param detailCode 字典详细编码
	 * @param body body
	 * @param dataMap 模板数据
	 * @param pushMsgType 消息类型枚举
	 * @return
	 */
	public static PushMsg getPushMsg(String detailCode,String body,Map<String,Object> dataMap,PushMsgType pushMsgType){
		
		String describtion = DictUtil.getDictDetailValue(1, "pushMsgDescModel", detailCode);
		if (describtion==null || "".equals(describtion)) {
			describtion = pushMsgType.text;
		}
		
		String desc = FreeMarkerUtil.getContentFromStringTemplate(dataMap, describtion);
		PushMsg pushMsg = new PushMsg(pushMsgType.title, desc, body);
		return pushMsg;
	}
   	
    
    public static void main(String[] args) {
    	
    	System.out.println(getBody("orderDetail", 0,"a","b","c","d"));
    	
    	System.out.println(getBody("orderDetail", 1,1,2,3));
	}
}
