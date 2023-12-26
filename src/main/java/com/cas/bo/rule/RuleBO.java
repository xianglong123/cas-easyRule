package com.cas.bo.rule;

/**
 * @description: 规则顶级类
 * @author: xianglong
 * @create: 2023-12-26 21:07
 **/
public abstract class RuleBO {

    /**
     * 手机号
     */
    private String mobileNo;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
