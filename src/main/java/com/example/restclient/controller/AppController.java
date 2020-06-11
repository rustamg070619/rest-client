package com.example.restclient.controller;

import com.example.restclient.model.User;
import com.example.restclient.service.UserServiceRest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    UserServiceRest userServiceRest;

    @GetMapping("/admin/all")
    public List<User> viewHomePage() {
        return userServiceRest.listAll();
    }

    @GetMapping("/admin/get/{id}")
    public User getUser(@PathVariable(name = "id") Long id) {
        return userServiceRest.get(id);
    }


    @PostMapping(value = "/admin/save")
    public void saveUser(@RequestBody User user, String role) {
        userServiceRest.save(user);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        userServiceRest.delete(id);
    }

    @GetMapping("/user/{login}")
    public ModelAndView showThisProductPage(@PathVariable(name = "login") String login) {

        return null;
    }

//    @GetMapping("/admin/getAuth")
//    public User getAuth() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        return (User) auth.getPrincipal();
//    }

}

