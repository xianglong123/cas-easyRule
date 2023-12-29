package com.cas.util;

import com.cas.config.MyRuleListener;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

public class RuleHelper {

    public static RulesEngine generateRuleEngine(){
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.registerRuleListener(new MyRuleListener());
        return rulesEngine;
    }


}