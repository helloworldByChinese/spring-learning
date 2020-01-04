package com.aop.demo1;

import org.springframework.stereotype.Service;

/**
 * @author JiangBaoyong
 * @date 2020/01/02
 **/
@Service
public class ArithmeticServiceImpl implements ArithmeticService {
    @Override
    public int add(int i, int j) {
        //测试同一service内部方法调用是否通过切面
        System.out.println("内部调用： " + sub(1,2));
        return i+j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
