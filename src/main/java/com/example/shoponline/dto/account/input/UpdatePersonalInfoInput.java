package com.example.shoponline.dto.account.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdatePersonalInfoInput {
	private String name;
	private LocalDate birthday;
	private String cardIdNumber;
	private String phoneNumber;
}
