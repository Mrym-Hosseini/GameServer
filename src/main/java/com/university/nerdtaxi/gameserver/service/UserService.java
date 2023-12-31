package com.university.nerdtaxi.gameserver.service;

import com.university.nerdtaxi.gameserver.apiresponse.CreateUserResponse;
import com.university.nerdtaxi.gameserver.repository.UserRepository;
import com.university.nerdtaxi.gameserver.model.UserEntity;
import com.university.nerdtaxi.gameserver.dto.UserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository; // Repository for UserEntity

    private Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public void userRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create a new user with the specified username.
     *
     * @param username The username of the user to create
     * @return ResponseEntity containing the CreateUserResponse or an error message
     */
    public ResponseEntity<?> createUser(String username) {
        try {
            UserEntity newUser = new UserEntity();
            newUser.setUsername(username);
            userRepository.save(newUser);
            LOG.info("New User created successfully. User Id : " + newUser.getId());
            return ResponseEntity.ok(new CreateUserResponse(newUser.getId()));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred : " + error.getMessage());
        }
    }

    /**
     * Retrieve a user by their ID.
     *
     * @param userId The ID of the user to retrieve
     * @return ResponseEntity containing the UserDTO or an error message
     */
    public ResponseEntity<?> getUserById(long userId) {
        try {
            UserEntity userEntity = userRepository.findById(String.valueOf(userId)).orElse(null);
            if (userEntity != null) {
                UserDTO userDTO = convertToDTO(userEntity);
                return ResponseEntity.ok(userDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found for Id : " + userId);
            }
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred : " + error.getMessage());
        }
    }

    /**
     * Updates the username of a user.
     *
     * @param userId   The ID of the user to update
     * @param username The new username for the user
     * @return ResponseEntity containing a success message or an error message
     */
    public ResponseEntity<String> updateUserUsername(long userId, String username) {
        try {
            UserEntity user = userRepository.findById(String.valueOf(userId)).orElse(null);
            if (user != null) {
                user.setUsername(username);
                userRepository.save(user);
                return ResponseEntity.ok("Username of user for Id : " + userId + " updated successfully to : " + username);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found for Id : " + userId);
            }
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred : " + error.getMessage());
        }
    }

    /**
     * Updates the score of a user.
     *
     * @param userId The ID of the user to update
     * @param score  The new score for the user
     * @return ResponseEntity containing a success message or an error message
     */
    public ResponseEntity<String> updateUserScore(long userId, int score) {
        try {
            UserEntity user = userRepository.findById(String.valueOf(userId)).orElse(null);
            if (user != null) {
                user.setScore(score);
                userRepository.save(user);
                return ResponseEntity.ok("Score of user : " + user.getUsername() + " updated successfully to : " + score);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found for Id : " + userId);
            }
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred : " + error.getMessage());
        }
    }

    /**
     * Deletes a user by their ID.
     *
     * @param userId The ID of the user to delete
     * @return ResponseEntity containing a success message or an error message
     */
    public ResponseEntity<String> deleteUserById(long userId) {
        try {
            UserEntity userEntity = userRepository.findById(String.valueOf(userId)).orElse(null);
            if (userEntity != null) {
                userRepository.deleteById(String.valueOf(userId));
                return ResponseEntity.ok("User for Id : " + userId + " deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found for Id : " + userId);
            }
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred : " + error.getMessage());
        }
    }

    /**
     * Retrieves a sorted list of users by score in descending order.
     *
     * @return ResponseEntity containing a list of UserDTO or an error message
     */
    public ResponseEntity<?> sortUsersScore() {
        try {
            List<UserEntity> userEntities = userRepository.findByScoreGreaterThanOrderByScoreDesc(0);
            List<UserDTO> userDTOs = covertToDtoList(userEntities);
            return ResponseEntity.ok(userDTOs);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred : " + error.getMessage());
        }
    }

    /**
     * Converts a UserEntity Object to a UserDTO object.
     *
     * @param userEntity The UserEntity to convert
     * @return The converted UserDTO object
     */
    private UserDTO convertToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setScore(userEntity.getScore());
        return userDTO;
    }

    /**
     * Converts a list of UserEntity objects to a list of UserDTO objects.
     *
     * @param userEntities The list of UserEntity objects to convert
     * @return The converted list of UserDTO objects
     */
    private List<UserDTO> covertToDtoList(List<UserEntity> userEntities) {
        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(userEntity.getUsername());
            userDTO.setId(userEntity.getId());
            userDTO.setScore(userEntity.getScore());
            dtoList.add(userDTO);
        }
        return dtoList;
    }

}
