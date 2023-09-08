package org.example.service;

import org.example.pojo.Orders;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrdersService {
    public List<Orders> queryOrdersAll();

    public Orders queryOrdersById(String id);

    public void deleteOrdersById(String id);

    public void deleteOrdersByIds(String[] ids);

    public void addOrders(Orders orders);

    public void updateOrders(Orders orders);
}
