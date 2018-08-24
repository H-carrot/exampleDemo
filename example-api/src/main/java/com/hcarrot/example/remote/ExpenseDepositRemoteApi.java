package com.hcarrot.example.remote;



import com.hcarrot.example.CommonReturnData;

import java.math.BigDecimal;

/**
 * 自营保证金API服务
 *
 * @author: kedi: kedi@corp.netease.com
 * @Date: 2018/8/15
 */
public interface ExpenseDepositRemoteApi {

    /**
     * 保证金应收款应付款完成通知
     */
    CommonReturnData updateReceivePayStatus(Integer type, String contractNo, String outId, int state, BigDecimal receivableAmount, BigDecimal receivablePayment);

    /**
     * 合同状态通知接口
     * 触发条件：合同流转为"合同已终止""合同已逾期""合同冻结"时，进销存触发通知费用管理系统
     */
    CommonReturnData updateContractState(String contractId);

    /**
     * 保证金余额查询接口
     */
    CommonReturnData getDepositBalance(Long supplierId);

}
