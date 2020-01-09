package com.baoyong.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JiangBaoyong
 * @date 2020/01/08
 **/
@Controller
public class HelloWorldController {

    /**
     * /WEB-INF/views/hello.jsp
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("请求来了！hello");
        return "hello";
    }
}
