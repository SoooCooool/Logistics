package org.example.pojo;

public class Vehicle {
    private String vehicle_id;

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_id='" + vehicle_id + '\'' +
                ", transfer_belong='" + transfer_belong + '\'' +
                ", driver_id='" + driver_id + '\'' +
                '}';
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public void setTransfer_belong(String transfer_belong) {
        this.transfer_belong = transfer_belong;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    private String transfer_belong;

    public String getVehicle_id() {
        return vehicle_id;
    }

    public String getTransfer_belong() {
        return transfer_belong;
    }

    public String getDriver_id() {
        return driver_id;
    }

    private String driver_id;

}
