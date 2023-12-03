package com.university.nerdtaxi.gameserver.apirequest;

public class GetUserByIdRequest {

    private long userId;

    public GetUserByIdRequest(long userId){
        setUserId(userId);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
