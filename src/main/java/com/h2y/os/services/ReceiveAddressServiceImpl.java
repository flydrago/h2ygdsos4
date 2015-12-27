package com.h2y.os.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.basic.WbsKeys.SInvokeKeys;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.dao.IReceiveAddressDao;
import com.h2y.os.entity.ReceiveAddress;
import com.h2y.os.entity.SysUnits;
import com.h2y.os.entity.Zone;
import com.h2y.util.DataResponseUtil;
import com.h2y.util.DateUtil;
import com.h2y.util.JSONUtil;
import com.h2y.util.MatcherUtil;
import com.h2y.util.StringUtil;

/**
 * 项目名称：h2ygdsos  
 * 类名称：ReceiveAddressServiceImpl  
 * 类描述：  收货地址业务操作接口实现类
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午11:38:57  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午11:38:57  
 * 修改备注：  
 * @version
 */
@Service("receiveAddressService")
public class ReceiveAddressServiceImpl implements IReceiveAddressService {
	
	@Autowired
	protected IReceiveAddressDao receiveAddressDao;
	
	@Autowired
	protected ICommonDao commonDao;
	
	private static final Logger logger = Logger.getLogger(ReceiveAddressServiceImpl.class);

	public Map<String,Object> add(Map<String, Object> reqMap) {
		
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String zoneCode = paraMap.get(JydKeys.zoneCode.value())+"";//用户所处区域添加的区域编码
			String memberId = paraMap.get("memberId")+"";//会员id
			String receiverZoneDetail = paraMap.get("receiverZoneDetail")+"";//收货地址详细地址
			String receiverZoneName = paraMap.get("receiverZoneName")+"";//收货地址名称
			String longitude = StringUtil.objectToString(paraMap.get("longitude"));//收货地址经度
			String latitude = StringUtil.objectToString(paraMap.get("latitude"));//收货地址纬度
			
			String receiverName = StringUtil.objectToString(paraMap.get("receiverName"));//收货人姓名
			String receiverMobile = StringUtil.objectToString(paraMap.get("receiverMobile"));//收货人电话
			String receiverTelephone = StringUtil.objectToString(paraMap.get("receiverTelephone"));//收货人固话
			
			if (!MatcherUtil.isMobileNO(receiverMobile)) {
				return DataResponseUtil.getResultData(reqMap, 0, "收货人手机号格式不正确！");
			}
			
			ReceiveAddress receiveAddress = new ReceiveAddress();
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}
			receiveAddress.setZoneId(sysUnits.getId());
			
			receiveAddress.setCreateDate(DateUtil.getSystemTime());
			receiveAddress.setUpdateDate(DateUtil.getSystemTime());
			receiveAddress.setIsDefault(0);//默认为非默认地址
			if (MatcherUtil.checkFloat(longitude)) {
				receiveAddress.setLongitude(new BigDecimal(longitude));
			}
			if (MatcherUtil.checkFloat(latitude)) {
				receiveAddress.setLatitude(new BigDecimal(latitude));
			}
			receiveAddress.setMemberId(memberId);
			receiveAddress.setReceiverMobile(receiverMobile);
			receiveAddress.setReceiverName(receiverName);
			receiveAddress.setReceiverTelephone(receiverTelephone);
			receiveAddress.setStatus(0);
			receiveAddress.setZoneDetail(receiverZoneDetail);
			receiveAddress.setZoneName(receiverZoneName);
			receiveAddressDao.add(receiveAddress);
			
			return DataResponseUtil.getResultData(reqMap, 1, "收货地址添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return DataResponseUtil.getResultData(reqMap, 0, "收货地址添加失败！");
		}
	}
	
	
	public Map<String,Object> update(Map<String, Object> reqMap) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String zoneCode = paraMap.get("zoneCode")+"";//收货地址区域编码
			String receiverZoneDetail = paraMap.get("receiverZoneDetail")+"";//收货地址详细地址
			String receiverZoneName = paraMap.get("receiverZoneName")+"";//收货地址名称
			String longitude = StringUtil.objectToString(paraMap.get("longitude"));//收货地址经度
			String latitude = StringUtil.objectToString(paraMap.get("latitude"));//收货地址纬度
			
			String receiverName = StringUtil.objectToString(paraMap.get("receiverName"));//收货人姓名
			String receiverMobile = StringUtil.objectToString(paraMap.get("receiverMobile"));//收货人电话
			String receiverTelephone = StringUtil.objectToString(paraMap.get("receiverTelephone"));//收货人固话
			String receiverMail = StringUtil.objectToString(paraMap.get("receiverMail"));//收货人邮件
			String id = paraMap.get("id")+"";
			
			if (!MatcherUtil.checkNumber(id)) {
				return DataResponseUtil.getResultData(reqMap, 0, "收货地址id不合法！");
			}
			
			ReceiveAddress receiveAddress = receiveAddressDao.get(Long.valueOf(paraMap.get("id")+""));
			if (null==receiveAddress) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前地址不存在！");
			}

			receiveAddress.setUpdateDate(DateUtil.getSystemTime());
			if (MatcherUtil.checkFloat(longitude)) {
				receiveAddress.setLongitude(new BigDecimal(longitude));
			}
			if (MatcherUtil.checkFloat(latitude)) {
				receiveAddress.setLatitude(new BigDecimal(latitude));
			}
			receiveAddress.setReceiverMail(receiverMail);
			receiveAddress.setReceiverMobile(receiverMobile);
			receiveAddress.setReceiverName(receiverName);
			receiveAddress.setReceiverTelephone(receiverTelephone);
			receiveAddress.setStatus(0);
			receiveAddress.setZoneDetail(receiverZoneDetail);
			receiveAddress.setZoneName(receiverZoneName);
			
			receiveAddressDao.update(receiveAddress);
			result = DataResponseUtil.getResultData(reqMap, 1, "收货地址修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "收货地址修改失败！");
		}
		return result;
	}
	
	public Map<String,Object> setDefault(Map<String,Object> reqMap){
		
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			String id = paraMap.get("id")+"";
			
			if (!MatcherUtil.checkNumber(id)) {
				return DataResponseUtil.getResultData(reqMap, 0, "收货地址id不合法！");
			}
			
			ReceiveAddress receiveAddress = receiveAddressDao.get(Long.valueOf(paraMap.get("id")+""));
			if (null==receiveAddress) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前地址不存在！");
			}
			receiveAddress.setIsDefault(1);
			
			//设置会员对应的其他收货地址为非默认地址
			receiveAddressDao.updateUnDefaultByMemberId(receiveAddress.getMemberId());
			
			receiveAddressDao.update(receiveAddress);
			
			result = DataResponseUtil.getResultData(reqMap, 1, "设置默认地址成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "设置默认地址失败！");
		}
		return result;
	}


	public Map<String,Object> getList(Map<String, Object> reqMap) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value()));
			String zoneCode = paraMap.get(JydKeys.zoneCode.value())+"";//用户所处区域添加的区域编码
			
			SysUnits sysUnits = commonDao.getSysUnitsByDomain(zoneCode);
			if (null==sysUnits) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前商家不存在！");
			}
			
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("memberId", paraMap.get("memberId"));
			params.put("zoneId", sysUnits.getId());
			dataList = receiveAddressDao.getListMap(params);
			if (null==dataList) {
				dataList = new ArrayList<Map<String,Object>>();
			}
			result = DataResponseUtil.getResultData(reqMap, 1, "获取数据成功", dataList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "获取数据失败", dataList);
		}
		return result;
	}


	public Map<String,Object> delete(Map<String, Object> reqMap) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			receiveAddressDao.deleteById(Long.valueOf(paraMap.get("id")+""));
			
			result = DataResponseUtil.getResultData(reqMap, 1, "删除地址成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "删除地址失败！");
		}
		return result;
	}

	public Map<String, Object> get(Map<String, Object> reqMap) {
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = JSONUtil.getMap(reqMap.get(SInvokeKeys.postData.value())+"");
			ReceiveAddress receiveAddress = receiveAddressDao.get(Long.valueOf(paraMap.get("id")+""));
			
			if (null==receiveAddress) {
				return DataResponseUtil.getResultData(reqMap, 0, "当前收货地址不存在！");
			}
			
			result = DataResponseUtil.getResultData(reqMap, 1, "获取收货地址成功！",receiveAddress);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = DataResponseUtil.getResultData(reqMap, 0, "获取收货地址失败！");
		}
		return result;
	}
	
}
