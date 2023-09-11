package org.example.pojo;

import java.util.Date;

public class Merchandise {
    private String orderid;
    private String kind;
    private Date arrivetransfertime;
    private Date starttime;
    private Date finaltime;
    private String presentlocation;
    private String presentstate;
    private Integer weight;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
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
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "orderid='" + orderid + '\'' +
                ", kind='" + kind + '\'' +
                ", arrivetransfertime=" + arrivetransfertime +
                ", starttime=" + starttime +
                ", finaltime=" + finaltime +
                ", presentlocation='" + presentlocation + '\'' +
                ", presentstate='" + presentstate + '\'' +
                ", weight=" + weight +
                '}';
    }
}
