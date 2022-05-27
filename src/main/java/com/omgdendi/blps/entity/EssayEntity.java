package com.omgdendi.blps.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "essay")
public class EssayEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String title;
    @NotNull
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @NotNull
    private Date dateLoad;

    @NotNull
    private String status;

    public EssayEntity(String title, String content, CategoryEntity category) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.status = "Awaiting verification";
        this.dateLoad = new Timestamp(new Date().getTime());
    }

    public EssayEntity(String title, String content, CategoryEntity category, String status) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.status = status;
        this.dateLoad = new Timestamp(new Date().getTime());
    }
}