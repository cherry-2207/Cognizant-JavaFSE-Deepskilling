package com.demo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(repository);
        customerService.getCustomerDetails(101);
        customerService.getCustomerDetails(102);
        customerService.getCustomerDetails(999);
    }
}