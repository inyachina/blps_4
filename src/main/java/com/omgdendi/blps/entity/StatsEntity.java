package com.omgdendi.blps.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@ToString
@Table(name = "stats")
public class StatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer essayAmount;
    @NotNull
    private Integer approvedEssayAmount;
    @NotNull
    private Integer notApprovedEssayAmount;
    @NotNull
    private Integer waitingEssayAmount;

    private Date date;

    public StatsEntity(Integer essayAmount, Integer approvedEssayAmount, Integer notApprovedEssayAmount, Integer waitingEssayAmount) {
        this.essayAmount = essayAmount;
        this.approvedEssayAmount = approvedEssayAmount;
        this.notApprovedEssayAmount = notApprovedEssayAmount;
        this.waitingEssayAmount = waitingEssayAmount;
        this.date = Date.valueOf(LocalDate.now());
    }

    public StatsEntity() {

    }
}
