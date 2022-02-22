package com.devcher.bookstore.users;

import com.devcher.bookstore.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends
        JpaRepository<User, Long>
{

}




