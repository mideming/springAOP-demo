package com.example.demo.service.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @description:
 * @author: mideming
 * @create: 2019-04-16 16:07
 **/
@Component
@Aspect
public class LogAopExceptionAdvise {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("within(DemoServiceImpl)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void logMethodInvokeParam(JoinPoint joinPoint) {
        logger.info("---Before method {} invoke, param: {}---", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "pointcut()", returning = "retVal")
    public void logMethodInvokeResult(JoinPoint joinPoint, Object retVal) {
        logger.info("---After method {} invoke, result: {}---", joinPoint.getSignature().toShortString(), retVal);
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
    public void logMethodInvokeException(JoinPoint joinPoint, Exception exception) {
        logger.info("---method {} invoke exception: {}---", joinPoint.getSignature().toShortString(), exception.getMessage());
    }
}
