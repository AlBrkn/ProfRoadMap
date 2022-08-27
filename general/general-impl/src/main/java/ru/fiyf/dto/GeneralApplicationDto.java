package ru.fiyf.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * GeneralApplicationDto.
 *
 * @author Aleksey_Brekhin
 * @since 8/17/21
 */
@Data
@Accessors(chain = true)
public class GeneralApplicationDto {

    private Long id;

    @ApiModelProperty(value = "Наименование специальности", example = "Java Developer", required = true)
    private String specialization;

    @ApiModelProperty(value = "Локация", example = "Москва", required = true)
    private String location;

    @ApiModelProperty(value = "Набор необходимых навыков", required = true)
    private List<SkillsDto> skills;

    @ApiModelProperty(value = "Подробное описание вакансии", required = true)
    private String description;

    @ApiModelProperty(value = "Видимость вакансии", required = true)
    private Boolean visible = Boolean.TRUE;

    @ApiModelProperty(value = "Требуемый опыт", required = true)
    private int experienceInMonth;
}