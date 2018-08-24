package com.hcarrot.example.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: kedi: kedi@corp.netease.com
 * @Date: 2018/8/15
 */
public class ContractDepositDto implements Serializable {

    private static final long serialVersionUID = 494323144637733624L;

    private Integer sourceSystemCode;

    private Long supplierId;

    private String supplierName;

    private String companyName;

    private String buName;

    private Integer payType;

    private Integer currencyType;

    private BigDecimal contractNeedAmount;

    private BigDecimal contractAddAmount;

    private String contractNo;

    public Integer getSourceSystemCode() {
        return sourceSystemCode;
    }

    public void setSourceSystemCode(Integer sourceSystemCode) {
        this.sourceSystemCode = sourceSystemCode;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBuName() {
        return buName;
    }

    public void setBuName(String buName) {
        this.buName = buName;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
        this.currencyType = currencyType;
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

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Override
    public String toString() {
        return "ContractDepositDto{" +
                "sourceSystemCode=" + sourceSystemCode +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", buName='" + buName + '\'' +
                ", payType=" + payType +
                ", currencyType=" + currencyType +
                ", contractNeedAmount=" + contractNeedAmount +
                ", contractAddAmount=" + contractAddAmount +
                ", contractNo='" + contractNo + '\'' +
                '}';
    }
}
