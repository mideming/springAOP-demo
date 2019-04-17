package com.example.demo;

import com.example.demo.entity.DemoEntity;
import com.example.demo.entity.HamburgerUserEntity;
import com.example.demo.logprintdemo.NeedLogService;
import com.example.demo.logprintdemo.NormalService;
import com.example.demo.methodexpireddemo.NeedExpiredService;
import com.example.demo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoEntityApplicationTests {

	@Autowired
	private DemoService demoService;

	@Autowired
	private NeedLogService needLogService;

	@Autowired
	private NormalService normalService;
	@Autowired
	private NeedExpiredService needExpiredService;

	@Test
	public void contextLoads() {
		String test = demoService.test();
		System.out.println(test);
	}

	@Test
	public void testLogPrint() {
		needLogService.logMethod("xys");
		try {
			needLogService.exceptionMethod();
		} catch (Exception e) {
			// Ignore
		}
		normalService.someMethod();
	}

	@Test
	public void testExpired() {
		needExpiredService.doSomeTime();
	}

	@Test
	public void testTransactional() {
		DemoEntity demoEntity = new DemoEntity();
		demoEntity.setName("哈哈哈");
		HamburgerUserEntity hamburgerUserEntity = new HamburgerUserEntity();
		hamburgerUserEntity.setUserName("哈哈哈");
		hamburgerUserEntity.setUserPassword("22222");
		hamburgerUserEntity.setUserMobile("14000000000");
		hamburgerUserEntity.setUserDescription("2楼是傻逼");
		hamburgerUserEntity.setUserLogo("www.baidu.com");
		hamburgerUserEntity.setCreateTime(new Date());
		Integer integer = demoService.testTransactional(demoEntity, hamburgerUserEntity);
	}

}
