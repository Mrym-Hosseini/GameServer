package com.university.nerdtaxi.gameserver.apirequest;

/**
 * Represents the request payload for updating a user username.
 */
public class UpdateUsernameRequest {

    private long userId;
    private String username;

    /**
     * Retrieves the user ID.
     *
     * @return The ID of the user to update the username
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The ID of the user to update the username
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the user username.
     *
     * @return The new username value
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the new username.
     *
     * @param username The new username value
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
