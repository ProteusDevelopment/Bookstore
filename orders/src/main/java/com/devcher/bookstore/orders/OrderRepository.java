package com.devcher.bookstore.orders;

import com.devcher.bookstore.orders.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends
		JpaRepository<OrderEntity, Long>
{

}
