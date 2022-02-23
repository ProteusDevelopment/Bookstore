package com.devcher.bookstore.payments;


import com.devcher.bookstore.payments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends
		JpaRepository<Payment, Long>
{

}
