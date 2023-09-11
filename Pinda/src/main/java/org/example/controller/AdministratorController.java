package org.example.controller;

import org.example.common.Result;
import org.example.pojo.Administrator;
import org.example.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value="/Administrator")
public class AdministratorController {
    @Autowired(required=false)
    AdministratorService administratorService;


    @GetMapping(value = "/queryAll")
    @ResponseBody
    public Result queryAll(){
        List<Administrator> administrator = administratorService.queryAdministratorAll();
        return Result.success(administrator);
    }

    @GetMapping(value = "/getbyId")
    @ResponseBody
    public Result getbyId(){
        Administrator administrator = administratorService.queryAdministratorById("M123456");
        return Result.success(administrator);
    }

    @GetMapping(value = "/deleteById")
    @ResponseBody
    public String deleteById(){
        administratorService.deleteAdministratorById("M123456");
        return "删除成功";
    }

    @GetMapping(value = "/add")
    @ResponseBody
    public String add(){
        Administrator administrator = null;
        administratorService.addAdministrator(administrator);
        return "删除成功";
    }

    @GetMapping(value = "/updateById")
    @ResponseBody
    public String updateById(){
        Administrator administrator = null;
        String id = null;
        administratorService.updateAdministratorById(administrator,id);
        return "删除成功";
    }
    @GetMapping(value = "/queryByNameAndPermissions")
    @ResponseBody
    public Result queryByNameAndPermissions(){
        Administrator admin=null;
        List<Administrator> administrator = administratorService.findAdministratorByNameAndPermissions(admin);
        return Result.success(administrator);
    }
}
