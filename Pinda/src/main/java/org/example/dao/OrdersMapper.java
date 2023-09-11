package org.example.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface OrdersMapper {
    Orders QueryordersById(String orderid);

    List<Orders> QueryordersAll();

    List<Orders> Queryorders(@Param("orderid")String orderid, @Param("userid")String userid, @Param("employeeid")String employeeid,
                             @Param("state")String state, @Param("startlocation")String startlocation, @Param("destination")String destination, @Param("amount")Integer amount);

    void Addorders(Orders orders);

    void DeleteordersById(String orderid);
    void DeleteordersByIds(@Param("orderids") List<String> orderids);

    void Updateorders(Orders orders);
}
