package com.cas.service.impl;

import com.cas.bo.RuleBaseBO;
import com.cas.service.RuleService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-26 21:12
 **/
@Service
public class RuleSimple2ServiceImpl implements RuleService {

    @Override
    public void execute(RuleBaseBO bo) {
        System.out.println("2222222手机号为 : " + bo.getMobileNo() + "   描述：" + bo.getActivityId());
    }
}
