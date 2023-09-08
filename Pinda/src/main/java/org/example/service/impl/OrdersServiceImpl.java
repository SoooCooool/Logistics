package org.example.service.impl;

import org.example.dao.OrdersMapper;
import org.example.pojo.Orders;
import org.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> queryOrdersAll(){
        return ordersMapper.QueryordersAll();
    }

    @Override
    public Orders queryOrdersById(String id){
        return ordersMapper.QueryordersById(id);
    }

    @Override
    public void deleteOrdersById(String id){
        ordersMapper.DeleteordersById(id);
    }

    @Override
    public void deleteOrdersByIds(String[] ids){
        //List<String> ids1 = Arrays.stream(ids).toList();
        //ordersMapper.DeleteordersByIds(ids1);
    }

    @Override
    public void addOrders(Orders orders){
        ordersMapper.Addorders(orders);
    }

    @Override
    public void updateOrders(Orders orders){
        ordersMapper.Updateorders(orders);
    }
}
