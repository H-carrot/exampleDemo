package com.hcarrot.example.module.expense.service;

import com.hcarrot.example.CommonReturnData;
import com.hcarrot.example.common.dao.mapper.DepositDetailMapper;
import com.hcarrot.example.common.dao.mapper.DepositInfoMapper;
import com.hcarrot.example.common.dao.meta.entity.DepositInfo;
import com.hcarrot.example.common.dao.meta.vo.DepositInfoVO;
import com.hcarrot.example.module.expense.annotation.OperationLogAnnotation;
import com.hcarrot.example.module.expense.helper.ConvertUtil;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.hcarrot.example.common.enums.Currency;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by hurenjian on 2018/8/6.
 */

@Service
public class DepositInfoServiceImp implements DepositInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger("depositInfo");

    @Resource
    private DepositInfoMapper depositInfoMapper;

    @Resource
    private DepositDetailMapper depositDetailMapper;

    /**
     * 列表页数据查询
     */
    public CommonReturnData listDepositInfo(int page, int pageSize, Long supplierId, String supplierName, Integer currencyType, Integer depositState) {
        try{
            int allNum = depositInfoMapper.countDepositInfoByCondition(supplierId, supplierName, currencyType, depositState);
            Map<String, Object> result = new HashMap<String, Object>();
            if (allNum == 0) {
                result.put("list", Collections.EMPTY_LIST);
                result.put("total", 0);
                result.put("page", page);
                return CommonReturnData.successRet(result);
            } else {
                int offset = (page - 1) * pageSize;
                int limit = pageSize;
                RowBounds rowBounds = new RowBounds(offset, limit);

                List<DepositInfo> depositInfos = depositInfoMapper.getDepositInfoByCondition(supplierId, supplierName, currencyType, depositState, rowBounds);
                List<DepositInfoVO> depositInfovos = new ArrayList<DepositInfoVO>();
                for(DepositInfo info : depositInfos){
                    DepositInfoVO infovo;
                    infovo = ConvertUtil.convert2DepositInfoVO(info);
                    depositInfovos.add(infovo);
                }
                result.put("list", depositInfovos);
                result.put("total", allNum);
                result.put("page", page);
                return CommonReturnData.successRet(result);
            }
        } catch (Exception e) {
            LOGGER.error("listDepositInfo execute fail, e={}", e);
            return CommonReturnData.errorRet(e.toString());
        }
    }

    /**
     * 获取所有供应商名称
     */
    /*
    @Override
    public CommonReturnData listAllMerchantName() {
        try {
            List<String> merchantNames = depositInfoMapper.getAllMerchantName();
            Map<String, Object> result = new HashMap<>();
            result.put("list", merchantNames);
            result.put("total", merchantNames.size());
            return CommonReturnData.successRet(result);
        } catch (Exception e) {
            LOGGER.error("listAllMerchantName execute fail, e={}", e);
            return CommonReturnData.errorRet(e.toString());
        }
    }*/

    /**
     * 查询商家信息
     *
     * @param supplierId
     */
    public CommonReturnData getDepositInfoByMerchantId(Long supplierId) {
        try {
            DepositInfo depositInfo = depositInfoMapper.getDepositInfoByMerchantId(supplierId);
            List<DepositInfo> info = new ArrayList<DepositInfo>();
            info.add(depositInfo);
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("list", info);
            result.put("total",1);
            return CommonReturnData.successRet(result);
        } catch (Exception e) {
            LOGGER.error("getDepositInfoByMerchantId execute fail, e={}", e);
            return CommonReturnData.errorRet(e.toString());
        }
    }

    /**
     * 获取所有币种
     */
    /*
    @Override
    public CommonReturnData listAllCurrency() {
        try {
            List<Integer> currencyType = depositInfoMapper.getAllCurrency();
            Map<String, Object> result = new HashMap<>();
            result.put("list", currencyType);
            result.put("total", currencyType.size());
            return CommonReturnData.successRet(result);
        } catch (Exception e) {
            LOGGER.error("listAllCurrency execute fail, e={}", e);
            return CommonReturnData.errorRet(e.toString());
        }
    }*/

    /**
     * 获取列表下拉框信息
     */
    public CommonReturnData listCommonData() {
        try {
            List<Integer> currencyType = depositInfoMapper.getAllCurrency();
            Map<Integer,String> currencyMap = new HashMap<Integer,String>();
            for(Integer type : currencyType) {
                currencyMap.put(type, Currency.genEnumByIntValueSt(type).getName());
            }
            List<String> merchantNames = depositInfoMapper.getAllMerchantName();
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("currency", currencyMap);
            result.put("merchantName",merchantNames);
            return CommonReturnData.successRet(result);
        } catch (Exception e) {
            LOGGER.error("listCommonData execute fail, e={}", e);
            return CommonReturnData.errorRet(e.toString());
        }
    }

    /**
     * 保证金余额查询接口
     */
    public CommonReturnData getDepositBalance(Long supplierId) {
        try {
            BigDecimal depositBalance = depositInfoMapper.getDepositBalancebyMerchantId(supplierId);
            Integer currencyType = depositInfoMapper.getCurrencyTypeByMerchantId(supplierId);
            Map<String,Object> result = new HashMap<String,Object>();
            result.put("currency",currencyType);
            result.put("balance",depositBalance);
            return CommonReturnData.successRet(result);
        } catch (Exception e) {
            LOGGER.error("getDepositBalance execute fail,contractId={}, e={}", supplierId, e);
            return CommonReturnData.errorRet(e.toString());
        }
    }

    /**
     * 统一计算更新保证金余额接口 保证金状态
     */
    public CommonReturnData updateDepositBalance(Long supplierId) {
        try {
            /**
             * 保证金余额：应收款金额之和- "应收状态"为"终止收款"的（"应收款金额"-"应收已核销金额"）之和
             * -  "应付状态"为"已完成"应付款金额之和
             */
            BigDecimal depositNeeded = depositInfoMapper.getDepositNeededBySupplierId(supplierId);
            BigDecimal depositTerminated = depositDetailMapper.getBalanceNeedToMinus(supplierId);
            BigDecimal depositPayed = depositDetailMapper.getAllPayedBySupplierId(supplierId);
            //double depositBalance = depositNeeded - depositTerminated - depositPayed;
            BigDecimal depositBalance = depositNeeded.subtract(depositTerminated).subtract(depositPayed);
            depositInfoMapper.updateDepositBalancebyMerchantId(supplierId,depositBalance);

            /**
             * 新增明细后，判断所有保证金明细中应收款金额≠0数据，转账汇款收款方式的应收状态是否有"核销中"
             * 是则保证金状态为"待缴纳"
             * 否则保证金状态为"已缴纳"
             */
            int count = depositDetailMapper.countBalanceState(supplierId);
            //保证金状态   0：代缴纳   1：已缴纳
            int depositState = 0;
            if(count != 0) {
                depositState = 1;
            }
            depositInfoMapper.updateDepositState(supplierId,depositState);

            return CommonReturnData.successRet("updateDepositBalance successfully");
        } catch (Exception e) {
            LOGGER.error("updateDepositBalance execute fail, e={}", e);
            return CommonReturnData.errorRet(e.toString());
        }
    }

    @OperationLogAnnotation
    public void getTest() {
        System.out.println("AOPtest");
    }

}
