package com.project.lld;

import lombok.Data;

@Data
public class Item {
    private final String name;
    private int quantity;
    private final double rate;
    private final boolean isGrocery;
    private double totalAmount;
    private int discount;
    private boolean subscribedAndSaved;

    public Item(String name, int quantity, double rate, boolean isGrocery, boolean subscribedAndSaved) {
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
        this.isGrocery = isGrocery;
        this.discount = 0;
        this.subscribedAndSaved = subscribedAndSaved;
        computeTotalAmount();
    }

    public void incrementQuantity(){
        quantity += 1;
        computeTotalAmount();
    }

    public void applyDiscount(int discount) {
        this.discount = discount;
        computeTotalAmount();
    }

    public void removeSubscription(){
        this.subscribedAndSaved = false;
        this.discount = 0;
        computeTotalAmount();
    }

    private void computeTotalAmount() {
        this.totalAmount = this.rate * this.quantity;
        if(this.discount > 0)
            this.totalAmount = this.totalAmount * 0.01 * this.discount;
    }
}
