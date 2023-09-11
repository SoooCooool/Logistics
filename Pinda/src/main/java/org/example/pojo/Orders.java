package org.example.pojo;

import java.util.Date;

public class Orders {
    private String orderid;
    private String userid;
    private String employeeid;
    private String modifiedpersonid;
    private Date createdtime;
    private Date modifiedtime;
    private String state;
    private String startlocation;
    private String destination;
    private Integer deleted;
    private Integer amount;

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

    public String getModifiedpersonid() {
        return modifiedpersonid;
    }

    public void setModifiedpersonid(String modifiedpersonid) {
        this.modifiedpersonid = modifiedpersonid;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderid='" + orderid + '\'' +
                ", userid='" + userid + '\'' +
                ", employeeid='" + employeeid + '\'' +
                ", modifiedpersonid='" + modifiedpersonid + '\'' +
                ", createdtime=" + createdtime +
                ", modifiedtime=" + modifiedtime +
                ", state='" + state + '\'' +
                ", startlocation='" + startlocation + '\'' +
                ", destination='" + destination + '\'' +
                ", deleted=" + deleted +
                ", amount=" + amount +
                '}';
    }
}
