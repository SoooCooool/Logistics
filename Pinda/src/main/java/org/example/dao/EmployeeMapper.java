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
     Employee findbyid(String employee_id);
     void insert(Employee employee);
     void delete(String employee_id);
     void update(Employee employee);
     List<Employee> findEmployeeByphonenumberandoccupation(
            @Param("phonenumber") String phonenumber,
            @Param("occupation") String occupation);
}