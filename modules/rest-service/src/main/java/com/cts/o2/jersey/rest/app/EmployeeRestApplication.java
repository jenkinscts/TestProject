package com.cts.o2.jersey.rest.app;

import com.cts.o2.jersey.rest.resource.EmployeeRestResource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by cts1 on 1/3/14.
 */
public class EmployeeRestApplication extends ResourceConfig {

    public EmployeeRestApplication(){
        packages(EmployeeRestResource.class.getPackage().toString());
        register(JacksonFeature.class);
    }
}
