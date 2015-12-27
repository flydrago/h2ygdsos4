package test;

import java.util.HashMap;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.FindServiceKeys;
import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.util.DataRequestUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class GoodsTest {

	public static void main(String[] args) {

//		 selfListTest();
//		 getGoodsTypeList();
//		 testAddGoodsFocus();
//		testCancelGoodsFocus();
		
//		testGetGoodsFocusList();
		
//		testGetRelationList();
		
		getGoodsDetail();
	}
	
	
	public static void getGoodsDetail() {

		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/goods/getDetail.htm";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());
		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put("id", 8303);
		postMap.put("zoneCode", "cs2");
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}

	public static void selfListTest() {

		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/goods/selfList.htm";
		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put("zoneCode", "cs2");
		postMap.put("page", "1");
		postMap.put("goodsTypeId", "108");

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}

	public static void getGoodsTypeList() {

		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/goods/getGoodsTypeList.htm";
		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put("zoneCode", "cs2");

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}
	
	
	public static void testAddGoodsFocus() {

		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/goods/addGoodsFocus.htm";
		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());
		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(JydKeys.memberId.value(), 28);
		postMap.put(JydKeys.goodsPriceId.value(), 8302);
		postMap.put("zoneCode", "cs2");
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));
		
		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);

	}
	
	
	public static void testCancelGoodsFocus() {

		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/goods/cancelGoodsFocus.htm";
		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(JydKeys.memberId.value(), 39);
		postMap.put(JydKeys.goodsPriceId.value(), 1);
		postMap.put("zoneCode", "cs2");

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);

	}

	public static void testGetGoodsFocusList() {

		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/goods/getGoodsFocusList.htm";
		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(JydKeys.memberId.value(), "28");
		postMap.put(JydKeys.zoneCode.value(), "cs2");

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);

	}

	public static void testGetRelationList() {

		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/goods/getRelationList.htm";
		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();		
		postMap.put(JydKeys.goodsPriceId.value(), 8302);
		postMap.put(JydKeys.zoneCode.value(), "cs2");


		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);

	}

}
