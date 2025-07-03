package com.pmlfl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;


}
