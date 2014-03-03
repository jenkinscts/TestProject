package com.cts.o2.employee;

import com.cts.o2.employee.Employee;
import com.cts.o2.employee.EmployeeService;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by cts1 on 1/3/14.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private static final TreeMap<Integer,Employee> employeeMap = new TreeMap<Integer, Employee>();

    static {
        Employee e1 = new Employee();
        e1.setEmployeeId(1);
        e1.setName("Sankalp Kale");
        e1.setDivision("Communications");

        Employee e2 = new Employee();
        e2.setEmployeeId(2);
        e2.setName("Ankit Chauhan");
        e2.setDivision("Communications");

        employeeMap.put(1, e1);
        employeeMap.put(2,e2);

    }

    @Override
    public List<Employee> getAllEmployeeDetails() {
        Collection<Employee> employeeCollection = employeeMap.values();
        return new ArrayList<Employee>(employeeCollection);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getEmployeeId(),employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeMap.remove(employeeId);

    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMap.put(employee.getEmployeeId(),employee);
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return employeeMap.get(employeeId);
    }
}
