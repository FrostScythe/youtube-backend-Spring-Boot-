package com.youtube.user_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isCreator = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

