package com.cts.o2.customer;

import com.cts.o2.billing.BillingDetailsVO;
import com.cts.o2.dao.CustomerRepository;
import com.cts.o2.domain.BillingDetails;
import com.cts.o2.domain.CustomerEntity;

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
    public CustomerVO getCustomerDetails(int customerId) {
       CustomerEntity customerEntity =  getCustomerRepository().getCustomer(customerId);
        return getCustomerVOFromEntity(customerEntity);

    }


    @Override
    public List<CustomerVO> getAllCustomer() {
        List<CustomerEntity> customerEntityList = getCustomerRepository().getAllCustomer();
        List<CustomerVO> customerVOs = new ArrayList<CustomerVO>();

        for(CustomerEntity customerEntity: customerEntityList){
            CustomerVO customerVO = getCustomerVOFromEntity(customerEntity);
            customerVOs.add(customerVO);
        }
        return customerVOs;
    }

    @Override
    public void addCustomer(CustomerVO customerVO) {
        getCustomerRepository().saveCustomer(getCustomerEntityFromCustomerVO(customerVO));
    }

    @Override
    public void updateCustomer(CustomerVO customerVO) {
        getCustomerRepository().updateCustomer(customerVO.getCustomerId(), getCustomerEntityFromCustomerVO(customerVO));
    }

    @Override
    public void deleteCustomer(int customerId) {
        getCustomerRepository().deleteCustomer(customerId);
    }

    @Override
    public BillingDetailsVO getBillingDetails(int customerId) {
       CustomerEntity customerEntity = getCustomerRepository().getCustomer(customerId);
       return getBillingDetailsVOFromEntity(customerEntity);
    }

    @Override
    public List<BillingDetailsVO> getAllBillingDetails() {
        List<CustomerEntity> customerEntityList = getCustomerRepository().getAllCustomer();
        List<BillingDetailsVO> billingDetailsVOList = new ArrayList<BillingDetailsVO>();

        for(CustomerEntity customerEntity : customerEntityList){
            BillingDetailsVO billingDetailsVO = getBillingDetailsVOFromEntity(customerEntity);
            billingDetailsVOList.add(billingDetailsVO);
        }
        return  billingDetailsVOList;
    }

    @Override
    public void addBillingDetails(BillingDetailsVO billingDetailsVO) {
        getCustomerRepository().updateBillingDetails(billingDetailsVO.getCustomerId(),
                getBillingDetailsFromVO(billingDetailsVO));
    }

    @Override
    public void updateBillingDetails(BillingDetailsVO billingDetailsVO) {
        getCustomerRepository().updateBillingDetails(billingDetailsVO.getCustomerId(),
                getBillingDetailsFromVO(billingDetailsVO));
    }

    private CustomerEntity getCustomerEntityFromCustomerVO(CustomerVO customerVO){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerVO.getCustomerId());
        customerEntity.setFirstName(customerVO.getFirstName());
        customerEntity.setLastName(customerVO.getLastName());
        customerEntity.setAddress(customerVO.getBillingAddress());
        return customerEntity;
    }

    private CustomerVO getCustomerVOFromEntity(CustomerEntity customerEntity){
        CustomerVO customerVO = new CustomerVO();
        customerVO.setCustomerId(customerEntity.getCustomerId());
        customerVO.setFirstName(customerEntity.getFirstName());
        customerVO.setLastName(customerEntity.getLastName());
        customerVO.setBillingAddress(customerEntity.getAddress());
        return customerVO;
    }


    private BillingDetailsVO getBillingDetailsVOFromEntity(CustomerEntity customerEntity){
        BillingDetailsVO billingDetailsVO = new BillingDetailsVO();
        billingDetailsVO.setCustomerId(customerEntity.getCustomerId());
        BillingDetails billingDetails = customerEntity.getBillingDetails();
        billingDetailsVO.setBalance(billingDetails.getBalance());
        billingDetailsVO.setCalls(billingDetails.getCalls());
        billingDetailsVO.setSms(billingDetails.getSms());
        return  billingDetailsVO;
    }

    private BillingDetails getBillingDetailsFromVO(BillingDetailsVO billingDetailsVO){
        BillingDetails billingDetails = new BillingDetails();
        billingDetails.setBalance(billingDetailsVO.getBalance());
        billingDetails.setSms(billingDetailsVO.getSms());
        billingDetails.setCalls(billingDetailsVO.getCalls());
        return billingDetails;
    }


}
