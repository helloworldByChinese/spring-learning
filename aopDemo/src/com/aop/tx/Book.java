package com.aop.tx;

/**
 * 实体类书
 * 可使用lombok简化实体类代码
 * @author JiangBaoyong
 * @date 2020/01/04
 **/
public class Book {

    private String isbn;
    private String name;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
