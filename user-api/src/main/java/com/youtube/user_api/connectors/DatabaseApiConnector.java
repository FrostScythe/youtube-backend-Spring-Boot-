package com.youtube.user_api.connectors;

import com.youtube.user_api.models.User;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This class will have different methods with the help of which you will be hitting
 * different endpoints of database-api
 */
@Component
public class DatabaseApiConnector {

    String databaseApiBaseUrl = "http://localhost:8081/api/v1/db";

    /**
     * Work of this method will be to call the create user endpoint of database api
     * /api/v1/db/user/create
     */
    public User callCreateUserEndpoint(User user){
        // 1. We are creating the url -> Which we want to hit
        String url = databaseApiBaseUrl + "/user/create";
        // 2. Creating the reuqest with the restmethod with which we want to call the url and request body
        RequestEntity request = RequestEntity.post(url).body(user);
        // 3. Hit the request -> RestTemplate class help us to hit the endpoint
        RestTemplate restTemplate = new RestTemplate();
        // .exchange method is actiually making the request to the database apo
        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.POST, request, User.class);
        return response.getBody();
    }

}
