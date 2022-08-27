package ru.fiyf.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * SkillsDto.
 *
 * @author Aleksey_Brekhin
 * @since 8/17/21
 */
@Data
@Accessors(chain = true)
public class SkillsDto {

    private Long id;

    @ApiModelProperty(value = "Наименование навыка", example = "Java", required = true)
    @Size(min = 1, max = 30, message = "About Me must be between 1 and 30 characters")
    private String label;

    @ApiModelProperty(value = "Уровень владения навыком", example = "10", required = true)
    @Min(1)
    @Max(10)
    private int rank;
}