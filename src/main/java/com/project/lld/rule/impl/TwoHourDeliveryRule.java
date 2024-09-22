package com.project.lld.rule.impl;

import com.project.lld.ShoppingCart;
import com.project.lld.rule.Rule;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TwoHourDeliveryRule implements Rule {
    private final double primeMinPrice;

    @Override
    public boolean isRuleApplicable(ShoppingCart cart) {
        return cart.getCustomer().isPrime() && cart.isAllGroceryItems() && cart.getCartTotal() > this.primeMinPrice;
    }

    @Override
    public void executeRule(ShoppingCart cart) {
        cart.setTwoHourDeliveryCharge(0);
    }
}
