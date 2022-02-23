package com.devcher.bookstore.users;

import com.devcher.bookstore.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserService userService;

	@Override
	public CustomUserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException
	{
		User user = userService.findByName(username);

		return CustomUserDetails.fromUserToCustomUserDetails(user);
	}
}
