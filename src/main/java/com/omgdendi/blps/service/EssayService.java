package com.omgdendi.blps.service;


import com.omgdendi.blps.entity.EssayEntity;
import com.omgdendi.blps.repository.CategoryRepository;
import com.omgdendi.blps.repository.EssayRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class EssayService {
    private EssayRepository essayRepository;
    private CategoryRepository categoryRepository;

    public List<EssayEntity> getEssaysByTitleAndStatus(String title, String status) {
        return essayRepository.findAllByTitleAndStatus(title, status);
    }

    public List<EssayEntity> findAllByStatus(String status) {
        return this.essayRepository.findAllByStatus(status);
    }

    public List<EssayEntity> getEssaysByCategory(Integer categoryId) {
        return essayRepository.findAllByCategory(categoryId);
    }

    public List<EssayEntity> getRecentEssays(int count) {
        return essayRepository.findAllRecentEssays(count);
    }

    public Collection<? extends EssayEntity> getEssaysByCategoryAndStatus(Integer categoryId, String status) {
        return essayRepository.findAllByCategoryAndStatus(this.categoryRepository.findById(categoryId).get(), status);
    }



}
