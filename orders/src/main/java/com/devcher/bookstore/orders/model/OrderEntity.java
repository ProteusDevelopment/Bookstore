package com.devcher.bookstore.orders.model;

import javax.persistence.*;

@Entity
public class OrderEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderTime;
    private String status;
    private String positionToken;


    private Long cartHeader;


    public OrderEntity(Long id, String orderTime, String status, String positionToken, Long cartHeader) {
        this.id = id;
        this.orderTime = orderTime;
        this.status = status;
        this.positionToken = positionToken;
        this.cartHeader = cartHeader;
    }

    public OrderEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getStatus() {
        return status;
    }

    public String getPositionToken() {
        return positionToken;
    }

    public Long getCartHeader() {
        return cartHeader;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPositionToken(String positionToken) {
        this.positionToken = positionToken;
    }

    public void setCartHeader(Long cartHeader) {
        this.cartHeader = cartHeader;
    }
}
