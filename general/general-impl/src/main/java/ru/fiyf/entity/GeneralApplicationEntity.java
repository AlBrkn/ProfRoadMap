package ru.fiyf.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * GeneralApplicationEntity.
 *
 * @author Aleksey_Brekhin
 * @since 8/17/21
 */
@Entity
@Table(name = "general_application")
@Data
@Accessors(chain = true)
public class GeneralApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialization;

    private String location;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="application_id",nullable=false)
    private List<SkillsEntity> skills = new ArrayList<>();

    private String description;

    private Boolean visible;

    private int experienceInMonth;
}