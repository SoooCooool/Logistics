package org.example.controller;

import org.example.common.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @param
     * @return
     */
    @GetMapping(value = "/queryAll")
    @ResponseBody
    public Result queryAll(){
        List<User> users = userService.queryUserAll();
        return Result.success(users);
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @PostMapping("/toadd")
    public String toAdd(){
        return "orders/add";
    }

    /**
     * 添加用户信息
     * @param
     * @return
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public Result add(@RequestBody User user){
        userService.addUser(user);
        return Result.success("success");
    }

    /**
     * 获取单个用户信息
     * @param
     * @return
     */
    @GetMapping(value = "/queryById")
    @ResponseBody
    public Result queryById(@RequestParam(value = "id") String id){
        User user = userService.queryUserById(id);
        return Result.success(user);
    }

    /**
     * 编辑更新用户信息
     * @param
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public Result update(@RequestBody User user){
        userService.updateUser(user);
        return Result.success("success");
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */

    @GetMapping(value = "/deleteById/{id}")
    @ResponseBody
    public Result deleteById(@PathVariable("id") String id){
        userService.deleteUserById(id);
        return Result.success("success");
    }
    @PostMapping(value = "/deleteByIds")
    @ResponseBody
    public Result deleteByIds(@RequestParam(value = "ids") String[] ids){
        userService.deleteUserByIds(ids);
        return Result.success("success");
    }

}

