package com.cts.o2.rest.resource;

import com.cts.o2.billing.BillingService;
import com.cts.o2.billing.BillingServiceImpl;
import com.cts.o2.customer.CustomerService;
import com.cts.o2.customer.CustomerServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

import org.springframework.web.context.ContextLoaderListener;
import org.glassfish.jersey.server.spring.SpringLifecycleListener;

public class O2BillingRestResourceTest extends JerseyTest {


    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(SpringLifecycleListener.class)
                .register(ContextLoaderListener.class)
                .register(O2BillingRestResource.class)
                .property("contextConfigLocation",
                        "classpath:testapplicationContext-restApplication.xml ");
        return resourceConfig;

    }



    @Test
    public void testGetCustomerDetails(){
        Response response = target("getCustomerDetails/id/").path("1").request().get(Response.class);
        assertNotNull(response);
        assertEquals(204, response.getStatus());
    }
}
