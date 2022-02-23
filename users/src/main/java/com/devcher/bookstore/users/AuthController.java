package com.devcher.bookstore.users;

import com.devcher.bookstore.users.model.UserAuthResponse;
import com.devcher.bookstore.users.model.UserLoginDto;
import com.devcher.bookstore.users.model.UserRegistrationDto;
import com.devcher.bookstore.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController
{
	@Autowired
	private UserService userService;
	@Autowired
	private JwtProvider jwtProvider;

	@PostMapping("/register")
	public String register(@RequestBody @Valid UserRegistrationDto userRegistrationDto)
	{
		User user = new User();
		user.setName(userRegistrationDto.getName());
		user.setPassword(userRegistrationDto.getPassword());
		user.setEmail(userRegistrationDto.getEmail());
		user.setPhone(userRegistrationDto.getPhone());
		user.setAddress(userRegistrationDto.getAddress());

		userService.saveUser(user);

		return "OK";
	}

	@PostMapping("/auth")
	public UserAuthResponse auth(@RequestBody UserLoginDto userLoginDto)
	{
		User user = userService.findByNameAndPassword(userLoginDto.getName(), userLoginDto.getPassword());

		String token = user != null ? jwtProvider.generateToken(user.getName()) : "null";

		return new UserAuthResponse(token);
	}
}
