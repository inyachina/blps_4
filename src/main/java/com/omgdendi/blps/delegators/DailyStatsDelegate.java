package com.omgdendi.blps.delegators;

import com.omgdendi.blps.service.StatsService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named("dailyStatsDelegate")
public class DailyStatsDelegate implements JavaDelegate {
    private StatsService statsService;

    @Autowired
    public DailyStatsDelegate(StatsService statsService) {
        this.statsService = statsService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("lalala");
        this.statsService.save();
    }
}
