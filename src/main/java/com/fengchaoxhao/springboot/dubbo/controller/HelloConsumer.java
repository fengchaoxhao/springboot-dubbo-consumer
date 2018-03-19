package com.fengchaoxhao.springboot.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fengchaoxhao.springboot.dubbo.HelloApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConsumer {
    @Reference(
            interfaceName = "helloProvider",
            version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345"
    )
    private HelloApi helloApi;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return helloApi.sayHello(name);
    }
}
