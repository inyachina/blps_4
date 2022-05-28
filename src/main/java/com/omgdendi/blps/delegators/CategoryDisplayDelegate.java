package com.omgdendi.blps.delegators;

import com.omgdendi.blps.entity.CategoryEntity;
import com.omgdendi.blps.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named("categoryDisplayDelegate")
public class CategoryDisplayDelegate implements JavaDelegate {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryDisplayDelegate(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<CategoryEntity> categories = categoryRepository.findAll();
        Map<String, Object> mapIdCategory =
                categories.stream().collect(
                        Collectors.toMap(category ->
                                "Category ID [" +category.getId().toString()+"]", CategoryEntity::getName));
        delegateExecution.setVariables(mapIdCategory);
    }
}
