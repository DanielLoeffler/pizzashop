package org.test.webapp.project.dto;

import java.util.Date;

public class Order {

    private Integer id;
    private Date date;
    private String phone;
    private String address;

    public Order() {
    }

    public Order(Integer id, Date date, String phone, String address) {
        this.id = id;
        this.date = date;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "#" + id + ": " + date + ", "+phone+", "+address;
    }
}
