package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.EmployeeMapper;
import org.example.pojo.Employee;
import org.example.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class EmployeeTest {
        @Test
        public void find(){
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        /*List<Employee> employeelist  =
                sqlSession.selectList("org.example.dao.EmployeeMapper.findall");
        System.out.println(employeelist);*/
            EmployeeMapper employeeMaper =
                    sqlSession.getMapper(EmployeeMapper.class);

            List<Employee> employees =
                    employeeMaper.findall();
            for(Employee emp : employees){
                System.out.println(emp);
            }
        /*sqlSession.commit();
        sqlSession.close();*/
        }
        @Test
        public void find1(){
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        /*List<Employee> employeeList =
         sqlSession.selectList("org.example.dao.EmployeeMapper.findEmployeeByphonenumberandoccupation");
        System.out.println(employeeList);
        sqlSession.commit();
        sqlSession.close();*/
            EmployeeMapper employeeMaper =
                    sqlSession.getMapper(EmployeeMapper.class);

            List<Employee> employees =
                    employeeMaper.findEmployeeByphonenumberandoccupation("1","司机");
            for(Employee emp : employees){
                System.out.println(emp);
            }
        }
        @Test
        public void insert(){
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();
            EmployeeMapper employeeMapper =
                    sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setEmployee_id("11");
            employee.setName("11");
            Date i = new Date(153,9,8);
            employee.setCreated_time(i);
            employee.setDeleted(0);
            employee.setOccupation("派送员");
            employee.setPermissions(2);
            employee.setPhonenumber(1234567891);
            Date o = new Date(153,9,11);
            employee.setModified_time(o);
            employeeMapper.insert(employee);
            sqlSession.commit();
            sqlSession.close();

        }
        @Test
        public void delete(){
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();
            EmployeeMapper employeeMapper =
                    sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.delete("11");
            sqlSession.commit();
            sqlSession.close();
        }
        @Test
        public void update(){
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();
            EmployeeMapper employeeMapper =
                    sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setEmployee_id("11");
            employee.setName("22");
            Date i = new Date(154,10,9);
            employee.setCreated_time(i);
            employee.setDeleted(1);
            employee.setOccupation("派送员1");
            employee.setPermissions(2);
            employee.setPhonenumber(1234567890);
            Date o = new Date(154,10,12);
            employee.setModified_time(o);
            employeeMapper.update(employee);
            sqlSession.commit();
            sqlSession.close();
        }

}
