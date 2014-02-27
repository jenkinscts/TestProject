package com.cts.o2.billing;


import java.util.TreeMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cts1 on 26/2/14.
 */
public class BillingServiceImpl implements  BillingService {

    private static final TreeMap<Integer,BillingDetails> billingMap = new TreeMap<Integer, BillingDetails>();

    static {
        BillingDetails b1 = new BillingDetails();
        b1.setCustomerId(1);
        b1.setSms(100);
        b1.setCalls(105);
        b1.setBalance(202.5);

        BillingDetails b2 = new BillingDetails();
        b2.setCustomerId(2);
        b2.setSms(45);
        b2.setCalls(15);
        b2.setBalance(86.5);

        BillingDetails b3 = new BillingDetails();
        b3.setCustomerId(3);
        b3.setSms(150);
        b3.setCalls(205);
        b3.setBalance(482.5);

        billingMap.put(1,b1);
        billingMap.put(2,b2);
        billingMap.put(3,b3);

    }

    @Override
    public BillingDetails getBillingDetails(int customerId) {
        return billingMap.get(customerId);
    }

    @Override
    public List<BillingDetails> getAllBillingDetails() {
        Collection<BillingDetails> billingDetailsCollection = billingMap.values();
        return new ArrayList<BillingDetails>(billingDetailsCollection);
    }
}
