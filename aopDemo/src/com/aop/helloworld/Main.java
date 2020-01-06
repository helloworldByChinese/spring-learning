package com.aop.helloworld;

/**
 * @author JiangBaoyong
 * @date 2020/01/02
 **/
public class Main {
    /**
     * 需求 ：每个运算前后都打印出对应的日志
     * 直接写在代码中会
     *      代码混乱（运算 + 日志 混在一起）
     *      代码分散（日志代码就一个统一的需求，之后的修改会异常复杂）
     * 本次demo使用动态代理简单实现
     * @param args
     */
    public static void main(String[] args) {
        ArithmeticService service = new ArithmeticServiceImpl();
//        int result = service.add(1, 2);
//        result = service.sub(3, 1);
        //创建动态代理
        ArithmeticService proxy = new ArithmeticProxy(service).getProxyService();


        int result = proxy.add(1,2);

        System.out.println("result: " + result);

        result = proxy.sub(3, 1);

        System.out.println("result: " + result);
    }
}
