package com.aop.aopXml;

/**
 * @author JiangBaoyong
 * @date 2020/01/02
 **/
public class ArithmeticServiceImpl implements ArithmeticService {
    @Override
    public int add(int i, int j) {
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
