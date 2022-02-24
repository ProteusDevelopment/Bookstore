package com.devcher.bookstore.payments.model;


import javax.persistence.*;

@Entity
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    private Long orderEntity;

    public Payment(Long id, String status, Long orderEntity) {
        this.id = id;
        this.status = status;
        this.orderEntity = orderEntity;
    }

    public Payment() {

    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Long getOrderEntity() {
        return orderEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderEntity(Long orderEntity) {
        this.orderEntity = orderEntity;
    }
}
