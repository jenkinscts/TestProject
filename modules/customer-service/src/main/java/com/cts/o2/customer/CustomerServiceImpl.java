package com.cts.o2.customer;

import com.cts.o2.dao.CustomerRepository;
import com.cts.o2.domain.base.CustomerEntity;

import java.util.*;

/**
 * Created by cts1 on 26/2/14.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;


    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerDetails(int customerId) {
       CustomerEntity customerEntity =  getCustomerRepository().getCustomer(customerId);
        return getCustomerFromEntity(customerEntity);

    }


    @Override
    public List<Customer> getAllCustomer() {
        List<CustomerEntity> customerEntityList = getCustomerRepository().getAllCustomer();
        List<Customer> customers = new ArrayList<Customer>();

        for(CustomerEntity customerEntity: customerEntityList){
            Customer customer = getCustomerFromEntity(customerEntity);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        getCustomerRepository().saveCustomer(getCustomerEntityFromCustom(customer));
    }

    @Override
    public void updateCustomer(Customer customer) {
        getCustomerRepository().updateCustomer(customer.getCustomerId(),customer.getFirstName());
    }

    private CustomerEntity getCustomerEntityFromCustom(Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customer.getCustomerId());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        return customerEntity;
    }

    private Customer getCustomerFromEntity(CustomerEntity customerEntity){
        Customer customer = new Customer();
        customer.setCustomerId(customerEntity.getCustomerId());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setBillingAddress("Pune");
        return customer;
    }
}
