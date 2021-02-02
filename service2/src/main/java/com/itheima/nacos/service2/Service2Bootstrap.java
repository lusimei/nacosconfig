package com.itheima.nacos.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
@RestController
public class Service2Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Service2Bootstrap.class,args);
    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Value("${common.name}")
    private String config2;

    @GetMapping("/configs")
    public String getConfigs(){
        return webApplicationContext.getEnvironment().getProperty("common.name");
//        return config2;
    }
}
