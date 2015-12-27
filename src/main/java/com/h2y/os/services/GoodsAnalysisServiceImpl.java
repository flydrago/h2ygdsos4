package com.h2y.os.services;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.basic.WbsKeys.UnitKeys;
import com.h2y.os.dao.IGoodsAnalysisDao;
import com.h2y.os.entity.GoodsAnalysis;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.DateUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.StringUtil;

/**
 * ServiceImpl
 * @author hwttnet
 * version:1.2
 * time:2015-06-30
 * email:info@hwttnet.com
 */
@Service("goodsAnalysisService")
public class GoodsAnalysisServiceImpl implements IGoodsAnalysisService{


	@Autowired
	protected IGoodsAnalysisDao goodsAnalysisDao;

	private final static Logger logger = Logger.getLogger(GoodsAnalysisServiceImpl.class);

	/**
	 * 获取猜你喜欢列表
	 */
	public Map<String,Object> getGoodsAnalysisList(Map<String,Object> reqMap){

		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

		Map<String,Object> paramsMap = new HashMap<String,Object>();

		Map<String,Object> resultMap = new HashMap<String,Object>();

		List<Map<String,Object>> guessList = new ArrayList<Map<String,Object>>();

		try{

			//查询数据总数，猜你喜欢一共9挑数据，分类热卖12条数据
			int analysisNum = 9;
			paramsMap.put("analysisNum", analysisNum);

			//获取用户id
			String memberId = StringUtil.objectToString(paraMap.get(JydKeys.memberId.value()));
			//获取用户id
			String zoneCode = StringUtil.objectToString(paraMap.get(UnitKeys.zoneCode.value()));
			paramsMap.put("zoneCode", zoneCode);

			//当前城市是否开通
			List<Map<String,Object>> zoneList = goodsAnalysisDao.getZoneListByCode(paramsMap);
			//当前城市未开通
			if(null == zoneCode || null == zoneList || zoneList.isEmpty() || zoneList.size() == 0){
				resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", guessList);
			}else{

				//获取该用户喜欢列表
				if(null != memberId && !"".equals(memberId) && !"0".equals(memberId)){
					paramsMap.put("memberId", memberId);
					guessList = goodsAnalysisDao.getGoodsAnalysisListByUser(paramsMap);
					//该用户喜欢数据为空，则查询点击量最高的9条数据
					if(null == guessList || guessList.isEmpty()){
						paramsMap.remove("memberId");
						guessList = goodsAnalysisDao.getGoodsAnalysisListAll2(paramsMap);
					}else if(guessList.size() < analysisNum){//不足9条就凑够9条
						//过滤重复
						String goodsPriceId = "";
						for(int i=0;i<guessList.size();i++){
							goodsPriceId = goodsPriceId + guessList.get(i).get("id")+",";
						}
						paramsMap.put("goodsPriceId", goodsPriceId.substring(0, goodsPriceId.length()-1));

						//					List<Map<String,Object>> guessList2 = goodsAnalysisDao.getGoodsAnalysisListByUser9(paramsMap);
						List<Map<String,Object>> guessList2 = goodsAnalysisDao.getGoodsAnalysisListAll2(paramsMap);
						if(null != guessList2 && !guessList2.isEmpty()){
							for(int i=0;i<guessList2.size();i++){						
								if(guessList.size()<analysisNum){//凑够9条数据
									guessList.add(guessList2.get(i));
								}else{
									i=guessList2.size();//结束循环
								}

							}
						}

					}
				}else{//获取所有用户点击率较高的数据列表
					guessList = goodsAnalysisDao.getGoodsAnalysisListAll2(paramsMap);
				}


				if(null != guessList && guessList.size() >0){
					resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", guessList);
				} else {
					resultMap = DataResponseUtil.getResultData(reqMap, 2, "暂无数据", guessList);
				}
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0 , "数据获取失败！",resultMap);
		}

		return resultMap;
	}


	/**
	 * 添加猜你喜欢
	 * memberId 会员id
	 * zoneCode 区域编码
	 * goodsPriceId 商品定价id
	 */
	public Map<String,Object> addGoodsAnalysis(Map<String,Object> reqMap){

		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

		Map<String,Object> paramsMap = new HashMap<String,Object>();

		Map<String,Object> resultMap = new HashMap<String,Object>();

		List<Map<String,Object>> guessListOne = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> guessListAll = new ArrayList<Map<String,Object>>();

		//操作标识
		int flag = 0;

		//获取用户id
		String memberId = StringUtil.objectToString(paraMap.get(JydKeys.memberId.value()));
		paramsMap.put("memberId", memberId);
		//获取用户id
		String zoneCode = StringUtil.objectToString(paraMap.get(UnitKeys.zoneCode.value()));
		paramsMap.put("zoneCode", zoneCode);	
		//获取用户id
		String goodsPriceId = StringUtil.objectToString(paraMap.get(JydKeys.goodsPriceId.value()));
		paramsMap.put("goodsPriceId", goodsPriceId);	

		String goodsTypeId = StringUtil.objectToString(paraMap.get(JydKeys.goodsTypeId.value()));

		//判断该用户是否已经添加过该猜你喜欢数据
		guessListOne = goodsAnalysisDao.getGoodsAnalysisListByUser(paramsMap);
		if(null != guessListOne && !guessListOne.isEmpty()){
			Map<String,Object> goodsAnalysisMap = guessListOne.get(0);
			GoodsAnalysis goodsAnalysis = goodsAnalysisDao.get(Long.valueOf(goodsAnalysisMap.get("aid")+""));
			//更新点击数及更新日期
			goodsAnalysis.setClickCount(goodsAnalysis.getClickCount()+1);
			goodsAnalysis.setUpdateDate(DateUtil.getSystemTime());
			flag = goodsAnalysisDao.update(goodsAnalysis);
		}else{//获取该用户一共有多少条猜你喜欢数据
			paramsMap.remove("goodsPriceId");
			guessListAll = goodsAnalysisDao.getGoodsAnalysisListByUser(paramsMap);
			GoodsAnalysis goodsAnalysisNew = new GoodsAnalysis();
			//该用户不足9条数据
			if(null == guessListAll || guessListAll.isEmpty() || guessListAll.size()<9){				
				goodsAnalysisNew.setOrd((guessListAll==null||guessListAll.isEmpty())?0:guessListAll.size());
			}else{//该用户大于9条数据则删除最早的数据
				//获取最后一条数据并删除
				Map<String,Object> goodsAnalysisLastMap = guessListAll.get(guessListAll.size()-1);
				GoodsAnalysis goodsAnalysisLast = goodsAnalysisDao.get(Long.valueOf(goodsAnalysisLastMap.get("aid")+""));
				goodsAnalysisNew.setOrd(goodsAnalysisLast.getOrd());
				goodsAnalysisDao.deleteById(goodsAnalysisLast.getId());
			}


			goodsAnalysisNew.setUserId(Long.valueOf(memberId));
			goodsAnalysisNew.setClickCount(1);
			goodsAnalysisNew.setGoodsPriceId(Long.valueOf(goodsPriceId));
			goodsAnalysisNew.setGoodsTypeId(Long.valueOf(goodsTypeId));
			goodsAnalysisNew.setCreateDate(DateUtil.getSystemTime());
			goodsAnalysisNew.setUpdateDate(DateUtil.getSystemTime());
			goodsAnalysisNew.setZoneCode(zoneCode);

			flag = goodsAnalysisDao.add(goodsAnalysisNew);

		}


		if(flag >0){
			resultMap = DataResponseUtil.getResultData(reqMap, 1, "操作成功", "");
		} else {
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "操作失败", "");
		}

		return resultMap;
	}










}