package org.example.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface OrdersMapper {
    Orders QueryordersById(String order_id);

    List<Orders> QueryordersAll();

    List<Orders> Queryorders(@Param("order_id")String order_id, @Param("user_id")String user_id, @Param("employee_id")String employee_id,
                             @Param("state")String state, @Param("start_location")String start_location, @Param("destination")String destination, @Param("amount")Integer amount);

    void Addorders(Orders orders);

    void DeleteordersById(String order_id);
    void DeleteordersByIds(@Param("order_ids") List<String> order_ids);

    void Updateorders(Orders orders);
}
