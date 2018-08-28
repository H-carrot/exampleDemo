package com.hcarrot.module;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String test(){
        return "test success";
    }
}
