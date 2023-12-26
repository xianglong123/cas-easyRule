package com.cas.test;

import cn.hutool.extra.spring.SpringUtil;
import com.cas.RuleApplication;
import com.cas.bo.rule.RuleBO;
import com.cas.bo.rule.SimpleRuleBO;
import com.cas.service.RuleService;
import com.cas.service.impl.RuleSimple2ServiceImpl;
import com.cas.service.impl.RuleSimpleServiceImpl;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.support.composite.ConditionalRuleGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-26 21:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleTest {

    @Test
    public void test() {
        Map<String, RuleService> map = new HashMap<>();
        map.put("ruleSimpleServiceImpl", SpringUtil.getBean("ruleSimpleServiceImpl"));
        map.put("ruleSimple2ServiceImpl", SpringUtil.getBean("ruleSimple2ServiceImpl"));

        Rule rule2 = new MVELRule()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when("bo.mobileNo == '119'")
                .then("cu['ruleSimple2ServiceImpl'].execute(bo);");
        Facts facts = new Facts();
        facts.put("bo", getObject());
        facts.put("cu", map);
        // define rules
        Rules rules = new Rules();
        ConditionalRuleGroup ruleGroup = new ConditionalRuleGroup("aa", "2222");
        ruleGroup.addRule(rule2);

        rules.register(ruleGroup);
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }

    private RuleBO getObject() {
        SimpleRuleBO bo = new SimpleRuleBO();
        bo.setMobileNo("119");
        bo.setDescription("2222");
        return bo;
    }


}
