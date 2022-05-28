package com.omgdendi.blps.delegators;

import com.omgdendi.blps.entity.CategoryEntity;
import com.omgdendi.blps.repository.CategoryRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;


@Named("essayCategorySaverDelegate")
public class ModeratorCategorySaverDelegate implements JavaDelegate {
    private CategoryRepository categoryRepository;

    @Autowired
    public ModeratorCategorySaverDelegate(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        categoryRepository.save(new CategoryEntity((String) delegateExecution.getVariable("category_name_input")));
    }
}
