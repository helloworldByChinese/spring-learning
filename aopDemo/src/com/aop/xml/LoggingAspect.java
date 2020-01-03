package com.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 配置的切面类
 * Order注解可以指定切面的执行顺序,值越小优先级越高,
 * 经测试，同一类内的方法设置Order注解无作用
 * @author JiangBaoyong
 * @date 2020/01/03
 **/
public class LoggingAspect {

    //前置通知：执行方法前的操作
    public void check(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("before 生效！！！method:" + methodName + "   args:" + args);
    }

    //后置通知：方法执行后（无论是否异常），执行的操作
    //在后置通知中还不能方法目标方法返回的结果
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("after 生效！！！method:" + methodName);
    }

    //返回通知：方法正常执行返回后的通知，可以访问到返回结果（异常不会执行）
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("afterReturning 生效！！！method:" + methodName + "  result:" + result);
    }

    //异常通知：方法执行异常时会执行的通知
    //可以访问到异常对象，且可以指定出现特定异常时执行通知代码（就算出现异常，也要符合异常的种类才会进入）
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("afterThrowing 生效！！！method:" + methodName + "  ex:" + ex);
    }

    /**
     * 环绕通知需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     * @param pjp
     */
    public Object around(ProceedingJoinPoint pjp) {
        String methodName = pjp.getSignature().getName();
        System.out.println("Around 生效！！！method:" + methodName + " begin with:" + Arrays.asList(pjp.getArgs()));

        //执行目标方法
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        }
        System.out.println("Around ends with:" + result);
        return result;
    }
}
