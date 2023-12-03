package com.university.nerdtaxi.gameserver.repository;

import com.university.nerdtaxi.gameserver.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    List<UserEntity> findByScoreGreaterThanOrderByScoreDesc(int score);
}
