package com.h2y.os.util;

import com.h2y.util.PropertiesUtil;



public class SysBaseUtil {

	/**
	 * mencached 缓存有效时间（秒）
	 */
	public final static long EXPIRY_TIME = 600;


	public final static String JYD_KF="4008609519";

	public final static String ZZS_CODE="4101";

	/**
	 * 微信注册模块code
	 */
	public final static String WREGISTER_CODE="W_REGISTER_MODULE";

	/**
	 * 微信充值密码code
	 */
	public final static String WRESET_CODE="W_RESET_MODULE";

	//服务器基础路径
	public static String BASE_PATH = null;

	//第三方代驾url
	public static String AGENT_DRIVER_URL = null;

	//图片服务器
	public static String FP_URL = null;

	//转发服务
	public static String CMBS_URL = null;

	//e代驾地址
	public static String EAGENT_URL = null;
	
	//会员服务url
	public static String USER_URL = null;

	static {

		PropertiesUtil mPropertiesUtil = PropertiesUtil.getInstance("/confing.properties");

		if(mPropertiesUtil.getValueByKey("os.basePath") != null){
			BASE_PATH = mPropertiesUtil.getValueByKey("os.basePath");
		}

		if(mPropertiesUtil.getValueByKey("ad.url") != null){
			AGENT_DRIVER_URL = mPropertiesUtil.getValueByKey("ad.url");
		}

		if(mPropertiesUtil.getValueByKey("fp.url") != null){
			FP_URL = mPropertiesUtil.getValueByKey("fp.url");
		}

		if(mPropertiesUtil.getValueByKey("cmbs.url") != null){
			CMBS_URL = mPropertiesUtil.getValueByKey("cmbs.url");
		}

		if(mPropertiesUtil.getValueByKey("eAgent.url") != null){
			EAGENT_URL = mPropertiesUtil.getValueByKey("eAgent.url");
		}
		
		if(mPropertiesUtil.getValueByKey("user.url") != null){
			USER_URL = mPropertiesUtil.getValueByKey("user.url");
		}
	}


	public static void main(String[] args) {

	}



	/**
	 * 侯飞龙
	 * 混合选择窗口，列表健
	 */
	public enum MixSelectListKey{

		/**
		 * 人员列表健
		 */
		pepleKey("p_"),

		/**
		 * 部门列表健
		 */
		deptKey("d_");

		public String key;
		private MixSelectListKey(String result){
			this.key=result;
		}
	}


	/**
	 * 权限类型静态变量
	 */
	public class PrivilegeKey{

		/**
		 * 单位
		 */
		public final static String UNIT = "UNIT";


		/**
		 * 用户
		 */
		public final static String USER = "USER";

		/**
		 * 角色
		 */
		public final static String ROLE = "ROLE";

		/**
		 * 菜单
		 */
		public final static String MENU = "MENU";


		/**
		 * 按钮
		 */
		public final static String BUTTON = "BUTTON";
	}


	/**
	 * 积分情况
	 * @author lilaing
	 *
	 */
	public class GradeKey{

		/**
		 * 达人豆
		 */
		public final static String CATEGORY_BEAN="0";

		/**
		 * 达人币
		 */
		public final static String CATEGORY_COIN="1";

		/**
		 * 签到
		 */
		public final static String SIGN_TYPE="0";

		/**
		 * 消费
		 */
		public final static String FEE_TYPE="1";

		/**
		 * 作为第一推荐人获取奖励
		 */
		public final static String REF_ONE_TYPE="2";

		/**
		 * 作为第二推荐热获取奖励
		 */
		public final static String REF_TWO_TYPE="3";

		/**
		 * 退还
		 */
		public final static String BACK_TYPE="4";




		/**
		 * 大转盘
		 */
		public final static String WHEEL_TYPE="5";


		/**
		 * 刮刮卡
		 */
		public final static String CARD_TYPE="6";


		/**
		 * 砸金蛋
		 */
		public final static String EGG_TYPE="7";


		/**
		 * 推荐人关系建立
		 */
		public final static String REF_BUILD="8";

		/**
		 * 促销活动
		 */
		public final static String COMMON_ACTIVITY="9";
		

		/**
		 * 商品赠送
		 */
		public final static String GOODS = "10";
		
		
		/**
		 * 推广活动
		 */
		public final static String PROMOTE = "11";
	}




	/**
	 * mencached健前缀
	 */
	public class MemcachedKeyPrefix{

		/**
		 * 用户Id
		 */
		public final static String USER_ID = "H2Y_USER_ID";


		/**
		 * 单位Id
		 */
		public final static String UNIT_ID = "H2Y_UNIT_ID";

		/**
		 * 系统角色Id
		 */
		public final static String SYS_ROLE_ID = "H2Y_SYS_ROLE_ID";


		/**
		 * 用户对象
		 */
		public final static String USER = "H2Y_USER";

		/**
		 * 单位对象
		 */
		public final static String UNIT = "H2Y_UNIT";
	}


	/**
	 * 系统维护关联类型
	 */
	public class SysJoinType{


		/**
		 * 菜单
		 */
		public final static String MENU = "menu";


		/**
		 * 表格列
		 */
		public final static String GRID = "grid";

		/**
		 * 验证
		 */
		public final static String VALIDATE = "validate";


		/**
		 * 查询
		 */
		public final static String QUERY = "query";
	}



	public class DictKey{


		public final static String ABOUT_DELIVERY="ABOUT_DELIVERY";

		public final static String DELIVERY_TIME="DELIVERY_TIME";

		//运费
		public final static String FEE="FEE";

		//产生运费标准
		public final static String MIN_FEE="MIN_FEE";



	}


	/**
	 * 字典前缀 
	 */
	public class DictPrefix{

		/**
		 * 主表
		 */
		public final static String DIC_MAIN = "DIC_MAIN";


		/**
		 * 详细表
		 */
		public final static String DIC_DETAIL = "DIC_DETAIL";
	}


	public enum DictClumn{
		//id
		id,
		//主表Id
		dictMainId,
		//编码
		code,
		//对应值
		value,
		//备注信息
		memo,
		//排序字段
		ord;
	}

	public enum DictOrderBy{
		//降序
		desc,
		//升序
		asc
	}


	/**
	 * 操作类型
	 */
	public enum OpType{

		/**
		 * 登陆
		 */
		login,

		/**
		 * 退出
		 */
		loginOut,

		/**
		 * 添加
		 */
		add,

		/**
		 * 删除
		 */
		delete,

		/**
		 * 修改
		 */
		modify,

		/**
		 * 查询
		 */
		search;
	}

	/**
	 * 操作结果
	 */
	public enum OpRresult{

		/**
		 * 操作成功
		 */
		success,

		/**
		 * 操作失败
		 */
		fail;
	}


	/**
	 * 广告对象数组
	 */
	public enum AdvertObj{


		/**
		 * android客户端
		 */
		Android("android",1),

		/**
		 * Ios客户端
		 */
		IOS("ios",2),

		/**
		 * 微信客户端
		 */
		WeChat("wechat",4);

		public final String name;//字典code
		public final int pow;//次方
		private AdvertObj(String name,int pow){
			this.name = name;
			this.pow = pow;
		}
	}

	/**
	 * 广告主题类型枚举
	 */
	public enum AdvertSubjectType{

		/**
		 * 商品列表
		 */
		LIST("list"),

		/**
		 * 商品详细
		 */
		DETAIL("detail"),

		/**
		 * 宣传页面
		 */
		HTML("html");

		public final String name;//字典code
		private AdvertSubjectType(String name){
			this.name = name;
		}
	}


	/**
	 * 类描述：微信活动类型   
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum WechatActivityType{

		/**
		 * 大转盘
		 */
		wheel("wheel"),

		/**
		 * 刮刮卡
		 */
		card("card"),

		/**
		 * 砸金蛋
		 */
		egg("egg");

		public final String name;
		private WechatActivityType(String name){
			this.name = name;
		}
	}


	/**
	 * 类描述：奖品类型
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum PrizeType{

		/**
		 * 达人币
		 */
		darenbi("darenbi"),

		/**
		 * 达人豆
		 */
		darendou("darendou"),

		/**
		 * 商品
		 */
		goods("goods"),

		/**
		 * 其他
		 */
		qita("qita");

		public final String name;
		private PrizeType(String name){
			this.name = name;
		}
	}

}
