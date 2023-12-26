package com.cas.config;

import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cas.bo.RuleCacheBO;
import com.cas.mapper.CasRuleInfoMapper;
import com.cas.mapper.UserMapper;
import com.cas.pojo.CasRuleInfo;
import com.cas.pojo.User;
import com.cas.service.RuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-26 22:03
 **/
@Component
public class RuleCacheConfig {

    private static final Logger log = LoggerFactory.getLogger(RuleCacheConfig.class);

    @Bean
    public RuleCacheBO ruleCacheBO() {
        RuleCacheBO bo = new RuleCacheBO();
        List<CasRuleInfo> infos = getObj();
        if (infos.isEmpty()) {
            log.info("无规则");
            return bo;
        }
        Map<String, RuleService> map = new HashMap<>();
        infos.stream().forEach(x -> map.put(x.getServiceName(), SpringUtil.getBean(x.getServiceName())));
        bo.setMapCache(map);
        return bo;
    }

    private List<CasRuleInfo> getObj() {
        List<CasRuleInfo> list = new ArrayList<>();


        return null;
    }

}
