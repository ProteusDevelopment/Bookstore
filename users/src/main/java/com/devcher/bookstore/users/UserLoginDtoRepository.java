package com.devcher.bookstore.users;


import com.devcher.bookstore.users.model.UserLoginDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginDtoRepository extends
		JpaRepository<UserLoginDto, Long>
{

}
