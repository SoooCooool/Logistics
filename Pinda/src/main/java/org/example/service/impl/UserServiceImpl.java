package org.example.service.impl;

import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserAll(){
        return userMapper.QueryuserAll();
    }

    @Override
    public User queryUserById(String id){
        return userMapper.QueryuserById(id);
    }

    @Override
    public void deleteUserById(String id){
        userMapper.DeleteuserById(id);
    }

    @Override
    public void deleteUserByIds(String[] ids){
        //List<String> ids1 = Arrays.stream(ids).toList();
        //userMapper.DeleteuserByIds(ids1);
    }

    @Override
    public void addUser(User user){
        userMapper.Adduser(user);
    }

    @Override
    public void updateUser(User user){
        userMapper.Updateuser(user);
    }
}
