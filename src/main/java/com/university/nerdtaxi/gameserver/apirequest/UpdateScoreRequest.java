package com.university.nerdtaxi.gameserver.apirequest;

public class UpdateScoreRequest {

    private long userId;
    private int score;

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
