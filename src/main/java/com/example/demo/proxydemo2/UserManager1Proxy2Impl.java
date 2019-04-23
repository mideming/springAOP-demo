package com.example.demo.proxydemo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-22 16:36
 **/
public class UserManager1Proxy2Impl implements InvocationHandler {
    private Object userManager1;

    public UserManager1Proxy2Impl(Object userManager1) {
        this.userManager1 = userManager1;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始");
        Object invoke = method.invoke(userManager1, args);
        System.out.println("结束");
        return invoke;
    }
}
