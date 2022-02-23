package com.devcher.bookstore.payments.model;


import javax.persistence.*;
import javax.persistence.criteria.Order;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @ManyToOne
    @JoinColumn(name = "author")
    private Order order;

    public Payment(Long id, String status, Order order) {
        this.id = id;
        this.status = status;
        this.order = order;
    }

    public Payment() {

    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Order getOrder() {
        return order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
