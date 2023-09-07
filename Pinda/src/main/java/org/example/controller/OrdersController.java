package org.example.controller;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.Orders;
import org.example.service.OrdersService;
import org.example.utils.SqlSessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/orders")
public class OrdersController {
    private OrdersService ordersService;

    @GetMapping(value = "/queryAll")
    public String queryAll(){
        return ordersService.queryOrdersAll().toString();
    }

    @GetMapping(value = "/queryById")
    public String queryById(@RequestParam(value = "id") String id){
        return ordersService.queryOrdersById(id).toString();
    }

    @PostMapping(value = "/deleteById")
    public String deleteById(@RequestParam(value = "id") String id){
        ordersService.deleteOrdersById(id);
        return "ok";
    }

    @PostMapping(value = "/deleteByIds")
    public String deleteByIds(@RequestParam(value = "ids") String[] ids){
        ordersService.deleteOrdersByIds(ids);
        return "ok";
    }

    @PostMapping(value = "/add")
    public String add(@RequestParam(value = "orders") Orders orders){
        ordersService.addOrdersByIds(orders);
        return "ok";
    }

    @PostMapping(value = "/updateById")
    public String updateById(@RequestParam(value = "orders") Orders orders){
        ordersService.updateOrdersByIds(orders);
        return "ok";
    }

    @GetMapping(value = "/query")
    public String query(@RequestParam(value = "ids") Orders orders){
        ordersService.updateOrdersByIds(orders);
        return "ok";
    }
}
