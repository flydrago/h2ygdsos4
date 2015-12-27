package test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.SystemUtils;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.util.DateUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class CommentTest {

	public static final String server = "http://10.10.10.186:8080/h2ygdsos/server/";

	
	public static void main(String[] args){
		cancelPraise();
//		addPraise();
//		addTest();
//		deleteTest();
//		updateTest();
//		selectTest();
//		selectListTest();
//		selectRowsTest();
//		mapToJson();
	}
	
	public static void cancelPraise(){
		String url = server+"comment/changePraiseStatus.htm";
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("dataId",15);
		postData.put("account","15036791525");
		postData.put("status",-1);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果：\n"+result);
	}
	
	public static void addPraise(){
		String url = server+"comment/doPraise.htm";
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("dataId",15);
		postData.put("account","15036791525");
		postData.put("praiseType",0);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果：\n"+result);
	}
	
	
	public static void addTest(){
		String url = server+"comment/addComment.htm";
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("dataId","69");
		postData.put("dataType",1);
		postData.put("account","15036791525");
		postData.put("content", "奉天承运，皇帝诏曰：日了狗了！");
		postData.put("level","4");
		postData.put("parentId", 0);
		postData.put("zoneCode", "4101");
		postData.put("orderNo","819200000");
		postData.put("beanName", "goodsCommentParamCheck");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果：\n"+result);
	}
	
	public static void deleteTest(){
		String url = server+"comment/deleteComment.htm";
		Map<String,Object> postData = new HashMap<String,Object>();
		postData.put("id", 1);
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果：\n"+result);
	}
	
	public static void updateTest(){
		String url = server+"comment/updateComment.htm";
		Map<String,Object> postData = new HashMap<String,Object>();
		postData.put("id", 2);
		postData.put("level", 1);
		postData.put("content","此酒只应天上有，人间难得几回闻。" );
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果：\n"+result);
	}
	
	public static void selectTest(){
		String url = server+"comment/getComment.htm";
		Map<String,Object> postData = new HashMap<String,Object>();
		postData.put("id", 2);
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果：\n"+result);
	}
	
	public static void selectListTest(){
		String url = server+"comment/getPageComments.htm";
		Map<String,Object> postData = new HashMap<String,Object>();
		postData.put("dataId", 93);
		postData.put("page", 1);
		postData.put("pagesize",10);
		postData.put("account","15838279930");
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果：\n"+result);
	}
	
	public static void selectRowsTest(){
		String url = server+"comment/getCommentRows.htm";
		Map<String,Object> postData = new HashMap<String,Object>();
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(postData));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果：\n"+result);
	}
	
	public static void mapToJson(){
		String oriStr = "{appv=null, os=null, sid=sid3, postData={\"id\":1}, osv=null, skey=skey2, slock=slock1}";
//		Map<String,Object> oriMap = JSONUtil.getMap(oriStr);
//		String resJson = JSONUtil.getJson(oriStr);
		String resJson = oriStr.replaceAll("=", ":");
		System.out.println(resJson);
	}
	
	
	
}

