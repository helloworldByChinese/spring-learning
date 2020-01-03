package com.aop.xml;

import com.aop.xml.within.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 需要注意切面表达式要换成对应目录的，不要选其他目录的
 * @author JiangBaoyong
 * @date 2020/01/03
 **/
public class Main {

    public static void main(String[] args) {
        //1. 创建IOC 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("com/aop/xml/applicationContext.xml");
        //2. 从IOC容器中获取实例
        ArithmeticService service = context.getBean(ArithmeticService.class);

        System.out.println(service.add(1, 23));
        System.out.println(service.sub(1, 23));
        //异常的情况
//        System.out.println(service.div(1, 0));
    }
}
