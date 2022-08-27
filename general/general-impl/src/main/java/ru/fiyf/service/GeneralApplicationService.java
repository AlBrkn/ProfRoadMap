package ru.fiyf.service;

import ru.fiyf.dto.GeneralApplicationDto;

import java.util.List;

/**
 * GeneralApplicationService.
 *
 * @author Aleksey_Brekhin
 * @since 8/18/21
 */
public interface GeneralApplicationService {

    GeneralApplicationDto create(GeneralApplicationDto dto);

    List<GeneralApplicationDto> getAll();
}