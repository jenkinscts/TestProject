package com.cts.o2.dao;

import com.cts.o2.domain.base.CustomerEntity;
import com.mongodb.WriteResult;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.sql.Timestamp;
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
        customer.setCreated_date(new Timestamp(System.currentTimeMillis()));
        customer.setUpdated_date(new Timestamp(System.currentTimeMillis()));
        mongoTemplate.insert(customer);
    }

    @Override
    public CustomerEntity getCustomer(int customerId) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        return mongoTemplate.findOne(query,CustomerEntity.class);
    }

    @Override
    public WriteResult updateCustomer(int customerId, String name) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        Update update = new Update();
        update.set("firstName",name);
        update.set("updated_date",new Timestamp(System.currentTimeMillis()));
        return mongoTemplate.updateFirst(query,update,CustomerEntity.class);

    }

    @Override
    public void deleteCustomer(int customerId) {
        Query query = new Query(Criteria.where("customerId").is(customerId));
        mongoTemplate.remove(query,CustomerEntity.class);
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
