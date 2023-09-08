package org.example.service;

import org.example.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> queryUserAll();

    public User queryUserById(String id);

    public void deleteUserById(String id);

    public void deleteUserByIds(String[] ids);

    public void addUser(User user);

    public void updateUser(User user);
}
