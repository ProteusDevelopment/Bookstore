package com.devcher.bookstore.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationDtoRepository extends
		JpaRepository<UserRegistrationDtoRepository, Long>
{

}
