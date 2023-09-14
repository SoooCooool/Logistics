package org.example.service;

import org.example.pojo.Employee;
import org.example.pojo.Orders;
import org.example.pojo.Vehicle;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findall();
    public Employee findbyid (String id);

    public void deleteemployeebyid(String id);


    public void insertemployee(Employee employee);

    public void updateemployeebyid(Employee employee);
    public List<Employee> searchEmployee(String search);
    public int accountEmployee();
}
