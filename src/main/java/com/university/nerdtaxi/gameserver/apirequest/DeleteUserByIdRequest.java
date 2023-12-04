package com.university.nerdtaxi.gameserver.apirequest;

/**
 * Represents the request payload for deleting a user by their ID.
 */
public class DeleteUserByIdRequest {

    private long userId;

    /**
     * Retrieves the user ID.
     *
     * @return The ID of the user to delete
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The ID of the user to delete
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
