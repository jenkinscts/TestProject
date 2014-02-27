package com.cts.o2.customer;

import java.util.*;

/**
 * Created by cts1 on 26/2/14.
 */
public class CustomerServiceImpl implements CustomerService {

    private static final TreeMap<Integer,Customer> customerMap = new TreeMap<Integer, Customer>();

    static {
        Customer c1 = new Customer();
        c1.setCustomerId(1);
        c1.setFirstName("Sankalp");
        c1.setLastName("Kale");
        c1.setBillingAddress("Magarpatta City Pune");

        Customer c2 = new Customer();
        c2.setCustomerId(2);
        c2.setFirstName("Nihar");
        c2.setLastName("Patil");
        c2.setBillingAddress("PipleSaudagar  Pune");

        Customer c3 = new Customer();
        c3.setCustomerId(3);
        c3.setFirstName("Parag");
        c3.setLastName("Patil");
        c3.setBillingAddress("Magarpatta City Pune");

        customerMap.put(1,c1);
        customerMap.put(2,c2);
        customerMap.put(3,c3);


    }


    @Override
    public Customer getCustomerDetails(int customerId) {
        return customerMap.get(customerId);
    }


    @Override
    public List<Customer> getAllCustomer() {
        Collection<Customer> customerCollection = customerMap.values();
        return  new ArrayList<Customer>(customerCollection);
    }
}
