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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SkillsEntity.
 *
 * @author Aleksey_Brekhin
 * @since 8/17/21
 */
@Entity
@Table(name = "skills")
@Data
@Accessors(chain = true)
public class SkillsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private int rank;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "application_id", nullable = false, insertable = false, updatable = false)
    private GeneralApplicationEntity application;

}