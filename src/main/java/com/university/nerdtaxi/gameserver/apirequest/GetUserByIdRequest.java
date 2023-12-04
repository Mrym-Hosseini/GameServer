package com.university.nerdtaxi.gameserver.apirequest;

/**
 * Represents thr request payload for retrieving a user by their ID.
 */
public class GetUserByIdRequest {

    private long userId;

    /**
     * Constructs a new GetUserByIdRequest with the specified user ID.
     *
     * @param userId The ID of the user to retrieve
     */
    public GetUserByIdRequest(long userId) {
        setUserId(userId);
    }

    /**
     * Retrieves the user ID.
     *
     * @return The ID of the user to */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The ID of the user to retrieve
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
