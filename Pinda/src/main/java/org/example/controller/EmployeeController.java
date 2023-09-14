package org.example.controller;

import org.apache.ibatis.session.SqlSession;
import org.example.common.Result;
import org.example.dao.EmployeeMapper;
import org.example.dao.UserMapper;
import org.example.dto.EmployeeDto;
import org.example.dto.LogonRequest;
import org.example.pojo.Employee;
import org.example.pojo.Orders;
import org.example.pojo.User;
import org.example.pojo.Vehicle;
import org.example.service.EmployeeService;
import org.example.service.OrdersService;
import org.example.service.UserService;
import org.example.utils.SqlSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private EmployeeController employeeController;

    @GetMapping(value = "/queryAll")
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
    @GetMapping(value = "/queryById")
    @ResponseBody
    public Result findbyid(@RequestParam(value = "id") String id, Model model){
        Employee employee = employeeService.findbyid(id);
        //model.addAttribute("Employee",employee);
        return Result.success(employee);
    }
    @PostMapping(value = "/update")
    @ResponseBody
    public Result update(@RequestBody EmployeeDto employeeDto){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Date date = new Date();
        Employee employee = employeeService.findbyid(employeeDto.getEmployeeid());
        employee.setName(employeeDto.getName());

        employee.setPassword(employeeDto.getPassword());
        employee.setPhonenumber(employeeDto.getPhonenumber());
        employee.setOccupation(employeeDto.getOccupation());
        employee.setModifiedtime(date);
        System.out.print(employee);

        employeeService.updateemployeebyid(employee);
        sqlSession.commit();
        sqlSession.close();
        return Result.success("success");
    }
    @PostMapping(value = "/addEmployee")
    @ResponseBody
    public Result Register(@RequestBody EmployeeDto employeeDto){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper =sqlSession.getMapper(EmployeeMapper.class);
        Date date = new Date();
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setOccupation(employeeDto.getOccupation());
        employee.setPhonenumber(employeeDto.getPhonenumber());
        employee.setPassword(employeeDto.getPassword());
        employee.setCreatedtime(date);
        employee.setModifiedtime(date);
        employee.setPermissions(2);
        employee.setDeleted(0);
        for(int i=0;i<1000000;i++){
            long r = System.currentTimeMillis();//生成一个随机变量
            r%=1000000;//将id长度规范到6位
            int rand=(int)r;//强制类型转换
            String idh = "E";
            String idt = String.valueOf(rand);//强制类型转换
            String newid =idh+idt;//将id的头部U和后面的数字拼接
            Employee newuser = new Employee();
            newuser=employeeMapper.findbyid(newid);//检测该id有没有被用过，user注册使用user类，其它用其它类
            if(newuser==null){//如果该id未被使用则使用这个id退出循环
                employee.setEmployeeid(newid);
                break;
            }
        }
        System.out.print(employee);
        employeeService.insertemployee(employee);
        //sqlSession.insert("org.example.dao.UserMapper.Adduser",user);
        sqlSession.commit();
        sqlSession.close();
        return Result.success(employee.getEmployeeid());

    }

    @GetMapping(value = "/deleteById/{id}")
    @ResponseBody
    public Result deleteById(@PathVariable("id") String id){
        employeeService.deleteemployeebyid(id);
        return Result.success("success");
    }
    @GetMapping(value = "/searchEmployee")
    @ResponseBody
    public Result searchVehicle (@RequestParam(value = "search") String search){
        List<Employee> employees = employeeService.searchEmployee(search);
        return Result.success(employees);
    }

}
