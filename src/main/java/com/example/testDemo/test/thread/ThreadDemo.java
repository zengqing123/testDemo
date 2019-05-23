/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.test.thread<br/>
 * <b>文件名：</b>ThreadDemo.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月1日-下午5:00:25<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * <b>类   名：</b>ThreadDemo<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月1日 下午5:00:25<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月1日 下午5:00:25<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public class ThreadDemo implements Runnable{
	private Lock lock = new ReentrantLock();

	private Integer a;
	public ThreadDemo(Integer b) {
		this.a=b;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (a>0) {
			try {
				lock.lock();
				if (a>0) {
					System.out.println(Thread.currentThread().getName()+":"+(a--));
				}
			} catch (Exception e) {
			}finally{
				lock.unlock();
			}
		}
	}
}
