/**
 * <b>包   名：</b>com.example.testDemo.service.impl<br/>
 * <b>文件名：</b>RunnAbleImpl.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月29日-下午1:43:45<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 */
package com.example.testDemo.service.impl;

import com.example.testDemo.service.AsyncService;
import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <b>类   名：</b>RunnAbleImpl<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月29日 下午1:43:45<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月29日 下午1:43:45<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br       />
 */
public class RunnAbleImpl implements Runnable {
    private List<String> list = new ArrayList<>();

    private AsyncService asyncService;

    public RunnAbleImpl(AsyncService asyncService, CountDownLatch latch) {
        this.asyncService = asyncService;
        this.latch = latch;
    }

    private CountDownLatch latch;

    private RateLimiter limiter = RateLimiter.create(10.0);

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            latch.countDown();
            latch.await();
//			limiter.acquire();
            String buy = asyncService.buy();
            list.add(buy);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<String> getList() {
        return this.list;
    }
}
