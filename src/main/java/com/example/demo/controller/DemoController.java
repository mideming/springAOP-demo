package com.example.demo.controller;

import com.example.demo.entity.DemoEntity;
import com.example.demo.httpfilterdemo.AuthChecker;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(path = "/demoController")
    public Integer insertDemo (@RequestParam String name) {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName(name);
        return demoService.insertDemo(demoEntity);
    }


    @RequestMapping("/aop/http/alive")
    public String alive() {
        return "服务一切正常";
    }

    @AuthChecker
    @RequestMapping("/aop/http/user_info")
    public String callSomeInterface() {
        return "调用了 user_info 接口.";
    }
}
