package com.example.testDemo.utils;

import java.text.SimpleDateFormat;

/**
 * <b>类   名：</b>DateFormat<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月21日 下午2:22:17<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月21日 下午2:22:17<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public class DateFormat {
	
	private static volatile SimpleDateFormat format;
	
	public DateFormat(){}
	
	public static SimpleDateFormat getNewDateFormat(){
				if (format == null) {
                    synchronized(DateFormat.class){
                        if (format == null){
                            format = new SimpleDateFormat("yyyy-MM-dd");
                        }
                    }
				}
		return format;
	}
	

}
