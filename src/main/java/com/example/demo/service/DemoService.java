package com.example.demo.service;


import com.example.demo.entity.DemoEntity;
import com.example.demo.entity.HamburgerUserEntity;

public interface DemoService {
    public String test();

    public Integer insertDemo(DemoEntity demoEntity);

    public Integer testTransactional(DemoEntity demoEntity, HamburgerUserEntity hamburgerUserEntity);
}
