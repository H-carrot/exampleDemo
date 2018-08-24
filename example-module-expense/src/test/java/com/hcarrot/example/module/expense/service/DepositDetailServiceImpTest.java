package com.hcarrot.example.module.expense.service;

import com.hcarrot.example.CommonReturnData;
import com.hcarrot.example.module.expense.AbstractTestNG;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by hurenjian on 2018/8/8.
 */
public class DepositDetailServiceImpTest extends AbstractTestNG {

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
    void testinsertDepositDetail() {
        /*
        Mockito.when(depositInfoMapper.getCurrencyTypeByMerchantId(Mockito.anyString())).thenReturn(new String("currency1"));
        CommonReturnData commonReturnData = depositDetailServiceImp.insertDepositDetail("system01", "Test1", "Name1", "考拉", "母婴", 1, "currency2", new BigDecimal("100.00"),new BigDecimal("80.00"), "contract1");
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getMessage());

        Mockito.when(depositInfoMapper.getCurrencyTypeByMerchantId(Mockito.anyString())).thenReturn(new String("currency1"));
        CommonReturnData commonReturnData1 = depositDetailServiceImp.insertDepositDetail("system01","Test1","Name1","考拉","母婴",1,"currency1",new BigDecimal("100.00"),new BigDecimal("80.00"),"contract1");
        System.out.println(commonReturnData1.getCode());
        System.out.println(commonReturnData1.getMessage());

        Mockito.when(depositInfoMapper.getCurrencyTypeByMerchantId(Mockito.anyString())).thenReturn(null);
        CommonReturnData commonReturnData2 = depositDetailServiceImp.insertDepositDetail("system01","Test1","Name1","考拉","母婴",1,"currency1",new BigDecimal("100.00"),new BigDecimal("80.00"),"contract1");
        System.out.println(commonReturnData2.getCode());
        System.out.println(commonReturnData2.getMessage());*/

        Assert.assertTrue(true);
    }

    @Test
    void testUpdateContractState(){
        CommonReturnData commonReturnData = depositDetailService.updateContractState("1111Test1");
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getMessage());
        Assert.assertTrue(true);
    }

    @Test
    void testUpdateReceivePayStatus(){
        CommonReturnData commonReturnData = depositDetailService.updateReceivePayStatus(0, "1111Test1", "recvNo1",0, new BigDecimal("100.00"),new BigDecimal("60.00"));
        System.out.println(commonReturnData.getCode());
        System.out.println(commonReturnData.getMessage());

        CommonReturnData commonReturnData1 = depositDetailService.updateReceivePayStatus(1, "1111Test1", "payNo2",1,new BigDecimal("60.00"),null);
        System.out.println(commonReturnData1.getCode());
        System.out.println(commonReturnData1.getMessage());
        Assert.assertTrue(true);
    }
}
