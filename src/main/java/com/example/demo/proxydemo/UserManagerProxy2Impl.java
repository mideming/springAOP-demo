package com.example.demo.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-22 15:02
 **/
public class UserManagerProxy2Impl implements InvocationHandler {
    private Object realObject;

    public UserManagerProxy2Impl(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o;
        System.out.println("invoke前");
        o = method.invoke(realObject, args);
        System.out.println("invoke后");
        return o;
    }
}
