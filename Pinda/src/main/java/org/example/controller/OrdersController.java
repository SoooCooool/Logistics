package org.example.controller;

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
     * @param model
     * @return
     */
    @GetMapping(value = "/queryAll")
    public String queryAll(Model model){
        List<Orders> orders = ordersService.queryOrdersAll();
        model.addAttribute("Orders",orders);
        return "orders/displayorders";
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
    public String add(Orders orders){
        ordersService.addOrders(orders);
        return "redirect:/queryAll";
    }

    /**
     * 获取单个订单信息
     * @param
     * @return
     */
    @GetMapping(value = "/queryById")
    public String queryById(@RequestParam(value = "id") String id,Model model){
        Orders orders = ordersService.queryOrdersById(id);
        model.addAttribute("Orders",orders);
        return "orders/update";
    }

    /**
     * 编辑更新订单信息
     * @param orders
     * @return
     */
    @GetMapping(value = "/update")
    public String update(Orders orders){
        ordersService.updateOrders(orders);
        return "redirect:/queryAll";
    }

    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteById")
    public String deleteById(@RequestParam(value = "id") String id){
        ordersService.deleteOrdersById(id);
        return "redirect:/queryAll";
    }

    @PostMapping(value = "/deleteByIds")
    public String deleteByIds(@RequestParam(value = "ids") String[] ids){
        ordersService.deleteOrdersByIds(ids);
        return "redirect:/queryAll";
    }


}
