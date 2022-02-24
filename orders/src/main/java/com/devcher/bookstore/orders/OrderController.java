package com.devcher.bookstore.orders;


import com.devcher.bookstore.orders.model.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/admin/orders")
    public List<OrderEntity> getAllOrders()
    {
        return orderRepository.findAll();
    }

    @PostMapping("/user/orders")
    public void createNewOrder(@RequestBody OrderEntity orderEntity)
    {
        orderRepository.save(orderEntity);
    }

    @GetMapping("/user/orders/{id}")
    public OrderEntity getOrder(@PathParam("id") Long id)
    {
        return orderRepository.findById(id).orElse(null);
    }

    @PatchMapping("/user/orders/{id}")
    public void patchOrder(@PathParam("id") Long id,
                          @RequestBody OrderEntity orderEntity)
    {
        Optional<OrderEntity> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent())
        {
            OrderEntity existOrderEntity = optionalOrder.get();

            boolean needUpdate = false;

            if (StringUtils.hasLength(orderEntity.getOrderTime()))
            {
                existOrderEntity.setOrderTime(orderEntity.getOrderTime());
                needUpdate = true;
            }

            if (StringUtils.hasLength(orderEntity.getStatus()))
            {
                existOrderEntity.setStatus(orderEntity.getStatus());
                needUpdate = true;
            }

            if (StringUtils.hasLength(orderEntity.getPositionToken()))
            {
                existOrderEntity.setPositionToken(orderEntity.getPositionToken());
                needUpdate = true;
            }


            if (orderEntity.getCartHeader() != null)
            {
                existOrderEntity.setCartHeader(orderEntity.getCartHeader());
                needUpdate = true;
            }

            if (needUpdate)
            {
                orderRepository.save(existOrderEntity);
            }
        }
    }

    @DeleteMapping("/user/orders/{id}")
    public void deleteBook(@PathParam("id") Long id)
    {
        orderRepository.deleteById(id);
    }
}
