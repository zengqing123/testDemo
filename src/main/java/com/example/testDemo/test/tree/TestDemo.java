/**
 * <b>包   名：</b>com.example.testDemo.test.tree<br/>
 * <b>文件名：</b>TestDemo.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月28日-上午10:43:40<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.test.tree;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import com.example.testDemo.test.tree.entity.StuInfo;

/**
 * <b>类   名：</b>TestDemo<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月28日 上午10:43:40<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月28日 上午10:43:40<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public class TestDemo {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * 
	 * @param args 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		TreeSet<StuInfo> stuSet = new TreeSet<StuInfo>(new Comparator<StuInfo>() {

			@Override
			public int compare(StuInfo o1, StuInfo o2) {
				return o1.getAge()-o2.getAge();
			}
		});
		TreeSet<StuInfo> stuSet1 = new TreeSet<StuInfo>(new Comparator<StuInfo>() {
			
			@Override
			public int compare(StuInfo o1, StuInfo o2) {
				return o2.getAge()-o1.getAge();
			}
		});
		StuInfo stuInfo = new StuInfo();
		stuInfo.setAge(1);
		stuInfo.setName("1");
		stuInfo.setSex("1");
		stuSet1.add(stuInfo);
		StuInfo stuInfo2 = new StuInfo();
		stuInfo2.setAge(4);
		stuInfo2.setName("2");
		stuInfo2.setSex("2");
		stuSet1.add(stuInfo2);
		StuInfo stuInfo3 = new StuInfo();
		stuInfo3.setAge(2);
		stuInfo3.setName("3");
		stuInfo3.setSex("3");
		stuSet1.add(stuInfo3);
		Iterator<StuInfo> iterator = stuSet1.iterator();
		while (iterator.hasNext()) {
			StuInfo next = iterator.next();
			System.out.println(next.getName());
		}

	}

}
