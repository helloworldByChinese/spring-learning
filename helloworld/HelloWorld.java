package com.helloworld.helloworld;

/**
 * @author byJiang
 * @title HelloWorld
 * @date 2019/12/26
 **/
public class HelloWorld {

    private int age;
    private String name;
    private double money;

    // 重载构造器，
    // 多个构造器可以根据构造入参来选择对应的构造器
    public HelloWorld() {
        System.out.println("constructor with none args...");
    }

    public HelloWorld(int age, String name) {
        System.out.println("constructor with age and name...");
        this.age = age;
        this.name = name;
    }

    public HelloWorld(double money, String name) {
        System.out.println("constructor with money and name...");
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
