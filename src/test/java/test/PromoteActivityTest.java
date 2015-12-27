package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.util.SysBaseUtil;
import com.h2y.util.DataRequestUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class PromoteActivityTest {

	
	public static void main(String[] args) {
		
		
		add();
	}
	
	
	/**
	 * 获取推广活动收益（优惠劵、商品、达人币、达人豆）
	 * @param reqMap
	 * postData={
	 * promoteId:推广活动id,
	 * shareAccount:分享会员账号,
	 * claimAccount:认领会员账号
	 * }
	 * @return
	 */
	public static void add(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("promoteId", "8");
		postData.put("shareAccount", "13838257740");
		postData.put("claimAccount", "15136209859");
		
			
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put(SInvokeKeys.slock.value(),"1");
		resultMap.put(SInvokeKeys.skey.value(),"2");
		resultMap.put(SInvokeKeys.sid.value(),"3");
		resultMap.put(SInvokeKeys.os.value(),"h2ygdsos");
		resultMap.put(SInvokeKeys.osv.value(),"1.0");
		resultMap.put(SInvokeKeys.appv.value(),"1.0");
		resultMap.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		String resultMsg = HttpTookit.doPost("http://ctlsvr.jydapp.com:92/promoteActivity/claim.htm", resultMap);
		System.out.println("返回结果："+resultMsg);
	}
}
