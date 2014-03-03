package com.cts.o2.jersey.rest.resource;

import com.cts.o2.employee.Employee;
import com.cts.o2.employee.EmployeeService;
import com.cts.o2.employee.EmployeeServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * Created by cts1 on 1/3/14.
 */
@Path("/")
public class EmployeeRestResource {

    private EmployeeService employeeService = new EmployeeServiceImpl();


    @GET
    @Path("help")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelp() {
        return "Employee Rest Application \n"+
               "Usage: \n"+
                "/getEmployeeDetails --Get All Employee Details \n"+
                "/getEmployee/employeeId/123 -- Get Employee Detail of 123 employee \n"+
                "/getEmploye?employeeId=123 -- Get Employee Detail of 123 employee \n"+
                "/addJsonEmployee -- Add Employee using json object \n"+
                "/addXmlEmployee -- Add Employee using xml object \n"+
                "/updateEmployee -- Update Employee using json object \n"+
                "deleteEmployee/employeeId/123  -- Delete 123 Employee";

    }

    @GET
    @Path("getEmployeeDetails")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Employee> getEmployeeDetails(){
        return employeeService.getAllEmployeeDetails();
    }

    @GET
    @Path("getEmployee/employeeId/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeePathParam(@PathParam("employeeId") int employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @GET
    @Path("getEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeQueryParam(@QueryParam("employeeId") int employeeId){
        return employeeService.getEmployee(employeeId);
    }



    @POST
    @Path("addJsonEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addJsonEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "Employee added successfully";

    }



    @POST
    @Path("addXmlEmployee")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String addXmlEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "Employee added successfully";
    }

    @PUT
    @Path("updateEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "Employee updated successfully";
    }

    @DELETE
    @Path("deleteEmployee/employeeId/{employeeId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteEmployee(@PathParam("employeeId") int employeeId){
        employeeService.deleteEmployee(employeeId);
        return "Employee has been deleted";
    }
}
