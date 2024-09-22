package com.project.lld.rule;

import com.project.lld.ShoppingCart;

public interface Rule {
    boolean isRuleApplicable(ShoppingCart cart);
    void executeRule(ShoppingCart cart);
}
