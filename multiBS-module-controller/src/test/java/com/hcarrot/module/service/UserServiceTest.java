package com.hcarrot.module.service;

import com.hcarrot.dao.model.User;
import com.hcarrot.module.Tester;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceTest extends Tester {

    @Resource
    private UserService userService;

    @Test
    public void test1(){
        userService.findAll();
    }

    @Test
    public void test2(){
        List<User> users = userService.findByIds("1");
        System.out.println(users.get(0).getNickName());
    }
}
