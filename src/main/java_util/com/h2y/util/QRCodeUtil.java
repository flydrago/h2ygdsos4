package com.h2y.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * 二维码工具类

 * 作者：侯飞龙

 * 时间：2014-3-27 下午03:45:44

 * 电子邮件：1162040314@qq.com

 * QQ：1162040314

 * Gmail :
 */
public class QRCodeUtil {
	
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	
	private QRCodeUtil() {
		
	}
	
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}
	
	
	public static void writeToFile(BitMatrix matrix, String format, File file)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format " + format + " to " + file);
		}
	}
	
	public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}
	
	/**
	 * 生成二维码图片
	 * @param url 二维码代表的url
	 * @param width 二维码宽度
	 * @param height 二维码高度
	 * @param picPath 二维码图片存储路径
	 */
	public static void createQrCode(String url,int width,int height,String picPath){
		
		BitMatrix bitMatrix = null;
		
		Map<EncodeHintType,String> hints = new HashMap<EncodeHintType,String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		
		try {
			bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		File outputFile = new File(picPath);
		try {
			QRCodeUtil.writeToFile(bitMatrix, picPath.substring(picPath.lastIndexOf(".")+1, picPath.length()), outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 生成二维码图片
	 * @param url 二维码代表的url
	 * @param width 二维码宽度
	 * @param height 二维码高度
	 * @param response 响应
	 */
	public static void createQrCode(String url,int width,int height,HttpServletResponse response){
		
		BitMatrix bitMatrix = null;
		
		Map<EncodeHintType,String> hints = new HashMap<EncodeHintType,String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		
		try {
			bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		
		try {
			
			writeToStream(bitMatrix, "png", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		
//		for (int i = 0; i < 200; i++) {
//			
//			long time1 = DateUtil.getSystemTime().getTime();
//
//			String text = "http://192.168.8.111:8080/site/sign/init.do?signCode=sign100001&accountId=PWdoX2Y2MGY2YTI2NDI1ZjRmMzFjZjZl!2&openId=b1ZtbWZ1SHBuZ3lHc0NIVWlqTzgyamxpaVhnczRmMzFjZjZl!0";
//			int width = 300;
//			int height = 300;
////			String picPath = "D:/TEST/tes.png";
//			
//			QRCodeUtil.createQrCode(text, width, height, "D:/tes.png");
//			long time2 = DateUtil.getSystemTime().getTime();
//			
//			
//			System.out.println(time2-time1);
//		}
		
		
		
		
		for (int i = 0; i < 200; i++) {
			
			long time1 = DateUtil.getSystemTime().getTime();

//			String picPath = "D:/TEST/tes.png";
			
			try {
				FileUtils.copyFile(new File("D:/tes.png"), new File("D:/temp/"+DateUtil.getSystemTime().getTime()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			long time2 = DateUtil.getSystemTime().getTime();
			System.out.println(time2-time1);
		}
		
//		BitMatrix bitMatrix = null;
//		
//		Map<EncodeHintType,String> hints = new HashMap<EncodeHintType,String>();
//		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//		
//		try {
//			bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
//		} catch (WriterException e) {
//			e.printStackTrace();
//		}
//		
//		File outputFile = new File("d:"+File.separator+"new.gif");
//		try {
//			QRCodeUtil.writeToFile(bitMatrix, "gif", outputFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

}
