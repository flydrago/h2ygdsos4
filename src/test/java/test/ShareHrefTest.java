package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.h2y.util.DataRequestUtil;
import com.h2y.util.EmojiFilter;
import com.h2y.util.JSONUtil;

public class ShareHrefTest {

	public static void main(String[] args) {
		
		getList();
		
		
//		List<String> list = new ArrayList<String>();
//		
//		for (int i = 0; i < 10; i++) {
//			list.add(i+"");
//		}
//		
//		System.out.println(list.subList(0, 5));
//		System.out.println(list);
	}
	
	
	/**
	 * 获取分享链接列表
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * zoneCode:区域编码}
	 * @return
	 * [{title=标题, description=描述, img:图标, url=跳转url}]
	 */
	public static void getList(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", "30");
		postData.put("zoneCode", "4101");
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("shareHref/getList.htm", postData);
		System.out.println("返回结果："+JSONUtil.getJson(resultMap));
	}
}
