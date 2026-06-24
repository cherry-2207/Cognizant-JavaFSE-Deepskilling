package com.demo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new RazorpayGateway());
        payPalProcessor.processPayment(1000);
        stripeProcessor.processPayment(2500);
        razorpayProcessor.processPayment(5000);
    }
}