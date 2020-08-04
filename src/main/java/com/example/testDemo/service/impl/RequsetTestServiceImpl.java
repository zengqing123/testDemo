package com.example.testDemo.service.impl;

import com.example.testDemo.dao.BizCaseCheckMapper;
import com.example.testDemo.entity.BizCaseCheck;
import com.example.testDemo.service.RequsetTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Service
public class RequsetTestServiceImpl implements RequsetTestService {

    class Requset {
        String caseId;
        CompletableFuture<BizCaseCheck> future;
    }

    private LinkedBlockingQueue<Requset> queue = new LinkedBlockingQueue<>(10);

    @Autowired
    private BizCaseCheckMapper mapper;

    @Override
    public BizCaseCheck getEntity(String caseId) throws ExecutionException, InterruptedException {
//        System.out.println(Thread.currentThread()+"拿到的数据:"+caseId);
        Requset requset = new Requset();
        requset.caseId = caseId;
        CompletableFuture<BizCaseCheck> future = new CompletableFuture<>();
        requset.future = future;
        queue.add(requset);
        return future.get();
    }


    @PostConstruct
    public void init(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                int size = queue.size();
                if (size == 0){
                    return;
                }
//                System.out.println("批量处理了："+size);
                List<String> caseIdList = new ArrayList<>();
                List<Requset> requsetList = new ArrayList<>();
                for (int i = 0;i < size;i++){
                    Requset requset = queue.poll();
                    requsetList.add(requset);
//                    System.out.println("第"+i+"次队列取出的数据"+requset.caseId);
                    caseIdList.add(requset.caseId);
                }
                Map<String,Object> map = new HashMap<>();
                map.put("caseIdList",caseIdList);
                List<BizCaseCheck> list = mapper.getList(map);
                for (Requset i:requsetList) {
                    for (BizCaseCheck o:list) {
//                        System.out.println("查询结果"+o.getCaseNo());
                        if (o.getCaseNo().equals(i.caseId)){
                            i.future.complete(o);
                            break;
                        }
                    }
                }
            }
        },0,10,TimeUnit.MICROSECONDS);
    }

}
