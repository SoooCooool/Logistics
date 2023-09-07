package org.example.service;

import org.example.pojo.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> queryOrdersAll();

    Orders queryOrdersById(String id);

    void deleteOrdersById(String id);

    void deleteOrdersByIds(String[] ids);

    void addOrdersByIds(Orders orders);

    void updateOrdersByIds(Orders orders);
}
