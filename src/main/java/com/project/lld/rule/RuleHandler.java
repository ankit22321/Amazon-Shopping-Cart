package com.project.lld.rule;

import com.project.lld.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class RuleHandler {
    private final List<Rule> rules = new ArrayList<>();

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public void applyRules(ShoppingCart cart) {
        for (Rule rule : this.rules){
            if (rule.isRuleApplicable(cart)){
                rule.executeRule(cart);
                cart.getAllAppliedRules().add(rule);
            }
        }
    }
}
