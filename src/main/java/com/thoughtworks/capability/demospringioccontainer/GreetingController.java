package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private  GreetingService greetingService;
    private  ApplicationContext context;

    public GreetingController(ApplicationContext context) {
        this.context = context;
        this.greetingService = this.context.getBean("greetingService",GreetingService.class);
        System.out.println("greetingService build");
    }

    @GetMapping("/greet")
    public String greet() {
        return greetingService.sayHi();
    }

}
