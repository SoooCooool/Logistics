package org.example.controller;

import org.example.common.Result;
import org.example.pojo.Employee;
import org.example.pojo.Orders;
import org.example.service.EmployeeService;
import org.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private EmployeeController employeeController;

    @GetMapping(value = "/findall")
    @ResponseBody
    public Result findall(){
        List<Employee> employees = employeeService.findall();
        return Result.success(employees);

    }

    @PostMapping("/toinsert")
    @ResponseBody
    public String toinsert(){
        return "employee/insert";
    }
    @PostMapping(value = "/insert")
    @ResponseBody
    public Result insert(Employee employee){
        employeeService.insertemployee(employee);
        return Result.success("success");
    }
    @GetMapping(value = "/findbyid")
    @ResponseBody
    public Result findbyid(@RequestParam(value = "id") String id, Model model){
        Employee employee = employeeService.findbyid(id);
        //model.addAttribute("Employee",employee);
        return Result.success(employee);
    }
    @GetMapping(value = "/update")
    @ResponseBody
    public Result update(Employee employee){
        employeeService.updateemployeebyid(employee);
        return Result.success("success");
    }
    @PostMapping(value = "/deletebyid")
    @ResponseBody
    public Result<String> deletebyid(@RequestParam(value = "id") String id){
        employeeService.deleteemployeebyid(id);
        return Result.success("success");
    }

}
