package com.project.lld.rule.impl;

import com.project.lld.Item;
import com.project.lld.ShoppingCart;
import com.project.lld.rule.Rule;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SubscribedDiscountRule implements Rule {
    private final int discount;
    @Override
    public boolean isRuleApplicable(ShoppingCart cart) {
        return cart.isAllGroceryItems() && cart.getItems().stream().anyMatch(Item::isSubscribedAndSaved);
    }

    @Override
    public void executeRule(ShoppingCart cart) {
        cart.getItems().stream().filter(Item::isSubscribedAndSaved).forEach(item -> item.applyDiscount(this.discount));
        cart.computeCartTotal();
    }
}
