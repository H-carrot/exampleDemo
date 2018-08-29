package com.hcarrot.common.enums;

/**
 * Created by hurenjian on 2018/8/20.
 */
public enum Currency {
    CNY(1, "CNY", "人民币"),
    USD(2, "USD", "美元"),
    JPY(3, "JPY", "日元"),
    KRW(4, "KRW", "韩元"),
    EUR(5, "EUR", "欧元"),
    AUD(6, "AUD", "澳币"),
    GBP(7, "GBP", "英镑"),
    HKD(8, "HKD", "港币"),
    NZD(9, "NZD", "新西兰币");

    private int type;
    private String code;
    private String name;

    private Currency(int type, String code, String name) {
        this.type = type;
        this.code = code;
        this.name = name;
    }

    public int getType() {
        return this.type;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public int getIntValue() {
        return this.type;
    }

    public Currency genEnumByIntValue(int intValue) {
        Currency[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Currency val = var2[var4];
            if(intValue == val.getIntValue()) {
                return val;
            }
        }

        return null;
    }

    public static Currency genEnumByDesc(String name) {
        Currency[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Currency currency = var1[var3];
            if(currency.getName().equals(name)) {
                return currency;
            }
        }

        return null;
    }

    public static Currency genEnumByIntValueSt(int value) {
        return values()[0].genEnumByIntValue(value);
    }
}
