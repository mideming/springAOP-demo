package com.example.demo.methodexpireddemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-16 17:22
 **/
@Component
@Aspect
public class MethodExpiredAdviseDefine {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("within(NeedExpiredService)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object methodInvokeExpiredTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = proceedingJoinPoint.proceed();
        stopWatch.stop();
        reportToMonitorSystem(proceedingJoinPoint.getSignature().toShortString(), stopWatch.getTotalTimeMillis());
        return proceed;
    }

    public void reportToMonitorSystem(String methodName, long expiredTime) {
        logger.info("---method {} invoked, expired time: {} ms---", methodName, expiredTime);
    }
}
