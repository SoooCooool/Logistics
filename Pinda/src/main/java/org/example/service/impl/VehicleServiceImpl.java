package org.example.service.impl;

import org.example.dao.VehicleMapper;
import org.example.pojo.Vehicle;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleMapper vehicleMapper;
    @Override
    public List<Vehicle> queryVehicleAll(){return vehicleMapper.findAll();}
    @Override
    public Vehicle queryVehicleById(String id){return vehicleMapper.getVehiclebyId(id);}

    @Override
    public void deleteVehicle(String id){vehicleMapper.deleteVehicle(id);}
    @Override
    public void addVehicle(Vehicle vehicle){vehicleMapper.addVehicle(vehicle);}
    @Override
    public void updateVehicle(Vehicle vehicle){vehicleMapper.updateVehicle(vehicle);}
}
