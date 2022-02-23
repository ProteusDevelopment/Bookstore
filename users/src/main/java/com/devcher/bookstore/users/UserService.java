package com.devcher.bookstore.users;

import com.devcher.bookstore.users.models.Role;
import com.devcher.bookstore.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User saveUser(User user)
	{
		Role role = roleRepository.findByName("USER");
		user.setRole(role);

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}

	public User findByName(String name)
	{
		return userRepository.findByName(name);
	}

	public User findByNameAndPassword(String name,
	                                  String password)
	{
		User user = findByName(name);

		if (user != null)
		{
			if (passwordEncoder.matches(password, user.getPassword()))
			{
				return user;
			}
		}

		return null;
	}
}
