package com.h2y.os.check;

import java.util.Map;

import com.h2y.os.entity.CheckBaseResult;
import com.h2y.os.util.SpiritRoomUtil.CheckModule;

/**
 * 项目名称：h2ygdsos  
 * 类名称：IGiftBagService  
 * 类描述：礼包业务操作接口  
 * 创建人：侯飞龙  
 * 创建时间：2015年6月10日 上午11:37:16  
 * 修改人：侯飞龙
 * 修改时间：2015年6月10日 上午11:37:16  
 * 修改备注：  
 * @version
 */
public interface ICommonCheck{
	
	/**
	 * 验证
	 * @param postData
	 * @param checkBaseResult
	 * @param checkModule 验证的模块
	 */
	public void check(Map<String, Object> postData,CheckBaseResult checkBaseResult,CheckModule ... checkModule);
	
}
