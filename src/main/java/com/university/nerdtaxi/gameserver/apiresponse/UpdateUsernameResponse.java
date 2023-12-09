package com.university.nerdtaxi.gameserver.apiresponse;

/**
 * Represents the response payload for updating a user username.
 */
public class UpdateUsernameResponse {

    private long userId;
    private String username;

    /**
     * Constructs a new UpdateUsernameResponse with the specified user ID and username.
     *
     * @param userId The ID of the user whose username was updated
     * @param username The new username value
     */
    public UpdateUsernameResponse(long userId, String username) {
        setUserId(userId);
        setUsername(username);
    }

    /**
     * Retrieves the user ID.
     *
     * @return The ID of the user whose username was updated
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The ID of the user whose username was updated
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the new username.
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
