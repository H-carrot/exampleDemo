package com.hcarrot.module.controller;

import com.hcarrot.dao.core.Result;
import com.hcarrot.module.Tester;
import org.junit.Test;

import javax.annotation.Resource;

public class UserControllerTest extends Tester {

    @Resource
    private UserController userController;

    @Test
    public void test1(){
        Integer index = 1;
        Result result = userController.detail(index);
        System.out.println(result.getCode());
    }
}
