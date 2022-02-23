package com.devcher.bookstore.orders.model;

import antlr.Token;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderTime;
    private String status;
    private String positionToken;


    @ManyToOne
    @JoinColumn(name = "cartHeard")
    private CartHeard cartHeard;


    public Order(Long id, String orderTime, String status, String positionToken, CartHeard cartHeard) {
        this.id = id;
        this.orderTime = orderTime;
        this.status = status;
        this.positionToken = positionToken;
        this.cartHeard = cartHeard;
    }

    public Order() {

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

    public CartHeard getCartHeard() {
        return cartHeard;
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

    public void setCartHeard(CartHeard cartHeard) {
        this.cartHeard = cartHeard;
    }
}
