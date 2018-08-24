package com.hcarrot.example.module.expense.service;


import com.hcarrot.example.CommonReturnData;

/**
 * Created by hurenjian on 2018/8/6.
 */

public interface DepositInfoService {

    /**
     * 列表页数据查询
     */
    CommonReturnData listDepositInfo(int page, int pageSize, Long supplierId, String supplierName, Integer currencyType, Integer depositState);

    /**
     * 获取所有供应商名称
     */
    //CommonReturnData listAllMerchantName();

    /**
     * 查询商家信息
     */
    CommonReturnData getDepositInfoByMerchantId(Long supplierId);

    /**
     * 获取所有币种
     */
    //CommonReturnData listAllCurrency();

    /**
     * 获取列表下拉框信息
     */
    CommonReturnData listCommonData();

    /**
     * 保证金余额查询接口
     */
    CommonReturnData getDepositBalance(Long supplierId);

    /**
     * 统一计算保证金余额接口 保证金状态
     */
    CommonReturnData updateDepositBalance(Long supplierId) ;

    void getTest();

}
