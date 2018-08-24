package com.hcarrot.example.common.dao.mapper;

import com.hcarrot.example.common.dao.AbstractDaoTestNG;
import com.hcarrot.example.common.dao.meta.entity.DepositInfo;
import org.apache.ibatis.session.RowBounds;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hurenjian on 2018/8/6.
 */
public class DepositInfoMapperTest extends AbstractDaoTestNG {
    @Resource
    DepositInfoMapper depositInfoMapper;

    @Test
    void testInsertDepositInfo(){
        DepositInfo depositInfo = new DepositInfo();
        //depositInfo.setId(1L);
        /*depositInfo.setSupplierId(1111L);
        depositInfo.setSupplierName("Name1");
        depositInfo.setCurrencyType(1);
        depositInfo.setDepositNeeded(new BigDecimal("200.00"));
        depositInfo.setDepositReceived(new BigDecimal("100.00"));
        depositInfo.setDepositBalance(new BigDecimal("100.00"));
        depositInfo.setDepositState(new Integer(1));
        depositInfo.setUrgentMerchant(new Integer(1));*/
        depositInfo.setSupplierId(2222L);
        depositInfo.setSupplierName("Name2");
        depositInfo.setCurrencyType(2);
        depositInfo.setDepositNeeded(new BigDecimal("200.00"));
        depositInfo.setDepositReceived(new BigDecimal("100.00"));
        depositInfo.setDepositBalance(new BigDecimal("100.00"));
        depositInfo.setDepositState(new Integer(1));
        depositInfo.setUrgentMerchant(new Integer(1));
        System.out.println("test");

        depositInfoMapper.insertDepositInfo(depositInfo);
        Assert.assertTrue(true);
    }

    @Test
    void testCountDepositInfoByCondition(){
        int num = depositInfoMapper.countDepositInfoByCondition(1111L,null,null,null);
        System.out.println(num);
        System.out.println("Test");
        int num1 = depositInfoMapper.countDepositInfoByCondition(1L,null,null,null);
        System.out.println(num1);
        System.out.println("Test1");
        Assert.assertTrue(true);
    }

    @Test
    void testGetDepositInfoByCondition(){
        int offset = (1 - 1) * 10;
        int limit = 10;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<DepositInfo> result = depositInfoMapper.getDepositInfoByCondition(null,null,null,null,rowBounds);
        System.out.println(result.size());
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testGetAllMerchantName(){
        List<String> result = depositInfoMapper.getAllMerchantName();
        System.out.println(result);
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testGetAllCurrency(){
        List<Integer> result = depositInfoMapper.getAllCurrency();
        System.out.println(result);
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testGetDepositBalancebyMerchantId(){
        BigDecimal result = depositInfoMapper.getDepositBalancebyMerchantId(1L);
        System.out.println(result);
        System.out.println("Test");
        BigDecimal result1 = depositInfoMapper.getDepositBalancebyMerchantId(1111L);
        System.out.println(result1);
        System.out.println("Test1");
        Assert.assertTrue(true);
    }

    @Test
    void testGetDepositNeededBySupplierId(){
        BigDecimal result = depositInfoMapper.getDepositNeededBySupplierId(1111L);
        System.out.println(result);
        System.out.println("Test");
        Assert.assertTrue(true);
    }

    @Test
    void testUpdateDepositBalancebyMerchantId(){
        depositInfoMapper.updateDepositBalancebyMerchantId(1111L, new BigDecimal(50.00));
        Assert.assertTrue(true);
    }

    @Test
    void testUpdateDepositState(){
        depositInfoMapper.updateDepositState(1111L, 1);
        Assert.assertTrue(true);
    }

    @Test
    void testUpdateUrgentMerchant(){
        depositInfoMapper.updateUrgentMerchant(1111L, 0);
        Assert.assertTrue(true);
    }

}
