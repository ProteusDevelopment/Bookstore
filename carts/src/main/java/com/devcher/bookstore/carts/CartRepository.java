package com.devcher.bookstore.carts;

import com.devcher.bookstore.carts.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends
    JpaRepository<Cart, Long>
    {

    }

