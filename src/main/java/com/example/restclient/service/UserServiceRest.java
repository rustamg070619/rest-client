package com.example.restclient.service;

import com.example.restclient.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class UserServiceRest implements UserService {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    final String ROOT_URI = "http://localhost:8080/admin/";


    @Override
    public List<User> listAll() {
        User[] response = restTemplate.getForObject(ROOT_URI + "all", User[].class);
        return Arrays.asList(response);
    }

    @Override
    public HttpStatus save(User user) {
        ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ROOT_URI + "save/", user, HttpStatus.class);
        return response.getBody();
    }

    @Override
    public User get(long id) {
        User response = restTemplate.getForObject(ROOT_URI + "get/" +id, User.class);
        return response;
    }

    @Override
    public void delete(long id) {
        restTemplate.delete(ROOT_URI + "delete/" + id);
    }

}



