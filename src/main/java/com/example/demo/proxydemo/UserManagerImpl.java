package com.example.demo.proxydemo;

/**
 * @description: 委托类
 * @author: mideming
 * @create: 2019-04-22 14:13
 **/
public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(Long userId, String userName) {
        System.out.println("UserManagerImpl.addUser");
    }
}
