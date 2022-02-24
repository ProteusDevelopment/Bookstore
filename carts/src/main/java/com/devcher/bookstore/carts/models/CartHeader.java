package com.devcher.bookstore.carts.models;

import javax.persistence.*;

@Entity
public class CartHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user;

    public CartHeader() {

    }

    public CartHeader(Long id, Long user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Long getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
