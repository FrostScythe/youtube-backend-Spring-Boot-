package com.youtube.user_api.service;

import com.youtube.user_api.connectors.DatabaseApiConnector;
import com.youtube.user_api.connectors.NotificationApiConnector;
import com.youtube.user_api.dto.UserRegistrationDTO;
import com.youtube.user_api.models.User;
import com.youtube.user_api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    MappingUtility mappingUtility;
    DatabaseApiConnector databaseApiConnector;
    NotificationApiConnector notificationApiConnector;
    @Autowired
    public UserService(MappingUtility mappingUtility,
                       DatabaseApiConnector databaseApiConnector,
                       NotificationApiConnector notificationApiConnector){
        this.mappingUtility = mappingUtility;
        this.databaseApiConnector = databaseApiConnector;
        this.notificationApiConnector = notificationApiConnector;
    }

    /**
     * Work of this function is to call the database api to register user inside the user table
     * after calling database api and the database api call is successfull then it will call notifaction api
     * Notification will notify regarding successfull registration of user in the database
     */
    public User registerUser(UserRegistrationDTO userRegistrationDTO){
        // 1. Map userRegistrationDto to User Model -> Why ?
        // Mapping logic I will not write here ->
        User user = mappingUtility.mapUserRegistrationDtoToUser(userRegistrationDTO);
        // 2. Database API -> To register user inside the database.
        user = databaseApiConnector.callCreateUserEndpoint(user);
        // 3. Call notification api to notify user that his details got succesfulluy registered in our application
        // We will develop it later
        notificationApiConnector.callSendUserRegistrationNOtificationEndpoint(user.getEmail(), user.getFirstName());
        return user;
    }
}
