package com.university.nerdtaxi.gameserver.controller;

import com.university.nerdtaxi.gameserver.service.UserService;
import com.university.nerdtaxi.gameserver.apirequest.CreateUserRequest;
import com.university.nerdtaxi.gameserver.apirequest.GetUserByIdRequest;
import com.university.nerdtaxi.gameserver.apirequest.UpdateUsernameRequest;
import com.university.nerdtaxi.gameserver.apirequest.UpdateScoreRequest;
import com.university.nerdtaxi.gameserver.apirequest.DeleteUserByIdRequest;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/nerdtaxi")
public class UserController {

    private UserService userService;

    @Autowired
    public void userService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to create a new user.
     *
     * @param username The username of the new user
     * @return ResponseEntity containing the response body
     */
    @PostMapping(path = "/createUser")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest username) {
        return userService.createUser(username.getUsername());
    }

    /**
     * Endpoint to get a user by their ID.
     *
     * @param userId The ID of the user
     * @return ResponseEntity containing the response body
     */
    @GetMapping(path = "/getUser")
    public ResponseEntity<?> getUserById(@RequestBody GetUserByIdRequest userId) {
        return userService.getUserById(userId.getUserId());
    }

    /**
     * Endpoint to get the leaderboard of users sorted by score.
     *
     * @return ResponseEntity containing the response body
     */
    @GetMapping(path = "/get/leaderBoard")
    public ResponseEntity<?> getLeaderBoard() {
        return userService.sortUsersScore();
    }

    /**
     * Endpoint to update a user's username.
     *
     * @param updateUsernameRequest The request containing the user ID and new score
     * @return ResponseEntity containing the response body
     * */
    @PutMapping(path = "/updateUsername")
    public ResponseEntity<String> updateUserUsername(@RequestBody UpdateUsernameRequest updateUsernameRequest) {
        return userService.updateUserUsername(updateUsernameRequest.getUserId(), updateUsernameRequest.getUsername());
    }

    /**
     * Endpoint to update a user's score.
     *
     * @param updateScoreRequest The request containing the user ID and new score
     * @return ResponseEntity containing the response body
     * */
    @PutMapping(path = "/updateUserScore")
    public ResponseEntity<String> updateUserScore(@RequestBody UpdateScoreRequest updateScoreRequest) {
        return userService.updateUserScore(updateScoreRequest.getUserId(), updateScoreRequest.getScore());
    }

    /**
     * Endpoint to delete a user by their ID.
     *
     * @param userId The ID of the user to delete
     * @return ResponseEntity containing the response body
     */
    @DeleteMapping(path = "/deleteUser")
    public ResponseEntity<String> deleteUserById(@RequestBody DeleteUserByIdRequest userId) {
        return userService.deleteUserById(userId.getUserId());
    }

}
