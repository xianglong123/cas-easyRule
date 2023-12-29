package com.cas.config;

import com.cas.bo.RuleBaseBO;
import com.cas.constant.Constants;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: xianglong
 * @create: 2023-12-28 09:21
 **/
public class MyRuleListener implements RuleListener {

    private static final Logger log = LoggerFactory.getLogger(MyRuleListener.class);

    /**
     * 在评估规则之前触发。
     *
     * @param rule 正在被评估的规则
     * @param facts 评估规则之前的已知事实
     * @return 如果规则应该评估，则返回true，否则返回false
     */
    @Override
    public boolean beforeEvaluate(Rule rule, Facts facts) {
        log.info("在评估规则之前触发。");
        String activityId = ((RuleBaseBO) facts.get(Constants.BASE_NAME)).getActivityId();
        String name = rule.getName();
        boolean flag = activityId.equals(name);
        if (!flag) {
            log.info("规则名未匹配，不启动该规则组，activityId=[{}], actId=[{}]", activityId, name);
        }
        return flag;
    }

    /**
     * 在评估规则之后触发
     *
     * @param rule 评估之后的规则
     * @param facts 评估规则之后的已知事实
     * @param evaluationResult 评估结果
     */
    @Override
    public void afterEvaluate(Rule rule, Facts facts, boolean evaluationResult) {
        String activityId = ((RuleBaseBO) facts.get(Constants.BASE_NAME)).getActivityId();
        String name = rule.getName();
        log.info("该对象=【{}】匹配组规则=[{}], 匹配结果=【{}】", activityId, name, evaluationResult);
    }

    /**
     * 运行时异常导致条件评估错误时触发
     *
     * @param rule 评估之后的规则
     * @param facts 评估时的已知事实
     * @param exception 条件评估时发生的异常
     */
    @Override
    public void onEvaluationError(Rule rule, Facts facts, Exception exception) {
        RuleListener.super.onEvaluationError(rule, facts, exception);
    }

    /**
     * 在规则操作执行之前触发。
     *
     * @param rule 当前的规则
     * @param facts 执行规则操作时的已知事实
     */
    @Override
    public void beforeExecute(Rule rule, Facts facts) {
        RuleListener.super.beforeExecute(rule, facts);
    }

    /**
     * 在规则操作成功执行之后触发
     *
     * @param rule t当前的规则
     * @param facts 执行规则操作时的已知事实
     */
    @Override
    public void onSuccess(Rule rule, Facts facts) {
        RuleListener.super.onSuccess(rule, facts);
    }

    /**
     * 在规则操作执行失败时触发
     *
     * @param rule 当前的规则
     * @param facts 执行规则操作时的已知事实
     * @param exception 执行规则操作时发生的异常
     */
    @Override
    public void onFailure(Rule rule, Facts facts, Exception exception) {
        RuleListener.super.onFailure(rule, facts, exception);
    }

}
