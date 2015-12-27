package com.h2y.os.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.os.services.ICommonSpikeService;

/**
 * 秒杀活动
 * @author sunfj
 *
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/server/commonSpike")
public class CommonSpikeController extends BaseController{


	@Autowired
	private ICommonSpikeService commonSpikeService;


	/**
	 * 获取秒杀活动商品列表
	 */
	@RequestMapping(value="/getCommonSpikeGoodsList")
	public void getCommonSpikeGoodsList(){

		outJson(commonSpikeService.getCommonSpikeGoodsList(getReqMap()));
	}

}
