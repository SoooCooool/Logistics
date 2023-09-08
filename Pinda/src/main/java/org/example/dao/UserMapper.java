package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.example.pojo.Orders;
import org.example.pojo.User;
import org.springframework.stereotype.Repository;


import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;



public interface UserMapper {
    User QueryuserById(String user_id);

    List<User> QueryuserAll();

    List<User> Queryuser(@Param("user_id")String order_id, @Param("name")String name, @Param("created_time") Data created_time,
                             @Param("location")String location, @Param("phonenumber")String phonenumber);

    void Adduser(User user);

    void DeleteuserById(String user_id);
    void DeleteuserByIds(@Param("user_ids") String user_ids);

    void Updateuser(User user);
}
