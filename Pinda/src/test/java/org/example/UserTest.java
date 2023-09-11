package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.Orders;
import org.example.pojo.User;
import org.example.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.*;

public class UserTest {
    @Test
    public void testMethod1(){
        System.out.println("hello Testing!");
    }


    @Test
    public void testQueryuserById(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        User user =
                sqlSession.selectOne("org.example.dao.UserMapper.QueryuserById","U123456");

        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testAdduser(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        User user=new User();
        user.setUserid("U000000");
        user.setName("hhh");
        user.setPhonenumber(1213234545);
        user.setLocation("wuhan");
        user.setPermissions(1);
        Date date1 = new Date(2022,12,3);
        Date date2 = new Date(2022,12,8);
        user.setCreatedtime(date1);
        user.setModifiedtime(date2);

        sqlSession.insert("org.example.dao.UserMapper.Adduser",user);
        sqlSession.commit();
        testQueryuserAll();
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testQueryuserAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        List<User> user =
                sqlSession.selectList("org.example.dao.UserMapper.QueryuserAll");

        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testDeleteuserById(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        sqlSession.delete("org.example.dao.UserMapper.DeleteuserById","U000000");
        sqlSession.commit();
        testQueryuserAll();
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteuserByIds(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<String> List = new ArrayList<>();
        List.add("U000000");
        List.add("U000001");
        sqlSession.delete("org.example.dao.UserMapper.DeleteuserByIds",List);
        sqlSession.commit();
        testQueryuserAll();
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateuser(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        User user =
                sqlSession.selectOne("org.example.dao.UserMapper.QueryuserById","U123456");

        user.setName("张勇");


        sqlSession.update("org.example.dao.UserMapper.Updateuser",user);

        //3.关闭SqlSession对象
        sqlSession.commit();
        testQueryuserAll();
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryuser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id","U12");
        map.put("name","已签收");
        List<User> user= sqlSession.selectList("org.example.dao.UserMapper.Queryuser",map);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
