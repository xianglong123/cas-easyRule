package com.cas.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-26 21:40
 **/
@TableName("cas_rule_act_composite")
public class CasRuleActComposite {

    @TableId(type = IdType.AUTO)
    private String id;
    private String actId;
    private String name;
    private Integer priority;
    private String description;
    private String rCondition;
    private String rAction;
    private String serviceName;
    private String serviceAlias;

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getServiceAlias() {
        return serviceAlias;
    }

    public void setServiceAlias(String serviceAlias) {
        this.serviceAlias = serviceAlias;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
