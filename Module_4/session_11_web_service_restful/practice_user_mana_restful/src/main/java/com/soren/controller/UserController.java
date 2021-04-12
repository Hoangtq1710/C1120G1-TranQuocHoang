package com.soren.controller;

import com.soren.model.User;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> listAllUser() {
        List<User> listUser = userService.findAll();
        if (listUser.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listUser,HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        User user = this.userService.findById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder){
        this.userService.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        User currentUser = this.userService.findById(id);

        if (currentUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setId(user.getId());

        this.userService.save(currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
        User user = this.userService.findById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
