package com.omgdendi.blps.repository;

import com.omgdendi.blps.entity.EssayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EssayRepository extends JpaRepository<EssayEntity, Integer> {
    @Query(value = "SELECT * FROM essay WHERE title ~ ?1", nativeQuery = true)
    List<EssayEntity> findAllByTitle(String title);

    @Query(value = "SELECT * FROM essay WHERE category_id = ?1", nativeQuery = true)
    List<EssayEntity> findAllByCategory(Integer id);

    @Query(value = "SELECT * FROM essay ORDER BY date_load DESC LIMIT ?1", nativeQuery = true)
    List<EssayEntity> findAllRecentEssays(int count);
}
