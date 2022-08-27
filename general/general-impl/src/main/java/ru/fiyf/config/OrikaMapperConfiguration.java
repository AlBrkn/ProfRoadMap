package ru.fiyf.config;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.fiyf.dto.GeneralApplicationDto;
import ru.fiyf.entity.GeneralApplicationEntity;

/**
 * OrikaMapperConfig.
 *
 * @author Aleksey_Brekhin
 * @since 8/17/21
 */
@Component
public abstract class OrikaMapperConfiguration extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(GeneralApplicationEntity.class, GeneralApplicationDto.class)
                .byDefault()
                .register();
    }
}