package com.university.nerdtaxi.gameserver.repository;

import com.university.nerdtaxi.gameserver.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    /**
     * Retrieves a list of UserEntity objects with a score greater than the specified score,
     * order by score in descending order.
     */
    List<UserEntity> findByScoreGreaterThanOrderByScoreDesc(int score);
}
