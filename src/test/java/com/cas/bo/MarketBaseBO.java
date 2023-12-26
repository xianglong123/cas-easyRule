package com.cas.bo;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @description: 营销活动基础对象
 * @author: xianglong
 * @create: 2023-12-22 10:32
 **/
public class MarketBaseBO {

    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 行为码
     */
    private String behaviorCode;
    /**
     * 活动时间
     */
    private LocalDateTime activeTime;
    /**
     * 活动来源
     */
    private String activeSource;
    /**
     * 行为数据
     */
    private Map<String, Object> behaviorData;

    public Map<String, Object> getBehaviorData() {
        return behaviorData;
    }

    public void setBehaviorData(Map<String, Object> behaviorData) {
        this.behaviorData = behaviorData;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getBehaviorCode() {
        return behaviorCode;
    }

    public void setBehaviorCode(String behaviorCode) {
        this.behaviorCode = behaviorCode;
    }

    public LocalDateTime getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(LocalDateTime activeTime) {
        this.activeTime = activeTime;
    }

    public String getActiveSource() {
        return activeSource;
    }

    public void setActiveSource(String activeSource) {
        this.activeSource = activeSource;
    }
}
