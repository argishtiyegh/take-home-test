package com.take.home.test.repository;

import com.take.home.test.model.BetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BettingRepository extends JpaRepository<BetEntity, Long> {

    List<BetEntity> findByEventId(Long eventId);

}
