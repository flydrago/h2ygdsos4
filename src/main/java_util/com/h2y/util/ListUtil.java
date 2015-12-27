package com.h2y.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListUtil {

	
	/**
	 * 均匀合并集合元素
	 * @param list1 主集合顺序不变
	 * @param list2
	 * @return
	 */
	public static List<Map<String,Object>> mergeList(List<Map<String,Object>> list1,List<Map<String,Object>> list2){
		

		if (list1==null || list1.isEmpty()) {
			return list2;
		}
		
		if (list2==null || list2.isEmpty()) {
			return list1;
		}
		
		List<Map<String,Object>> wheelList = new ArrayList<Map<String,Object>>();
		wheelList.addAll(list1);
		
		int count1 = list1.size();
		int count2 = list2.size();
		
		if (count1>count2) {
			
			for (int i = 0; i < count2; i++) {
				
				wheelList.add(i*(count1/count2)+i,list2.get(i));
			}
		}else {
			
			int round = count2/count1+1;
			count2--;
			for (int j = 0; j <= round; j++) {
				
				for (int i = 0; i < count1; i++) {
					
					if (count2<0) {
						return wheelList;
					}
					wheelList.add(j+i*(j+2), list2.get(count2));
					count2--;
				}
			}
		}
		
		//合并集合
		return wheelList;
	}
}
