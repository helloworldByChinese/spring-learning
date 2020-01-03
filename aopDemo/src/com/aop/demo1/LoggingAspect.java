package com.aop.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 配置的切面类
 * @author JiangBaoyong
 * @date 2020/01/03
 **/
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.aop.demo1.*Impl.*(..)) && !within(com.aop.demo1.within.*Impl)")
    public void createLogging() {

    }

    @Before("createLogging()")
    public void check(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("before 生效！！！method:" + methodName + "   args:" + args);
    }
}
