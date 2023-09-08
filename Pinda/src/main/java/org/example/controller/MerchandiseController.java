package org.example.controller;


import org.example.common.Result;
import org.example.pojo.Merchandise;
import org.example.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/mercahndise")

public class MerchandiseController {
    @Autowired
    private MerchandiseService merchandiseService;

    @GetMapping(value = "/findall")
    @ResponseBody
    public Result findall(Model model){
        List<Merchandise> merchandises = merchandiseService.findall();
        /*model.addAttribute("Merchandise",merchandises);*/
        return Result.success(merchandises);
    }
    @PostMapping("/toinsert")
    @ResponseBody
    public String toinsert(){
        return "merchandise/insert";
    }
    @PostMapping(value = "/insert")
    @ResponseBody
    public Result insert(Merchandise merchandise){
        merchandiseService.insertmerchandise(merchandise);
        return Result.success("success");
    }
    @GetMapping(value = "/findbyid")
    @ResponseBody
    public Result findbyid(@RequestParam(value = "id") String id, Model model){
        Merchandise merchandise = merchandiseService.findbyid(id);
        model.addAttribute("Merchandise",merchandise);
        return Result.success(merchandise);
    }
    @GetMapping(value = "/update")
    @ResponseBody
    public Result update(Merchandise merchandise){
        merchandiseService.updatemerchandisebyid(merchandise);
        return Result.success("success");
    }
    @PostMapping(value = "/deletebyid")
    @ResponseBody
    public Result deletebyid(@RequestParam(value = "id") String id){
        merchandiseService.deletemerchandisebyid(id);
        return Result.success("success");
    }
}
