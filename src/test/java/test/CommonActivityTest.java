package test;

import java.util.HashMap;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class CommonActivityTest {

	
	public static void main(String[] args) {
//		
		getList();
//		getGoodsList();
//		getGoodsDetail();
		
		updateGoods();
	}
	
	/**
	 * 得到活动列表
	 * @param reqMap
	 * paraData={
	 * zoneCode:区域编码,
	 * activityType:活动类型（index:主页、other:其他）
	 * }
	 * @return
	 */
	public static void getList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/commonactivity/getList2_1.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("zoneCode", "cs2");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		System.out.println(params);
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	/**
	 * 得到活动商品列表
	 * @param reqMap
	 * paradata={
	 * zoneCode:区域编码,
	 * dataId:活动或主题Id,
	 * dataType:数据类型（0：活动、1：主题）
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public static void getGoodsList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/commonactivity/getGoodsList.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("zoneCode", "cs2");
		paraInfo.put("dataId", "888");
		paraInfo.put("dataType", "1");
		paraInfo.put("page", "1");
		paraInfo.put("pagesize", "10");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		System.out.println(params);
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	/**
	 * 得到主题对应的商品详细
	 * @param reqMap
	 * paradata={
	 * id:主题Id,
	 * memberId:会员id（未登录时可以不传）}
	 * @return
	 */
	public static void getGoodsDetail(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/commonactivity/getGoodsDetail.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("id", "889");
		paraInfo.put("memberId", "6");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		System.out.println(params);
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	public static void updateGoods(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/commonactivity/updateGoods.htm";
		Map<String,Object> params = new HashMap<String,Object>();
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
}
