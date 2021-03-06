package com.devcher.bookstore.users;

import com.devcher.bookstore.users.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails
{
	private String name;
	private String password;
	private Collection<? extends GrantedAuthority> grantedAuthorities;

	public static CustomUserDetails fromUserToCustomUserDetails(User user)
	{
		CustomUserDetails customUserDetails = new CustomUserDetails();
		customUserDetails.name = user.getName();
		customUserDetails.password = user.getPassword();
		customUserDetails.grantedAuthorities = Collections.singletonList(
				new SimpleGrantedAuthority(user.getRole().getName()));

		return customUserDetails;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return grantedAuthorities;
	}

	@Override
	public String getUsername()
	{
		return name;
	}

	@Override
	public String getPassword()
	{
		return password;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}
}
