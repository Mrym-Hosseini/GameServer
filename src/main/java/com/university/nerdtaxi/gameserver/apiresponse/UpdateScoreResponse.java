package com.university.nerdtaxi.gameserver.apiresponse;

public class UpdateScoreResponse {

    private long userId;

    private int score;

    public UpdateScoreResponse(long userId, int score) {
        setUserId(userId);
        setScore(score);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
