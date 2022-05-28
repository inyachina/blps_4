package com.omgdendi.blps.repository;

import com.omgdendi.blps.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<EssayEntity, Integer> {
    public StatsEntity save(StatsEntity statsEntity);
}
