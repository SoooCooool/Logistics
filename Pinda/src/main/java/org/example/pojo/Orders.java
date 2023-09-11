package org.example.pojo;

import java.util.Date;

public class Orders {
    private String orderid;
    private String userid;
    private String employeeid;
    private String modifiedpersonid;
    private Date createdtime;
    private Date modifiedtime;
    private String startlocation;
    private String destination;
    private Integer deleted;
    private Integer amount;
    private String kind;
    private Date arrivetransfertime;
    private Date starttime;
    private Date finaltime;
    private String presentlocation;
    private String presentstate;
    private Integer weight;

    @Override
    public String toString() {
        return "Orders{" +
                "orderid='" + orderid + '\'' +
                ", userid='" + userid + '\'' +
                ", employeeid='" + employeeid + '\'' +
                ", modifiedpersonid='" + modifiedpersonid + '\'' +
                ", createdtime=" + createdtime +
                ", modifiedtime=" + modifiedtime +
                ", startlocation='" + startlocation + '\'' +
                ", destination='" + destination + '\'' +
                ", deleted=" + deleted +
                ", amount=" + amount +
                ", kind='" + kind + '\'' +
                ", arrivetransfertime=" + arrivetransfertime +
                ", starttime=" + starttime +
                ", finaltime=" + finaltime +
                ", presentlocation='" + presentlocation + '\'' +
                ", presentstate='" + presentstate + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getArrivetransfertime() {
        return arrivetransfertime;
    }

    public void setArrivetransfertime(Date arrivetransfertime) {
        this.arrivetransfertime = arrivetransfertime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getFinaltime() {
        return finaltime;
    }

    public void setFinaltime(Date finaltime) {
        this.finaltime = finaltime;
    }

    public String getPresentlocation() {
        return presentlocation;
    }

    public void setPresentlocation(String presentlocation) {
        this.presentlocation = presentlocation;
    }

    public String getPresentstate() {
        return presentstate;
    }

    public void setPresentstate(String presentstate) {
        this.presentstate = presentstate;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }public String getOrderid() {
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


}
