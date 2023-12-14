package com.university.nerdtaxi.gameserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Generate setters and getters for all fields automatically
@Getter
@Setter
// Generate a constructor with no argument for UserEntity class
@NoArgsConstructor
@Entity
@Table
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // The unique identifier for the user
    private long id;
    // The username of the user
    private String username;
    // The password of the user
    private String password;
    // The score of the user
    private int score;

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

}
