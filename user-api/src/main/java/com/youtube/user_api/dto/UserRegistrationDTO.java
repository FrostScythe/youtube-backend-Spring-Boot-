package com.youtube.user_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegistrationDTO {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}

