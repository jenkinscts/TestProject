package com.cts.o2.dao;

import java.util.List;

import com.cts.o2.domain.BillingDetails;
import com.cts.o2.domain.CustomerEntity;
import com.mongodb.WriteResult;

/**
 * Created by cts1 on 3/3/14.
 */
public interface CustomerRepository {


    public void createCollection();

    public void dropCollection();

    public List<CustomerEntity> getAllCustomer();

    public void saveCustomer(CustomerEntity customer);

    public CustomerEntity getCustomer(int customerId);

    public WriteResult updateCustomer(int customerId,CustomerEntity customerEntity);

    public void deleteCustomer(int customerId);

    public WriteResult updateBillingDetails(int customerId,BillingDetails billingDetails);

    public WriteResult updateCalls(int customerId,int calls);

    public WriteResult updateSMS(int customerId,int sms);

    public WriteResult updateBalance(int customerId,double balance);

}
