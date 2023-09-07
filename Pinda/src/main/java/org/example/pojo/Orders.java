package org.example.pojo;

import java.util.Date;

public class Orders {
    private String order_id;
    private String user_id;
    private String employee_id;
    private String modified_person_id;
    private Date created_time;
    private Date modified_time;
    private String state;
    private String start_location;
    private String destination;
    private Integer deleted;
    private Integer amount;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getModified_person_id() {
        return modified_person_id;
    }

    public void setModified_person_id(String modified_person_id) {
        this.modified_person_id = modified_person_id;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStart_location() {
        return start_location;
    }

    public void setStart_location(String start_location) {
        this.start_location = start_location;
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
                "order_id='" + order_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", employee_id='" + employee_id + '\'' +
                ", modified_person_id='" + modified_person_id + '\'' +
                ", created_time=" + created_time +
                ", modified_time=" + modified_time +
                ", state='" + state + '\'' +
                ", start_location='" + start_location + '\'' +
                ", destination='" + destination + '\'' +
                ", deleted=" + deleted +
                ", amount=" + amount +
                '}';
    }
}
