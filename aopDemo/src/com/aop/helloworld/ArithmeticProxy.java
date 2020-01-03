package com.aop.helloworld;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * aspect： ArithmeticProxy
 * advice： invoke中的打印日志行为（具体做的功能，抽象成具体的方法就是一个方法一个advice）
 * target:  service
 * proxy:   getLogging 方法返回的对象就是代理，代替业务实际对象的对象
 * joinPoint:
 *          1.方法表示的程序执行点，eg: ArithmeticServiceImpl#add()
 *          2.相对点的方位，eg: 方法执行前/后
 * pointCut：
 *          AOP通过切点定位到特定的连接点，类比： 连接点是数据库的记录，切点相当于查询条件（可一个切点对应多个连接点）
 * @author JiangBaoyong
 * @date 2020/01/02
 **/
public class ArithmeticProxy {

    // 代理对象
    private ArithmeticService service;

    public void setService(ArithmeticService service) {
        this.service = service;
    }

    public ArithmeticProxy(ArithmeticService service) {
        this.service = service;
    }

    public ArithmeticService getLogging() {
        ArithmeticService proxy = null;
        // 代理对象由哪一个类加载器加载
        ClassLoader classLoader = service.getClass().getClassLoader();
        // 代理对象的类型， 即其中有哪些方法
        Class[] inerfaces = new Class[]{ArithmeticService.class};
        // 当调用代理对象方法时，该执行的方法
        InvocationHandler h = new InvocationHandler() {
            /**
             * invoke方法自定义
             * @param o
             * @param method 正在被调用的方法
             * @param objects 方法的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //注意：此处第一个参数一般不使用，因为该参数就是proxy，它调用方法又会回到这个invoke中，从而形成一个死循环
                //运行前日志
                System.out.println("method: " + method.getName() + " begins with objects:" + Arrays.asList(objects));
                //运行方法
                Object result = method.invoke(service, objects);
                //运行后日志
                System.out.println("method: " + method.getName() + " ends with result:" + result);
                return result;
            }
        };
        proxy = (ArithmeticService) Proxy.newProxyInstance(classLoader, inerfaces, h);
        return proxy;
    }
}
