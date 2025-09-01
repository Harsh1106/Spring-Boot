package com.harsh.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

//    @Around("execution(* com.harsh.springbootrest.service..getJob(..))")
    @Around("execution(* com.harsh.springbootrest.service..*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object obj = jp.proceed();

        long endTime = System.currentTimeMillis();

//        LOGGER.info("Time taken: " + (endTime - startTime) + "ms");
        LOGGER.info("Time taken by: " + jp.getSignature().getName() + " : " + (endTime - startTime) + "ms");
        return obj;
    }
}
