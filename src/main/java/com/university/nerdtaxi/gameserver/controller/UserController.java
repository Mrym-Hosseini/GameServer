package com.university.nerdtaxi.gameserver.controller;

import com.university.nerdtaxi.gameserver.service.UserService;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/nerdtaxi")
public class UserController {

    private UserService userService;

    @Autowired
    public void userService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/create/{username}")
    public ResponseEntity<?> createUser(@PathVariable(name = "username") String username) {
        return userService.createUser(username);
    }

    @GetMapping(path = "/get/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "userId") long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(path = "/get/leaderBoard")
    public ResponseEntity<?> getLeaderBoard(){
        return userService.sortUsersScore();
    }

    @PutMapping(path = "/updateUsername/{userId}/{username}")
    public ResponseEntity<String> updateUserUsername(@PathVariable(name = "userId") long userId, @PathVariable(name = "username") String username) {
        return userService.updateUserUsername(userId, username);
    }

    @PutMapping(path = "/updateUserScore/{userId}/{score}")
    public ResponseEntity<String> updateUserScore(@PathVariable(name = "userId") long userId, @PathVariable(name = "score") int score) {
        return userService.updateUserScore(userId, score);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable(name = "userId") long userId) {
        return userService.deleteUserById(userId);
    }

}
