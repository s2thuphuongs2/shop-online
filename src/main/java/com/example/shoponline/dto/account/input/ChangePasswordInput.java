package com.example.shoponline.dto.account.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordInput {
	private String oldPassword;
	private String newPassword;
}
