package com.aop.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author JiangBaoyong
 * @date 2020/01/04
 **/
@Order(11)
@Aspect
@Component
public class TestingOrderAspect {

    @Before("com.aop.demo1.LoggingAspect.createLogging()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("before 生效！！！+++++++order2++++++++method:" + methodName + "   args:" + args);
    }
}
