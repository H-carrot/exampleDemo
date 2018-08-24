package com.hcarrot.example.common.dao.meta.vo;

import com.netease.haitao.finance.expense.dao.meta.entity.DepositDetail;
import lombok.Data;

/**
 * @author: kedi: kedi@corp.netease.com
 * @Date: 2018/8/13
 */
@Data
public class DepositDetailVO extends DepositDetail {
    private String supplierName;
    private Integer currencyType;
}
