package com.SA.Student.AOP;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class AuthService {

   private final RestTemplate restTemplate;

    private static final String AUTH_URL = "http://localhost:9090/users/validate-token";

    public ResponseEntity<?> isAuthorized(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);


        try {
            ResponseEntity<String> response = restTemplate.exchange(AUTH_URL, HttpMethod.GET, entity, String.class);

            // If you reach here, the token is valid. You can return the user.
            return response;
        } catch (Exception e) {
            // In case of an exception (like 403), return a status of 403
            return ResponseEntity.status(403).build();
        }
    }
}

