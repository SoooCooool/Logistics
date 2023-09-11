package org.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Vehicle;
import org.springframework.stereotype.Repository;



public interface VehicleMapper {
    /**
     * 功能：查询车辆所有信息
     *
     * @return
     */

    public List<Vehicle> findAll();

    /**
     * 功能：根据车辆号查询车辆信息
     * @param vehicle_id
     * @return
     */
    public Vehicle getVehiclebyId(String vehicleid);
    /**
     * 功能：添加车辆信息
     * @param vehicle ：车辆对象
     * @return ：受影响的行数
     */
    public Integer addVehicle(Vehicle vehicle);

    /**
     * 功能：根据车辆号修改车辆信息
     * @param vehicle
     * @return
     */
    public Integer updateVehicle(Vehicle vehicle);
    /**
     * 功能：根据车辆号删除车辆信息
     * @param vehicleid ：要删除的车辆号
     * @return
     */
    public Integer deleteVehicle(String vehicleid);
}