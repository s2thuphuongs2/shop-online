package com.example.shoponline.entity;

import com.example.shoponline.customenum.RoleEnum;
import com.example.shoponline.customenum.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "library_user")
public class UserEntity extends SuperEntity {

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserTypeEnum type;
    //    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "card_id_number", unique = true)
    private String cardIdNumber;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

}
