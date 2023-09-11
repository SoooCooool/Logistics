package org.example.service;

import org.example.pojo.Employee;
import org.example.pojo.Orders;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findall();
    public Employee findbyid (String id);

    public void deleteemployeebyid(String id);


    public void insertemployee(Employee employee);

    public void updateemployeebyid(Employee employee);
}
