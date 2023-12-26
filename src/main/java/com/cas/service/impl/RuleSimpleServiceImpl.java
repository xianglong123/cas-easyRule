package com.cas.service.impl;

import com.cas.bo.rule.RuleBO;
import com.cas.bo.rule.SimpleRuleBO;
import com.cas.service.RuleService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-26 21:12
 **/
@Service
public class RuleSimpleServiceImpl implements RuleService {

    @Override
    public void execute(RuleBO bo) {
        SimpleRuleBO simpleRuleBO = (SimpleRuleBO) bo;
        System.out.println("手机号为 : " + simpleRuleBO.getMobileNo() + "   描述：" + simpleRuleBO.getDescription());
    }
}
