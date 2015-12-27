package test;

import java.util.HashMap;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.LocalServiceKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class LocalServiceTest {

	public static void main(String[] args) {
		//getSortListTest();
		getShopListBySortTest();
		//getGoodsListByShopIdTest();
	}


	public static void getSortListTest() {

		String url = "http://10.10.10.189:8082/h2ygdsos/server/localService/getSortList.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		//postMap.put(LocalServiceKeys.latitude.value(), 39);
		//postMap.put(LocalServiceKeys.longitude.value(), 0);
		//postMap.put(LocalServiceKeys.id.value(), 1);
		//postMap.put(LocalServiceKeys.parentId.value(), 1);
		//postMap.put(LocalServiceKeys.shopName.value(), 3);
		//postMap.put(LocalServiceKeys.sortId.value(), 0);

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}


	public static void getShopListBySortTest() {

		String url = "http://10.10.10.189:8082/h2ygdsos/server/localService/getShopListBySort.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());
		params.put("zoneCode", "4101");

		Map<String, Object> postMap = new HashMap<String, Object>();
		//postMap.put(LocalServiceKeys.latitude.value(), 34.821311);
		//postMap.put(LocalServiceKeys.longitude.value(), 113.642736);

		//postMap.put(LocalServiceKeys.id.value(), 1);
		postMap.put(LocalServiceKeys.parentId.value(), 2);
		//postMap.put(LocalServiceKeys.shopName.value(), 3);
		postMap.put(LocalServiceKeys.sortId.value(), 3);

		postMap.put(JydKeys.zoneCode.value(), "4101");
		postMap.put("page", 1);
		postMap.put("pagesize", 10);

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}

	public static void getGoodsListByShopIdTest() {

		String url = "http://10.10.10.189:8082/h2ygdsos/server/localService/getGoodsListByShopId.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(LocalServiceKeys.unitId.value(), 32);

		postMap.put("page", 1);
		postMap.put("pagesize", 10);

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}

}
