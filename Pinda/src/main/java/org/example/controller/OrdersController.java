package org.example.controller;

import org.example.common.Result;
import org.example.pojo.Orders;
import org.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 查询所有订单
     * @param
     * @return
     */
    @GetMapping(value = "/queryAll")
    @ResponseBody
    public Result queryAll(){
        List<Orders> orders = ordersService.queryOrdersAll();
        return Result.success(orders);
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
     * 添加订单信息
     * @param orders
     * @return
     */
    @PostMapping(value = "/add")
    public Result add(Orders orders){
        orders.setDeleted(0);
        ordersService.addOrders(orders);
        return Result.success("success");
    }

    /**
     * 获取单个订单信息
     * @param
     * @return
     */
    @GetMapping(value = "/queryById")
    public Result queryById(@RequestParam(value = "id") String id,Model model){
        Orders orders = ordersService.queryOrdersById(id);
        return Result.success(orders);
    }

    /**
     * 编辑更新订单信息
     * @param orders
     * @return
     */
    @GetMapping(value = "/update")
    public Result update(Orders orders){
        ordersService.updateOrders(orders);
        return Result.success("success");
    }

    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteById")
    public Result deleteById(@RequestParam(value = "id") String id){
        ordersService.deleteOrdersById(id);
        return Result.success("success");
    }

    @PostMapping(value = "/deleteByIds")
    public Result deleteByIds(@RequestParam(value = "ids") String[] ids){
        ordersService.deleteOrdersByIds(ids);
        return Result.success("success");
    }


}
