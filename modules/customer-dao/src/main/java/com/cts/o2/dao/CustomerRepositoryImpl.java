package com.cts.o2.dao;

import com.cts.o2.domain.BillingDetails;
import com.cts.o2.domain.CustomerEntity;
import com.mongodb.WriteResult;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


import java.util.Date;
import java.util.List;

/**
 * Created by cts1 on 3/3/14.
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private MongoTemplate mongoTemplate;


    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void init(){
        this.createCollection();
    }


    @Override
    public List<CustomerEntity> getAllCustomer() {
        return mongoTemplate.findAll(CustomerEntity.class);
    }

    @Override
    public void saveCustomer(CustomerEntity customer) {
        BillingDetails billingDetails = new BillingDetails();
        billingDetails.setCalls(100);
        billingDetails.setSms(50);
        billingDetails.setBalance(225.00);
        customer.setBillingDetails(billingDetails);
        customer.setCreated_date(new Date(System.currentTimeMillis()));
        customer.setUpdated_date(new Date(System.currentTimeMillis()));
        mongoTemplate.insert(customer);
    }

    @Override
    public CustomerEntity getCustomer(int customerId) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        return mongoTemplate.findOne(query,CustomerEntity.class);
    }

    @Override
    public WriteResult updateCustomer(int customerId, CustomerEntity customerEntity) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        Update update = new Update();
        update.set("firstName",customerEntity.getFirstName());
        update.set("lastName",customerEntity.getLastName());
        update.set("address",customerEntity.getAddress());
        update.set("updated_date",new Date(System.currentTimeMillis()));
        return mongoTemplate.updateFirst(query, update, CustomerEntity.class);

    }

    @Override
    public void deleteCustomer(int customerId) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        mongoTemplate.remove(query,CustomerEntity.class);
    }

    @Override
    public WriteResult updateBillingDetails(int customerId, BillingDetails billingDetails) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        Update update = new Update();
        update.set("billingDetails",billingDetails);
        update.set("updated_date",new Date(System.currentTimeMillis()));
        return mongoTemplate.updateFirst(query, update, CustomerEntity.class);

    }

    @Override
    public WriteResult updateCalls(int customerId, int calls) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        CustomerEntity customerEntity = mongoTemplate.findOne(query,CustomerEntity.class);
        BillingDetails billingDetails = customerEntity.getBillingDetails();
        billingDetails.setCalls(calls);

        Update update = new Update();
        update.set("billingDetails",billingDetails);
        update.set("updated_date",new Date(System.currentTimeMillis()));

        return mongoTemplate.updateFirst(query, update, CustomerEntity.class);
    }

    @Override
    public WriteResult updateSMS(int customerId, int sms) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        CustomerEntity customerEntity = mongoTemplate.findOne(query,CustomerEntity.class);
        BillingDetails billingDetails = customerEntity.getBillingDetails();
        billingDetails.setSms(sms);

        Update update = new Update();
        update.set("billingDetails",billingDetails);
        update.set("updated_date",new Date(System.currentTimeMillis()));

        return mongoTemplate.updateFirst(query, update, CustomerEntity.class);
    }

    @Override
    public WriteResult updateBalance(int customerId, double balance) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        CustomerEntity customerEntity = mongoTemplate.findOne(query,CustomerEntity.class);
        BillingDetails billingDetails = customerEntity.getBillingDetails();
        billingDetails.setBalance(balance);

        Update update = new Update();
        update.set("billingDetails",billingDetails);
        update.set("updated_date",new Date(System.currentTimeMillis()));

        return mongoTemplate.updateFirst(query, update, CustomerEntity.class);
    }

    @Override
    public void createCollection() {
        if(!mongoTemplate.collectionExists(CustomerEntity.class)){
            mongoTemplate.createCollection(CustomerEntity.class);
        }
    }

    @Override
    public void dropCollection() {
        if(mongoTemplate.collectionExists(CustomerEntity.class)){
            mongoTemplate.dropCollection(CustomerEntity.class);
        }
    }
}
