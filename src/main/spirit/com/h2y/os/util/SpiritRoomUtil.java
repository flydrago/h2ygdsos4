package com.h2y.os.util;


public class SpiritRoomUtil {
	
	/**
	 * 类描述：礼包状态
	 * 作者：侯飞龙
	 * 时间：2014年12月17日下午6:03:49
	 * 邮件：1162040314@qq.com
	 */
	public enum CheckModule{

		/**
		 * 会员验证
		 */
		memberUser("memberUser"),
		
		/**
		 * 区域验证
		 */
		zoneCode("zoneCode"),

		/**
		 * 分页验证
		 */
		page("page"),
		

		/**
		 * 酒库验证
		 */
		spiritRoom("spiritRoom");

		public final String value;
		private CheckModule(String value){
			this.value = value;
		}
	}
	
}
