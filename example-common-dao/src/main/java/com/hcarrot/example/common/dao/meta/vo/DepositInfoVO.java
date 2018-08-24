package com.hcarrot.example.common.dao.meta.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by hurenjian on 2018/8/20.
 */
public class DepositInfoVO implements Serializable {
    private static final long serialVersionUID = 425096625050245692L;

    //主键
    private Long id;

    //供应商编号
    private Long supplierId;

    //供应商名称
    private String supplierName;

    //币种  详见Type
    private String currencyType;

    //保证金应缴总额
    private BigDecimal depositNeeded;

    //保证金实收总额
    private BigDecimal depositReceived;

    //保证金余额
    private BigDecimal depositBalance;

    //保证金状态  详见Type
    private String depositState;

    //是否加急商户  详见Type
    private String urgentMerchant;

    //创建时间
    private Timestamp createTime;

    //创建时间
    private Timestamp updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getDepositNeeded() {
        return depositNeeded;
    }

    public void setDepositNeeded(BigDecimal depositNeeded) {
        this.depositNeeded = depositNeeded;
    }

    public BigDecimal getDepositBalance() {
        return depositBalance;
    }

    public void setDepositBalance(BigDecimal depositBalance) {
        this.depositBalance = depositBalance;
    }

    public BigDecimal getDepositReceived() {
        return depositReceived;
    }

    public void setDepositReceived(BigDecimal depositReceived) {
        this.depositReceived = depositReceived;
    }

    public String getDepositState() {
        return depositState;
    }

    public void setDepositState(String depositState) {
        this.depositState = depositState;
    }

    public String getUrgentMerchant() {
        return urgentMerchant;
    }

    public void setUrgentMerchant(String urgentMerchant) {
        this.urgentMerchant = urgentMerchant;
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
