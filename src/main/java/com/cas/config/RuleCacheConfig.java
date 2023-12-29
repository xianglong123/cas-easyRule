package com.cas.config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cas.bo.RuleCacheBO;
import com.cas.bo.RuleGroup;
import com.cas.bo.RuleMVEL;
import com.cas.mapper.CasRuleActCompositeMapper;
import com.cas.mapper.CasRuleActMapper;
import com.cas.pojo.CasRuleAct;
import com.cas.pojo.CasRuleActComposite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private CasRuleActCompositeMapper casRuleInfoMapper;
    @Resource
    private CasRuleActMapper casRuleActMapper;

    @Bean
    public RuleCacheBO ruleCacheBO() {
        RuleCacheBO bo = new RuleCacheBO();
        List<CasRuleAct> acts = casRuleActMapper.selectList(null);
        List<RuleGroup> rg = new ArrayList<>();
        acts.forEach(x -> {
            RuleGroup group = BeanUtil.copyProperties(x, RuleGroup.class);
            QueryWrapper<CasRuleActComposite> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("act_id", x.getId());
            List<CasRuleActComposite> composites = casRuleInfoMapper.selectList(queryWrapper);
            List<RuleMVEL> list = new ArrayList<>();
            Set<String> alias = new HashSet<>();
            composites.forEach(y -> {
                if (alias.contains(y.getServiceAlias())) {
                    throw new RuntimeException("别名存在相同，请检查【{" + y.getServiceAlias() + "}】");
                }
                alias.add(y.getServiceAlias());
                RuleMVEL mvel = BeanUtil.copyProperties(y, RuleMVEL.class);
                mvel.setRuleService(SpringUtil.getBean(y.getServiceName()));
                list.add(mvel);
            });
            group.setRm(list);
            rg.add(group);
        });
        bo.setRg(rg);
        return bo;
    }

}
