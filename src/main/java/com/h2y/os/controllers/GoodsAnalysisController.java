package com.h2y.os.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2y.os.basic.BaseController;
import com.h2y.os.services.IGoodsAnalysisService;

@Controller
@Scope("prototype")
@RequestMapping(value="/server/goodsAnalysis")
public class GoodsAnalysisController extends BaseController{

	@Autowired
	protected IGoodsAnalysisService goodsAnalysisService;

	/**
	 * 获取猜你喜欢列表
	 */
	@RequestMapping(value = "/getGoodsAnalysisList")
	public void getGoodsAnalysisList(){
		outJson(goodsAnalysisService.getGoodsAnalysisList(getReqMap()));
	}


	@RequestMapping(value = "/addGoodsAnalysis")
	public void addGoodsAnalysis(){
		outJson(goodsAnalysisService.addGoodsAnalysis(getReqMap()));
	}

}
