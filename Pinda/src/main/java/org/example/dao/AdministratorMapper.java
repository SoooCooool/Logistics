package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Administrator;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据库访问层
 */

public interface AdministratorMapper {

    /**
     * 功能：查询管理员所有信息
     *
     * @return
     */

    public List<Administrator> findAll();
    /**
     * 功能：根据管理员工号查询员工信息
     * @param administrator_id
     * @return
     */
    public Administrator getAdministratorbyId(String administrator_id);
    /**
     * 功能：添加管理员信息
     * @param administrator ：管理员对象
     * @return ：受影响的行数
     */
    public Integer addAdministrator(Administrator administrator);

    /**
     * 功能：根据管理员工号修改管理员信息
     * @param administrator
     * @return
     */
    public Integer updateAdministrator(Administrator administrator);
    /**
     * 功能：根据管理员工号删除管理员信息
     * @param administrator_id ：要删除的管理员工号
     * @return
     */
    public Integer deleteAdministrator(String administrator_id);
    /**
     * 功能：按多个条件组合查询
     * @Param注解，实现传递多个参数的命名
     * @param name ：管理员姓名（模糊查询）
     * @param  permissions  : 管理员权限
     * @return
     */
    public List<Administrator> findAdministratorByNameAndPermissions(
            @Param("name") String name,
            @Param("permissions") Integer permissions);
}