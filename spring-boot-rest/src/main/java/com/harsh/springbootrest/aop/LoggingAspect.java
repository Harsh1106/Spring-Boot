package com.harsh.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("execution(* com.harsh.springbootrest.service..*(..))") //return-type, class-name..method-name(args) and * means all
    @Before("execution(* com.harsh.springbootrest.service..getJob(..))") //return-type, class-name..method-name(args) and * means all
    //we can write multiple statement using ||
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called "+jp.getSignature().getName());
    }

    @After("execution(* com.harsh.springbootrest.service..getJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.harsh.springbootrest.service..getJob(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method has some issues "+jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.harsh.springbootrest.service..getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
    }



}
