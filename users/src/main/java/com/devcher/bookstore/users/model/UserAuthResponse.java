package com.devcher.bookstore.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthResponse
{
	private String token;
}
