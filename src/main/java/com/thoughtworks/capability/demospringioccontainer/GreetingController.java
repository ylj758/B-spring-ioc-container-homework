package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private GreetingService greetingService;
    private final ApplicationContext applicationContext;

    @Autowired
    public GreetingController(GreetingService greetingService, ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greet() {
        greetingService = applicationContext.getBean(GreetingService.class);
        return greetingService.sayHi()+greetingService.toString();
    }

}
