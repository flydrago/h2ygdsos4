package test;

import java.util.HashMap;
import java.util.Map;

import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class FindActivityTest {

	
	public static void main(String[] args) {
		
//		getList();
//		getCommentList();
		getGoodsList();
//		getDetail();
	}
	
	
	public static void getList(){
		
		String url = "http://10.10.10.182/h2yos/server/findactivity/getList.htm";
		
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("page", 1);
		paraMap.put("pagesize", 10);
		paraMap.put("zoneCode", 410100000);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("paraJson", JSONUtil.getJson(paraMap));
		
		String result = HttpTookit.doPost(url, params);
		System.out.println("result:\n"+result);
		
		//返回实例
		/**
		 [
		    {
		        "id": 6,
		        "title": "活动三",
		        "description": "活动三活动三",
		        "path": "/opt/wps/file/fup/findactivity_path/2014/12/11/1418280086544.jpg",
		        "createDate": "2014-12-11 14:41:42",
		        "commentRows": 1
		    },
		    {
		        "id": 5,
		        "title": "活动二",
		        "description": "活动二",
		        "path": "/opt/wps/file/fup/findactivity_path/2014/12/11/1418280064956.jpg",
		        "createDate": "2014-12-11 14:37:08",
		        "commentRows": 0
		    }
		]
		 */
	}
	
	
	public static void getCommentList(){
		
		String url = "http://10.10.10.182/h2yos/server/findactivity/getCommentList.htm";
		
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("page", 2);
		paraMap.put("pagesize", 2);
		paraMap.put("activityId", 6);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("paraJson", JSONUtil.getJson(paraMap));
		
		String result = HttpTookit.doPost(url, params);
		System.out.println("result:\n"+result);
		
		//返回实例
		/**
		 [
		    {
		        "content": "hello",
		        "activityId": 6,
		        "id": 3,
		        "nickName": "贱人",
		        "account": "13839735371",
		        "realName": "李世娜",
		        "memberId": 28,
		        "createDate": "2014-12-12 16:52:59"
		    },
		    {
		        "content": "nihao",
		        "activityId": 6,
		        "id": 2,
		        "nickName": "宝宝",
		        "account": "18662302973",
		        "realName": "石天保",
		        "memberId": 27,
		        "createDate": "2014-12-12 16:52:22"
		    }
		]
		 */
	}
	
	
	
	public static void getGoodsList(){
		
		String url = "http://10.10.10.182/h2yos/server/findactivity/getGoodsList.htm";
		
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("page", 1);
		paraMap.put("pagesize", 2);
		paraMap.put("activityId", 6);
		paraMap.put("zoneCode", 410100000);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("paraJson", JSONUtil.getJson(paraMap));
		
		String result = HttpTookit.doPost(url, params);
		System.out.println("result:\n"+result);
		
		//返回实例
		/**
		 [
		    {
		        "content": "hello",
		        "activityId": 6,
		        "id": 3,
		        "nickName": "贱人",
		        "account": "13839735371",
		        "realName": "李世娜",
		        "memberId": 28,
		        "createDate": "2014-12-12 16:52:59"
		    },
		    {
		        "content": "nihao",
		        "activityId": 6,
		        "id": 2,
		        "nickName": "宝宝",
		        "account": "18662302973",
		        "realName": "石天保",
		        "memberId": 27,
		        "createDate": "2014-12-12 16:52:22"
		    }
		]
		 */
	}
	
	
	
	public static void getDetail(){
		
		String url = "http://10.10.10.182/h2yos/server/findactivity/getDetail.htm";
		
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("page", 1);
		paraMap.put("pagesize", 2);
		paraMap.put("activityId", 6);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("paraJson", JSONUtil.getJson(paraMap));
		
		String result = HttpTookit.doPost(url, params);
		System.out.println("result:\n"+result);
		
		//返回实例
		/**
		 [
		    {
		        "content": "hello",
		        "activityId": 6,
		        "id": 3,
		        "nickName": "贱人",
		        "account": "13839735371",
		        "realName": "李世娜",
		        "memberId": 28,
		        "createDate": "2014-12-12 16:52:59"
		    },
		    {
		        "content": "nihao",
		        "activityId": 6,
		        "id": 2,
		        "nickName": "宝宝",
		        "account": "18662302973",
		        "realName": "石天保",
		        "memberId": 27,
		        "createDate": "2014-12-12 16:52:22"
		    }
		]
		 */
	}
}
