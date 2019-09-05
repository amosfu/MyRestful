package com.amos.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.amos.bean.Account;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingController {

    @RequestMapping("/")
    public String greeting(){

        return "welcome";
    }
}
