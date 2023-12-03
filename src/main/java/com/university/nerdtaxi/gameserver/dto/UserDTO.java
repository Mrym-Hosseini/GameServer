package com.university.nerdtaxi.gameserver.dto;

public class UserDTO {

    private long id;
    private String username;
    private Integer score;

    public UserDTO() {

    }

    public UserDTO(String username, Integer score) {
        setUsername(username);
        setScore(score);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
