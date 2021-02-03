package com.itheima.nacos.service1;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
@RestController
public class Service1Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Service1Bootstrap.class,args);
    }

    @Autowired
    private WebApplicationContext webApplicationContext;

//    @Value("${common.name}")
//    private String config1;

    @GetMapping("/configs")
    public String getConfigs(){
        return webApplicationContext.getEnvironment().getProperty("common.name");
//      return config1;
    }

    @GetMapping("/userinfo")
    public String getUserinfo(){
        String name = webApplicationContext.getEnvironment().getProperty("user.name");
        String age = webApplicationContext.getEnvironment().getProperty("user.age");
        String birthday = webApplicationContext.getEnvironment().getProperty("common.birthday");
        String email = webApplicationContext.getEnvironment().getProperty("common.email");
        return "name="+name+"  age="+age+"  birthday="+birthday+"  email="+email;
//      return config1;
    }
}
