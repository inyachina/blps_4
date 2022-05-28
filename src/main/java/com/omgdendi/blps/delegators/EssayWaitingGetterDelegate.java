package com.omgdendi.blps.delegators;

import com.omgdendi.blps.entity.CategoryEntity;
import com.omgdendi.blps.entity.EssayEntity;
import com.omgdendi.blps.service.EssayService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named("essayWaitingGetterDelegate")
public class EssayWaitingGetterDelegate implements JavaDelegate {
    private EssayService essayService;

    @Autowired
    public EssayWaitingGetterDelegate(EssayService essayService) {
        this.essayService = essayService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        List<EssayEntity> essays = essayService.findAllByStatus("Awaiting verification");
        Map<String, Object> mapIdEssay =
                essays.stream().collect(
                        Collectors.toMap(essay ->
                                "Essay ID [" +essay.getId().toString()+"]", EssayEntity::getTitle));
        delegateExecution.setVariables(mapIdEssay);
    }
}
