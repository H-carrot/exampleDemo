package com.hcarrot.example.common.dao;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author: kedi: kedi@corp.netease.com
 * @Date: 2018/8/15
 */
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public abstract class AbstractDaoTestNG extends AbstractTransactionalTestNGSpringContextTests {

    @Test
    public void func(){
        System.out.println("this module is confiured right!");
    }


    @BeforeClass
    public void setup() {
        System.out.println("==============begin test=================");
    }

}
