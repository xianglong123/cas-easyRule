package com.cas.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-26 21:40
 **/
@TableName("cas_rule_info")
public class CasRuleInfo {

    @TableId(type = IdType.AUTO)
    private String id;
    private String name;
    private Integer priority;
    private String description;
    private String rCondition;
    private String rAction;
    private String serviceName;
    private String serviceAlias;

    private Date createDate;
    private Date createTime;
    private Date updateTime;


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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
