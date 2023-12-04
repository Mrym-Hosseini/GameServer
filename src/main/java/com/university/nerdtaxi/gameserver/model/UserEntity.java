package com.university.nerdtaxi.gameserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // The unique identifier for the user
    private long id;
    // The username of the user
    private String username;
    // The score of the user
    private int score;

    /**
     * Default constructor for UserEntity class.
     */
    public UserEntity() {

    }

    /**
     * Constructs a UserEntity object with specified username and score.
     */
    public UserEntity(String username, Integer score) {
        setUsername(username);
        setScore(score);
    }

    /**
     * Retrieves the ID of the userEntity.
     *
     * @return The ID of the userEntity
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the userEntity.
     *
     * @param id The ID to set for the userEntity
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retrieves the username of the userEntity.
     *
     * @return The username of the userEntity
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the userEntity.
     *
     * @param username The username to set for the userEntity
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the score of the userEntity.
     *
     * @return The score of the userEntity
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the userEntity.
     *
     * @param score The score to set for the userEntity
     */
    public void setScore(int score) {
        this.score = score;
    }
}
