package com.helloworld.entity;

import com.helloworld.demo.Car;

/**
 * @author byJiang
 * @title Person
 * @date 2019/12/26
 **/
public class Person {
    private String name;

    private Car car;

    public Person() {
        System.out.println("Constructor is using....");
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
