package com.aop.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.UUID;

/**
 * 事务管理
 * @author JiangBaoyong
 * @date 2020/01/04
 **/
public class TransactionMain {
    //1. 分为编程式事务管理 和 声明式事务管理（如注解）
    // 主要了解的是声明式事务注解
    // 声明式事务管理是管理AOP切面范围内的service
    // 故方法A调用方法B的时候：
    //  必要条件：（就是基本要求，单不是必然就有新事务）
    //      方法B必须是AOP切面包含的范围内且不再同一个类内

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/aop/tx/app.xml");
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());

        BigTransactionServiceImpl service = context.getBean(BigTransactionServiceImpl.class);
        //事务传播方式测试demo
//        service.checkNonTransactional();

//        service.checkExistTransactional();
        service.checkWithTryCatch();
    }

//    以下是jdbcTemplate调用的测试
//        BookShopDao bookShopDao = context.getBean(BookShopDao.class);
//
//        Book book = new Book();
//        String isbn = UUID.randomUUID().toString();
//        book.setIsbn(isbn);
//        int number = (int) (Math.random() * 100);
//        book.setName("hello world" + number);
//        book.setNumber(number);
//        bookShopDao.insertBook(book);
//
//        System.out.println(bookShopDao.getBookNumberByIsbn(isbn));

//        bookShopDao.updateBookNum(isbn, 103);
}
