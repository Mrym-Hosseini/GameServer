package com.university.nerdtaxi.gameserver.controller;

import com.university.nerdtaxi.gameserver.service.UserService;
import com.university.nerdtaxi.gameserver.apirequest.CreateUserRequest;
import com.university.nerdtaxi.gameserver.apirequest.GetUserByIdRequest;
import com.university.nerdtaxi.gameserver.apirequest.UpdateUsernameRequest;
import com.university.nerdtaxi.gameserver.apirequest.UpdateScoreRequest;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/nerdtaxi")
public class UserController {

    private UserService userService;

    @Autowired
    public void userService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest username) {
        return userService.createUser(username.getUsername());
    }

    @GetMapping(path = "/getUser")
    public ResponseEntity<?> getUserById(@RequestBody GetUserByIdRequest userId) {
        return userService.getUserById(userId.getUserId());
    }

    @GetMapping(path = "/get/leaderBoard")
    public ResponseEntity<?> getLeaderBoard() {
        return userService.sortUsersScore();
    }

    @PutMapping(path = "/updateUsername")
    public ResponseEntity<?> updateUserUsername(@RequestBody UpdateUsernameRequest updateUsernameRequest) {
        return userService.updateUserUsername(updateUsernameRequest.getUserId(), updateUsernameRequest.getUsername());
    }

    @PutMapping(path = "/updateUserScore")
    public ResponseEntity<?> updateUserScore(@RequestBody UpdateScoreRequest updateScoreRequest) {
        return userService.updateUserScore(updateScoreRequest.getUserId(), updateScoreRequest.getScore());
    }

    @DeleteMapping(path = "/delete/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable(name = "userId") long userId) {
        return userService.deleteUserById(userId);
    }

}
