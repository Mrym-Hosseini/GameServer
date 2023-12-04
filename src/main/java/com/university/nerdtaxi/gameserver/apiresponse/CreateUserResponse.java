package com.university.nerdtaxi.gameserver.apiresponse;

/**
 * Represents thw response payload for creating a new user.
 */
public class CreateUserResponse {

    private long userId;

    /**
     * Constructs a new CreateUserResponse with the specified user ID.
     *
     * @param userId The ID of the newly created user
     */
    public CreateUserResponse(long userId){
        setUserId(userId);
    }

    /**
     * Retrieves the user ID.
     *
     * @return The ID of the newly created user
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The ID of the newly created user
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
