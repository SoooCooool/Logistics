package org.example.service.impl;

import org.example.dao.OrdersMapper;
import org.example.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service("bookInfoService")
public class OrdersServiceImpl {
    //@Autowired
    private OrdersMapper ordersMapper;

    List<Orders> queryOrdersAll(){
        return ordersMapper.QueryordersAll();
    }

    Orders queryOrdersById(String id){
        return ordersMapper.QueryordersById(id);
    }

    void deleteOrdersById(String id){
        ordersMapper.DeleteordersById(id);
    }

    void deleteOrdersByIds(String[] ids){
        //List<String> ids1 = Arrays.stream(ids).toList();
        //ordersMapper.DeleteordersByIds(ids1);
    }

    void addOrdersByIds(Orders orders){
        ordersMapper.Addorders(orders);
    }

    void updateOrdersByIds(Orders orders){
        ordersMapper.Updateorders(orders);
    }
}
