package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.example.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeMapper {
    public List<Employee> findall();
    public void insert(Employee employee);
    public void delete(String employee_id);
    public void update(Employee employee);
    public List<Employee> findEmployeeByphonenumberandoccupation(
            @Param("phonenumber") String phonenumber,
            @Param("occupation") String occupation);
}