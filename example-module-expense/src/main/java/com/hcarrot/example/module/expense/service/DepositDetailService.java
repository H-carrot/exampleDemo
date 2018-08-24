package com.hcarrot.example.module.expense.service;

import com.hcarrot.example.CommonReturnData;

import java.math.BigDecimal;

/**
 * @author: kedi: kedi@corp.netease.com
 * @Date: 2018/8/16
 */
public interface DepositDetailService {
    /*
    @Resource
    private DepositDetailMapper depositDetailMapper;

    public List<DepositDetail> getDetail(Long supplierId) {
        return depositDetailMapper.findBySupplierId(supplierId);
    }
    */

    /**
     * 查询数据
     */
    CommonReturnData listDepositDetailByMerchantId(int page, int pageSize, Long supplierId);

    /**
     * 插入保证金明细数据
     */
    CommonReturnData insertDepositDetail(String systemNo, Long supplierId, String merchantName, String companyName,
                                         String bu, int payType, Integer currencyType, BigDecimal contractNeedAmount,
                                         BigDecimal contractAddAmount, String contractNo);

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
     * 合同操作加急
     */
    CommonReturnData updateContractUrgent(String contractId, int state);
}
