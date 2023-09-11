package org.example;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.example.pojo.Orders;
import org.example.pojo.User;
import org.example.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.*;

public class OrdersTest {
    @Test
    public void testMethod1(){
        System.out.println("hello Testing!");
    }


    @Test
    public void testQueryordersById(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        Orders orders =
                sqlSession.selectOne("org.example.dao.OrdersMapper.QueryordersById","D001");

        System.out.println(orders);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testAddorders(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Orders orders=new Orders();
        orders.setOrderid("D002");
        orders.setEmployeeid("E123456");
        orders.setUserid("U123456");
        orders.setModifiedpersonid("M123456");
        orders.setDestination("wuhan");
        orders.setStartlocation("anhui");
        orders.setPresentstate("已签收");
        orders.setAmount(99);
        orders.setDeleted(0);
        Date date1 = new Date(2022,12,3);
        Date date2 = new Date(2022,12,8);
        orders.setCreatedtime(date1);
        orders.setModifiedtime(date2);

        sqlSession.insert("org.example.dao.OrdersMapper.Addorders",orders);
        sqlSession.commit();
        testQueryordersAll();
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testQueryordersAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        List<Orders> orders =
                sqlSession.selectList("org.example.dao.OrdersMapper.QueryordersAll");

        System.out.println(orders);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testDeleteordersById(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        sqlSession.delete("org.example.dao.OrdersMapper.DeleteordersById","D002");
        sqlSession.commit();
        testQueryordersAll();
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteordersByIds(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<String> List = new ArrayList<>();
        List.add("D002");
        List.add("D003");
        sqlSession.delete("org.example.dao.OrdersMapper.DeleteordersByIds",List);
        sqlSession.commit();
        testQueryordersAll();
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateorders(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        Orders orders =
                sqlSession.selectOne("org.example.dao.OrdersMapper.QueryordersById","D001");

        orders.setState("已签收");


        sqlSession.update("org.example.dao.OrdersMapper.Updateorders",orders);

        //3.关闭SqlSession对象
        sqlSession.commit();
        testQueryordersAll();
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryorders(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Map<String, Object> map = new HashMap<>();
        map.put("order_id","D00");
        map.put("state","已签收");
        List<Orders> orders= sqlSession.selectList("org.example.dao.OrdersMapper.Queryorders",map);
        System.out.println(orders);
        sqlSession.commit();
        sqlSession.close();
    }
}
