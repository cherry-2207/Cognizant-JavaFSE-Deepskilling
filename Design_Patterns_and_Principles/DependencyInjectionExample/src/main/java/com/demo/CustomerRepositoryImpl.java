package com.demo;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {
        // Simulating database access
        if (id == 101) {
            return "Kim";
        } else if (id == 102) {
            return "David";
        } else if (id == 103) {
            return "Kevin";
        }

        return "Customer Not Found";
    }
}
