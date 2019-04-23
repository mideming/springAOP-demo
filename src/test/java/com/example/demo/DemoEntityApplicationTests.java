package com.example.demo;

import com.example.demo.entity.DemoEntity;
import com.example.demo.entity.HamburgerUserEntity;
import com.example.demo.logprintdemo.NeedLogService;
import com.example.demo.logprintdemo.NormalService;
import com.example.demo.methodexpireddemo.NeedExpiredService;
import com.example.demo.proxydemo.UserManager;
import com.example.demo.proxydemo.UserManagerImpl;
import com.example.demo.proxydemo.UserManagerProxy2Impl;
import com.example.demo.proxydemo.UserManagerProxyImpl;
import com.example.demo.proxydemo2.UserManager1;
import com.example.demo.proxydemo2.UserManager1Impl;
import com.example.demo.proxydemo2.UserManager1Proxy2Impl;
import com.example.demo.proxydemo2.UserManager1ProxyImpl;
import com.example.demo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.lang.reflect.Proxy;
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
	public void testProxy () {
		UserManager1ProxyImpl userManager1Proxy = new UserManager1ProxyImpl(new UserManager1Impl());
		userManager1Proxy.addUser("111");
	}
	@Test
	public void testProxy2 () {
		UserManager1Proxy2Impl userManager1Proxy2 = new UserManager1Proxy2Impl(new UserManager1Impl());
		UserManager1 userManager1 = (UserManager1)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{UserManager1.class}, userManager1Proxy2);
		userManager1.addUser("111");
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
	public void testClassloader() {
		DemoEntityApplicationTests tests = new DemoEntityApplicationTests();
		Class<? extends DemoEntityApplicationTests> aClass = tests.getClass();
		ClassLoader classLoader = aClass.getClassLoader();
		ClassLoader parent = classLoader.getParent();
		ClassLoader parent1 = parent.getParent();
		ClassLoader parent2 = parent1.getParent();
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

	@Test
	public void testProxyManager() {
		UserManager userManagerProxy = new UserManagerProxyImpl(new UserManagerImpl());
		userManagerProxy.addUser(111L,"mideming");
	}
	@Test
	public void testProxyManager2() {
		UserManager userManager1 = (UserManager)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{UserManager.class}, new UserManagerProxy2Impl(new UserManagerImpl()));
		userManager1.addUser(111L,"mideming");
	}
}
