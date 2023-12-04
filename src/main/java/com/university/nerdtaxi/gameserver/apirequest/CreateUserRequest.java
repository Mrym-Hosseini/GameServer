package com.university.nerdtaxi.gameserver.apirequest;

/**
 * Represents the request payload for creating a new user.
 */
public class CreateUserRequest {

    private String username;

    /**
     * Retrieves the username.
     *
     * @return The username of the new user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The username to set for the new user
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
