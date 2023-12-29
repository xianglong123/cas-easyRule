package com.cas.bo;

import java.util.List;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-28 10:34
 **/
public class RuleGroup {

    private String id;
    private String groupName;
    private String groupDesc;

    private List<RuleMVEL> rm;

    public List<RuleMVEL> getRm() {
        return rm;
    }

    public void setRm(List<RuleMVEL> rm) {
        this.rm = rm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }
}
