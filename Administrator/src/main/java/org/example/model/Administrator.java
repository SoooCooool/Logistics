package org.example.model;
import java.util.Date;

public class Administrator {
    private String administrator_id;
    private Date create_time = new Date();
    private Date modified_time = new Date();
    private String name;


    public String getAdmin_id() {
        return administrator_id;
    }

    public void setAdmin_id(String admin_id) {
        this.administrator_id = admin_id;
    }

    public Date getCreate_Date() {
        return create_time;
    }

    public void setCreate_Date(Date create_Date) {
        this.create_time = create_Date;
    }

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
                "administrator_id='" + administrator_id +
                "', create_time=" + create_time +
                ", modified_time=" + modified_time +
                ", name='" + name +
                "', permissions=" + permissions +
                ", deleted=" + deleted +
                '}';
    }
}