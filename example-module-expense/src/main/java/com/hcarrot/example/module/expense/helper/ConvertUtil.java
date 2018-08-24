package com.hcarrot.example.module.expense.helper;


import com.hcarrot.example.common.dao.meta.entity.DepositInfo;
import com.hcarrot.example.common.dao.meta.vo.DepositInfoVO;
import com.hcarrot.example.common.enums.Currency;

import java.math.BigDecimal;

/**
 * Created by hurenjian on 2018/8/20.
 */
public class ConvertUtil {

    /**
     * 转换对象
     * @param item
     * @return
     */
    public static DepositInfoVO convert2DepositInfoVO(DepositInfo item) {
        if (null == item) {
            return null;
        }
        DepositInfoVO vo = new DepositInfoVO();
        vo.setId(item.getId());
        vo.setSupplierId(item.getSupplierId());
        vo.setSupplierName(item.getSupplierName());
        vo.setCurrencyType(Currency.genEnumByIntValueSt(item.getCurrencyType()).getName());
        vo.setDepositNeeded(item.getDepositNeeded());
        vo.setDepositReceived(item.getDepositReceived());
        vo.setDepositBalance(item.getDepositBalance());
        vo.setDepositState((item.getDepositState() == 0)?"待缴纳":"已缴纳");
        vo.setUrgentMerchant((item.getUrgentMerchant() == 0)?"否":"是");
        vo.setCreateTime(item.getCreateTime());
        vo.setUpdateTime(item.getUpdateTime());
        return vo;
    }
}
