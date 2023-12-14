package com.university.nerdtaxi.gameserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Generate setters and getters for all fields automatically
@Getter
@Setter
// Generate a constructor with no argument for UserDTO class
@NoArgsConstructor
public class UserDTO {

    // The unique identifier for the user
    private long id;
    // The username of the user
    private String username;
    // The password of the user
    private String password;
    // The score of the user
    private Integer score;

}       