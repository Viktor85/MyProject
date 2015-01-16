package com.test.web.model;


public class Employee {


    private int employeeId;
    private String firstName;
    private String lastName;
    private String saleItems;
    private String email;
    private String registrDate;
    private int departmentId;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(String saleItems) {
        this.saleItems = saleItems;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrDate() {
        return registrDate;
    }

    public void setRegistrDate(String registrDate) {
        this.registrDate = registrDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


}
