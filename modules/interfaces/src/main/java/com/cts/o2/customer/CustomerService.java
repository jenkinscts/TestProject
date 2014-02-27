package com.cts.o2.customer;

import java.util.List;

/**
 * Created by cts1 on 26/2/14.
 */
public interface CustomerService {

    public Customer getCustomerDetails(int customerId);

    public List<Customer> getAllCustomer();
}
