package com.youtube.user_api.utility;

import com.youtube.user_api.dto.UserRegistrationDTO;
import com.youtube.user_api.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MappingUtility {


    public User mapUserRegistrationDtoToUser(UserRegistrationDTO userRegistrationDTO){
        User user = new User();
        user.setUsername(userRegistrationDTO.getUsername());
        user.setFirstName(userRegistrationDTO.getFirstName());
        user.setLastName(userRegistrationDTO.getLastName());
        user.setCreator(false);
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(userRegistrationDTO.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }

}
