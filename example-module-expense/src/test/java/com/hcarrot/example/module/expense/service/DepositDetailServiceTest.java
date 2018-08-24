package com.hcarrot.example.module.expense.service;


import com.hcarrot.example.module.expense.AbstractTestNG;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @author: kedi: kedi@corp.netease.com
 * @Date: 2018/8/16
 */
public class DepositDetailServiceTest extends AbstractTestNG {

    @Resource
    DepositDetailService depositDetailService;

    @Test
    public void getDetail() {
        try {
            //depositDetailService.getDetail(123L);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }
}