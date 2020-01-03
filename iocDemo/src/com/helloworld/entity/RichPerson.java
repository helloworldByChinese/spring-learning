package com.helloworld.entity;

import com.helloworld.demo.Car;

import java.util.List;

/**
 * @author byJiang
 * @title RichPerson
 * @date 2019/12/27
 **/
public class RichPerson {
    private String name;

    private List<Car> cars;

    public RichPerson() {
    }

    @Override
    public String toString() {
        String str = "RichPerson{" +
                "name='" + name + '\'' +
                ", cars=[";
        for (Car one: cars) {
            str += one.toString();
        }
        str += "]}";
        return str;
    }

    public RichPerson(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
