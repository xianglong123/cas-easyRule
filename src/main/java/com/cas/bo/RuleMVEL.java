package com.cas.bo;

import com.cas.service.RuleService;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-27 16:16
 **/
public class RuleMVEL {

    private String name;
    private Integer priority;
    private String description;
    private String rCondition;
    private String rAction;
    private String serviceAlias;
    private RuleService ruleService;

    public String getServiceAlias() {
        return serviceAlias;
    }

    public void setServiceAlias(String serviceAlias) {
        this.serviceAlias = serviceAlias;
    }

    public RuleService getRuleService() {
        return ruleService;
    }

    public void setRuleService(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getrCondition() {
        return rCondition;
    }

    public void setrCondition(String rCondition) {
        this.rCondition = rCondition;
    }

    public String getrAction() {
        return rAction;
    }

    public void setrAction(String rAction) {
        this.rAction = rAction;
    }
}
