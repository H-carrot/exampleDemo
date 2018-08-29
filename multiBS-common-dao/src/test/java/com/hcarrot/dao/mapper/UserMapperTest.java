package com.hcarrot.dao.mapper;

import com.hcarrot.dao.Tester;
import com.hcarrot.dao.model.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class UserMapperTest extends Tester {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test1(){
        userMapper.selectAll();
    }

    @Test
    public void test2(){
        List<User> users = userMapper.selectByIds("1");
        System.out.println(users.get(0).getNickName());
    }
}
