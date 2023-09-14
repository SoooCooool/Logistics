package org.example.controller;

import org.apache.ibatis.annotations.Param;
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
@RequestMapping(value="/api/administrator")
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
    public Result getbyId(@Param("id") String id){
        Administrator administrator = administratorService.getAdministratorbyId(id);
        return Result.success(administrator);
    }

    @GetMapping(value = "/deleteById")
    @ResponseBody
    public String deleteById(@Param("id") String id){
        administratorService.deleteAdministratorById(id);
        return "删除成功";
    }

    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@Param("admin") Administrator admin){
        administratorService.addAdministrator(admin);
        return "添加成功";
    }

    @GetMapping(value = "/updateById")
    @ResponseBody
    public String updateById(@Param("id") String id,
                             @Param("admin") Administrator admin){
        administratorService.updateAdministratorById(admin,id);
        return "删除成功";
    }
    @GetMapping(value = "/queryByNameAndPermissions")
    @ResponseBody
    public Result queryByNameAndPermissions(@Param("name") String name,
                                            @Param("permissions") Integer permissions){
        Administrator admin=null;
        admin.setName(name);
        admin.setPermissions(permissions);
        List<Administrator> administrator = administratorService.findAdministratorByNameAndPermissions(admin.getName(),admin.getPermissions());
        return Result.success(administrator);
    }
}
