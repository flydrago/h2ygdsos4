package com.h2y.os.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.read.IWechatActivityDaoR;
import com.h2y.os.dao.write.IWechatActivityDaoW;
import com.h2y.os.entity.WechatActivity;
import com.h2y.os.entity.WechatActivityHis;
import com.h2y.os.entity.WechatActivityPrize;


@Service("wechatActivityDao")
public class WechatActivityDaoImpl implements IWechatActivityDao{
	
	@Autowired
	protected IWechatActivityDaoR wechatActivityDaoR;
	
	@Autowired
	protected IWechatActivityDaoW wechatActivityDaoW;

	public WechatActivity getWechatActivity(long id) {
		return wechatActivityDaoR.getWechatActivity(id);
	}

	public List<Map<String, Object>> getStartWechatActivity(
			Map<String, Object> map) {
		return wechatActivityDaoR.getStartWechatActivity(map);
	}

	public void addWechatActivityHis(WechatActivityHis wechatActivityHis) {
		wechatActivityDaoW.addWechatActivityHis(wechatActivityHis);
	}

	public List<WechatActivityPrize> getPrizeListByActivityId(long activityId) {
		return wechatActivityDaoR.getPrizeListByActivityId(activityId);
	}

	public List<WechatActivityPrize> getShowPrizeListByActivityId(
			long activityId) {
		return wechatActivityDaoR.getShowPrizeListByActivityId(activityId);
	}

	public long getActivityHisRowsByLimitType(Map<String, Object> map) {
		return wechatActivityDaoR.getActivityHisRowsByLimitType(map);
	}

	public long getHitPrizeRowsByActivityId(Map<String, Object> map) {
		return wechatActivityDaoR.getHitPrizeRowsByActivityId(map);
	}

	public WechatActivity getOneStartWechatActivity(Map<String, Object> map) {
		return wechatActivityDaoR.getOneStartWechatActivity(map);
	}

}
