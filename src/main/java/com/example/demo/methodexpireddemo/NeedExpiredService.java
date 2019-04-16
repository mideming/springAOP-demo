package com.example.demo.methodexpireddemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-16 17:23
 **/
@Service
public class NeedExpiredService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Random random = new Random(System.currentTimeMillis());
    public void doSomeTime () {
        logger.info("---SomeService: someMethod invoked---");
        try {
            // 模拟耗时任务
            Thread.sleep(random.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
