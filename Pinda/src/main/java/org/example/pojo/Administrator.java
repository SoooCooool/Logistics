package org.example.pojo;
import java.util.Date;

public class Administrator {
    private String administratorid;
    private Date createdtime;
    private Date modifiedtime;
    private String name;
    private String password;

    private Integer permissions;
    private Integer deleted;

    @Override
    public String toString() {
        return "Administrator{" +
                "administratorid='" + administratorid + '\'' +
                ", createdtime=" + createdtime +
                ", modifiedtime=" + modifiedtime +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", permissions=" + permissions +
                ", deleted=" + deleted +
                '}';
    }

    public String getAdministratorid() {
        return administratorid;
    }

    public void setAdministratorid(String administratorid) {
        this.administratorid = administratorid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}