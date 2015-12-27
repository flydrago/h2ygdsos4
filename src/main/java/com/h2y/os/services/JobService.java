package com.h2y.os.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.util.PropertiesUtil;

/**
 * 消息发送调度

 * @update：2014年12月28日 下午8:11:54

 * @Email：
 */
@Service("jobService")
public class JobService {
	
	private static Logger logger = Logger.getLogger(JobService.class);
	
	@Autowired
	protected ICommonActivityService commonActivityService;
	
	/**
	 * 发送推送消息
	 */
	public void updateGoodsPrice(){
		logger.debug("更新商品价格调度开始！");
		commonActivityService.updateActivityGoodsPrize();
		logger.debug("更新商品价格调度结束!");
	}
}
