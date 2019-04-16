package com.example.demo.mapper;

import com.example.demo.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {
    Integer insertDemo(DemoEntity demoEntity);
}
