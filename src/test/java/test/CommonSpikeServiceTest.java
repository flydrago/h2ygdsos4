package test;

import java.util.HashMap;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.basic.WbsKeys.SpikeKeys;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class CommonSpikeServiceTest {

	public static void main(String[] args) {
		//getCountdownTest();
		getCommonSpikeGoodsListTest();
	}


	public static void getCountdownTest() {

		String url = "http://10.10.10.189:8082/h2ygdsos/server/commonSpike/getCountdown.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(JydKeys.zoneCode.value(), "4101");
		

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}
	
	
	public static void getCommonSpikeGoodsListTest() {

		String url = "http://10.10.10.189:8082/h2ygdsos/server/commonSpike/getCommonSpikeGoodsList.htm";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put(SInvokeKeys.slock.value(), "slock_value");
		params.put(SInvokeKeys.skey.value(), "skey_value");
		params.put(SInvokeKeys.sid.value(), System.currentTimeMillis());

		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put(JydKeys.zoneCode.value(), "4101");
		postMap.put(SpikeKeys.spikeEvent.value(), 1);
		

		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postMap));

		System.out.println("--" + JSONUtil.getJson(params));
		String resutlJson = HttpTookit.doPost(url, params);
		System.out.println(resutlJson);
	}



	
		
		

	

}
