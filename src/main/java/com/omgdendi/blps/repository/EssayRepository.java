package com.omgdendi.blps.repository;

import com.omgdendi.blps.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public interface EssayRepository extends JpaRepository<EssayEntity, Integer> {
    @Query(value = "SELECT * FROM essay WHERE title ~ ?1 and status ~ ?2", nativeQuery = true)
    List<EssayEntity> findAllByTitleAndStatus(String title, String status);

    List<EssayEntity> findAllByCategoryAndStatus(CategoryEntity categoryEntity, String status);

    List<EssayEntity> findAllByStatus(String status);

    @Query(value = "SELECT * FROM essay WHERE category_id = ?1", nativeQuery = true)
    List<EssayEntity> findAllByCategory(Integer id);

    @Query(value = "SELECT * FROM essay ORDER BY date_load DESC LIMIT ?1", nativeQuery = true)
    List<EssayEntity> findAllRecentEssays(int count);
}
