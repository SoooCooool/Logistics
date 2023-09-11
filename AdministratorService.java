package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Administrator;

import java.util.List;

public interface AdministratorService {

    public List<Administrator> queryAdministratorAll();

    public Administrator queryAdministratorById(String id);

    public void deleteAdministratorById(String id);

    public void addAdministrator(Administrator administrator);

    public void updateAdministratorById(Administrator administrator,String id);

    public List<Administrator> findAdministratorByNameAndPermissions(Administrator administrator);
}
