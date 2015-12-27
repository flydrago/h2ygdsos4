package test;

import java.util.HashMap;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.basic.WbsKeys.UnitKeys;
import com.h2y.os.basic.WbsKeys.UserKeys;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class GoodsAnalysisTest {

	public static void main(String[] args) {
		getGoodsAnalysisListTest();
		//addGoodsAnalysisTest();
	}
	
	
	public static void getGoodsAnalysisListTest() {

		String url = "http://10.10.10.182:80/h2ygdsos/server/goodsAnalysis/getGoodsAnalysisList.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(UnitKeys.zoneCode.value(), "4101");
//		postMap.put("memberId", "30");
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
	
	
	public static void addGoodsAnalysisTest() {

		String url = "http://10.10.10.189:8082/h2ygdsos/server/goodsAnalysis/addGoodsAnalysis.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(UnitKeys.zoneCode.value(), "4101");
		postMap.put(UserKeys.userId.value(), 1343);
		postMap.put(JydKeys.goodsPriceId.value(), 68);
		postMap.put(JydKeys.goodsTypeId.value(), 152);
		//postMap.put(LocalServiceKeys.shopName.value(), 3);
		//postMap.put(LocalServiceKeys.sortId.value(), 0);

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}

}
