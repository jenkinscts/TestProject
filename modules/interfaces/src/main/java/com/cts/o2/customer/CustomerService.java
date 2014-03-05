package com.cts.o2.customer;




import com.cts.o2.billing.BillingDetailsVO;

import java.util.List;

/**
 * Created by cts1 on 26/2/14.
 */
public interface CustomerService {

    public CustomerVO getCustomerDetails(int customerId);

    public List<CustomerVO> getAllCustomer();

    public void addCustomer(CustomerVO customerVO);

    public void updateCustomer(CustomerVO customerVO);

    public void deleteCustomer(int customerId);

    public BillingDetailsVO getBillingDetails(int customerId);

    public List<BillingDetailsVO> getAllBillingDetails();

    public void addBillingDetails(BillingDetailsVO billingDetailsVO);

    public void updateBillingDetails(BillingDetailsVO billingDetailsVO);
}
