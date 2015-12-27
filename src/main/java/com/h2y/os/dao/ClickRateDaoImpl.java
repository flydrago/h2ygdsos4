package com.h2y.os.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2y.os.dao.write.IClickRateDaoW;
import com.h2y.os.entity.ClickRate;

@Service("clickRateDao")
public class ClickRateDaoImpl implements IClickRateDao{
	
	@Autowired
	protected IClickRateDaoW clickRateDaoW;
	
	public void add(ClickRate clickRate) {
		clickRateDaoW.add(clickRate);
	}

}
