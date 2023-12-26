package com.cas.test;

import com.cas.ApplicationTest;
import com.cas.bo.MarketBaseBO;
import com.cas.service.CustomRuleService;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.RuleDefinition;
import org.jeasy.rules.support.composite.ConditionalRuleGroup;
import org.jeasy.rules.support.composite.UnitRuleGroup;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FireTest {

    @Resource
    private CustomRuleService customRuleService;

    @Test
    public void test() {
//        Rule rule = new RuleBuilder()
//                .name("weather rule")
//                .description("if it rains then take an umbrella")
//                .priority(0)
//                .when(facts -> customRuleService.condition(facts.get("baseBo")))
//                .then(facts -> customRuleService.action(facts.get("baseBo")))
//                .build();
        Rule rule = new MVELRule()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when("baseBo.mobileNo == '15811317734'")
                .then("System.out.println(\"It rains, take an umbrella!\");");
        Rule rule2 = new MVELRule()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when("baseBo.behaviorData['name'] == 'xl'")
                .then("System.out.println(\"It rains, take an umbrella!222222222222\");");
        Facts facts = new Facts();
        facts.put("baseBo", getObject());
        // define rules
        Rules rules = new Rules();
//        UnitRuleGroup ruleGroup = new UnitRuleGroup("aa", "2222");
//        ActivationRuleGroup ruleGroup = new ActivationRuleGroup("aa", "2222");
        ConditionalRuleGroup ruleGroup = new ConditionalRuleGroup("aa", "2222");
        ruleGroup.addRule(rule2);

        rules.register(ruleGroup);

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);

    }


    /**
     *  in a programmatic way with a fluent API
     *  以编程的方式使用流畅的API
     */
    @Test
    public void testAPI() {
        Rule rule = new RuleBuilder()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when(facts -> facts.get("rain").equals(true))
                .then(facts -> System.out.println("It rains, take an umbrella!"))
                .build();

    }

    /**
     * using an Expression Language
     * 使用表达语言
     *
     */
    @Test
    public void testExpression() {
        Rule rule = new MVELRule()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when("rain == true")
                .then("System.out.println(\"It rains, take an umbrella!\");");
        
    }

    /**
     * using a rule descriptor
     * 使用规则描述
     *
     */
    @Test
    public void testXML() throws Exception {
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rule rule = ruleFactory.createRule(new FileReader("/Users/xianglong/IdeaProjects/cas-easyRule/src/test/resources/weather-rule.yml"));
        
    }


    private static MarketBaseBO getObject() {
        MarketBaseBO baseBO = new MarketBaseBO();
        baseBO.setMobileNo("15811317734");
        baseBO.setBehaviorCode("1005");
        baseBO.setActiveTime(LocalDateTime.now());
        baseBO.setActiveSource("H5");

        Map<String, Object> data = new HashMap<>();
        data.put("name", "xl");
        data.put("age", 24);
        baseBO.setBehaviorData(data);
        return baseBO;
    }


}

