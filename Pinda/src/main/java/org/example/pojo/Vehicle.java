package org.example.pojo;

public class Vehicle {
    private String vehicleid;

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleid='" + vehicleid + '\'' +
                ", transferbelong='" + transferbelong + '\'' +
                ", driverid='" + driverid + '\'' +
                '}';
    }

    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid;
    }

    public void setTransferbelong(String transferbelong) {
        this.transferbelong = transferbelong;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    private String transferbelong;

    public String getVehicleid() {
        return vehicleid;
    }

    public String getTransferbelong() {
        return transferbelong;
    }

    public String getDriverid() {
        return driverid;
    }

    private String driverid;

}
