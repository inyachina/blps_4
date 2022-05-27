package com.omgdendi.blps.delegators;

import com.omgdendi.blps.entity.EssayEntity;
import com.omgdendi.blps.repository.CategoryRepository;
import com.omgdendi.blps.repository.EssayRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;


@Named("essaySaverDelegate")
public class EssaySaverDelegate implements JavaDelegate {
    private EssayRepository essayRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public EssaySaverDelegate(EssayRepository essayRepository, CategoryRepository categoryRepository) {
        this.essayRepository = essayRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        essayRepository.save(new EssayEntity(
                (String) delegateExecution.getVariable("title_creation"),
                (String) delegateExecution.getVariable("content_creation"),
                categoryRepository.findById((Integer) delegateExecution.getVariable("category_id_creation")).get()
        ));
    }
}
