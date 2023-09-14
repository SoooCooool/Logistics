package org.example.dto;

public class OrdersDto {
    private String orderid;
    private String userid;
    private String employeeid;
    private String startlocation;
    private String destination;
    private Integer amount;
    private String kind;
    private Integer weight;
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getStartlocation() {
        return startlocation;
    }

    public void setStartlocation(String startlocation) {
        this.startlocation = startlocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "OrdersDto{" +
                "orderid'" + userid + '\'' +
                "userid='" + userid + '\'' +
                ", employeeid='" + employeeid + '\'' +
                ", startlocation='" + startlocation + '\'' +
                ", destination='" + destination + '\'' +
                ", amount=" + amount +
                ", kind='" + kind + '\'' +
                ", weight=" + weight +
                '}';
    }
}
