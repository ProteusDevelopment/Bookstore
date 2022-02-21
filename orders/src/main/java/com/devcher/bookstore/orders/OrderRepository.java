package com.devcher.bookstore.orders;

import com.devcher.bookstore.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends
		JpaRepository<Order, Long>
{

}
