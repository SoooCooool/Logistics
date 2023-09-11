package org.example.pojo;
import java.util.Date;

public class Administrator {
    private String administratorid;
    private Date createtime = new Date();
    private Date modifiedtime = new Date();
    private String name;


    public String getAdminid() {
        return administratorid;
    }

    public void setAdminid(String adminid) {
        this.administratorid = adminid;
    }

    public Date getCreateDate() {
        return createtime;
    }

    public void setCreateDate(Date createDate) {
        this.createtime = createDate;
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

    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }

    public Integer getDelete() {
        return deleted;
    }

    public void setDelete(Integer delete) {
        this.deleted = delete;
    }

    private Integer permissions;
    private Integer deleted;

    public String toString() {
        return "Administrator{" +
                "administratorid='" + administratorid +
                "', createtime=" + createtime +
                ", modifiedtime=" + modifiedtime +
                ", name='" + name +
                "', permissions=" + permissions +
                ", deleted=" + deleted +
                '}';
    }
}