package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class LogTest {

	
	public static void main(String[] args) {
		
		memberUserRegister();
	}
	
	
	/**
	 * ={refPhones:被推荐人手机号码, refInfo:推荐人推荐的备注信息, uid:推荐人会员Id}
	 */
	public static void memberUserRegister(){
		
		String url = "http://10.10.10.182:80/h2yos/server/log/memberRef.htm";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("refPhones", "15093324566");
		map.put("refInfo", "H2Y快红疯了，快来注册吧");
		map.put("uid", "30");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("paraJson", JSONUtil.getJson(map));
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
}
