package com.ssp.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AppRestController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}