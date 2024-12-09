package com.exam.examPortal.controller;

import com.exam.examPortal.entity.User;
import com.exam.examPortal.services.UserService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getUser(){
        List<User> users= userService.getUSers();
        if(users.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try {

            User createdUSer = userService.createUser(user, new HashSet<>());
            return new ResponseEntity(createdUSer, HttpStatus.OK);
        }catch (Exception e){
             return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") long id){
        try{
            Optional<User> currUser = this.userService.getByID(id);
            if(currUser.isPresent()){
                return new ResponseEntity<>(currUser.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteByID(@PathVariable("id") long id){


        try{
            if(userService.getByID(id)==null){
                userService.deleteByID(id);
                return new ResponseEntity<>("User Deleted SuccessFully", HttpStatus.OK);

            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/by-name/{userName}")
    public ResponseEntity<?> getByUserName(@PathVariable("userName") String userName){

        User currUser = this.userService.getByUserName(userName);
        if(currUser!=null){
            return new ResponseEntity<>(currUser, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
