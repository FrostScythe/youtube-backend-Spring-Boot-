package com.youtube.user_api.connectors;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationApiConnector {

    String notificationApiBaseUrl = "http://localhost:8083/api/v1/notify";

    public void callSendUserRegistrationNOtificationEndpoint(String email, String userName){
        String url = notificationApiBaseUrl + "/user/register?email=" + email + "&userName=" + userName;
        RequestEntity request = RequestEntity.put(url).build();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT, request, Object.class);
    }
}
