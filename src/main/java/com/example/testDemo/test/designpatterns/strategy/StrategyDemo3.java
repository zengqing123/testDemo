/**
 * <b>包   名：</b>com.example.testDemo.test.designpatterns.strategy<br/>
 * <b>文件名：</b>StrategyDemo3.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月11日-上午11:09:22<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.test.designpatterns.strategy;

/**
 * <b>类   名：</b>StrategyDemo3<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月11日 上午11:09:22<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月11日 上午11:09:22<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public class StrategyDemo3 implements Strategy{

	/* (non-Javadoc)
	 * @see com.example.testDemo.test.designpatterns.strategy.Strategy#say()
	 */
	@Override
	public void say(Say s) {
			System.out.println("demo3");
	}

}
