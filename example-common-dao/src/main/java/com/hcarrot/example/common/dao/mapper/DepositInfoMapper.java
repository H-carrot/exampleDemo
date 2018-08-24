package com.hcarrot.example.common.dao.mapper;


import com.hcarrot.example.common.dao.annotation.Mapper;
import com.hcarrot.example.common.dao.meta.entity.DepositInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hurenjian on 2017/3/8.
 */

@Mapper
public interface DepositInfoMapper {

    /**
     * 查询符合条件商家数量
     */
    int countDepositInfoByCondition(@Param("supplierId") Long supplierId, @Param("supplierName") String supplierName,
                                    @Param("currencyType") Integer currencyType, @Param("depositState") Integer depositState);

    /**
     * 查询符合条件商家信息
     */
    List<DepositInfo> getDepositInfoByCondition(@Param("supplierId") Long supplierId, @Param("supplierName") String supplierNamee,
                                                @Param("currencyType") Integer currencyType, @Param("depositState") Integer depositState,
                                                RowBounds rowBounds);

    /**
     * 查询商家信息
     */
    DepositInfo getDepositInfoByMerchantId(@Param("supplierId") Long supplierId);

    /**
     * 获取所有供应商名称
     */
    List<String> getAllMerchantName();

    /**
     * 获取所有币种
     */
    List<Integer> getAllCurrency();

    /**
     * 添加保证金商家记录
     * @param depositInfo
     */
    void insertDepositInfo(DepositInfo depositInfo);

    /**
     * 根据merchantId获取币种
     * @param supplierId
     */
    Integer getCurrencyTypeByMerchantId(@Param("supplierId") Long supplierId);

    /**
     * 根据merchantId获取应缴总额
     */
    BigDecimal getDepositNeededBySupplierId(@Param("supplierId") Long supplierId);

    /**
     *根据merchantId修改保证金余额
     */
    void updateDepositBalancebyMerchantId(@Param("supplierId") Long supplierId, @Param("depositBalance") BigDecimal depositBalance);

    /**
     * 根据merchantId获取保证金余额
     * @param supplierId
     */
    BigDecimal getDepositBalancebyMerchantId(@Param("supplierId") Long supplierId);

    /**
     * 更新保证金状态
     */
    void updateDepositState(@Param("supplierId") Long supplierId, @Param("depositState") Integer depositState);

    /**
     * 商户加急
     */
    void updateUrgentMerchant(@Param("supplierId") Long supplierId, @Param("urgentMerchant") Integer urgentMerchant);
}