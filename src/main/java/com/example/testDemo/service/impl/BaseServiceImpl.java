package com.example.testDemo.service.impl;

import com.example.testDemo.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * <b>类   名：</b>BaseServiceImpl<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/5/13 13:29<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/5/13 13:29<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
@Service("baseServiceImpl")
public class BaseServiceImpl implements BaseService {

    @Override
    public String doSomething() {
        String a = "Helle";
        return a.toLowerCase();
    }

    @Override
    public int eat() {
        return 3;
    }
}