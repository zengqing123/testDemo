/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.test<br/>
 * <b>文件名：</b>Demo.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月1日-下午4:59:59<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.test;

import com.example.testDemo.test.thread.ThreadDemo;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <b>类   名：</b>Demo<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月1日 下午4:59:59<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月1日 下午4:59:59<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public class Demo {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * 
	 * @param args 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 0, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
		Thread thread = null;
		ThreadDemo demo = new ThreadDemo(100);
		for (int i = 0; i < 10; i++) {
			thread = new Thread(demo);
			executor.execute(thread);
		}
		System.out.println("个数"+executor.getPoolSize()+"等待数："+executor.getQueue().size()+"执行完的："+executor.getCompletedTaskCount());
		executor.shutdown();
	}

}
