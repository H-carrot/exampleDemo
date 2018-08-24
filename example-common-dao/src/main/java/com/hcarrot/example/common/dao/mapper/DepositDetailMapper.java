package com.hcarrot.example.common.dao.mapper;


import com.hcarrot.example.common.dao.annotation.Mapper;
import com.hcarrot.example.common.dao.meta.entity.DepositDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface DepositDetailMapper {
    /*
    int insert(DepositDetail depositDetail);

    int update(DepositDetail depositDetail);

    int updateContractState(@Param("contractNo") String contractNo, @Param("state") Integer state,
                            @Param("flag") Integer urgentFlag);

    List<DepositDetail> findBySupplierId(@Param("supplierId")Long supplierId);
    */

    /**
     * 查询符合条件商家数量
     */
    int countDepositDetailByMerchantId(@Param("supplierId") Long supplierId);

    /**
     * 查询符合条件商家信息
     */
    List<DepositDetail> getDepositDetailByMerchantId(@Param("supplierId") Long supplierId, RowBounds rowBounds);

    /**
     * 添加保证金明细
     * @param depositDetail
     */
    void insertDepositDetail(DepositDetail depositDetail);

    /**
     * 更新应收款状态 已核销金额等
     */
    void updateReceivableState(@Param("contractNo") String contractNo, @Param("receivableNo") String receivableNo,
                               @Param("receivableState") Integer receivableState, @Param("receivableAmount") BigDecimal receivableAmount,
                               @Param("receivableOffsetAmount") BigDecimal receivableOffsetAmount);

    /**
     * 更新应付款状态
     */
    void updatePayableState(@Param("contractNo") String contractNo, @Param("payableNo") String payableNo,
                            @Param("payableAmount") BigDecimal payableAmount, @Param("payableState") Integer payableState);

    /**
     *"应收状态"为"终止收款"的（"应收款金额"-"应收已核销金额"）之和
     */
    BigDecimal getBalanceNeedToMinus(@Param("supplierId") Long supplierId);

    /**
     * 根据merchantId计算所有应付状态"为"已完成"应付款金额之和
     */
    BigDecimal getAllPayedBySupplierId(@Param("supplierId") Long supplierId);

    /**
     *更新保证金状态 计数用
     */
    int countDepositNeedToPay(@Param("supplierId") Long supplierId);

    /**
     *根据合同编号获取merchantId
     */
    Long getSupplierIdByContractId(@Param("contractNo") String contractNo);

    /**
     *根据合同编号获取urgentFlag
     */
    Integer getUrgentFlagByContractId(@Param("contractNo") String contractNo);

    /**
     * 根据合同ID获取应收款金额
     */
    BigDecimal getAccountReceivableByContractId(@Param("contractNo") String contractNo);

    /**
     * 判断所有保证金明细中应收款金额≠0数据，转账汇款收款方式的应收状态是否有"核销中"
     */
    int countBalanceState(@Param("supplierId") Long supplierId);

    /**
     * 根据合同ID获取应付款金额
     */
    BigDecimal getAccountPayableByContractId(@Param("contractNo") String contractNo);

    /**
     * 更新合同状态(生效 或者 未生效)
     */
    void updateContractState(@Param("contractNo") String contractNo, @Param("contractState") Integer contractState);

    /**
     * 合同加急
     */
    void updateUrgentFlag(@Param("contractNo") String contractNo, @Param("urgentFlag") Integer urgentFlag);

    /**
     * 计算商户加急合同个数
     * @return
     */
    int countUrgentFlagByMerchantId(@Param("supplierId") Long supplierId);

    /**
     * 获取商家明细信息
     * @return
     */
    List<DepositDetail> getMerchantDetailByMerchantId(@Param("supplierId") Long supplierId);


}
