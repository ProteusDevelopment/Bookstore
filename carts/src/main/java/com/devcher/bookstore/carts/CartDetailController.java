package com.devcher.bookstore.carts;

import com.devcher.bookstore.carts.models.CartDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
public class CartDetailController
{
    @Autowired
    private CartDetailRepository cartsDetailRepository;

    @GetMapping("/")
    public List<CartDetail> getAllCarts()
    {
        return cartsDetailRepository.findAll();
    }

    @PostMapping("/")
    public void createNewCart(@RequestBody CartDetail cartDetail)
    {
        cartsDetailRepository.save(cartDetail);
    }

    @GetMapping("/{id}")
    public CartDetail getCart(@PathParam("id") Long id)
    {
        return cartsDetailRepository.findById(id).orElse(null);
    }

    @PatchMapping("/{id}")
    public void patchCart(@PathParam("id") Long id,
                          @RequestBody CartDetail cartDetail)
    {
        Optional<CartDetail> optionalCartDetail = cartsDetailRepository.findById(id);

        if (optionalCartDetail.isPresent())
        {
            CartDetail existCartDetail = optionalCartDetail.get();

            boolean needUpdate = false;

            if (cartDetail.getCount() > 0)
            {
                existCartDetail.setCount(cartDetail.getCount());
                needUpdate = true;
            }


            if (cartDetail.getCartHeader() != null)
            {
                existCartDetail.setCartHeader(cartDetail.getCartHeader());
                needUpdate = true;
            }

            if (cartDetail.getBook() != null)
            {
                existCartDetail.setBook(cartDetail.getBook());
                needUpdate = true;
            }

            if (needUpdate)
            {
                cartsDetailRepository.save(existCartDetail);
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathParam("id") Long id)
    {
        cartsDetailRepository.deleteById(id);
    }
}
