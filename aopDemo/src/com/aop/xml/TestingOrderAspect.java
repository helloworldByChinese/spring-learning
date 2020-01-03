package com.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author JiangBaoyong
 * @date 2020/01/04
 **/
public class TestingOrderAspect {

    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("before 生效！！！+++++++order2++++++++method:" + methodName + "   args:" + args);
    }
}
