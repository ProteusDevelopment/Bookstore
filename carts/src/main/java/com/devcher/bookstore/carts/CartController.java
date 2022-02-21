package com.devcher.bookstore.carts;

import com.devcher.bookstore.books.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
public class CartController
{
    @Autowired
    private CartRepository cartsRepository;

    @GetMapping("/")
    public List<Cart> getAllCarts()
    {
        return cartsRepository.findAll();
    }

    @PostMapping("/")
    public void createNewCart(@RequestBody Cart cart)
    {
        booksRepository.save(cart);
    }

    @GetMapping("/{id}")
    public Book getCart(@PathParam("id") Long id)
    {
        return cartsRepository.findById(id).orElse(null);
    }

    @PatchMapping("/{id}")
    public void patchCart(@PathParam("id") Long id,
                          @RequestBody Cart cart)
    {
        Optional<Cart> optionalCart = CartRepository.findById(id);

        if (optionalCart.isPresent())
        {
            Cart existCart = optionalCart.get();

            boolean needUpdate = false;

            if (StringUtils.hasLength(Cart.getName()))
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
