# Amazon Shopping Cart
Build an online Shopping cart service

## Problem Statement
Write code that will be used by a Shopping cart service to enforce rules on the order

eg. Offer free 2 day shipping on orders > $35 if customer is not a prime member Offer free 2 day shipping on all orders if customer is a prime member Offer free 1 day shipping for order that are > $125 Offer free 2 hour shipping for prime customer that have > $25 and the items are grocery items

Make this extensible to add other rules in the future Apply a 10% discount if an item has been marked for subscribe and save

I was thinking of creating a Shopping cart class and create one prime member class and other non prime member.
interfaces for Shipping speed calculator and one for discount calculator