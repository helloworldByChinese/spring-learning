package com.helloworld.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 简单创建带有spring核心的项目，并读取到第一个简单Bean
 * 需要引用spring-beans && spring-context && spring-core && spring-expression 四个核心jar包
 * 以上四个包最好使用同一版本的，以防出现版本问题
 * 四个包中有调用到commons-logging 故需要另外引入该包
 * @author JiangBaoyong
 * @date 2019/12/31
 **/
public class MainApp {
    public static void main(String[] args) {
        // spring 四大重点
        //  1.IOC/DI
        //  2.AOP切面
        //  3.事务
        //  4.bean的XML配置（目前主流为注解配置，不过XML注解也可以了解一下，原理相通的）

        // spring 容器分为：
        //  1.BeanFactory
        //      IOC容器的基本实现，spring框架的基础，spring框架开发者使用的
        //  2.ApplicationContext
        //      BeanFactory的子接口，对于spring框架使用者来说日常基本所有场合都使用这个

        //ApplicationContext 容器接口类，
        //  存在子接口类ConfigurableApplicationContext，
        //  该子类增加了refresh, close 方法，故其子类具有启动，刷新和关闭上下文的能力
        //      其主要的两个主要实现类：
        //          ClassPathXmlApplicationContext 从类路径下加载配置文件（相对于根路径的路径文件）
        //          FileSystemXmlApplicationContext 从文件系统中加载配置文件（例如本地路径下的配置文件）
        //      WEB开发则有专用的WebApplicationContext，不在此处的spring讨论范围
        ApplicationContext context = new ClassPathXmlApplicationContext("com/helloworld/helloworld/app.xml");
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        System.out.println(helloWorld);

    }
}
