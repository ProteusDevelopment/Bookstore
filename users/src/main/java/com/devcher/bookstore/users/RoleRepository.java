package com.devcher.bookstore.users;

import com.devcher.bookstore.users.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends
		JpaRepository<Role, Long>
{
	Role findByName(String name);
}
