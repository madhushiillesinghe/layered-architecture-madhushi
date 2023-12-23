package com.example.layeredarchitecture.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerOrderDTO implements Serializable {
    private String id;
    private String name;
    private String address;
    private String orderId;
    private LocalDate orderDate;


    public CustomerOrderDTO() {

    }

    public CustomerOrderDTO(String id, String name, String address,String orderId, LocalDate orderDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orderId = orderId;
        this.orderDate = orderDate;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }



    @Override
    public String toString() {
        return "CustomerOrderDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
