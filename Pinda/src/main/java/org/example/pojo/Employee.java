package org.example.pojo;

import java.util.Date;


/**
 * 实体层--员工类
 * 数据表字段：
 *      empolyee_id,created_time,modified_time,name,phonenumber,occupation,permission,deleted
 */
public class Employee {
    private String employee_id;
    private Date created_time;
    private Date modified_time;
    private String name;
    private int phonenumber;
    private String occupation;
    private int permissions;
    private int deleted;
    public String getEmployee_id() {return employee_id;}
    public void setEmployee_id(String employee_id){this.employee_id=employee_id;}
    public Date getCreated_time(){return created_time;}
    public void setCreated_time(Date created_time){this.created_time=created_time;}

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permission) {
        this.permissions = permission;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id='" + employee_id + '\'' +
                ", created_time=" + created_time +
                ", modified_time=" + modified_time +
                ", name='" + name + '\'' +
                ", phonenumber=" + phonenumber +
                ", occupation='" + occupation + '\'' +
                ", permissions=" + permissions +
                ", deleted=" + deleted +
                '}';
    }
}