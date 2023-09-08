package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 前端控制器
 * @RestController注解：
 *      1.表示一个控制器
 *      2.返回json
 *
 * @Controller + @RequestBody
 *
 * @RequstMapping注解：
 *    执行哪一个类或方法来处理请求
 *    可以在类或方法上添加该注解
 *    value:用于指定请求的映射地址到实际的方法上
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String sayHello(){
        return "Hello SpringBoot!";
    }

    @RequestMapping(value = "/sayjsondata")
    public Map<String,String> sayJsonData(){
        //测试数据
        Map<String,String> datas = new HashMap<String ,String>();
        datas.put("empid","1001");
        datas.put("empname","admin");

        return datas;
    }

    /**
     * @GetMapping 等价于
     * @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
     * @return
     */
    @GetMapping(value = "/sayget")
    public String sayGet(){
        return "GET Request";
    }

    /**
     * @PostMapping等价于
     * @RequestMapping(value = "/hello" ,method = RequestMethod.POST)
     * @return
     */
    @PostMapping(value = "/saypost")
    public String sayPost(){
        return "POST Request";
    }

    /**
     * 验证登录有效性
     * 获取用户输入的用户名和密码
     * @RequestParam注解
     *     作用将指定的请求参数赋值给方法中的参数
     *     defaultValue:如果没有传递参数使用默认值
     * @return
     */
    @RequestMapping("/dologin")
    public String dologin(@RequestParam(value = "uname",defaultValue = "system") String uname,
                          @RequestParam("pwd") String pwd){

        return "username="+uname + ",pwd=" + pwd;
    }


    /**
     * 请求方式:
     *    eg：修改操作 /update/1
     *
     * @PathVariable注解
     *    将URL占位符参数赋值给方法的形参
     * @return
     */
    @RequestMapping("/update/{empid}")
    public String updateInputEmp(@PathVariable("empid") Integer empId){

        return "empid:" + empId;
    }

}
