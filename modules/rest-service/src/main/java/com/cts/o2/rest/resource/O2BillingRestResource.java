package com.cts.o2.rest.resource;

import com.cts.o2.billing.BillingDetailsVO;
import com.cts.o2.customer.CustomerService;
import com.cts.o2.customer.CustomerVO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Component
@Path("/")
public class O2BillingRestResource {

    private Logger logger = Logger.getLogger(O2BillingRestResource.class);

    private CustomerService customerService;

    @POST
    @Path("addCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addCustomer(CustomerVO customerVO){
        customerService.addCustomer(customerVO);
        return  "CustomerVO added successfully";
    }

    @PUT
    @Path("updateCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateCustomer(CustomerVO customerVO){
        customerService.updateCustomer(customerVO);
        return "CustomerVO updated successfully";
    }

    @GET
    @Path("getCustomerDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerVO> getAllCustomerDetails() {
        logger.info("CTS-dsfj: Fetching all customer details");
        List<CustomerVO> customerVOList = customerService.getAllCustomer();
        logger.info("CTS-fds"+customerVOList.toString());
        return customerVOList;
    }

    @GET
    @Path("getBillingDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BillingDetailsVO> getAllBillingDetails() {
        return customerService.getAllBillingDetails();
    }


    @GET
    @Path("getCustomerDetails/id/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerVO getCustomerDetails(@PathParam("customerId")int customerId) {
       return  customerService.getCustomerDetails(customerId);
    }

    @DELETE
    @Path("deleteCustomer/{customerId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteCustomer(@PathParam("customerId")int customerId) {
        customerService.deleteCustomer(customerId);
        return  "Customer has been deleted";
    }


    @GET
    @Path("getBillingDetails/id/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public BillingDetailsVO getBillingDetails(@PathParam("customerId")int customerId) {
        return customerService.getBillingDetails(customerId);
    }

    @POST
    @Path("addBillingDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addBillingDetails(BillingDetailsVO billingDetailsVO){
        customerService.addBillingDetails(billingDetailsVO);
        return  "BillingDetails added successfully";
    }

    @PUT
    @Path("updateBillingDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateBillingDetails(BillingDetailsVO billingDetailsVO){
        customerService.updateBillingDetails(billingDetailsVO);
        return "BillingDetails updated successfully";
    }


    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
