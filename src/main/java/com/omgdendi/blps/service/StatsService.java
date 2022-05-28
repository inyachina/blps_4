package com.omgdendi.blps.service;


import com.omgdendi.blps.entity.StatsEntity;
import com.omgdendi.blps.repository.EssayRepository;
import com.omgdendi.blps.repository.StatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class StatsService {
    private StatsRepository statsRepository;
    private EssayRepository essayRepository;

    public StatsEntity save() {
        int approvedAmount = this.essayRepository.findAllByStatus("Approved").size();
        int notApprovedAmount = this.essayRepository.findAllByStatus("Not Approved").size();
        int awaitingVerificationAmount = this.essayRepository.findAllByStatus("Awaiting verification").size();
        return statsRepository.save(new StatsEntity(
                approvedAmount + notApprovedAmount + awaitingVerificationAmount,
                approvedAmount,
                notApprovedAmount,
                awaitingVerificationAmount
        ));
    }
}
