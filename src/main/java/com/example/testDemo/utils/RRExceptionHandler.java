package com.example.testDemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <b>类   名：</b>RRExceptionHandler<br/>
 * <b>类描述：</b>异常处理类<br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/6/3 9:22<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/6/3 9:22<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
@RestControllerAdvice
public class RRExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @ExceptionHandler(RRException.class)
    public Result handleRRException(RRException e){
        Result r = new Result();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());
        return r;
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        logger.error(e.getMessage(), e);
        return Result.error();
    }


}
