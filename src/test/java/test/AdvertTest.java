package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class AdvertTest {

	
	public static void main(String[] args) {
		
//		getList();
		
//		getGoodsList();
		
		getGoodsDetail();
		
	}
	
	
	/**
	 * 得到广告栏位列表
	 * @param reqMap
	 * paraData={
	 * zoneCode:区域编码}
	 * @return
	 */
	public static void getList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/advert/getList.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("zoneCode", "cs2");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 得到广告栏位商品列表
	 * @param reqMap
	 * paradata={
	 * zoneCode:区域编码,
	 * id:栏位主题Id,
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 */
	public static void getGoodsList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/advert/getGoodsList.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("zoneCode", "ceshi");
		paraInfo.put("id", "520");
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
	 * 得到广告栏位对应的商品详细
	 * @param reqMap
	 * paradata={
	 * id:栏位主题Id,
	 * memberId:会员id（未登录时可以不传）}
	 * @return
	 */
	public static void getGoodsDetail(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/advert/getGoodsDetail.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("id", "524");
		
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
	 * 根据主题id，获取对应的促销商品数据
	 * @param reqMap
	 * paradata={id:栏位主题Id}
	 * @return
	 */
	public static void getPosterActivityData(){
		
		String url = "http://10.99.99.195:80/h2ycmbs2/cmbs/advert/getPosterActivityData.htm";
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("id", "110");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
}