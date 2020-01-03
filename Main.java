package com.helloworld;

import com.helloworld.demo.Person;
import com.helloworld.demo.RichPerson;
import com.helloworld.helloworld.HelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        // 1.容器创建，读取xml文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2.获取容器内的实例，当前class有多个不同ID的bean时，设置了primary的为默认获取的bean
        // 也可以通过ID名称获取bean
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        // 3.调用类的具体方法
        System.out.println(helloWorld);

        Person person = context.getBean(Person.class);
        Person person2 = (Person) context.getBean("person");
        System.out.println(person == person2);
        RichPerson richPerson = context.getBean(RichPerson.class);
        System.out.println(richPerson);
        context.close();
    }
}
