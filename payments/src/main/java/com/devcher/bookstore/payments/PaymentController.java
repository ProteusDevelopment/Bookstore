package com.devcher.bookstore.payments;


import com.devcher.bookstore.payments.model.Payment;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/")
    public List<Payment> getAllPayment()
    {
        return paymentRepository.findAll();
    }

    @PostMapping("/")
    public void createNewPayment(@RequestBody Payment payment)
    {
        paymentRepository.save(payment);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathParam("id") Long id)
    {
        return paymentRepository.findById(id).orElse(null);
    }

    @PatchMapping("/{id}")
    public void patchPayment(@PathParam("id") Long id,
                          @RequestBody Payment payment)
    {
        Optional<Payment> optionalBook = paymentRepository.findById(id);

        if (optionalBook.isPresent())
        {
            Payment existBook = optionalBook.get();

            boolean needUpdate = false;

            if (StringUtils.hasLength(book.getName()))
            {
                existBook.setName(book.getName());
                needUpdate = true;
            }

            if (StringUtils.hasLength(book.getDescription()))
            {
                existBook.setDescription(book.getDescription());
                needUpdate = true;
            }

            if (book.getPrice() > 0)
            {
                existBook.setPrice(book.getPrice());
                needUpdate = true;
            }

            if (StringUtils.hasLength(book.getImgUrl()))
            {
                existBook.setImgUrl(book.getImgUrl());
                needUpdate = true;
            }

            if (book.getAuthor() != null)
            {
                existBook.setAuthor(book.getAuthor());
                needUpdate = true;
            }

            if (book.getTheme() != null)
            {
                existBook.setTheme(book.getTheme());
                needUpdate = true;
            }

            if (needUpdate)
            {
                booksRepository.save(existBook);
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathParam("id") Long id)
    {
        booksRepository.deleteById(id);
    }
}
