package com.example.demo.proxydemo2;

/**
 * @description: 委托类
 * @author: mideming
 * @create: 2019-04-22 16:28
 **/
public class UserManager1Impl implements UserManager1 {
    @Override
    public void addUser(String id) {
        System.out.println("UserManager1Impl.addUser");
    }
}
