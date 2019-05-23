package com.example.testDemo.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <b>类   名：</b>TestScheduled<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/5/7 16:53<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/5/7 16:53<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
@Component
public class TestScheduled {

//    @Scheduled(cron = "*/3 * * * * ?")
    public void execute(){
        System.out.println("运行测试定时任务");

    }
}
