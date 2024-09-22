package com.project.lld.rule.impl;

import com.project.lld.ShoppingCart;
import com.project.lld.rule.Rule;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OneDayDeliveryRule implements Rule {
    private final double nonPrimeMinPrice;

    @Override
    public boolean isRuleApplicable(ShoppingCart cart) {
        return cart.getCustomer().isPrime() || (cart.isAllGroceryItems() && cart.getCartTotal() > this.nonPrimeMinPrice);
    }

    @Override
    public void executeRule(ShoppingCart cart) {
        cart.setOneDayDeliveryCharge(0);
    }
}
