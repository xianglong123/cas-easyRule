package com.cas.bo;

import com.cas.service.RuleService;

import java.util.Map;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-26 22:02
 **/
public class RuleCacheBO {

    private Map<String, RuleService> mapCache;

    public Map<String, RuleService> getMapCache() {
        return mapCache;
    }

    public void setMapCache(Map<String, RuleService> mapCache) {
        this.mapCache = mapCache;
    }
}
