package org.example.dto;

import java.util.Date;

public class AdministratorDto {
    private String administratorid;
    private String name;
    private String password;

    public String getAdministratorid() {
        return administratorid;
    }

    public void setAdministratorid(String administratorid) {
        this.administratorid = administratorid;
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


    @Override
    public String toString() {
        return "AdministratorDto{" +
                "administratorid='" + administratorid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
