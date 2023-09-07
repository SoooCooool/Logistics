package org.example.model;

import java.util.Date;

/**
 * 实体层--货物类
 * 数据表字段：
 *      order_id,kind,weight,arrive_transfer_time,start_time,final_time,present_location,present_state
 */
public class Merchandise {
    private String order_id;
    private String kind;
    private int weight;
    private Date arrive_transfer_time;
    private Date start_time;
    private Date final_time;
    private String present_location;
    private String present_state;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
}
