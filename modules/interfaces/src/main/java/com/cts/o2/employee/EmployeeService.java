package com.cts.o2.employee;

import java.util.List;

/**
 * Created by cts1 on 1/3/14.
 */
public interface EmployeeService {

    public List<Employee> getAllEmployeeDetails();

    public void addEmployee(Employee employee);

    public void deleteEmployee(int employeeId);

    public void updateEmployee(Employee employee);

    public Employee getEmployee(int employeeId);


}
