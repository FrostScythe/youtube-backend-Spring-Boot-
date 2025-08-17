package com.youtube.notification_api.controllers;

import com.youtube.notification_api.services.UserNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notify/user")
public class UserNotificationController {

    UserNotificationService userNotificationService;

    @Autowired
    public UserNotificationController(UserNotificationService userNotificationService){
        this.userNotificationService = userNotificationService;
    }

    @PutMapping("/register")
    public void sendUserRegistrationNotification(@RequestParam String email,
                                                 @RequestParam String userName){
        // I will call userNotificationService -> Which will actually send email for me.
        userNotificationService.sendUserRegistrationNotification(userName, email);
    }
}
