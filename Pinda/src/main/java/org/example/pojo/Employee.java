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
    private Date modifiedtime;
    private String name;
    private String phonenumber;
    private String occupation;
    private int permissions;
    private int deleted;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
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

    public void setPermissions(int permissions) {
        this.permissions = permissions;
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
                "password='" + password + '\'' +
                ", employeeid='" + employeeid + '\'' +
                ", createdtime=" + createdtime +
                ", modifiedtime=" + modifiedtime +
                ", name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", occupation='" + occupation + '\'' +
                ", permissions=" + permissions +
                ", deleted=" + deleted +
                '}';
    }
}