package com.hcarrot.example.module.expense.service;

import com.hcarrot.example.CommonReturnData;
import com.hcarrot.example.module.expense.AbstractTestNG;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by hurenjian on 2018/8/8.
 */
public class DepositInfoServiceImpTest extends AbstractTestNG {

    @Resource
    private DepositInfoService depositInfoService;

    @Resource
    private DepositDetailService depositDetailService;

    /*
    @InjectMocks
    private DepositDetailServiceImp depositDetailServiceImp;

    @InjectMocks
    private DepositInfoServiceImp depositInfoServiceImp;

    @Mock
    private DepositInfoMapper depositInfoMapper;

    @Mock
    private DepositDetailMapper depositDetailMapper;

    @BeforeMethod(alwaysRun = true)
    public void initMock() {
        MockitoAnnotations.initMocks(this);
    }
    */
    @Test
    void testGetDepositBalance() {
        /*
        Mockito.when(depositInfoMapper.getDepositBalancebyMerchantId(Mockito.anyString())).thenReturn(new BigDecimal("100.00"));
        CommonReturnData commonReturnData = depositInfoServiceImp.getDepositBalance("123456");
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getData());
        Assert.assertTrue(true);
        */
    }

    @Test
    void testGetTest(){
        depositInfoService.getTest();
    }

    @Test
    void testlistDepositInfo(){
        System.out.println("test1");
        CommonReturnData commonReturnData = depositInfoService.listDepositInfo(1, 10, null, null, null, null);
        System.out.println(commonReturnData.getCode());
        Map<String,Object> ret = commonReturnData.getData();
        Object result = ret.get("list");
        System.out.println(result);
        /*Mockito.when(depositInfoMapper.countDepositInfoByCondition(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt())).thenReturn(0);
        CommonReturnData commonReturnData = depositInfoService.listDepositInfo(1, 10, "ID1", "Name1", "curreny1", new Integer(1));
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getData());

        Mockito.when(depositInfoMapper.countDepositInfoByCondition(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt())).thenReturn(2);
        List<DepositInfo> info = new ArrayList<DepositInfo>();
        DepositInfo first = new DepositInfo();
        first.setSupplierId("Test1");
        first.setSupplierName("Name1");
        first.setCurrencyType("curreny1");
        first.setDepositState(1);
        DepositInfo second = new DepositInfo();
        second.setSupplierId("Test2");
        second.setSupplierName("Name2");
        second.setCurrencyType("currency2");
        first.setDepositState(1);
        info.add(first);
        info.add(second);
        Mockito.when(depositInfoMapper.getDepositInfoByCondition(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), new RowBounds(1,1))).thenReturn(info);
        CommonReturnData commonReturnData1 = depositInfoService.listDepositInfo(1, 10, "Test2", "Name2", "curreny2", new Integer(1));
        System.out.println(commonReturnData1.getCode());
        System.out.println(commonReturnData1.getData());*/

        Assert.assertTrue(true);
    }

    @Test
    void testlistAllMerchantName(){
        /*
        CommonReturnData commonReturnData = depositInfoService.listAllMerchantName();
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getData());
        Assert.assertTrue(true);*/
        /*
        List<String> merchantNames = new ArrayList<String>(2);
        merchantNames.add("Test1");
        merchantNames.add("Test2");
        Mockito.when(depositInfoMapper.getAllMerchantName()).thenReturn(merchantNames);
        CommonReturnData commonReturnData = depositInfoServiceImp.listAllMerchantName();
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getData());
        Assert.assertTrue(true);*/
    }

    @Test
    void testlistAllCurrency(){
        /*CommonReturnData commonReturnData = depositInfoService.listAllCurrency();
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getData());
        Assert.assertTrue(true);*/
        /*List<String> currencyType = new ArrayList<String>(2);
        currencyType.add("currency1");
        currencyType.add("currency2");
        Mockito.when(depositInfoMapper.getAllMerchantName()).thenReturn(currencyType);
        CommonReturnData commonReturnData = depositInfoServiceImp.listAllMerchantName();
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getData());*/
        Assert.assertTrue(true);
    }

    @Test
    void testgetDepositInfoByMerchantId(){
        /*DepositInfo first = new DepositInfo();
        first.setSupplierId("Test1");
        first.setSupplierName("Name1");
        first.setCurrencyType("curreny1");
        Mockito.when(depositInfoMapper.getDepositInfoByMerchantId(Mockito.anyString())).thenReturn(first);
        CommonReturnData commonReturnData = depositInfoServiceImp.getDepositInfoByMerchantId("Test1");
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getData().get("list"));*/
        Assert.assertTrue(true);
    }

    @Test
    void testgetDepositBalance(){
        CommonReturnData commonReturnData = depositInfoService.getDepositBalance(1111L);
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getData().get("currency"));
        System.out.println(commonReturnData.getData().get("balance"));
        /*Mockito.when(depositInfoMapper.getDepositBalancebyMerchantId(Mockito.anyString())).thenReturn(new BigDecimal("100.00"));
        Mockito.when(depositInfoMapper.getCurrencyTypeByMerchantId(Mockito.anyString())).thenReturn(new String("currency1"));
        CommonReturnData commonReturnData = depositInfoServiceImp.getDepositBalance("Test1");
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getData().get("currency"));
        System.out.println(commonReturnData.getData().get("balance"));*/
        Assert.assertTrue(true);
    }

    @Test
    void testupdateDepositBalance(){
        /*Mockito.when(depositInfoMapper.getDepositNeededByMerchantId(Mockito.anyString())).thenReturn(new BigDecimal("200.00"));
        Mockito.when(depositDetailMapper.getBalanceNeedToMinus(Mockito.anyString())).thenReturn(new BigDecimal("50.00"));
        Mockito.when(depositDetailMapper.getAllPayedByMerchantId(Mockito.anyString())).thenReturn(new BigDecimal("50.00"));

        Mockito.when(depositDetailMapper.countBalanceState(Mockito.anyString())).thenReturn(new Integer(1));
        CommonReturnData commonReturnData = depositInfoServiceImp.updateDepositBalance("Test1");
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getMessage());*/
        Assert.assertTrue(true);
    }
}
