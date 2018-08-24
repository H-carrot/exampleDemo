package com.hcarrot.example.module.expense.controller;

import com.hcarrot.example.CommonReturnData;
import com.hcarrot.example.module.expense.service.DepositDetailService;
import com.hcarrot.example.module.expense.service.DepositInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: kedi: kedi@corp.netease.com
 * @Date: 2018/8/13
 */
@RestController
@RequestMapping("/fes-api/deposit")
public class DepositQueryController {
    @Autowired
    DepositDetailService depositDetailService;

    @Autowired
    DepositInfoService depositInfoService;

    /*
    @RequestMapping("/getDetail")
    public Object getDetail(Long supplierId) {
        return depositDetailService.getDetail(supplierId);
    }
    */
    /*
    @RequestMapping("/getAllMerchantName")
    public Object getAllMerchantName() {
        CommonReturnData commonReturnData = depositInfoService.listAllMerchantName();
        return commonReturnData.getData();
    }*/

    /*
    @RequestMapping("/getAllCurrency")
    public Object getAllCurrency() {
        CommonReturnData commonReturnData = depositInfoService.listAllCurrency();
        return commonReturnData.getData();
    }*/

    @RequestMapping("/getCommonData")
    public Object getCommonData() {
        CommonReturnData commonReturnData = depositInfoService.listCommonData();
        return commonReturnData.getData();
    }

    @RequestMapping("/getAllInfo")
    public Object getAllInfo(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                             @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                             @RequestParam(value = "merchantId", required = false) Long merchantId,
                             @RequestParam(value = "merchantName", required = false) String merchantName,
                             @RequestParam(value = "currency", required = false) Integer currency,
                             @RequestParam(value = "depositState", required = false) Integer depositState) {
        if (page <= 0 || pageSize <= 0) {
            return  CommonReturnData.errorRet(200, "page or pageSize is invalid");
        }
        CommonReturnData result = depositInfoService.listDepositInfo(page, pageSize, merchantId, merchantName, currency, depositState);
        return result;
    }
}
