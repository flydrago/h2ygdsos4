package test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.util.SysBaseUtil;
import com.h2y.util.DataRequestUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class ReceiveAddressTest {

	
	public static void main(String[] args) {
		
		add();
		
//		update();
		
//		setDefault();
		
//		delete();
//		getList();
		
//		get();
	}
	
	
	/**
	 * 添加收货地址
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * receiverZoneCode:收获地址区域编码,
	 * receiverZoneDetail:收货地址详细,
	 * receiverZoneName:收货地址名称,
	 * longitude:收货地址经度,
	 * latitude:收货地址纬度,
	 * receiverName:收货地址名称,
	 * receiverMobile:收货地址手机号码,
	 * receiverTelephone:收货地址固话,
	 * receiverMail:收货地址邮件,
	 * isDefault:是否为默认地址（0：否、1：是）
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void add(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/receiveaddress/add.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", "28");
		postData.put("zoneCode", "cs2");
		postData.put("receiverZoneCode", "410102000003");
		postData.put("receiverZoneDetail", "陈寨北街21");
		postData.put("receiverZoneName", "河南省郑州市文化路北环交叉口23");
		postData.put("receiverName", "武兵123");
		postData.put("receiverMobile", "15838226036");
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 修改收货地址
	 * @param reqMap
	 * postData={
	 * id:收货地址主键id,
	 * receiverZoneCode:收获地址区域编码,
	 * memberId:会员id,
	 * receiverZoneDetail:收货地址详细,
	 * receiverZoneName:收货地址名称,
	 * longitude:收货地址经度,
	 * latitude:收货地址纬度,
	 * receiverName:收货地址名称,
	 * receiverMobile:收货地址手机号码,
	 * receiverTelephone:收货地址固话,
	 * receiverMail:收货地址邮件,
	 * isDefault:是否为默认地址（0：否、1：是）
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void update(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/receiveaddress/update.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("id", 5000);
		postData.put("receiverZoneDetail", "陈寨北街1");
		postData.put("receiverZoneName", "河南省郑州市文化路北环交叉口1");
		postData.put("receiverName", "侯飞龙");
		postData.put("receiverMobile", "15838226037");
		
		System.out.println(JSONUtil.getJson(postData));
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	
	/**
	 * 设置默认收货地址
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * page:页码,
	 * pagesize:也显示最大记录数}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:地址列表信息}
	 */
	public static void getList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/receiveaddress/getList.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", "28asdfasdfasdfasdf");
		postData.put("zoneCode", "cs2");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 设置默认收货地址
	 * @param reqMap
	 * postData={
	 * id:收货地址主键id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void setDefault(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/receiveaddress/setDefault.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("id", 5000);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 设置默认收货地址
	 * @param reqMap
	 * postData={id:收货地址主键id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void delete(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/receiveaddress/delete.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("id", 4998);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 得到收货地址
	 * @param reqMap
	 * postData={id:收货地址主键id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void get(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/receiveaddress/get.htm";
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("id", 5000);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
}
