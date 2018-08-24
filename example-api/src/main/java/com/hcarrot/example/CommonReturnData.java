package com.hcarrot.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hurenjian on 2018/8/7.
 */
public class CommonReturnData implements Serializable {

    private static final long serialVersionUID = 5690121003849634280L;

    private static final int SUCCESS_CODE = 200;

    private static final int FAIL_CODE = 400;

    public static final String TOTAL = "total";

    public static final String LIST = "list";

    private int code;

    private Map<String, Object> data;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommonReturnData putData(String key,Object value) {
        if (data == null) {
            data = new HashMap<>();
        }
        data.put(key,value);
        return this;
    }

    public static CommonReturnData successRet() {
        CommonReturnData ret = new CommonReturnData();
        ret.setCode(SUCCESS_CODE);
        return ret;
    }

    public static CommonReturnData successRet(String message) {
        CommonReturnData ret = new CommonReturnData();
        ret.setCode(SUCCESS_CODE);
        ret.setMessage(message);
        return ret;
    }

    public static CommonReturnData successRet(String key, Object value) {
        CommonReturnData ret = successRet();
        return ret.putData(key, value);
    }

    public static CommonReturnData successRet(Map<String, Object> data) {
        if (null == data) {
            return successRet();
        }
        CommonReturnData ret = successRet();
        for (String key : data.keySet()) {
            ret.putData(key, data.get(key));
        }
        return ret;
    }

    public static CommonReturnData successRet(int total, List objectList) {
        CommonReturnData ret = successRet();
        ret.putData(TOTAL, total);
        ret.putData(LIST, objectList);
        return ret;
    }

    public static CommonReturnData errorRet() {
        return errorRet(FAIL_CODE, null);
    }

    public static CommonReturnData errorRet(String errMsg) {
        return errorRet(FAIL_CODE, errMsg);
    }

    public static CommonReturnData errorRet(int errCode) {
        return errorRet(errCode, null);
    }

    public static CommonReturnData errorRet(int errCode, String errMsg) {
        CommonReturnData ret = new CommonReturnData();
        ret.setCode(errCode);
        ret.setMessage(errMsg);
        return ret;
    }

    public static CommonReturnData errorRet(String errMsg, Map<String, Object> data) {
        CommonReturnData ret = new CommonReturnData();
        ret.setCode(FAIL_CODE);
        ret.setMessage(errMsg);
        ret.setData(data);
        return ret;
    }

    public boolean isSuccess() {
        return code == 200;
    }
}

