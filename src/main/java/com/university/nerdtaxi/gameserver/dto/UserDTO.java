package com.university.nerdtaxi.gameserver.dto;

public class UserDTO {

    // The unique identifier for the user
    private long id;
    // The username of the user
    private String username;
    // The score of the user
    private Integer score;

    /**
     * Default constructor for the userDTO class.
     */
    public UserDTO() {

    }

    /**
     * Constructs the userDTO objects with specified username and score.
     */
    public UserDTO(String username, Integer score) {
        setUsername(username);
        setScore(score);
    }

    /**
     * Retrieves the ID of the userDTO.
     *
     * @return The ID of the userDTO
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the userDTO.
     *
     * @param id The ID to set for the userDTO
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retrieves the username of the userDTO.
     *
     * @return The username of the userDTO
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the userDTO.
     *
     * @param username The username to set for the userDTO
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the score of the userDTO.
     *
     * @return The score of the userDTO
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Sets the score of the userDTO.
     *
     * @param score The score to set for the userDTO
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}
