package com.cas.test;

import com.cas.bo.WeatherRule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import org.junit.Test;

import java.io.FileReader;


public class FireTest {

    /**
     * 测试通过注解配置规则
     */
    @Test
    public void testAnnotations() {
        // 创建规则对象
        WeatherRule rule = new WeatherRule();
        fire(rule);
    }

    public static void fire(Object obj) {
        // define facts
        Facts facts = new Facts();
        facts.put("rain", true);

        // define rules
        Rules rules = new Rules();
        rules.register(obj);

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
        fire(rule);
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
        fire(rule);
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
        fire(rule);
    }
}

