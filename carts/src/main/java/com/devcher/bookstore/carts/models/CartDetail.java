package com.devcher.bookstore.carts.models;

import javax.persistence.*;
import java.awt.print.Book;

@Entity
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "cartHeader")
    private CartHeader cartHeader;

    private Long book;



    public CartDetail() {

    }

    public CartDetail(Long id, Integer count, CartHeader cartHeader, Long book) {
        this.id = id;
        this.count = count;
        this.cartHeader = cartHeader;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public Integer getCount() {
        return count;
    }

    public CartHeader getCartHeader() {
        return cartHeader;
    }

    public Long getBook() {
        return book;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setCartHeader(CartHeader cartHeader) {
        this.cartHeader = cartHeader;
    }

    public void setBook(Long book) {
        this.book = book;
    }
}
