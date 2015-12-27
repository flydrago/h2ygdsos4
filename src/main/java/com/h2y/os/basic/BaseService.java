package com.h2y.os.basic;

import java.math.BigDecimal;
import java.util.Random;

public class BaseService {
	
	//获取六位随机数 
	public  String getRandomCode (){
		Random random = new Random();
    	String randomCode = "";
    	for ( int i = 0; i < 6; i++ ){
    		randomCode += Integer.toString(random.nextInt(9));
    	}
    	return randomCode;
	}
	
	
	//简单加法
	public Double add(Object obj1,Object obj2){
		BigDecimal bigDecimal1  =new BigDecimal(obj1.toString());
		BigDecimal bigDecimal2 = new BigDecimal(obj2.toString());
		return bigDecimal1.add(bigDecimal2).doubleValue();
	}
	
	
	//简单减法
	public Double sub(Object obj1,Object obj2){
		BigDecimal bigDecimal1  =new BigDecimal(obj1.toString());
		BigDecimal bigDecimal2 = new BigDecimal(obj2.toString());
		return bigDecimal1.subtract(bigDecimal2).doubleValue();
	}
	
	//简单乘法
	public Double mul(Object obj1,Object obj2){
		BigDecimal bigDecimal1  =new BigDecimal(obj1.toString());
		BigDecimal bigDecimal2 = new BigDecimal(obj2.toString());
		return bigDecimal1.multiply(bigDecimal2).doubleValue();
	}
	
	//简单除法
	public Double div(Object obj1,Object obj2){
		BigDecimal bigDecimal1  =new BigDecimal(obj1.toString());
		BigDecimal bigDecimal2 = new BigDecimal(obj2.toString());
		return bigDecimal1.divide(bigDecimal2).doubleValue();
	}
}
