package com.cas.service.impl;

import com.cas.bo.MarketBaseBO;
import com.cas.service.CustomRuleService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-22 11:00
 **/
@Service
public class ManCustomRuleServiceImpl implements CustomRuleService {

    @Override
    public Boolean condition(MarketBaseBO bo) {
        return bo.getMobileNo().equals("15811317734");
    }

    @Override
    public void action(MarketBaseBO bo) {
        System.out.println("成功判断执行");
    }
}
