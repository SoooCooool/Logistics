package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.example.pojo.Orders;
import org.example.pojo.User;
import org.example.pojo.Vehicle;
import org.springframework.stereotype.Repository;


import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;



public interface UserMapper {
    User QueryuserById(String userid);

    List<User> QueryuserAll();

    List<User> Queryuser(@Param("userid")String orderid, @Param("name")String name, @Param("createdtime") Data createdtime,
                             @Param("location")String location, @Param("phonenumber")String phonenumber);

    void Adduser(User user);

    void DeleteuserById(String userid);
    void DeleteuserByIds(@Param("user_ids") String userids);

    void Updateuser(User user);
    public List<User> searchUser(String search);
    public int accountUser();
}
