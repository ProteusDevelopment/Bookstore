package com.devcher.bookstore.payments;


import com.devcher.bookstore.payments.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/admin/payments")
    public List<Payment> getAllPayment()
    {
        return paymentRepository.findAll();
    }

    @PostMapping("/user/payments")
    public void createNewPayment(@RequestBody Payment payment)
    {
        paymentRepository.save(payment);
    }

    @GetMapping("/user/payments/{id}")
    public Payment getPayment(@PathParam("id") Long id)
    {
        return paymentRepository.findById(id).orElse(null);
    }

    @PatchMapping("/admin/payments/{id}")
    public void patchPayment(@PathParam("id") Long id,
                          @RequestBody Payment payment)
    {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);

        if (optionalPayment.isPresent())
        {
            Payment existPayment = optionalPayment.get();

            boolean needUpdate = false;

            if (payment.getOrderEntity() != null)
            {
                existPayment.setOrderEntity(payment.getOrderEntity());
                needUpdate = true;
            }

            if (StringUtils.hasLength(payment.getStatus()))
            {
                existPayment.setStatus(payment.getStatus());
                needUpdate = true;
            }

            if (needUpdate)
            {
                paymentRepository.save(existPayment);
            }

        }
    }

    @DeleteMapping("/admin/payments/{id}")
    public void deleteBook(@PathParam("id") Long id)
    {
        paymentRepository.deleteById(id);
    }
}
