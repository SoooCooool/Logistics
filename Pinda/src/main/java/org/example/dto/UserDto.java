package org.example.dto;

public class UserDto {
    private String userid;
    private String name;
    private String phonenumber;
    private String location;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
