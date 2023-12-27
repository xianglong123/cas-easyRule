package com.cas.config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cas.bo.RuleCacheBO;
import com.cas.bo.RuleMVEL;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-26 22:03
 **/
@Component
public class RuleCacheConfig {

    private static final Logger log = LoggerFactory.getLogger(RuleCacheConfig.class);

    @Resource
    private CasRuleInfoMapper casRuleInfoMapper;

    @Bean
    public RuleCacheBO ruleCacheBO() {
        RuleCacheBO bo = new RuleCacheBO();
        List<CasRuleInfo> infos = casRuleInfoMapper.selectList(null);
        List<RuleMVEL> list = new ArrayList<>();
        Set<String> alias = new HashSet<>();
        infos.forEach(x -> {
            if (alias.contains(x.getServiceAlias())) {
                throw new RuntimeException("别名存在相同，请检查【{" + x.getServiceAlias() + "}】");
            }
            alias.add(x.getServiceAlias());
            RuleMVEL mvel = BeanUtil.copyProperties(x, RuleMVEL.class);
            mvel.setRuleService(SpringUtil.getBean(x.getServiceName()));
            list.add(mvel);
        });
        bo.setRm(list);
        return bo;
    }

}
