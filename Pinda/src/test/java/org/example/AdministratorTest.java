package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.AdministratorMapper;
import org.example.pojo.Administrator;
import org.example.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class AdministratorTest {



    @Test
    public void testMethod1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        System.out.println(sqlSession);
    }

    /**
     * 功能：查询员工所有信息
     */
    @Test
    public void testQueryAllAdministrator(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AdministratorMapper administratorMapper =
                sqlSession.getMapper(AdministratorMapper.class);

        List<Administrator> administrator = administratorMapper.findAll();
        for(Administrator admin : administrator){
            System.out.println(admin);
        }
        sqlSession.close();
    }
    /**
     * 测试功能：根据管理员工号查询员工对象
     */
    @Test
    public void testGetAdministratorById(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        //2.创建AdministratorMapper的代理对象
        AdministratorMapper administratorMapper =
                sqlSession.getMapper(AdministratorMapper.class);
        //3.实现查询操作
        Administrator administrator = administratorMapper.getAdministratorbyId("M654321");
        System.out.println(administrator);
        //4.关闭SqlSession对象
        sqlSession.close();

    }
    /**
     * 功能：添加管理员对象
     */
    @Test
    public void testAddAdministrator() {

        //1.创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //2.创建EmployeeMapper的代理子类
        AdministratorMapper administratorMapper = sqlSession.getMapper(AdministratorMapper.class);
        //3.执行添加操作
        // 3.1 测试数据（创建Employee对象）
        Administrator administrator = new Administrator();
        administrator.setAdmin_id("M194321");
        Date date1=new Date(153,5,7);
        Date date2=new Date(133,9,7);
        administrator.setCreate_Date(date1);
        administrator.setModified_time(date2);
        administrator.setName("胡英俊");
        administrator.setPermissions(3);
        administrator.setDelete(0);
        // 3.2 添加员工信息
        administratorMapper.addAdministrator(administrator);
        // 注意（提交事务）
        sqlSession.commit();
        //4.关闭SqlSession对象
        sqlSession.close();

    }


    /**
     * 测试功能：根据管理员工号删除管理员信息
     */
    @Test
    public void testDeleteAdministratorId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AdministratorMapper administratorMapper = sqlSession.getMapper(AdministratorMapper.class);
        administratorMapper.deleteAdministrator("M104321");
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     * 测试功能：根据管理员工号修改管理员信息
     */
    @Test
    public void testUpdateAdministrator(){
        //1.创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //2.创建AdministratorMapper的代理子类
        AdministratorMapper administratorMapper = sqlSession.getMapper(AdministratorMapper.class);
        //3.执行添加操作
        // 3.1 测试数据（创建Administrator对象）
        Administrator administrator = new Administrator();
        administrator.setAdmin_id("M104321");
        Date date1=new Date(118,1,2);
        Date date2=new Date(123,9,7);
        administrator.setCreate_Date(date1);
        administrator.setModified_time(date2);
        administrator.setName("张绍刚");
        administrator.setPermissions(4);
        administrator.setDelete(0);
        // 3.2 修改员工信息
        administratorMapper.updateAdministrator(administrator);
        // 注意（提交事务）
        sqlSession.commit();
        //4.关闭SqlSession对象
        sqlSession.close();
    }

    /**
     * 测试功能：
     *  1.多个条件的组合查询
     *  2.带有多个参数的查询操作
     */
    @Test
    public void testQueryAdministratorByNameAndPermissions(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AdministratorMapper administratorMapper = sqlSession.getMapper(AdministratorMapper.class);
        List<Administrator> administrator =
                administratorMapper.findAdministratorByNameAndPermissions("牛",4);
        for(Administrator Administrator : administrator){
            System.out.println(Administrator);
        }
        sqlSession.close();
    }
}
