package com.example.demo.proxydemo;

/**
 * @description: 代理类
 * @author: mideming
 * @create: 2019-04-22 14:14
 **/
public class UserManagerProxyImpl implements UserManager {
    private UserManager userManager;

    public UserManagerProxyImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addUser(Long userId, String userName) {
        // 添加打印日志
        System.out.println("addUser前");
        userManager.addUser(userId, userName);
        System.out.println("addUser后");
    }
}
