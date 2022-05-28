package com.omgdendi.blps.delegators;

import com.omgdendi.blps.entity.CategoryEntity;
import com.omgdendi.blps.entity.EssayEntity;
import com.omgdendi.blps.service.EssayService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@Named("essayGetterDelegate")
public class EssayGetterDelegate implements JavaDelegate {
    private EssayService essayService;

    @Autowired
    public EssayGetterDelegate(EssayService essayService) {
        this.essayService = essayService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String searchTitle = (String) delegateExecution.getVariable("title_input");
        Integer categoryId = (Integer) delegateExecution.getVariable("category_id");
        Set<EssayEntity> essays = new HashSet<>();
        if (searchTitle != null)
            if (!searchTitle.isEmpty()) essays.addAll(essayService.getEssaysByTitleAndStatus(searchTitle, "Approved"));
        if (categoryId != null)
            essays.addAll(essayService.getEssaysByCategoryAndStatus(categoryId, "Approved"));
        else if (searchTitle == null) essays.addAll(essayService.findAllByStatus("Approved"));
        Map<String, Object> mapIdEssay =
                essays.stream().collect(
                        Collectors.toMap(essay ->
                                "Searched Essay ID [" +essay.getId().toString()+"]", EssayEntity::toString));
        delegateExecution.setVariables(mapIdEssay);
    }
}
