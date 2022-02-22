package com.devcher.bookstore.carts;

import com.devcher.bookstore.carts.models.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends
    JpaRepository<CartDetail, Long>
    {

    }

