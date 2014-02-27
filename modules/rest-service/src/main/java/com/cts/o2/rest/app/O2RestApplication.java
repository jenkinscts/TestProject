package com.cts.o2.rest.app;

import com.cts.o2.rest.resource.O2BillingRestResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jackson.JacksonFeature;


public class O2RestApplication extends ResourceConfig {

    public O2RestApplication(){
        packages(O2BillingRestResource.class.getPackage().toString());
        register(JacksonFeature.class);
    }
}
