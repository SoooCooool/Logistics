package org.example;

import org.example.pojo.Employee;
import org.example.pojo.Orders;
import org.example.service.OrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersServiceTest {
    @Autowired
    private OrdersService ordersService;

    @Test
    public void testqueryAll(){
        List<Orders> orders = ordersService.queryOrdersAll() ;
        for(Orders order : orders){
            System.out.println(order);
        }
    }
}
