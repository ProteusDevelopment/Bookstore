package com.devcher.bookstore.users;

import com.devcher.bookstore.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository usersRepository;

    @GetMapping("/admin/users")
    public List<User> getAllUsers()
    {
        return usersRepository.findAll();
    }

    @GetMapping("/user/users/{id}")
    public User getUser(@PathParam("id") Long id)
    {
        return usersRepository.findById(id).orElse(null);
    }

    @PatchMapping("/user/users/{id}")
    public void patchUser(@PathParam("id") Long id,
                          @RequestBody User user)
    {
        Optional<User> optionalUser = usersRepository.findById(id);

        if (optionalUser.isPresent())
        {
            User existUser = optionalUser.get();

            boolean needUpdate = false;

            if (StringUtils.hasLength(user.getName()))
            {
                existUser.setName(user.getName());
                needUpdate = true;
            }

            if (StringUtils.hasLength(user.getPhone()))
            {
                existUser.setPhone(user.getPhone());
                needUpdate = true;
            }


            if (StringUtils.hasLength(user.getEmail()))
            {
                existUser.setEmail(user.getEmail());
                needUpdate = true;
            }

            if (StringUtils.hasLength(user.getPassword()))
            {
                existUser.setPassword(user.getPassword());
                needUpdate = true;
            }

            if (StringUtils.hasLength(user.getAddress()))
            {
                existUser.setAddress(user.getAddress());
                needUpdate = true;
            }

            if (user.getRole() != null)
            {
                existUser.setRole(user.getRole());
                needUpdate = true;
            }

            if (needUpdate)
            {
                usersRepository.save(existUser);
            }
        }
    }

    @DeleteMapping("/user/users/{id}")
    public void deleteUser(@PathParam("id") Long id)
    {
        usersRepository.deleteById(id);
    }
}
