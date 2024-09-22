package com.project.lld;

import com.project.lld.constants.RateConstants;
import com.project.lld.rule.Rule;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShoppingCart {
    private final Customer customer;
    private final List<Item> items;
    private boolean allGroceryItems;
    private double cartTotal;
    private double twoHourDeliveryCharge;
    private double oneDayDeliveryCharge;
    private double twoDayDeliveryCharge;
    private List<Rule> allAppliedRules;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.allGroceryItems = true;
        this.items = new ArrayList<>();
        this.allAppliedRules = new ArrayList<>();
        this.cartTotal = 0;
        reset();
    }

    private void reset() {
        computeCartTotal();
        this.allAppliedRules = new ArrayList<>();

        this.twoHourDeliveryCharge = RateConstants.TWO_HOUR_DELIVERY_CHARGE;
        this.oneDayDeliveryCharge = RateConstants.ONE_DAY_DELIVERY_CHARGE;
        this.twoDayDeliveryCharge = RateConstants.TWO_DAY_DELIVERY_CHARGE;
    }

    public void addItem(Item item){
        items.add(item);
        allGroceryItems = allGroceryItems && item.isGrocery();
        reset();
    }

    public void computeCartTotal(){
        this.cartTotal = this.items.stream().mapToDouble(Item::getTotalAmount).sum();
    }
}
