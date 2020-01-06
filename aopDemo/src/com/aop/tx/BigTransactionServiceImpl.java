package com.aop.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * 主方法类
 * 用该类来调用其他类的service方法
 *
 * @author JiangBaoyong
 * @date 2020/01/04
 **/
@Service
public class BigTransactionServiceImpl {

    @Autowired
    BookShopDao bookShopDao;

    @Autowired
    TestServiceImpl testService;


    //书本的编码，需要注意的是要找到你的数据库存在的编码
    private static final String ISBN_STATIC = "327f3083-7d25-40f2-9c17-db13d9c3b5a2";

    /**
     * REQUIRED: 被调用方法内部异常和主方法异常，都无法insert数据，表明使用的是同一个事务
     * REQUIRES_NEW: 方法内部
     */
    @Transactional(rollbackFor = Exception.class)
    public void checkExistTransactional() {
        //先做个insert操作
        insertBook();
        //事务：往demo表中insert 一条数据
//        testService.createDemoByRequired();
//        testService.createDemoByRequiresNew();
//        testService.createDemoBySupports();
//        testService.createDemoByNotSupported();
//        testService.createDemoByMandatory();
        testService.createDemoByNever();
//        testService.createDemoByNested();
        //抛出异常, if是为了检测
        throw new RuntimeException("主方法出现异常");
    }

    public void checkNonTransactional() {
        //事务：往demo表中insert 一条数据
//        testService.createDemoByRequired();
        testService.createDemoByRequiresNew();
//        testService.createDemoBySupports();
//        testService.createDemoByNotSupported();
//        testService.createDemoByMandatory();
//        testService.createDemoByNever();
//        testService.createDemoByNested();
    }

    /**
     * 测试Nested事务传播
     */
    @Transactional
    public void checkWithTryCatch() {
        insertBook();
        try {
//            testService.createDemoByRequired();
//            testService.createDemoByRequiresNew();
//            testService.createDemoBySupports();
            testService.createDemoByNotSupported();
//            testService.createDemoByMandatory();
//            testService.createDemoByNested();
        } catch (Exception e) {
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        System.out.println("主方法事务完整跑完");
    }

    private void insertBook() {
        Book book = new Book();
        String isbn = UUID.randomUUID().toString();
        book.setIsbn(isbn);
        int number = (int) (Math.random() * 100);
        book.setName("hello world" + number);
        book.setNumber(number);
        bookShopDao.insertBook(book);
    }
}
