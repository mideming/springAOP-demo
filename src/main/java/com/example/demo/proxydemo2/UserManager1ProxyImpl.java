package com.example.demo.proxydemo2;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-22 16:29
 **/
public class UserManager1ProxyImpl implements UserManager1 {
    private UserManager1 userManager1;

    public UserManager1ProxyImpl(UserManager1 userManager1) {
        this.userManager1 = userManager1;
    }

    @Override
    public void addUser(String id) {
        System.out.println("start");
        userManager1.addUser("111");
        System.out.println("end");
    }
}
