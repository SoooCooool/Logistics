package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.VehicleMapper;
import org.example.model.Vehicle;
import org.example.util.SqlSessionUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class VehicleTest {
    /**
     * 功能：查询员工所有信息
     */
    @Test
    public void testQueryAllVehicle(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        VehicleMapper vehicleMapper =
                sqlSession.getMapper(VehicleMapper.class);

        List<Vehicle> vehicle = vehicleMapper.findAll();
        for(Vehicle vehicles : vehicle){
            System.out.println(vehicles);
        }
        sqlSession.close();
    }

    /**
     * 测试功能：根据管理员工号删除管理员信息
     */
    @Test
    public void testDeleteVehicleId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);
        vehicleMapper.deleteVehicle("C111");
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 功能：添加管理员对象
     */
    @Test
    public void testAddVehicle() {

        //1.创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //2.创建VehicleMapper的代理子类
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);
        //3.执行添加操作
        // 3.1 测试数据（创建Employee对象）
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id("C111");
        vehicle.setDriver_id("E123456");
        vehicle.setTransfer_belong("华北");
        // 3.2 添加员工信息
        vehicleMapper.addVehicle(vehicle);
        // 注意（提交事务）
        sqlSession.commit();
        //4.关闭SqlSession对象
        sqlSession.close();

    }
    /**
     * 测试功能：根据管理员工号修改管理员信息
     */
    @Test
    public void testUpdateVehicle(){
        //1.创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //2.创建VehicleMapper的代理子类
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);
        //3.执行添加操作
        // 3.1 测试数据（创建Vehicle对象）
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id("C111");
        vehicle.setTransfer_belong("西北");
        vehicle.setDriver_id("E123001");
        // 3.2 修改员工信息
        vehicleMapper.updateVehicle(vehicle);
        // 注意（提交事务）
        sqlSession.commit();
        //4.关闭SqlSession对象
        sqlSession.close();
    }
}
