package com.h2y.os.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.check.ICommonCheck;
import com.h2y.os.dao.ICommonActivityDao;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.dao.IShoppingCartDao;
import com.h2y.os.entity.BaseResult;
import com.h2y.os.entity.CheckBaseResult;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.entity.ShoppingCart;
import com.h2y.os.util.SpiritRoomUtil.CheckModule;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.DateUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.MatcherUtil;

/**
 * 项目名称：h2ygdsos  
 * 类名称：ReceiveAddressServiceImpl  
 * 类描述：  购物车业务操作接口实现类
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午11:38:57  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午11:38:57  
 * 修改备注：  
 * @version
 */
@Service("shopingCartService")
public class ShoppingCartServiceImpl implements IShoppingCartService {

	@Autowired
	protected IShoppingCartDao shoppingCartDao;

	@Autowired
	protected ICommonDao commonDao;

	@Autowired
	protected ICommonCheck commonCheck;

	@Autowired
	private ICommonActivityDao commonActivityDao;

	private static final Logger logger = Logger.getLogger(ShoppingCartServiceImpl.class);

	public Map<String,Object> add(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			long goodsPriceId = Long.valueOf(paraMap.get(JydKeys.goodsPriceId.value())+"");
			int buyType = MatcherUtil.checkNumber(paraMap.get("buyType")+"")?Integer.parseInt(paraMap.get("buyType")+""):0;//购买类型 0：购买、1：酒库
			CheckBaseResult checkBaseResult = new CheckBaseResult(0);
			//验证
			commonCheck.check(paraMap, checkBaseResult, CheckModule.memberUser,CheckModule.zoneCode);
			if (checkBaseResult.getResultFlag()!=1) {

				return DataResponseUtil.getResultData(reqMap, checkBaseResult.getResultFlag(), checkBaseResult.getResultMsg());
			}


			MemberUser memberUser = checkBaseResult.getMemberUser();
			BaseResult baseResult = addShoppingCart(memberUser, goodsPriceId, buyType,1);
			if (baseResult.getResultFlag()!=1) {
				return DataResponseUtil.getResultData(reqMap, baseResult.getResultFlag(),baseResult.getResultMsg());
			}

			result = DataResponseUtil.getResultData(reqMap, 1, "当前商品购物车数量添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "当前商品购物车数量添加失败！");
		}
		return result;
	}

	public Map<String, Object> addBatch(Map<String, Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			@SuppressWarnings("unchecked")
			List<Map<String,Object>> goodsList = (List<Map<String, Object>>) paraMap.get("goodsList");
			CheckBaseResult checkBaseResult = new CheckBaseResult(0);
			commonCheck.check(paraMap, checkBaseResult, CheckModule.memberUser,CheckModule.zoneCode);
			if (checkBaseResult.getResultFlag()!=1) {

				return DataResponseUtil.getResultData(reqMap, checkBaseResult.getResultFlag(), checkBaseResult.getResultMsg());
			}

			MemberUser memberUser = checkBaseResult.getMemberUser();

			for (Map<String, Object> goodsMap : goodsList) {

				long goodsPriceId = Long.valueOf(goodsMap.get(JydKeys.goodsPriceId.value())+"");
				int buyType = MatcherUtil.checkNumber(goodsMap.get("buyType")+"")?Integer.parseInt(goodsMap.get("buyType")+""):0;//购买类型 0：购买、1：酒库
				int count = MatcherUtil.checkNumber(goodsMap.get("count")+"","+")?Integer.parseInt(goodsMap.get("count")+""):1;

				BaseResult baseResult = addShoppingCart(memberUser, goodsPriceId, buyType,count);
				if (baseResult.getResultFlag()!=1) {
					return DataResponseUtil.getResultData(reqMap, baseResult.getResultFlag(),baseResult.getResultMsg());
				}
			}
			result = DataResponseUtil.getResultData(reqMap, 1, "购物车批量添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "购物车批量添加失败！");
		}
		return result;
	}

	public Map<String,Object> reduce(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			long goodsPriceId = Long.valueOf(paraMap.get(JydKeys.goodsPriceId.value())+"");
			String memberId = paraMap.get(JydKeys.memberId.value())+"";
			int buyType = MatcherUtil.checkNumber(paraMap.get("buyType")+"")?Integer.parseInt(paraMap.get("buyType")+""):0;//购买类型 0：购买、1：酒库

			Map<String,Object> params = new HashMap<String, Object>();
			params.put("goodsPriceId", goodsPriceId);
			params.put("memberId", memberId);
			params.put("buyType", buyType);

			//查询当前用户看是否已经添加当前商品
			ShoppingCart shoppingCart = shoppingCartDao.getByGoodsPriceIdAndMemberId(params);

			if (null==shoppingCart){
				return DataResponseUtil.getResultData(reqMap, 1, "当前商品购物车数量减少成功！");
			}
			if (shoppingCart.getGoodsCount()<=1) {

				return DataResponseUtil.getResultData(reqMap, 0, "当前商品在购物车数量已达到了下限，不可继续减少！");
			}
			shoppingCart.setGoodsCount(shoppingCart.getGoodsCount()-1);
			shoppingCartDao.update(shoppingCart);

			result = DataResponseUtil.getResultData(reqMap, 1, "当前商品购物车数量减少成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 1, "当前商品购物车数量减少失败！");
		}
		return result;
	}

	public Map<String,Object> update(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			long goodsPriceId = Long.valueOf(paraMap.get(JydKeys.goodsPriceId.value())+"");
			String memberId = paraMap.get(JydKeys.memberId.value())+"";
			int goodsCount = Integer.parseInt(paraMap.get("goodsCount")+"");
			int buyType = MatcherUtil.checkNumber(paraMap.get("buyType")+"")?Integer.parseInt(paraMap.get("buyType")+""):0;//购买类型 0：购买、1：酒库


			CheckBaseResult checkBaseResult = new CheckBaseResult(0);
			//验证
			commonCheck.check(paraMap, checkBaseResult, CheckModule.memberUser,CheckModule.zoneCode);
			if (checkBaseResult.getResultFlag()!=1) {

				return DataResponseUtil.getResultData(reqMap, checkBaseResult.getResultFlag(), checkBaseResult.getResultMsg());
			}

			Map<String,Object> params = new HashMap<String, Object>();
			params.put("goodsPriceId", goodsPriceId);
			params.put("memberId", memberId);
			params.put("buyType", buyType);

			boolean isHasAdd = true;//是否已经添加过

			//查询当前用户看是否已经添加当前商品
			ShoppingCart shoppingCart = shoppingCartDao.getByGoodsPriceIdAndMemberId(params);
			if (null==shoppingCart) {
				shoppingCart = new ShoppingCart();
				isHasAdd = false;
			}
			shoppingCart.setCreateDate(DateUtil.getSystemTime());
			shoppingCart.setGoodsPriceId(goodsPriceId);
			shoppingCart.setMemberId(memberId);
			shoppingCart.setStatus(0);
			shoppingCart.setGoodsCount(goodsCount);

			if (isHasAdd) {
				shoppingCartDao.update(shoppingCart);
			}else {
				shoppingCartDao.add(shoppingCart);
			}

			result = DataResponseUtil.getResultData(reqMap, 1, "当前商品购物车数量修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "当前商品购物车数量修改失败！");
		}
		return result;
	}

	public Map<String,Object> delete(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			@SuppressWarnings("unchecked")
			List<Long> ids = (List<Long>) paraMap.get("ids");
			if (null==ids || ids.isEmpty()) {
				result = DataResponseUtil.getResultData(reqMap, 0, "移除商品为空！");
			}else {

				Map<String,Object> params = new HashMap<String, Object>();
				params.put("ids", ids);
				params.put("status", -1);
				shoppingCartDao.updateStatusByIds(params);
				result = DataResponseUtil.getResultData(reqMap, 1, "当前商品从购物车移除成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "当前商品从购物车移除失败！");
		}
		return result;
	}


	public Map<String, Object> syn(Map<String, Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");

			//本地商品列表
			@SuppressWarnings("unchecked")
			List<Map<String,Object>> localList = (List<Map<String, Object>>) paraMap.get("goodsList");
			String memberId = paraMap.get(JydKeys.memberId.value())+"";

			if (null!=localList && !localList.isEmpty()) {

				for (Map<String, Object> dataMap : localList) {

					long goodsPriceId = Long.valueOf(dataMap.get(JydKeys.goodsPriceId.value())+"");
					int goodsCount = Integer.parseInt(dataMap.get("goodsCount")+"");

					Map<String,Object> params = new HashMap<String, Object>();
					params.put("goodsPriceId", goodsPriceId);
					params.put("memberId", memberId);
					params.put("buyType", 0);

					//查询当前用户看是否已经添加当前商品
					ShoppingCart shoppingCart = shoppingCartDao.getByGoodsPriceIdAndMemberId(params);

					if (null==shoppingCart) {
						shoppingCart = new ShoppingCart();

						shoppingCart.setCreateDate(DateUtil.getSystemTime());
						shoppingCart.setGoodsPriceId(goodsPriceId);
						shoppingCart.setMemberId(memberId);
						shoppingCart.setStatus(0);
						shoppingCart.setGoodsCount(goodsCount);
						shoppingCartDao.add(shoppingCart);
					}else {

						shoppingCart.setCreateDate(DateUtil.getSystemTime());
						shoppingCart.setGoodsCount(shoppingCart.getGoodsCount()+goodsCount);
						shoppingCartDao.update(shoppingCart);
					}
				}
			}

			result = DataResponseUtil.getResultData(reqMap, 1, "购物车商品同步成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "购物车商品同步失败！");
		}
		return result;
	}

	public Map<String,Object> getList(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value()));

			Map<String,Object> params = new HashMap<String, Object>();
			params.put("memberId", paraMap.get(JydKeys.memberId.value()));

			dataList = shoppingCartDao.getListMap(params);
			result = DataResponseUtil.getResultData(reqMap, 1, "购物车列表数据获取成功！",dataList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "购物车列表数据获取失败！",dataList);
		}
		return result;
	}

	public Map<String, Object> getUnLoginList(Map<String, Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();

		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value()));

			@SuppressWarnings("unchecked")
			List<Map<String,Object>> goodsPriceInfos =  (List<Map<String, Object>>) paraMap.get("goodsPriceInfos");

			if (null==goodsPriceInfos || goodsPriceInfos.isEmpty()) {

				result = DataResponseUtil.getResultData(reqMap, 0, "商品id集合为空，获取列表数据失败！",dataList);
			}else{

				Map<String,Object> params = new HashMap<String, Object>();
				params.put("goodsPriceInfos", goodsPriceInfos);
				dataList = shoppingCartDao.getUnLoginListMap(params);
				result = DataResponseUtil.getResultData(reqMap, 1, "购物车列表数据获取成功！",dataList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "购物车列表数据获取失败！",dataList);
		}
		return result;
	}

	public Map<String, Object> clear(Map<String, Object> reqMap) {

		Map<String,Object> result = new HashMap<String, Object>();

		try {

			doClear(1000);
			result = DataResponseUtil.getResultData(reqMap, 1, "购物车清除数据成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "购物车清除数据失败！");
		}
		return result;
	}

	/**
	 * 递归清除数据
	 * @param pagesize 一次最大清除数量
	 */
	@Transactional(rollbackFor=Exception.class)
	private void doClear(int pagesize){

		Map<String,Object> params = new HashMap<String, Object>();
		params.put("page", 1);
		params.put("pagesize", pagesize);
		List<ShoppingCart> list = shoppingCartDao.getShoppingCartRemoveList(params);
		if (list!=null && !list.isEmpty()) {

			//添加历史表
			shoppingCartDao.addBatchHis(list);

			//删除购物车表数据
			Map<String,Object> deleteParams = new HashMap<String, Object>();
			deleteParams.put("list", list);
			shoppingCartDao.deleteByShoppingCarts(deleteParams);
		}

		if (null==list || list.size()<pagesize) {//清理数据为空，和清理数据未达到上限说明已清理完毕
			return;
		}

		doClear(pagesize);
	}


	/**
	 * 添加购物车
	 * @param memberId
	 * @param goodsPriceId
	 * @param buyType
	 * @param count 要添加的数量
	 */
	private BaseResult addShoppingCart(MemberUser memberUser,long goodsPriceId,int buyType,int count){

		BaseResult baseResult = new BaseResult(0);

		Map<String,Object> params = new HashMap<String, Object>();
		params.put("goodsPriceId", goodsPriceId);
		params.put("memberId", memberUser.getId());
		params.put("buyType", buyType);

		boolean isHasAdd = true;//是否已经添加过

		//查询当前用户看是否已经添加当前商品
		ShoppingCart shoppingCart = shoppingCartDao.getByGoodsPriceIdAndMemberId(params);
		if (null==shoppingCart) {
			shoppingCart = new ShoppingCart();
			isHasAdd = false;
		}
		shoppingCart.setCreateDate(DateUtil.getSystemTime());
		shoppingCart.setGoodsPriceId(goodsPriceId);
		shoppingCart.setMemberId(memberUser.getId());
		shoppingCart.setBuyType(buyType);
		shoppingCart.setStatus(0);

		if (isHasAdd) {

			shoppingCart.setGoodsCount(shoppingCart.getGoodsCount()+count);
			shoppingCartDao.update(shoppingCart);
		}else {

			shoppingCart.setGoodsCount(count);
			shoppingCartDao.add(shoppingCart);
		}
		baseResult.setResultFlag(1);
		return baseResult;
	}

	public Map<String, Object> getListRows(Map<String, Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();

		try {

			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value()));

			String zoneCode = paraMap.get(JydKeys.zoneCode.value())+"";

			if (MatcherUtil.isSqlAttack(zoneCode)) {
				return DataResponseUtil.getResultData(reqMap, 0, "区域编码格式不合法！",0);
			}
			
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("memberId", paraMap.get(JydKeys.memberId.value()));
			params.put("zoneCode", zoneCode);
			long rows = shoppingCartDao.getListRows(params);
			result = DataResponseUtil.getResultData(reqMap, 1, "购物车列表数据行数获取成功！",rows);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "购物车列表数据行数获取失败！",0);
		}
		return result;
	}
}
