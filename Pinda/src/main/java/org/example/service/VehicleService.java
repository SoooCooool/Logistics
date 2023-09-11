package org.example.service;

import org.example.pojo.User;
import org.example.pojo.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> queryVehicleAll();
    public Vehicle queryVehicleById(String id);
    public void deleteVehicle(String id);
    public void addVehicle(Vehicle vehicle);
    public void updateVehicle(Vehicle vehicle);
}
