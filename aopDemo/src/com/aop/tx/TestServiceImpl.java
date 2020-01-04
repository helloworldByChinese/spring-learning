package com.aop.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * 创建一个另外的service
 *
 * @author JiangBaoyong
 * @date 2020/01/04
 **/
@Service
public class TestServiceImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 7种事务的传播机制
     * 首先需要明白：
     * 使用何种机制是由被调用的service#method来决定的，主调用方法是无法决定的
     */

    /**
     * 1. Propagation.REQUIRED （默认） ：
     * 支持使用当前事务，若不存在，则创建一个新事务
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void createDemoByRequired() {
        String sql = "insert into demo values(?, ?)";
        String name = UUID.randomUUID().toString();
        int number = 10;
        jdbcTemplate.update(sql, name, number);
        throw new RuntimeException("被调用方法出现异常");
    }

    /**
     * 2. Propagation.REQUIRES_NEW
     * 创建一个新事务，若当前事务存在，则挂起
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createDemoByRequiresNew() {
        String sql = "insert into demo values(?, ?)";
        String name = UUID.randomUUID().toString();
        int number = 10;
        jdbcTemplate.update(sql, name, number);
        throw new RuntimeException("被调用方法出现异常");
    }

    /**
     * 3.Propagation.SUPPORTS
     * 支持使用当前事务，若当前事务不存在，则不使用事务
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void createDemoBySupports() {
        String sql = "insert into demo values(?, ?)";
        String name = UUID.randomUUID().toString();
        int number = 10;
        jdbcTemplate.update(sql, name, number);
        throw new RuntimeException("被调用方法出现异常");
    }

    /**
     * 4. Propagation.NOT_SUPPORTED
     * 无事务执行，若当前事务存在，则挂起
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createDemoByNotSupported() {
        String sql = "insert into demo values(?, ?)";
        String name = UUID.randomUUID().toString();
        int number = 10;
        jdbcTemplate.update(sql, name, number);
        throw new RuntimeException("被调用方法出现异常");
    }

    /**
     * 5. Propagation.MANDATORY
     * 强制使用当前事务，若当前不存在事务，则抛出异常
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void createDemoByMandatory() {
        String sql = "insert into demo values(?, ?)";
        String name = UUID.randomUUID().toString();
        int number = 10;
        jdbcTemplate.update(sql, name, number);
        throw new RuntimeException("被调用方法出现异常");
    }

    /**
     * 6. Propagation.NEVER
     * 无事务执行，若当前存在事务，则抛出异常
     */
    @Transactional(propagation = Propagation.NEVER)
    public void createDemoByNever() {
        String sql = "insert into demo values(?, ?)";
        String name = UUID.randomUUID().toString();
        int number = 10;
        jdbcTemplate.update(sql, name, number);
        throw new RuntimeException("被调用方法出现异常");
    }

    /**
     *  7. Propagation.NESTED 嵌套事务
     *   若当前存在事务，则创建一个嵌套事务并在其中执行；
     *   若当前不存在事务，与1相同
     *
     *   不同点在于此嵌套事务出现异常时，只会回滚当前嵌套事务的操作，不会回滚当前事务的操作
     */
    @Transactional(propagation = Propagation.NESTED)
    public void createDemoByNested() {
        String sql = "insert into demo values(?, ?)";
        String name = UUID.randomUUID().toString();
        int number = 10;
        jdbcTemplate.update(sql, name, number);
        throw new RuntimeException("被调用方法出现异常");
    }
}
