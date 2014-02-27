package com.cts.o2.billing;

import java.util.List;

/**
 * Created by cts1 on 26/2/14.
 */
public interface BillingService {

    public BillingDetails getBillingDetails(int customerId);

    public List<BillingDetails> getAllBillingDetails();
}
