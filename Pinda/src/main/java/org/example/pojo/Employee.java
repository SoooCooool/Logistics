package org.example.pojo;

import java.util.Date;


/**
 * 实体层--员工类
 * 数据表字段：
 *      empolyee_id,created_time,modified_time,name,phonenumber,occupation,permission,deleted
 */
public class Employee {
    private String password;
    private String employeeid;
    private Date createdtime;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Date modifiedtime;
    private String name;
    private int phonenumber;
    private String occupation;
    private int permissions;
    private int deleted;
    public String getEmployeeid() {return employeeid;}
    public void setEmployeeid(String employeeid){this.employeeid=employeeid;}
    public Date getCreatedtime(){return createdtime;}
    public void setCreatedtime(Date createdtime){this.createdtime=createdtime;}

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
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
                "employeeid='" + employeeid + '\'' +
                ", createdtime=" + createdtime +
                ", modifiedtime=" + modifiedtime +
                ", name='" + name + '\'' +
                ", phonenumber=" + phonenumber +
                ", occupation='" + occupation + '\'' +
                ", permissions=" + permissions +
                ", deleted=" + deleted +
                '}';
    }
}