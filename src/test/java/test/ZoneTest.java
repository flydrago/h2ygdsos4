package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import sun.print.resources.serviceui;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.entity.BaseResult;
import com.h2y.os.entity.CheckBaseResult;
import com.h2y.util.DataRequestUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class ZoneTest {
	
	public static void main(String[] args) {
		
		getZoneCode();
	}
	
	/**
	 * 根据当前位置信息，得到对应的区域编码信息
	 * @param reqMap
	 * postdata={
	 * countyName:区县,
	 * cityName:城市名
	 * }
	 * @return
	 */
	public static void getZoneCode(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/zone/getZoneCode.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("zoneCode", "cs3");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		params.put(SInvokeKeys.os.value(),"os-1.0");
		params.put(SInvokeKeys.osv.value(),"osv-1.1");
		params.put(SInvokeKeys.appv.value(),"appv-1.2");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
}

