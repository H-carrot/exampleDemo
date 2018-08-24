package com.hcarrot.example.common.dao.meta.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author: kedi: kedi@corp.netease.com
 * @Date: 2018/8/13
 */
public class DepositDetail implements Serializable {
    private static final long serialVersionUID = 425096625050245692L;

    /**
     * 主键id
     */
    private Long id;
    /**
     * 来源系统编号：02——供应商管理系统
     */
    private Integer sourceSystemCode;
    /**
     * 合同编号
     */
    private String contractNo;
    /**
     * 合同状态
     */
    private Integer contractState;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 所属BU
     */
    private String buName;
    /**
     * 缴纳方式
     */
    private Integer payType;
    /**
     * 实体公司
     */
    private String companyName;
    /**
     * 应缴金额
     */
    private BigDecimal contractNeedAmount;
    /**
     * 追缴金额
     */
    private BigDecimal contractAddAmount;
    /**
     * 应收款金额
     */
    private BigDecimal receivableAmount;
    /**
     * 应收已核销金额
     */
    private BigDecimal receivableOffsetAmount;
    /**
     * 应收单号
     */
    private String receivableNo;
    /**
     * 应收状态
     */
    private Integer receivableState;
    /**
     * 应付款金额
     */
    private BigDecimal payableAmount;
    /**
     * 应付单号
     */
    private String payableNo;
    /**
     * 应付状态
     */
    private Integer payableState;
    /**
     * 加急标识
     */
    private Integer urgentFlag;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public int getContractState() {
        return contractState;
    }

    public void setContractState(int contractState) {
        this.contractState = contractState;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getBuName() {
        return buName;
    }

    public void setBuName(String buName) {
        this.buName = buName;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getContractNeedAmount() {
        return contractNeedAmount;
    }

    public void setContractNeedAmount(BigDecimal contractNeedAmount) {
        this.contractNeedAmount = contractNeedAmount;
    }

    public BigDecimal getContractAddAmount() {
        return contractAddAmount;
    }

    public void setContractAddAmount(BigDecimal contractAddAmount) {
        this.contractAddAmount = contractAddAmount;
    }

    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(BigDecimal receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public BigDecimal getReceivableOffsetAmount() {
        return receivableOffsetAmount;
    }

    public void setReceivableOffsetAmount(BigDecimal receivableOffsetAmount) {
        this.receivableOffsetAmount = receivableOffsetAmount;
    }

    public String getReceivableNo() {
        return receivableNo;
    }

    public void setReceivableNo(String receivableNo) {
        this.receivableNo = receivableNo;
    }

    public int getReceivableState() {
        return receivableState;
    }

    public void setReceivableState(int receivableState) {
        this.receivableState = receivableState;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double BigDecimal) {
        this.payableAmount = payableAmount;
    }

    public String getPayableNo() {
        return payableNo;
    }

    public void setPayableNo(String payableNo) {
        this.payableNo = payableNo;
    }

    public int getPayableState() {
        return payableState;
    }

    public void setPayableState(int payableState) {
        this.payableState = payableState;
    }

    public int getUrgentFlag() {
        return urgentFlag;
    }

    public void setUrgentFlag(int urgentFlag) {
        this.urgentFlag = urgentFlag;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
