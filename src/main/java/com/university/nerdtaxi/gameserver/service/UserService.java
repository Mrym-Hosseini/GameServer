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

    private UserRepository userRepository;

    private Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public void userRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    public ResponseEntity<?> sortUsersScore() {
        try {
            List<UserEntity> userEntities = userRepository.findAllByOrderByScoreDesc();
            List<UserDTO> userDTOS = covertToDtoList(userEntities);
            return ResponseEntity.ok(userDTOS);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred : " + error.getMessage());
        }
    }

    private UserDTO convertToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setScore(userEntity.getScore());
        return userDTO;
    }

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
