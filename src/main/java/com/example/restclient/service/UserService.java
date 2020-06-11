package com.example.restclient.service;


import com.example.restclient.model.Role;
import com.example.restclient.model.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserService {

    public List<User> listAll();

    public HttpStatus save(User user);

    public User get(long id);

    public void delete(long id);

}
