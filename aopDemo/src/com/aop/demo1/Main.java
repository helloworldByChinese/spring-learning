package com.aop.demo1;

import com.aop.demo1.within.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author JiangBaoyong
 * @date 2020/01/03
 **/
public class Main {

    public static void main(String[] args) {
        //1. 创建IOC 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("com/aop/demo1/applicationContext.xml");
        //2. 从IOC容器中获取实例
        ArithmeticService service = context.getBean(ArithmeticService.class);

        System.out.println(service.add(1, 23));
        System.out.println(service.sub(1, 23));
        System.out.println(service.div(1, 23));

        ProductService productService = context.getBean(ProductService.class);
        System.out.println(productService.add("Food"));
    }
}
