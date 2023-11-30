package com.example.shoponline.dto.account.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class UpdatePersonalInfoInput {
    private String name;
    private Date birthday;
    private String cardIdNumber;
    private String phoneNumber;
}
