package com.cts.o2.rest.resource;



import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
