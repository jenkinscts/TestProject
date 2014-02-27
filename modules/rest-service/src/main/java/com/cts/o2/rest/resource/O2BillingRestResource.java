package com.cts.o2.rest.resource;

import com.cts.o2.billing.BillingDetails;
import com.cts.o2.billing.BillingService;
import com.cts.o2.customer.Customer;
import com.cts.o2.customer.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Component
@Path("/")
public class O2BillingRestResource {

    private Logger logger = Logger.getLogger(O2BillingRestResource.class);

    private BillingService billingService;
    private CustomerService customerService;

    @GET
    @Path("getCustomerDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomerDetails() {
        logger.info("CTS-dsfj: Fetching all customer details");
        return  customerService.getAllCustomer();
    }

    @GET
    @Path("getBillingDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BillingDetails> getAllBillingDetails() {
        return billingService.getAllBillingDetails();
    }


    @GET
    @Path("getCustomerDetails/id/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerDetails(@PathParam("customerId")int customerId) {
       return  customerService.getCustomerDetails(customerId);
    }

    @GET
    @Path("getBillingDetails/id/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public BillingDetails getBillingDetails(@PathParam("customerId")int customerId) {
        return billingService.getBillingDetails(customerId);
    }

    public BillingService getBillingService() {
        return billingService;
    }

    public void setBillingService(BillingService billingService) {
        this.billingService = billingService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
