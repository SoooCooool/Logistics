package org.example.controller;

import org.example.common.Result;
import org.example.pojo.Vehicle;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/api/vehicle")
public class VehicleController {
    @Autowired(required=false)
    VehicleService vehicleService;

    @GetMapping(value = "/queryAll")
    @ResponseBody
    public Result queryAll(){
        List<Vehicle> vehicle = vehicleService.queryVehicleAll();
        return Result.success(vehicle);
    }

    @GetMapping(value = "/getbyId")
    @ResponseBody
    public Result getbyId(){
        Vehicle vehicle = vehicleService.queryVehicleById("C111");
        return Result.success(vehicle);
    }
    @GetMapping(value = "/deleteById")
    @ResponseBody
    public String deleteById(){
        vehicleService.deleteVehicle("C111");
        return "删除成功";
    }
    @GetMapping(value = "/addVehicle")
    @ResponseBody
    public void addVehicle(Vehicle vehicle){
       vehicleService.addVehicle(vehicle);
    }
    @GetMapping(value = "/updateVehicle")
    @ResponseBody
    public void updateVehicle(Vehicle vehicle){
        vehicleService.updateVehicle(vehicle);
    }
}
