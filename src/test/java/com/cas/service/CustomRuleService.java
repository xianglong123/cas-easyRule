package com.cas.service;

import com.cas.bo.MarketBaseBO;

/**
 * @description: 自定义规则
 * @author: xianglong
 * @create: 2023-12-22 10:36
 **/
public interface CustomRuleService {

    /**
     * 规则判断
     */
    Boolean condition(MarketBaseBO bo);

    /**
     * true执行结果
     */
    void action(MarketBaseBO bo);

}
