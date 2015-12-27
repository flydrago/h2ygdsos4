package com.h2y.os.services;

import java.util.Map;

public interface ICommonSpikeService {


	/**
	 * 获取秒杀活动列表
	 * @param reqMap
	 *  zoneCode 区域编码
	 *  spikeEvent 秒杀场次: 0本场秒杀 1下场预告
	 *  page pagesize 分页
	 * @return
	 */
	public Map<String, Object> getCommonSpikeGoodsList(Map<String,Object> reqMap);

}
