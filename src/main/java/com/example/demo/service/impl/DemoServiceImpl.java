package com.example.demo.service.impl;

import com.example.demo.entity.DemoEntity;
import com.example.demo.entity.HamburgerUserEntity;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.mapper.HamburgerUserMapper;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private HamburgerUserMapper hamburgerUserMapper;
    @Override
    public String test() {
        return "service返回的";
    }

    @Override
    public Integer insertDemo(DemoEntity demoEntity) {
        return demoMapper.insertDemo(demoEntity);
    }

    /**
     * 测试事务
     * @param demoEntity
     * @param hamburgerUserEntity
     * @return
     */
    @Override
    @Transactional
    public Integer testTransactional(DemoEntity demoEntity, HamburgerUserEntity hamburgerUserEntity) {
        demoMapper.insertDemo(demoEntity);
        int i = 1/0;

        return hamburgerUserMapper.insert(hamburgerUserEntity);
    }
}
