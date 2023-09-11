package org.example.service.impl;

import org.apache.ibatis.annotations.Param;
import org.example.dao.AdministratorMapper;
import org.example.pojo.Administrator;
import org.example.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired

    private AdministratorMapper administratorMapper;
    @Override
    public  List<Administrator> queryAdministratorAll(){return administratorMapper.findAll();}
    @Override
    public Administrator queryAdministratorById(String id){return administratorMapper.getAdministratorbyId(id);}
    @Override
    public void deleteAdministratorById(String id){administratorMapper.deleteAdministratorById(id);}
    @Override
    public void addAdministrator(Administrator administrator){administratorMapper.addAdministrator(administrator);}
    @Override
    public void updateAdministratorById(Administrator administrator,String id){administratorMapper.updateAdministratorById(administrator,id);}

    @Override
    public List<Administrator> findAdministratorByNameAndPermissions(Administrator administrator){
        return administratorMapper.findAdministratorBy(administrator);
    }

}
