package com.hcarrot.example.common.dao.mapper;

import com.hcarrot.example.common.dao.meta.entity.DepositDetail;
import com.hcarrot.example.common.dao.AbstractDaoTestNG;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: kedi: kedi@corp.netease.com
 * @Date: 2018/8/15
 */
public class DepositDetailMapperTest extends AbstractDaoTestNG {
    @Resource
    DepositDetailMapper depositDetailMapper;

    /*
    @Test
    public void insert() {
        try {
            DepositDetail detail = new DepositDetail();
            detail.setSourceSystemCode(2);
            detail.setCompanyName("aaa");
            detail.setContractNo("aaaaaaa");
            detail.setContractState(1);
            detail.setSupplierId(2L);
            detail.setPayType(1);
            detail.setContractNeedAmount(BigDecimal.TEN);
            depositDetailMapper.insert(detail);
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testUpdate() {
        try {
            DepositDetail detail = new DepositDetail();
            detail.setContractNo("aaa");
            detail.setContractState(1);
            detail.setReceivableNo("abc");
            detail.setReceivableAmount(BigDecimal.TEN);
            detail.setReceivableState(1);
            depositDetailMapper.update(detail);
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
    */


    @Test
    void testCountDepositDetailByMerchantId(){
        try {
            int num = depositDetailMapper.countDepositDetailByMerchantId(1L);
            System.out.println(num);
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }

    }

    @Test
    void testInsertDepositDetail(){
        DepositDetail depositDetail = new DepositDetail();
        //depositDetail.setId(3L);
        depositDetail.setContractNo("1111Test4");
        depositDetail.setContractState(1);
        depositDetail.setSupplierId(1111L);
        depositDetail.setPayType(1);
        depositDetail.setCompanyName("kaola test4");
        depositDetailMapper.insertDepositDetail(depositDetail);
        System.out.println("test");
        Assert.assertTrue(true);
    }

    @Test
    void testUpdateContractState(){
        depositDetailMapper.updateContractState("1111Test1",1);
        System.out.println("test");
        Assert.assertTrue(true);
    }

    @Test
    void testGetSupplierIdByContractId(){
        Long result = depositDetailMapper.getSupplierIdByContractId("1111Test1");
        System.out.println(result);
        Assert.assertTrue(true);
    }

    @Test
    void testGetAllPayedBySupplierId(){
        System.out.println("Test");
        BigDecimal result = depositDetailMapper.getAllPayedBySupplierId(1111L);
        System.out.println(result);
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testGetBalanceNeedToMinus(){
        BigDecimal result = depositDetailMapper.getBalanceNeedToMinus(1111L);
        System.out.println(result);
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testCountBalanceState(){
        int result = depositDetailMapper.countBalanceState(1111L);
        System.out.println(result);
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testGetUrgentFlagByContractId(){
        Integer result = depositDetailMapper.getUrgentFlagByContractId("1111Test1");
        System.out.println(result);
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testUpdateReceivableState(){
        depositDetailMapper.updateReceivableState("1111Test1",null,1,null,new BigDecimal("50.00"));
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testUpdatePayableState(){
        depositDetailMapper.updatePayableState("1111Test1", "payNo1", new BigDecimal("50.00"),1);
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testUpdateUrgentFlag(){
        depositDetailMapper.updateUrgentFlag("1111Test1", 0);
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testCountUrgentFlagByMerchantId(){
        int num = depositDetailMapper.countUrgentFlagByMerchantId(1111L);
        System.out.println(num);
        Assert.assertTrue(true);
    }


}