package org.example.controller;

import org.example.common.Result;
import org.example.dao.*;
import org.example.pojo.Administrator;
import org.example.pojo.Employee;
import org.example.pojo.LogonRequest;
import org.example.pojo.User;
import org.example.service.AdministratorService;
import org.example.service.UserService;
import org.example.service.EmployeeService;
import org.example.service.OrdersService;
import org.example.service.VehicleService;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/api/set")
public class UpdateController {
    @Autowired
    private AdministratorService administratorService;
    private UserService userService;
    private EmployeeService employeeService;
    private OrdersService ordersService;
    private VehicleService vehicleService;
    @PostMapping(value = "/userset")
    @ResponseBody
    public void Userset (@RequestBody LogonRequest logonRequest){
        //用户名：username，密码：password，手机号：phone，位置：location
        Date date = new Date();
        User user = new User();
        user.setName(logonRequest.getUsername());
        user.setLocation(logonRequest.getLocation());
        user.setPhonenumber(logonRequest.getPhone());
        user.setPassword(logonRequest.getPassword());

    }

    @PostMapping(value = "/adminset")
    @ResponseBody
    public Result Adminset (@RequestBody LogonRequest logonRequest){
        List<Administrator> administrator = administratorService.queryAdministratorAll();
        return Result.success(administrator);
    }

    @PostMapping(value = "/employeeset")
    @ResponseBody
    public void Employeeset (@RequestBody LogonRequest logonRequest){
        Date date = new Date();

    }

    @PostMapping(value = "/ordersset")
    @ResponseBody
    public void Ordersset (@RequestBody LogonRequest logonRequest){
        Date date = new Date();
    }

    @PostMapping(value = "/vehicleset")
    @ResponseBody
    public void Vehicleset (@RequestBody LogonRequest logonRequest){
        Date date = new Date();

    }
}
