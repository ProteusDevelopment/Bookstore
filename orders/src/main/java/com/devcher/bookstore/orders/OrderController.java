package com.devcher.bookstore.orders;


import com.devcher.bookstore.orders.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

    @PostMapping("/")
    public void createNewOrder(@RequestBody Order order)
    {
        orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathParam("id") Long id)
    {
        return orderRepository.findById(id).orElse(null);
    }

    @PatchMapping("/{id}")
    public void patchOrder(@PathParam("id") Long id,
                          @RequestBody Order order)
    {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent())
        {
            Order existOrder = optionalOrder.get();

            boolean needUpdate = false;

            if (StringUtils.hasLength(order.getOrderTime()))
            {
                existOrder.setOrderTime(order.getOrderTime());
                needUpdate = true;
            }

            if (StringUtils.hasLength(order.getStatus()))
            {
                existOrder.setStatus(order.getStatus());
                needUpdate = true;
            }

            if (StringUtils.hasLength(order.getPositionToken()))
            {
                existOrder.setPositionToken(order.getPositionToken());
                needUpdate = true;
            }


            if (order.getCartHeard() != null)
            {
                existOrder.setCartHeard(order.getCartHeard());
                needUpdate = true;
            }

            if (needUpdate)
            {
                orderRepository.save(existOrder);
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathParam("id") Long id)
    {
        orderRepository.deleteById(id);
    }
}
