package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired(required=false)
    private UserService userService;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping(value = "/queryAll")
    public String queryAll(Model model){
        List<User> user = userService.queryUserAll();
        model.addAttribute("User",user);
        return "user/displayuser";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @PostMapping("/toadd")
    public String toAdd(){
        return "user/add";
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @PostMapping(value = "/add")
    public String add(User user){
        userService.addUser(user);
        return "redirect:/queryAll";
    }

    /**
     * 获取单个用户信息
     * @param
     * @return
     */
    @GetMapping(value = "/queryById")
    public String queryById(@RequestParam(value = "id") String id, Model model){
        User user = userService.queryUserById(id);
        model.addAttribute("User",user);
        return "user/update";
    }

    /**
     * 编辑更新用户信息
     * @param user
     * @return
     */
    @GetMapping(value = "/update")
    public String update(User user){
        userService.updateUser(user);
        return "redirect:/queryAll";
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteById")
    public String deleteById(@RequestParam(value = "id") String id){
        userService.deleteUserById(id);
        return "redirect:/queryAll";
    }

    @PostMapping(value = "/deleteByIds")
    public String deleteByIds(@RequestParam(value = "ids") String[] ids){
        userService.deleteUserByIds(ids);
        return "redirect:/queryAll";
    }


}

