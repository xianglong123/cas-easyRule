package com.cas.bo;

import java.util.Map;

/**
 * @description: 规则顶级类
 * @author: xianglong
 * @create: 2023-12-26 21:07
 **/
public class RuleBaseBO {

    /**
     * 手机号
     */
    private String mobileNo;

    private String activityId;

    private Map<String, Object> behaviorData;

    public Map<String, Object> getBehaviorData() {
        return behaviorData;
    }

    public void setBehaviorData(Map<String, Object> behaviorData) {
        this.behaviorData = behaviorData;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
