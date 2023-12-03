package com.university.nerdtaxi.gameserver.apiresponse;

public class UpdateUsernameResponse {

    private long userId;
    private String username;

    public UpdateUsernameResponse(long userId, String username) {
        setUserId(userId);
        setUsername(username);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
