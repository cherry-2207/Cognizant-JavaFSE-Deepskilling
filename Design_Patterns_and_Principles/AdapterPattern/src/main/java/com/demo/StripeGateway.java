package com.demo;

public class StripeGateway {

    public void chargeCard(double amount) {
        System.out.println("Processing payment of ₹" + amount + " through Stripe.");
    }
}
