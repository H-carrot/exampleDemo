package com.hcarrot.example.module.expense.remote;

import com.hcarrot.example.CommonReturnData;
import com.hcarrot.example.module.expense.service.DepositDetailService;
import com.hcarrot.example.module.expense.service.DepositInfoService;
import com.hcarrot.example.remote.ExpenseDepositRemoteApi;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by hurenjian on 2018/8/20.
 */
public class ExpenseDepositRemoteApiImp implements ExpenseDepositRemoteApi {

    @Resource
    private DepositInfoService depositInfoService;

    @Resource
    private DepositDetailService depositDetailService;

    /**
     * 保证金应收款应付款完成通知
     *
     * @param type
     * @param contractNo
     * @param outId
     * @param state
     * @param receivableAmount
     * @param receivablePayment
     */
    public CommonReturnData updateReceivePayStatus(Integer type, String contractNo, String outId, int state, BigDecimal receivableAmount, BigDecimal receivablePayment) {
        CommonReturnData commonReturnData = depositDetailService.updateReceivePayStatus(type,contractNo,outId,state,receivableAmount,receivablePayment);
        return commonReturnData;
    }

    /**
     * 合同状态通知接口
     * 触发条件：合同流转为"合同已终止""合同已逾期""合同冻结"时，进销存触发通知费用管理系统
     *
     * @param contractId
     */
    public CommonReturnData updateContractState(String contractId) {
        CommonReturnData commonReturnData = depositDetailService.updateContractState(contractId);
        return commonReturnData;
    }

    /**
     * 保证金余额查询接口
     *
     * @param supplierId
     */
    public CommonReturnData getDepositBalance(Long supplierId) {
        CommonReturnData commonReturnData = depositInfoService.getDepositBalance(supplierId);
        return commonReturnData;
    }
}

