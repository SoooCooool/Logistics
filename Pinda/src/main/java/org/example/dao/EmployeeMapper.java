package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.example.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

     List<Employee> findall();
     Employee findbyid(String employeeid);
     void insert(Employee employee);
     void delete(String employeeid);
     void update(Employee employee);
     List<Employee> findEmployeeByphonenumberandoccupation(
            @Param("phonenumber") String phonenumber,
            @Param("occupation") String occupation);

    List<Employee> searchEmployee(String search);
     public int accountEmployee();
}