package com.example.demo.service.impl;

import com.example.demo.entity.DemoEntity;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.service.DemoService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;
    @Override
    public String test() {
        return "service返回的";
    }

    @Override
    public Integer insertDemo(DemoEntity demoEntity) {
        return demoMapper.insertDemo(demoEntity);
    }
}
