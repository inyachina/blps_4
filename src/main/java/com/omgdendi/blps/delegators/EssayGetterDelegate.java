package com.omgdendi.blps.delegators;

import com.omgdendi.blps.entity.EssayEntity;
import com.omgdendi.blps.service.EssayService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

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
        List<EssayEntity> essays = new ArrayList<EssayEntity>();

        if (searchTitle != null)
            if (!searchTitle.isEmpty()) essays.addAll(essayService.getEssaysByTitle(searchTitle));
        if (categoryId != null)
            essays.addAll(essayService.getEssaysByCategory(categoryId));
//        else if (searchTitle == null)
//            essays.addAll(essayService.getRecentEssays(25));
        System.out.print("essays ");
        System.out.println(essays);
        delegateExecution.setVariable("searched_essays_list", essays);
    }
}
