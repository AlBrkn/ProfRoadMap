package ru.fiyf.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fiyf.dto.GeneralApplicationDto;
import ru.fiyf.entity.GeneralApplicationEntity;
import ru.fiyf.repository.GeneralApplicationRepository;
import ru.fiyf.service.GeneralApplicationService;
import ru.fiyf.util.ModelsMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * GeneralApplicationServiceImpl.
 *
 * @author Aleksey_Brekhin
 * @since 8/18/21
 */
@Service
@AllArgsConstructor
public class GeneralApplicationServiceImpl implements GeneralApplicationService {

    private final GeneralApplicationRepository repository;
    private final ModelsMapping modelsMapping;

    @Override
    public GeneralApplicationDto create(GeneralApplicationDto dto) {
        GeneralApplicationEntity applicationEntity = modelsMapping.map(dto, GeneralApplicationEntity.class);
        repository.save(applicationEntity);
        return modelsMapping.map(applicationEntity, GeneralApplicationDto.class);
    }

    @Override
    public List<GeneralApplicationDto> getAll() {
        List<GeneralApplicationEntity> all = repository.findAll();
        return all.stream()
                .map(e -> modelsMapping.map(e, GeneralApplicationDto.class))
                .collect(Collectors.toList());
    }
}