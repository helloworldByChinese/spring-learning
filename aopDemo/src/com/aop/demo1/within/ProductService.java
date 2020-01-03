package com.aop.demo1.within;

import org.springframework.stereotype.Service;

/**
 * 用于作区分的service，为了简易就不写接口类了
 * @author JiangBaoyong
 * @date 2020/01/03
 **/
@Service
public class ProductService {

    public String add(String name) {
        return "add product "  + name;
    }

    public String del(String name) {
        return "delete product " + name;
    }
}
