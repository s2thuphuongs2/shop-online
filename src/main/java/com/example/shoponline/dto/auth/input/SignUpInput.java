package com.example.shoponline.dto.auth.input;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class SignUpInput {
    private String username;
    private String password;
    private String name;
    //    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthday;  // Ngày sinh (YYYY-MM-DD)
    private String cardIdNumber;
    private String phoneNumber;


}
