package com.hcarrot.example.module.expense.service;

import com.hcarrot.example.CommonReturnData;
import com.hcarrot.example.common.dao.mapper.DepositDetailMapper;
import com.hcarrot.example.common.dao.mapper.DepositInfoMapper;
import com.hcarrot.example.common.dao.meta.entity.DepositDetail;
import com.hcarrot.example.common.dao.meta.entity.DepositInfo;
import com.hcarrot.example.module.expense.annotation.OperationLogAnnotation;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hurenjian on 2018/8/6.
 */

@Service
public class DepositDetailServiceImp implements DepositDetailService{

    private static final Logger LOGGER = LoggerFactory.getLogger("depositDetail");

    @Resource
    private DepositDetailMapper depositDetailMapper;

    @Resource
    private DepositInfoMapper depositInfoMapper;

    @Resource
    private  DepositInfoService depositInfoService;

    /**
     * 查询数据
     *  @param page
     * @param pageSize
     * @param supplierId
     */
    public CommonReturnData listDepositDetailByMerchantId(int page, int pageSize, Long supplierId) {
        try{
            int allNum = depositDetailMapper.countDepositDetailByMerchantId(supplierId);
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

                List<DepositDetail> depositDetails = depositDetailMapper.getDepositDetailByMerchantId(supplierId, rowBounds);
                result.put("list", depositDetails);
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
     * 插入保证金明细数据
     */
    @OperationLogAnnotation
    public CommonReturnData insertDepositDetail(String systemNo, Long supplierId, String merchantName, String companyName,
                                         String bu, int payType, Integer currencyType, BigDecimal contractNeedAmount,
                                         BigDecimal contractAddAmount, String contractNo) {
        try {
            Integer realCurrency = depositInfoMapper.getCurrencyTypeByMerchantId(supplierId);

            if(realCurrency == null){
                DepositInfo depositInfo = new DepositInfo();
                depositInfo.setSupplierId(supplierId);
                depositInfo.setSupplierName(merchantName);
                depositInfo.setCurrencyType(currencyType);
                depositInfo.setDepositNeeded(contractNeedAmount);
                /*********************************************************
                 * 是否要赋值 保证金应缴总额 保证金实收总额 保证金余额
                 ********************************************************/
                depositInfoMapper.insertDepositInfo(depositInfo);
            }else if(!realCurrency.equals(currencyType)) {
                LOGGER.error("insertDepositDetail merchantId={}, currencyName={}, currency isnot consistent", supplierId, currencyType);
                return CommonReturnData.errorRet("currencyName isnot consistent");
            }
            //contractNeedAmount和contractAddAmount不能同时为空  不能同时有值
            if((contractNeedAmount != null & contractAddAmount != null)|(contractNeedAmount == null & contractAddAmount == null)) {
                LOGGER.error("insertDepositDetail contractNeedAmount={}, contractAddAmount={} are wrong",  contractNeedAmount, contractAddAmount);
                return CommonReturnData.errorRet("contractNeedAmount and contractAddAmount are wrong");
            }

            DepositDetail depositDetail = new DepositDetail();
            depositDetail.setSupplierId(supplierId);
            depositDetail.setCompanyName(companyName);
            if(bu != null){
                depositDetail.setBuName(bu);
            }
            depositDetail.setPayType(payType);
            depositDetail.setContractNeedAmount(contractNeedAmount);
            depositDetail.setContractAddAmount(contractAddAmount);
            depositDetail.setContractNo(contractNo);

            //判断应收款
            BigDecimal depositBalance = depositInfoMapper.getDepositBalancebyMerchantId(supplierId);
            BigDecimal zero = BigDecimal.ZERO;
            BigDecimal diff = contractNeedAmount.subtract(depositBalance);
            if(contractNeedAmount != null & diff.compareTo(zero) <= 0) {
                depositDetail.setReceivableAmount(zero);
                //应收状态   0核销中  1 收款完成  2终止收款
                depositDetail.setReceivableState(1);
                // 合同生效标识 0未生效  1生效
                depositDetail.setContractState(1);
                /******************************************************************************
                 * 保证金缴纳状态通知接口
                 * 触发条件：
                 * 1、保证金应收款金额为0，触发通知进销存
                 * 2、保证金已缴纳，即转账汇款应收状态更新为"收款完成"，货款抵扣应收状态更新为"核销中"，触发通知进销存
                 * 3、操作"加急"
                 ******************************************************************************/

            } else if((contractNeedAmount != null & diff.compareTo(zero) > 0)){
                depositDetail.setReceivableAmount(diff);
                // 合同生效标识 0未生效  1生效
                depositDetail.setContractState(0);
                //修改保证金余额
                //depositInfoMapper.updateDepositBalancebyMerchantId(merchantId, 0);
                /*******************************************************************************
                 * 通知进销存 生成应收单号
                 ******************************************************************************/
                depositDetail.setReceivableNo("No1");
                //应收状态  0：核销  1：收款完成
                depositDetail.setReceivableState(0);

                //payType = 0 为转账汇款 ||payType=1为货款抵扣 则直接生成应收单号 应收状态为核销中
                if(payType == 1){
                    /******************************************************************************
                     * 保证金缴纳状态通知接口
                     * 触发条件：
                     * 1、保证金应收款金额为0，触发通知进销存
                     * 2、保证金已缴纳，即转账汇款应收状态更新为"收款完成"，货款抵扣应收状态更新为"核销中"，触发通知进销存
                     * 3、操作"加急"
                     ******************************************************************************/
                }
            }
            if(contractAddAmount != null) {
                depositDetail.setReceivableAmount(contractAddAmount);
                /*******************************************************************************
                 * 通知进销存 生成应收单号
                 ******************************************************************************/
                depositDetail.setReceivableNo("No2");
                //应收状态  0：核销  1：收款完成
                depositDetail.setReceivableState(0);

                //payType = 0 为转账汇款 ||payType=1为货款抵扣 则直接生成应收单号 应收状态为核销中
                if(payType == 1){
                    /******************************************************************************
                     * 保证金缴纳状态通知接口
                     * 触发条件：
                     * 1、保证金应收款金额为0，触发通知进销存
                     * 2、保证金已缴纳，即转账汇款应收状态更新为"收款完成"，货款抵扣应收状态更新为"核销中"，触发通知进销存
                     * 3、操作"加急"
                     ******************************************************************************/
                }
            }

            depositDetailMapper.insertDepositDetail(depositDetail);
            return CommonReturnData.successRet("depositDetail inserted successfully");
        }  catch (Exception e) {
            LOGGER.error("insertDepositDetail execute fail,contractId={}, e={}", contractNo, e);
            return CommonReturnData.errorRet(e.toString());
        }
    }

    /**
     * 保证金应收款应付款完成通知
     * type款项类型  0：应收   1:应付
     * contractId：合同编号  outId：应收/应付单号  state：应收/应付状态（应收--核销中/收款完成/终止收款；应付--结算中/已完结/已取消）
     */
    public CommonReturnData updateReceivePayStatus(Integer type, String contractNo, String outId, int state, BigDecimal amount, BigDecimal receivableOffsetAmount) {
        try {
            if(type != 0 & type != 1) {
                LOGGER.error("insertDepositDetail contractId={}, type is wrong", contractNo);
                return CommonReturnData.errorRet("type is wrong");
            }

            /**
             * 可以用于处理type和state的类型转换 Enum
             */

            //获取合同对应的merchantId
            int urgentFlag = depositDetailMapper.getUrgentFlagByContractId(contractNo);
            Long supplierId = depositDetailMapper.getSupplierIdByContractId(contractNo);
            //DepositInfo depositInfo = depositInfoMapper.getDepositInfoByMerchantId(merchantId);
            //double depositBalance = depositInfo.getDepositBalance();

            if( type == 0) {
                //更新应收状态
                depositDetailMapper.updateReceivableState(contractNo, outId, state, amount, receivableOffsetAmount );

                //保证金已缴纳，即转账汇款应收状态更新为"收款完成"
                if(state == 1){
                    /******************************************************************************
                     * 保证金缴纳状态通知接口
                     * 触发条件：
                     * 1、保证金应收款金额为0，触发通知进销存
                     * 2、保证金已缴纳，即转账汇款应收状态更新为"收款完成"，货款抵扣应收状态更新为"核销中"，触发通知进销存
                     * 3、操作"加急"
                     ******************************************************************************/

                    //更新合同状态
                    depositDetailMapper.updateContractState(contractNo,1);
                }

                /***************************************************************
                 * 如果应收完成  加急状态取消 state=1表示应收完成
                 ***************************************************************/
                if(urgentFlag == 1 & state == 1) {
                    depositDetailMapper.updateUrgentFlag(contractNo,0);
                    int countUrgent = depositDetailMapper.countUrgentFlagByMerchantId(supplierId);
                    if(countUrgent == 0){
                        depositInfoMapper.updateUrgentMerchant(supplierId,0);
                    }
                }

                /********************************************************************************
                 * 保证金缴纳状态通知接口
                 * 触发条件：
                 * 1、保证金应收款金额为0，触发通知进销存
                 * 2、保证金已缴纳，即转账汇款应收状态更新为"收款完成"，货款抵扣应收状态更新为"核销中"，触发通知进销存
                 * 3、操作"加急"
                 *******************************************************************************/

                //统一更新保证金余额 状态
                depositInfoService.updateDepositBalance(supplierId);

                //更新保证金状态
                //int count = depositDetailMapper.countDepositNeedToPay(supplierId);
                //保证金状态：0为待缴纳  1为已缴纳
                //if(count == 0) {
                   // depositInfoMapper.updateDepositState(supplierId,1);
                //}
                //else {
                //    depositInfoMapper.updateDepositState(supplierId,0);
               // }
                //更新保证金余额接口*************************判断是否需要更新**************************
                //depositBalance = depositBalance - accountReceivable;
                //depositInfoMapper.updateDepositBalancebyMerchantId(merchantId,depositBalance);
            }
            else {
                depositDetailMapper.updatePayableState(contractNo, outId, amount, state);
                //更新保证金余额接口************************判断是否需要更新***************************
                //depositBalance = depositBalance + accountPayable;
                //depositInfoMapper.updateDepositBalancebyMerchantId(merchantId,depositBalance);
                //统一更新保证金余额 状态
                depositInfoService.updateDepositBalance(supplierId);
            }
            return CommonReturnData.successRet("updateReceivePayStatus inserted successfully");
        } catch (Exception e) {
            LOGGER.error("updateReceivePayStatus execute fail,contractId={}, e={}", contractNo, e);
            return CommonReturnData.errorRet(e.toString());
        }
    }

    /**
     * 合同状态通知接口
     * 触发条件：合同流转为"合同已终止""合同已逾期""合同冻结"时，进销存触发通知费用管理系统
     */
    public CommonReturnData updateContractState(String contractNo) {
        try {
            //合同状态：0:"合同已终止"  1:"合同已逾期"  2:"合同冻结"
            depositDetailMapper.updateContractState(contractNo,0);
            /********************************************************************************
             * 合同结束  重新计算余额
             *******************************************************************************/
            Long supplierId = depositDetailMapper.getSupplierIdByContractId(contractNo);
            CommonReturnData ret = depositInfoService.updateDepositBalance(supplierId);
            if(ret.getCode() == 200) {
                return CommonReturnData.successRet("updateContractState inserted successfully");
            } else {
                return CommonReturnData.errorRet(ret.getMessage());
            }
        } catch (Exception e) {
            LOGGER.error("updateReceivePayStatus execute fail,contractId={}, e={}", contractNo, e);
            return CommonReturnData.errorRet(e.toString());
        }
    }

    /**
     * 合同操作加急
     */
    public CommonReturnData updateContractUrgent(String contractNo, int state) {
        try {
            /*******************************************************************************
             ** 通知合同系统
             *******************************************************************************/
            depositDetailMapper.updateUrgentFlag(contractNo, state);

            Long merchantId = depositDetailMapper.getSupplierIdByContractId(contractNo);

            //商户加急： 0 为不加急 1为加急
            depositInfoMapper.updateUrgentMerchant(merchantId,1);

            return CommonReturnData.successRet("updateContractUrgent successfully");
        } catch (Exception e) {
            LOGGER.error("updateReceivePayStatus execute fail,contractId={}, e={}", contractNo, e);
            return CommonReturnData.errorRet(e.toString());
        }
    }

}
