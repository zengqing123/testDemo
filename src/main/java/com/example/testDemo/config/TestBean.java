package com.example.testDemo.config;

import com.example.testDemo.service.BaseService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <b>类   名：</b>TestBean<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/5/13 10:39<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/5/13 10:39<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
@Component
public class TestBean implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = bean.getClass();
        if (bean instanceof BaseService){
            Object proxy = Proxy.newProxyInstance(beanClass.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getReturnType() == String.class){
                        String result = (String)method.invoke(bean,args);
                        if (method.getName().equals("doSomething")){
                            return result.toUpperCase();
                        }
                        return result;
                    }
                    return method.invoke(bean,args);
                }
            });
            return proxy;
        }
        return bean;
    }
}
