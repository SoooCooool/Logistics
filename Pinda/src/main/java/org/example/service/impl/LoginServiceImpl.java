package org.example.service.impl;

import org.example.dao.AdministratorMapper;
import org.example.dao.EmployeeMapper;
import org.example.dao.UserMapper;
import org.example.pojo.Administrator;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdministratorMapper administratorMapper;
    private EmployeeMapper employeeMapper;
    private UserMapper userMapper;

    @Override
    public void Login(String account, String password, int type) {
        if(type==1){
            Administrator administrator = null;
            administrator=administratorMapper.getAdministratorbyId(account);
            if(administrator == null){
                //预留报错
            }
            if(administrator.getPassword().equals(password)){
                //跳转页面
            }

        } else if (type==2) {
            Administrator administrator = null;
            administrator=administratorMapper.getAdministratorbyId(account);
            if(administrator == null){
                //预留报错
            }
            if(administrator.getPassword().equals(password)){
                //跳转页面
            }

        } else if (type==3) {
            Administrator administrator = null;
            administrator=administratorMapper.getAdministratorbyId(account);
            if(administrator == null){
                //预留报错
            }
            if(administrator.getPassword().equals(password)){
                //跳转页面
            }

        }

    }


}
