package com.hcarrot.module;

import com.hcarrot.service.aop.UserAccess;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String user(){
        return "test success";
    }

    @RequestMapping(value = "/aop1",method = RequestMethod.GET)
    public String aop1(){
        return "aop1 success";
    }

    @RequestMapping(value = "/aop2",method = RequestMethod.GET)
    @UserAccess(desc = "second")
    public Object aop2() {
        return "aop2 controller";
    }
}
