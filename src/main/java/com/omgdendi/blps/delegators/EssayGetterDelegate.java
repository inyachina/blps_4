package com.omgdendi.blps.delegators;

import com.omgdendi.blps.entity.EssayEntity;
import com.omgdendi.blps.service.EssayService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Named("essayGetterDelegate")
public class EssayGetterDelegate implements JavaDelegate {
    @Autowired
    private EssayService essayService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String searchTitle = (String) delegateExecution.getVariable("title_input");
        String categoryTitle = (String) delegateExecution.getVariable("category_select");
        Set<EssayEntity> essays = new HashSet<>();

        if (searchTitle != null)
            essays.addAll(essayService.getEssaysByTitle(searchTitle));
        if (categoryTitle != null)
            essays.addAll(essayService.getEssaysByCategory(categoryTitle));
        else if (searchTitle == null)
            essays.addAll(essayService.getRecentEssays(25));

        delegateExecution.setVariable("searched_essays_list", essays);
    }
}
