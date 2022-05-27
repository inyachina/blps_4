package com.omgdendi.blps.service;


import com.omgdendi.blps.entity.EssayEntity;
import com.omgdendi.blps.repository.CategoryRepository;
import com.omgdendi.blps.repository.EssayRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EssayService {
    @Autowired
    EssayRepository essayRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<EssayEntity> getEssaysByTitle(String title) {
        return essayRepository.findAllByTitle(title);
    }

    public List<EssayEntity> getEssaysByCategory(String categoryName) {
        return categoryRepository.findByName(categoryName)
                .map(value -> essayRepository.findAllByCategory(value.getId()))
                .orElse(null);
    }

    public List<EssayEntity> getRecentEssays(int count) {
        return essayRepository.findAllRecentEssays(count);
    }

}
