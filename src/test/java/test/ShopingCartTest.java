package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.util.DataRequestUtil;
import com.h2y.util.HttpTookit;
import com.h2y.util.JSONUtil;

public class ShopingCartTest {

	
	public static void main(String[] args) {
		
		add();
		
//		addBatch();
		
//		reduce();
		
//		update();
		
//		getList();
		
//		syn();
		
//		delete();
		
//		getUnLoginList();
		
//		getListRows();
		
	}
	
	
	/**
	 * memberId:会员id, goodsPriceId:商品定价id, goodsId:商品id（暂不使用）
	 */
	public static void add(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/shopingcart/add.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("zoneCode", "cs2");
		paraInfo.put("memberId", 28);
		paraInfo.put("goodsPriceId", "8302");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 批量添加购物车商品数量
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * goodsList:[{
	 * goodsPriceId:商品定价id,
	 * goodsId:商品id（暂不使用）,
	 * count:商品数量,
	 * buyType:购买类型（0：购买、1：酒库）}]}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void addBatch(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", 30);
		
		List<Map<String,Object>> goodsList = new ArrayList<Map<String,Object>>();
		Map<String,Object> goodsData = new HashMap<String, Object>();
		goodsData.put("goodsPriceId", 66);
		goodsData.put("buyType", 1);
		goodsData.put("count", 1);
		
		Map<String,Object> goodsData1 = new HashMap<String, Object>();
		goodsData1.put("goodsPriceId", 67);
		goodsData1.put("buyType", 1);
		goodsData1.put("count", 1);
		
		goodsList.add(goodsData);
		goodsList.add(goodsData1);
		
		postData.put("goodsList", goodsList);
		
		System.out.println(JSONUtil.getJson(postData));
		
//		Map<String,Object> resultMap = DataRequestUtil.getRequestData("shopingcart/addBatch.htm", postData);
//		System.out.println("返回结果："+resultMap);
	}
	
	
	/**
	 * memberId:会员id, goodsPriceId:商品定价id, goodsId:商品id（暂不使用）
	 */
	public static void reduce(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/shopingcart/reduce.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("memberId", 28);
		paraInfo.put("goodsPriceId", 4);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * memberId:会员id, goodsPriceId:商品定价id, goodsCount:商品数量, goodsId:商品id（暂不使用）
	 */
	public static void update(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/shopingcart/update.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("memberId", 28);
		paraInfo.put("goodsPriceId", "4");
		paraInfo.put("goodsCount", "10");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * memberId:会员id, goodsPriceId:商品定价id, goodsId:商品id（暂不使用）
	 */
	public static void delete(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/shopingcart/delete.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		List<Long> ids = new ArrayList<Long>();
		ids.add(7l);
		ids.add(8l);
		paraInfo.put("ids", ids);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * memberId:会员id, page:页码, pagesize:也显示最大记录数
	 */
	public static void getList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/shopingcart/getList.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("memberId", 28);
		paraInfo.put("page", "1");
		paraInfo.put("pagesize", "10");
		paraInfo.put("zoneCode", "4101");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	
	/**
	 * goodsPriceIds:商品定价id集合
	 */
	public static void getUnLoginList(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/shopingcart/getUnLoginList.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		
		List<Long> goodsPriceIds = new ArrayList<Long>();
		paraInfo.put("goodsPriceIds", goodsPriceIds);
		paraInfo.put("zoneCode", "370000000");
		goodsPriceIds.add(2l);
		goodsPriceIds.add(4l);
		goodsPriceIds.add(5l);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * memberId:会员id, page:页码, pagesize:也显示最大记录数
	 */
	public static void syn(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/shopingcart/syn.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("memberId", 28);
		paraInfo.put("zoneCode", "370000000");
		List<Map<String,Object>> goodsList = new ArrayList<Map<String,Object>>();
		paraInfo.put("goodsList", goodsList);
		Map<String,Object> goods1 = new HashMap<String, Object>();
		goods1.put("goodsPriceId", 4);
		goods1.put("goodsCount", 4);
		
		Map<String,Object> goods2 = new HashMap<String, Object>();
		goods2.put("goodsPriceId", 7);
		goods2.put("goodsCount", 5);
		
		Map<String,Object> goods3 = new HashMap<String, Object>();
		goods3.put("goodsPriceId", 8);
		goods3.put("goodsCount", 6);
		goodsList.add(goods1);
		goodsList.add(goods2);
		goodsList.add(goods3);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * memberId:会员id, page:页码, pagesize:也显示最大记录数
	 */
	public static void clear(){
		
		String url = "http://127.0.0.1:80/h2ycmbs4/cmbs/shopingcart/clear.htm";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), null);
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
	
	
	/**
	 * 获取购物车列表行数
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * zoneCode:区域编码}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:行数}
	 */
	public static void getListRows(){
		
		String url = "http://10.10.10.182:80/h2ycmbs2/cmbs/shopingcart/getListRows.htm";
		
		Map<String,Object> paraInfo = new HashMap<String, Object>();
		paraInfo.put("memberId", 30);
		paraInfo.put("zoneCode", "4101");//区域编码
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(SInvokeKeys.postData.value(), JSONUtil.getJson(paraInfo));
		params.put(SInvokeKeys.slock.value(),"slock1");
		params.put(SInvokeKeys.skey.value(),"skey2");
		params.put(SInvokeKeys.sid.value(),"sid3");
		String result = HttpTookit.doPost(url, params);
		System.out.println("返回结果："+result);
	}
}
