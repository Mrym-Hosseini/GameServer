package com.university.nerdtaxi.gameserver.apirequest;

/**
 * Represents the request payload for updating a user score.
 */
public class UpdateScoreRequest {

    private long userId;
    private int score;

    /**
     * Retrieves the user ID.
     *
     * @return The user ID of the user to update the score
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The ID of the user to update the score
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the score.
     *
     * @return The new score value
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score.
     *
     * @param score The new score value
     */
    public void setScore(int score) {
        this.score = score;
    }
}
