package com.university.nerdtaxi.gameserver.apiresponse;

public class CreateUserResponse {

    private long userId;

    public CreateUserResponse(long userId){
        setUserId(userId);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
