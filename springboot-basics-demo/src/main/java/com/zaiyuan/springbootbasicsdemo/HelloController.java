package com.zaiyuan.springbootbasicsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Environment env;

    @Autowired
    private Person person;

    @Value("${address[0]}")
    private String city;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(city);
        System.out.println(env.getProperty("testString"));
        System.out.println(person);
        return person.getName();
    }
}
