package com.example.demo.mapper;

import com.example.demo.entity.HamburgerUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-17 10:35
 **/
@Mapper
public interface HamburgerUserMapper {

    Integer insert(HamburgerUserEntity hamburgerUserEntity);
}
