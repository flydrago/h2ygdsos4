package test;

import java.util.HashMap;
import java.util.Map;

import sun.misc.CEFormatException;

import com.h2y.util.DataRequestUtil;
import com.h2y.util.JSONUtil;

public class SpiritRoomTest {

	
	public static void main(String[] args) {
		
//		add();
		
//		updatePassWord();
		
//		getValidGoodsList();
		
//		getGoodsUnitList();
		
//		getGoodsListByUnitId();
		
		getGoodsListByZoneCode();
		
		
//		getGoodsInfo();
		
//		checkPwd();
		
//		veriCode();
		
//		resetPwd();
	}
	
	/**
	 * 创建酒库
	 * @param reqMap
	 * postData={
	 * zoneCode:区域编码,
	 * memberId:会员id,
	 * password:酒库密码
	 * }
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void add(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("zoneCode", "4101");
		postData.put("memberId", 30);
		postData.put("password", "123456");
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/add.htm", postData);
		System.out.println("返回结果："+resultMap);
	}
	
	
	
	
	/**
	 * 修改酒库密码
	 * @param reqMap
	 * postData={
	 * zoneCode:区域编码,
	 * memberId:会员id,
	 * oldPassword:酒库旧密码,
	 * newPassword:酒库新密码}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void updatePassWord(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("zoneCode", "4101");
		postData.put("memberId", 30);
		postData.put("oldPassword", "234567");
		postData.put("newPassword", "123456");
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/updatePassWord.htm", postData);
		System.out.println("返回结果："+resultMap);
	}
	
	/**
	 * 得到当前区域有效的酒库商品列表
	 * @param reqMap
	 * postData={
	 * zoneCode:区域编码,
	 * memberId:会员id,
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:商品列表信息}
	 */
	public static void getValidGoodsList(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("zoneCode", "4101");
		postData.put("memberId", 30);
		
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/getValidGoodsList.htm", postData);
		System.out.println("返回结果："+JSONUtil.getJson(resultMap));
	}
	
	
	/**
	 * 得到酒库中的单位列表（显示单位的商品总数量）
	 * @param reqMap
	 * postData={
	 * zoneCode:区域编码,
	 * memberId:会员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:单位列表信息}
	 */
	public static void getGoodsUnitList(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("zoneCode", "4101");
		postData.put("memberId", 30);
		postData.put("page", 1);
		postData.put("pagesize", 10);
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/getGoodsUnitList.htm", postData);
		System.out.println("返回结果："+JSONUtil.getJson(resultMap));
	}
	
	
	/**
	 * 得到当前区域有效的酒库商品列表
	 * @param reqMap
	 * postData={
	 * zoneCode:区域编码,
	 * memberId:会员id,
	 * unitId:单位id,
	 * page:页码,
	 * pagesize:页显示最大记录数}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:商品列表信息}
	 */
	public static void getGoodsListByUnitId(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("zoneCode", "4101");
		postData.put("memberId", 30);
		postData.put("unitId", 63);
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/getGoodsListByUnitId.htm", postData);
		System.out.println("返回结果："+resultMap);
	}
	
	
	/**
	 * 得到指定区域有效的酒库商品列表
	 * @param reqMap
	 * postData={
	 * zoneCode:区域编码,
	 * roomZoneCode:酒库区域编码,
	 * memberId:会员id}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息,resultData:商品列表信息}
	 */
	public static void getGoodsListByZoneCode(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("zoneCode", "4101");
		postData.put("memberId", 30);
		postData.put("roomZoneCode", "4101");
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/getGoodsListByZoneCode.htm", postData);
		System.out.println("返回结果："+JSONUtil.getJson(resultMap));
	}
	
	/**
	 * 得到酒库中添加商品详细
	 * @param reqMap
	 * postData={
	 * zoneCode:区域编码,
	 * memberId:会员id,
	 * goodsPriceId:商品定价id
	 * }
	 * @return
	 */
	public static void getGoodsInfo(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("zoneCode", "4101");
		postData.put("memberId", 30);
		postData.put("goodsPriceId", "66");
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/getGoodsInfo.htm", postData);
		System.out.println("返回结果："+resultMap);
	}
	
	/**
	 * 酒库密码验证
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * password:酒库旧密码}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void checkPwd(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", 30);
		postData.put("password", "654321");
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/checkPwd.htm", postData);
		System.out.println("返回结果："+resultMap);
	}
	
	
	/**
	 * 获取酒库验证码
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * mobile:绑定手机号（目前为账号）}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void veriCode(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", 30);
		postData.put("zoneCode", "4101");
		postData.put("mobile", "13838257740");
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/veriCode.htm", postData);
		System.out.println("返回结果："+resultMap);
	}
	
	
	/**
	 * 酒库密码重置
	 * @param reqMap
	 * postData={
	 * memberId:会员id,
	 * veriCode:验证码,
	 * newPassword:新密码}
	 * @return
	 * {resultFlag:结果标识（0：失败、1：成功 ） ,resultMsg:提示消息}
	 */
	public static void resetPwd(){
		
		Map<String,Object> postData = new HashMap<String, Object>();
		postData.put("memberId", 30);
		postData.put("veriCode", "681115");
		postData.put("newPassword", "123456");
		
		Map<String,Object> resultMap = DataRequestUtil.getRequestData("spiritRoom/resetPwd.htm", postData);
		System.out.println("返回结果："+resultMap);
	}
}
