package com.cts.o2.dao;

import java.util.List;

import com.cts.o2.domain.base.CustomerEntity;
import com.mongodb.WriteResult;

/**
 * Created by cts1 on 3/3/14.
 */
public interface CustomerRepository {

    public List<CustomerEntity> getAllCustomer();

    public void saveCustomer(CustomerEntity customer);

    public CustomerEntity getCustomer(int customerId);

    public WriteResult updateCustomer(int customerId, String firstName);

    public void deleteCustomer(int customerId);

    public void createCollection();

    public void dropCollection();
}
