package org.example.service.impl;

import org.example.dao.EmployeeMapper;
import org.example.pojo.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findall() {return employeeMapper.findall();}
    @Override
    public Employee findbyid(String id){return employeeMapper.findbyid(id);}

    @Override
    public void deleteemployeebyid(String id){employeeMapper.delete(id);}

    @Override
    public void insertemployee(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void updateemployeebyid(Employee employee) {
        employeeMapper.update(employee);
    }
}
