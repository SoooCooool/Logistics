package org.example.pojo;

import java.util.Date;

public class Merchandise {
    private String order_id;
    private String kind;
    private Date arrive_transfer_time;
    private Date start_time;
    private Date final_time;
    private String present_location;
    private String present_state;
    private Integer weight;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getArrive_transfer_time() {
        return arrive_transfer_time;
    }

    public void setArrive_transfer_time(Date arrive_transfer_time) {
        this.arrive_transfer_time = arrive_transfer_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getFinal_time() {
        return final_time;
    }

    public void setFinal_time(Date final_time) {
        this.final_time = final_time;
    }

    public String getPresent_location() {
        return present_location;
    }

    public void setPresent_location(String present_location) {
        this.present_location = present_location;
    }

    public String getPresent_state() {
        return present_state;
    }

    public void setPresent_state(String present_state) {
        this.present_state = present_state;
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
                "order_id='" + order_id + '\'' +
                ", kind='" + kind + '\'' +
                ", arrive_transfer_time=" + arrive_transfer_time +
                ", start_time=" + start_time +
                ", final_time=" + final_time +
                ", present_location='" + present_location + '\'' +
                ", present_state='" + present_state + '\'' +
                ", weight=" + weight +
                '}';
    }
}