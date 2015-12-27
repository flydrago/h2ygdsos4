package com.h2y.os.basic;

/**
 * 常用参数处理
 * 
 * @author：段晓刚
 * 
 * @update：2015年4月3日 上午11:39:23
 * 
 * @Email：
 */
public class WbsKeys {

	/**
	 * 服务端调用参数
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年3月27日 上午9:12:27
	 * 
	 * @Email：
	 */
	public enum SInvokeKeys {

		// 配合skey使用进行安全验证
		slock("slock"),
		// 配合slock使用
		skey("skey"),
		// 请求发出后的唯一标示
		sid("sid"),
		// 操作系统
		os("os"),
		// 系统操作类型
		osv("osv"),
		// app版本号
		appv("appv"),
		// 参数头部
		paramData("paramData"),
		// 业务参数
		postData("postData"),
		// 返回结果标示
		resultFlag("resultFlag"),
		// 返回结果信息
		resultMsg("resultMsg"),
		// 返回的业务逻辑
		resultData("resultData");

		private String _value;

		SInvokeKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * bean常量
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年4月3日 上午11:43:26
	 * 
	 * @Email：
	 */
	public enum UserKeys {

		// 用户id
		userId("userId"),
		// 用户名字
		userName("userName"),
		// 昵称
		nickName("nickName"),
		// 账号
		account("account"),
		// 密码
		password("password");

		private String _value;

		UserKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * 单位信息键值
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年4月7日 上午9:35:52
	 * 
	 * @Email：
	 */
	public enum UnitKeys {

		// 单位id
		unitId("unitId"),
		// 单位code
		unitCode("unitCode"),
		// 单位名称
		unitName("unitName"),
		// 地区编码
		zoneCode("zoneCode"),
		// 地区名称
		zoneName("zoneName");

		private String _value;

		UnitKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * 方法处理
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年3月31日 下午4:41:40
	 * 
	 * @Email：
	 */
	public enum MethodKeys {

		// 注册
		register("user/register"),
		// 登录
		login("login"),
		// 用户退出
		exit("update"),
		// 商品数据
		goods("goods");

		private String _value;

		MethodKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}

	/**
	 * 服务端调用参数
	 * 
	 * @author：段晓刚
	 * 
	 * @update：2015年3月27日 上午9:12:27
	 * 
	 * @Email：
	 */
	public enum JydKeys {

		// 商品id
		focusId("focusId"),

		// 商品id
		goodsId("goodsId"),
		// 商品编码
		gdsCode("gdsCode"),
		// 会员id
		memberId("memberId"),
		// 关注类型 0商品 1店铺
		focusType("focusType"),
		// 地区编号
		zoneCode("zoneCode"),

		// 定价表id
		goodsPriceId("goodsPriceId"),

		// 定价表版本号
		goodsPriceVersion("goodsPriceVersion"),

		// 商品类别
		goodsTypeId("goodsTypeId"),
		// 店铺id
		shopId("shopId"),
		// 商品来源
		goodsSource("goodsSource"),

		// 单位id
		unitId("unitId");

		private String _value;

		JydKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}



	/**
	 * 发现
	 * @author sunfj
	 *
	 */
	public enum FindServiceKeys {

		// 地区编号
		zoneCode("zoneCode"),
		// 父id
		parentId("parentId");


		private String _value;

		FindServiceKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}



	/**
	 * 秒杀活动
	 * @author sunfj
	 *
	 */
	public enum SpikeKeys {

		// 本次秒杀活动id
		dataId("dataId"),
		//0本场 1下场
		spikeEvent("spikeEvent");



		private String _value;

		SpikeKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}



	/**
	 * 生活+
	 * @author sunfj
	 *
	 */
	public enum LocalServiceKeys {

		// 地区编号
		id("id"),
		// 父id
		parentId("parentId"),
		//公司名称
		shopName("shopName"),
		//经度
		longitude("longitude"),
		//维度
		latitude("latitude"),
		//公司id
		unitId("unitId"),
		//是否预约
		isReservation("isReservation"),
		//是否H2Y合作
		isJyd("isJyd"),
		//是否提供wifi
		isWifi("isWifi"),
		//是否提供车位
		isPark("isPark"),
		//小编认证
		isApprove("isApprove"),
		//是否推广
		isSpread("isSpread"),
		//分类id
		sortId("sortId");


		private String _value;

		LocalServiceKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}


	/**
	 * e代驾
	 * @author sunfj
	 *
	 */
	public enum EAgentDriverKeys {

		// 地区编号
		id("id"),		
		//经度
		locationLongitude("locationLongitude"),
		//维度
		locationLatitude("locationLatitude"),
		//电话
		phone("phone"),
		//客户端类型：android:安卓、ios:苹果客户端
		clientType("clientType"),		
		//地址
		locationAddress("locationAddress"),
		//
		from("from");


		private String _value;

		EAgentDriverKeys(String value) {
			_value = value;
		}

		public String value() {
			return _value;
		}
	}


}