package com.h2y.os.check;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.basic.WbsKeys.JydKeys;
import com.h2y.os.dao.ICommonDao;
import com.h2y.os.dao.IGoodsDao;
import com.h2y.os.entity.CheckBaseResult;
import com.h2y.os.entity.MemberUser;
import com.h2y.os.util.SpiritRoomUtil.CheckModule;
import com.h2y.util.MatcherUtil;

/**
 * 项目名称：h2ygdsos  
 * 类名称：GiftBagServiceImpl  
 * 类描述：礼包业务验证接口实现类  
 * 创建人：侯飞龙  
 * 创建时间：2015年6月10日 上午11:57:24  
 * 修改人：侯飞龙
 * 修改时间：2015年6月10日 上午11:57:24  
 * 修改备注：  
 * @version
 */
@Service("commonCheck")
public class CommonCheckImpl implements ICommonCheck{
	
	@Autowired
	protected ICommonDao commonDao;
	
	@Autowired
	protected IGoodsDao goodsDao;

	private void memberUser(Map<String, Object> postData,
			CheckBaseResult checkBaseResult) {
		
//		checkBaseResult.setResultFlag(0);
		String memberId = postData.get(JydKeys.memberId.value())+"";//会员id
//		if (!MatcherUtil.checkNumber(memberId)) {
//			checkBaseResult.setResultMsg("会员id不合法！");
//			return;
//		}
//		
//		MemberUser memberUser = commonDao.getMemberUser(Long.valueOf(memberId));
//		if (null==memberUser) {
//			checkBaseResult.setResultMsg("当前会员不存在！");
//			return;
//		}
		MemberUser memberUser = new MemberUser();
		memberUser.setId(memberId);
		checkBaseResult.setResultFlag(1);
		checkBaseResult.setMemberUser(memberUser);
	}
	
	private void zoneCode(Map<String, Object> postData,
			CheckBaseResult checkBaseResult) {
		
		
		String zoneCode = postData.get(JydKeys.zoneCode.value())+"";//区域编码
//		if (!MatcherUtil.checkNumber(zoneCode)) {
//			checkBaseResult.setResultMsg("区域编码不合法！");
//			return;
//		}
		
		checkBaseResult.setResultFlag(1);
		checkBaseResult.setZoneCode(zoneCode);
	}
	
	private void page(Map<String, Object> postData,
			CheckBaseResult checkBaseResult) {
		
		//重置结果标识
		checkBaseResult.setResultFlag(0);
		
		String page = postData.get("page")+"";//页码
		String pagesize = postData.get("pagesize")+"";//页显示最大记录数
		
		if (!MatcherUtil.checkNumber(page)) {
			checkBaseResult.setResultMsg("页码格式不合法！");
			return;
		}
		
		if (!MatcherUtil.checkNumber(pagesize)) {
			checkBaseResult.setResultMsg("页显示最大记录数不合法！");
			return;
		}
		
		checkBaseResult.setResultFlag(1);
		checkBaseResult.setPage(Integer.parseInt(page));
		checkBaseResult.setPagesize(Integer.parseInt(pagesize));
	}

	public void check(Map<String, Object> postData,CheckBaseResult checkBaseResult,
			CheckModule... checkModule) {
		
		for (CheckModule checkModule2 : checkModule) {
			
			if (checkModule2.value == CheckModule.memberUser.value) {//会员验证
				
				memberUser(postData, checkBaseResult);
			}else if (checkModule2.value == CheckModule.page.value) {//页码验证
				
				page(postData, checkBaseResult);
			}else if (checkModule2.value == CheckModule.zoneCode.value) {//区域验证
				
				zoneCode(postData, checkBaseResult);
			}
			
			if (checkBaseResult.getResultFlag()!=1) {
				return ;
			}
		}
	}


}