package com.example.demo.test1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {
    @RequestMapping("/helloSpringBoot")
    public String HelloString () {
        return "hello! Spring Boot";
    }
}
