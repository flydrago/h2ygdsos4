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
import com.h2y.os.dao.IClickRateDao;
import com.h2y.os.dao.ICommonActivityDao;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.dao.IGoodsAnalysisDao;
import com.h2y.os.dao.IGoodsDao;
import com.h2y.os.dao.IGoodsFocusDao;
import com.h2y.os.entity.ClickRate;
import com.h2y.os.entity.GoodsFocus;
import com.h2y.os.entity.GoodsPrice;
import com.h2y.os.entity.SysUnits;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.DateUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.StringUtil;


/**
 * 项目名称：h2ygdsos  
 * 类名称：GoodsService  
 * 类描述：商品服务接口实现类  
 * 创建人：侯飞龙  
 * 创建时间：2015年5月4日 上午10:45:00  
 * 修改人：侯飞龙
 * 修改时间：2015年5月4日 上午10:45:00  
 * 修改备注：  
 * @version
 */
@Service("goodsService")
public class GoodsService implements IGoodsService {

	@Autowired
	protected ICommonDao commonDao;

	@Autowired
	protected IGoodsDao goodsDao;

	@Autowired
	protected ICommonActivityDao commonActivityDao;

	@Autowired
	protected IGoodsFocusDao goodsFocusDao;

	@Autowired
	protected IClickRateDao clickRateDao;

	@Autowired
	protected IGoodsAnalysisDao goodsAnalysisDao;

	private final static Logger logger = Logger.getLogger(GoodsService.class);

	/**
	 * 得到自营的商品列表
	 */
	public Map<String, Object> getSelfList(Map<String,Object> reqMap) {

		Map<String,Object> resultMap = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String zoneCode = paraMap.get("zoneCode")+"";
			String sortname = paraMap.get("sortname")+"";//排序字段 sellRate:销量、price:价格
			String sortorder = paraMap.get("sortorder")+"";//排序方式 asc desc

			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {// 当前单位不是区域代理
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");	
			}

			Map<String, Object> goodsParams = new HashMap<String, Object>();
			goodsParams.put("unitId", sysUnits.getId());
			if (null != paraMap.get("keyWord") && !"".equals(paraMap.get("keyWord") + "")) {
				goodsParams.put("keyWord", "%" + paraMap.get("keyWord") + "%");
			}
			goodsParams.put("page", Integer.parseInt(paraMap.get("page") + ""));
			goodsParams.put("pagesize", 20);
			goodsParams.put("goodsTypeId", paraMap.get("goodsTypeId"));

			//防注入处理
			if (!sortname.equals("sellRate") && !sortname.equals("price")) {
				sortname = null;
			}else {
				sortname = sortname.equals("sellRate")?"gpl.sell_rate":"gpl.single_price";
			}

			if (!sortorder.equals("desc") && !sortorder.equals("asc")) {
				sortorder = null;
			}else {
				sortorder = sortorder.equals("desc")?"desc":"asc";
			}
			goodsParams.put("sortname", sortname);
			goodsParams.put("sortorder", sortorder);
			List<Map<String, Object>> goodsList = goodsDao.getListMap(goodsParams);
			if (null==goodsList) {
				goodsList = new ArrayList<Map<String,Object>>();
			}
			resultMap = DataResponseUtil.getResultData(reqMap, 1, "获取数据成功", goodsList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}


	/**
	 * 获取商品详细
	 */
	public Map<String, Object> getGoodsDetail(Map<String,Object> reqMap) {

		Map<String, Object> result = new HashMap<String, Object>();

		Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

		Map<String,Object> resultMap = new HashMap<String, Object>();

		try {

			Long goodsPriceId = Long.valueOf(paraMap.get("id")+""); 
			String memberId = paraMap.get(JydKeys.memberId.value())+"";
			String zoneCode = paraMap.get(UnitKeys.zoneCode.value())+"";
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}
			result = getGoodsDetail(goodsPriceId, memberId,sysUnits);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "获取商品详细数据失败");
		}

		resultMap = DataResponseUtil.getResultData(reqMap, 1, "获取商品数据成功", result);

		return resultMap;
	}

	/**
	 * 获取类别列表
	 * @param resultMap
	 * @param postMap
	 * @return
	 */
	public Map<String, Object> getGoodsTypeList(Map<String,Object> reqMap) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String zoneCode = paraMap.get(UnitKeys.zoneCode.value())+"";
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}
			
			List<Map<String, Object>> goodsTypeList = goodsDao.getGoodsTypeListByParentId(sysUnits.getId());

			if (goodsTypeList == null) {
				goodsTypeList = new ArrayList<Map<String, Object>>();
			}
			resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功！",goodsTypeList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "服务器出现异常！！");
		}
		return resultMap;
	}


	/**
	 * 获取关注列表
	 */
	public Map<String, Object> getGoodsFocusList(Map<String,Object> reqMap) {

		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String memberId = StringUtil.objectToString(paraMap.get(JydKeys.memberId.value()));
			String zoneCode = StringUtil.objectToString(paraMap.get(JydKeys.zoneCode.value()));
			if (null == memberId) {
				return DataResponseUtil.getResultData(reqMap, 0, "会员id不能为空！");
			}
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}
			
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("memberId", memberId);
			params.put("unitId", sysUnits.getId());
			List<Map<String, Object>> goodsFocusList = goodsFocusDao.getListPage(params);
			if (null == goodsFocusList) {
				goodsFocusList = new ArrayList<Map<String,Object>>();
			}
			resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", goodsFocusList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "暂无数据");
		}
		return resultMap;
	}

	/**
	 * 关注
	 */
	public Map<String, Object> addGoodsFocus(Map<String,Object> reqMap) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String memberId = StringUtil.objectToString(paraMap.get(JydKeys.memberId.value()));
			String zoneCode = StringUtil.objectToString(paraMap.get(JydKeys.zoneCode.value()));
			String goodsPriceId = StringUtil.objectToString(paraMap.get(JydKeys.goodsPriceId.value()));
			if (null == memberId) {
				return DataResponseUtil.getResultData(reqMap, 0, "会员id不能为空！");
			}
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}
			
			// 判断是否已关注
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("memberId", memberId);
			params.put("unitId", sysUnits.getId());
			params.put("goodsPriceId", goodsPriceId);
			long rows = goodsFocusDao.getListRowsByMemberId(params);
			if (rows>0) {
				return DataResponseUtil.getResultData(reqMap, 1, "当前商品已关注成功！");
			}
			
			GoodsFocus goodsFocus = new GoodsFocus();
			goodsFocus.setGoodsPriceId(Long.valueOf(goodsPriceId));
			goodsFocus.setFocusDate(DateUtil.getSystemTime());
			goodsFocus.setStatus(0);
			goodsFocus.setMemberId(memberId);
			goodsFocus.setUnitId(sysUnits.getId());
			goodsFocusDao.add(goodsFocus);
			resultMap = DataResponseUtil.getResultData(reqMap, 1, "关注成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "关注失败，服务器出现异常！");
		}
		return resultMap;
	}

	/**
	 * 取消关注
	 */
	public Map<String, Object> cancelGoodsFocus(Map<String,Object> reqMap) {
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String memberId = StringUtil.objectToString(paraMap.get(JydKeys.memberId.value()));
			String zoneCode = StringUtil.objectToString(paraMap.get(JydKeys.zoneCode.value()));
			String goodsPriceId = StringUtil.objectToString(paraMap.get(JydKeys.goodsPriceId.value()));
			if (null == memberId) {
				return DataResponseUtil.getResultData(reqMap, 0, "会员id不能为空！");
			}
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}
			// 判断是否已关注
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("memberId", memberId);
			params.put("unitId", sysUnits.getId());
			params.put("goodsPriceId", goodsPriceId);
			goodsFocusDao.cancelGoodsFocus(params);
			resultMap = DataResponseUtil.getResultData(reqMap, 1, "取消关注成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap = DataResponseUtil.getResultData(reqMap, 0, "取消关注失败，服务器出现异常！");
		}
		return resultMap;
	}


	public Map<String, Object> getGoodsDetail(Long goodsPriceId, String memberId,SysUnits sysUnits) {

		Map<String,Object> result = new HashMap<String, Object>();
		// 商品信息
		GoodsPrice goodsPrice = goodsDao.get(Long.valueOf(goodsPriceId));
		goodsPrice.setSinglePrice(goodsPrice.getIsActivity()==1?goodsPrice.getActivityPrice():goodsPrice.getMemberPrice());
		result.put("goods", goodsPrice);
		//更新商品点击量
		goodsDao.updateClickRateByGoodsPriceId(goodsPrice.getId());
		
		ClickRate clickRate = new ClickRate();
		clickRate.setAccount(memberId+"");
		clickRate.setCreateDate(DateUtil.getSystemTime());
		clickRate.setGoodsId(goodsPrice.getGoodsId());
		clickRate.setGoodsPriceId(goodsPrice.getId());
		clickRate.setZoneCode(goodsPrice.getUnitId()+"");
		clickRateDao.add(clickRate);

		//商品赠品
		List<Map<String,Object>> giftList = new ArrayList<Map<String,Object>>();
		if (goodsPrice.getIsGift()==1) {
			Map<String,Object> giftParams = new HashMap<String, Object>();
			giftParams.put("unitId", goodsPrice.getUnitId());
			giftParams.put("goodsPriceId", goodsPrice.getId());
			giftList = goodsDao.getGiftListMap(giftParams);
		}
		result.put("giftList", giftList);


		// 商品标签信息
		Map<String, Object> markParams = new HashMap<String, Object>();
		String markInfoIds = goodsPrice.getMarkInfoIds();
		if (null != markInfoIds && !"".equals(markInfoIds)) {
			markInfoIds = markInfoIds.substring(1, markInfoIds.length() - 1).replaceAll("\\]\\[", ",");
			markParams.put("markInfoIds", markInfoIds);
			List<Map<String, Object>> markList = goodsDao.getGoodsMarkInfo(markParams);
			result.put("tags", markList);
		}


		// 商品图片
		Map<String, Object> imgParams = new HashMap<String, Object>();
		imgParams.put("dataId", goodsPrice.getId());
		List<Map<String,Object>> imgList = goodsDao.getGoodsImgList(imgParams);
		result.put("imgs", imgList);

		//是否关注 0:未关注、1：已关注
		Map<String,Object> focusParams = new HashMap<String, Object>();
		focusParams.put("memberId", memberId);
		focusParams.put("unitId", sysUnits.getId());
		focusParams.put("goodsPriceId", goodsPriceId);
		long rows = goodsFocusDao.getListRowsByMemberId(focusParams);
		result.put("isFocus", rows>0?1:0);

		// 活动信息
		if (goodsPrice.getIsActivity() == 1) {
			Map<String, Object> activityGoodsData = commonActivityDao.getCommonActivityGoodsById(goodsPrice.getActivityGoodsId());
			result.put("activity", activityGoodsData);
		}

		//商品详细信息
		Map<String,Object> infoParams = new HashMap<String, Object>();
		infoParams.put("dataId", goodsPrice.getId());
		infoParams.put("dataType", 1);
		Map<String,Object> goodsInfo = goodsDao.getGoodsInfo(infoParams);
		result.put("info", goodsInfo);

		return result;
	}

	/**
	 * 获取关联商品
	 */
	public Map<String, Object> getRelationList(Map<String, Object> reqMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String zoneCode = StringUtil.objectToString(paraMap.get(JydKeys.zoneCode.value()));
			String goodsPriceId = StringUtil.objectToString(paraMap.get(JydKeys.goodsPriceId.value()));
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}

			Map<String,Object> paramsMap = new HashMap<String,Object>();		
			paramsMap.put("unitId", sysUnits.getId());
			paramsMap.put("goodsPriceId", Long.valueOf(goodsPriceId));

			List<Map<String,Object>> relateionList = goodsDao.getRelationListMap(paramsMap);
			if (null==relateionList) {		
				relateionList = new ArrayList<Map<String,Object>>();
			} 
			resultMap = DataResponseUtil.getResultData(reqMap, 1, "返回成功", relateionList);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return DataResponseUtil.getResultData(reqMap, 1, "服务器端出现异常！");
		}
		return resultMap;
	}

}
