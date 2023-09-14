package org.example.dto;


public class EmployeeDto {
    private String employeeid;
    private String name;
    private String occupation;
    private String password;
    private String phonenumber;

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeid='" + employeeid + '\'' +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
//