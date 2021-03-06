package com.aop.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单使用spring自带的jdbcTemplate（实际工作一般使用mybatis等成熟的JDBC框架，这个不算框架，只是工具）
 * @author JiangBaoyong
 * @date 2020/01/04
 **/
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 简单配置一下@Transactional 注解的几个属性
     * propagation 对应 事务传播机制
     * isolation 对应 隔离级别
     * noRollbackFor 对应的是 不回滚异常
     * readOnly 只读， 据说可以帮助数据库引擎优化事务
     * timeout 超时时间 ，单位是s（秒）
     * @param isbn
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED, noRollbackFor = BookNullException.class,
            readOnly = true, timeout = 10)
    @Override
    public int getBookNumberByIsbn(String isbn) {
        String sql = "select number from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Transactional
    @Override
    public void insertBook(Book book) {
        String sql = "insert into book values(?,?,?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{book.getIsbn(),book.getName(),book.getNumber()});
        int[] result = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(result);
    }

    @Transactional
    @Override
    public void updateBookNum(String isbn, int num) {
        //这个是为了测试事务的原子性而增加的操作，无实际意义
        String sql = "update book set number = number - ? where isbn = ?";
        jdbcTemplate.update(sql, 1, isbn);
        int number = getBookNumberByIsbn(isbn);
        if (number == 0 || number - num < 0) {
            throw new BookNullException("编号为：" + isbn + "的书库存不足");
        }
        jdbcTemplate.update(sql, num, isbn);
    }
}
