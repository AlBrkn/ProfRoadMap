package mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.fiyf.dto.GeneralApplicationDto;
import ru.fiyf.dto.SkillsDto;
import ru.fiyf.entity.GeneralApplicationEntity;
import ru.fiyf.entity.SkillsEntity;
import ru.fiyf.util.ModelsMapping;

import java.util.List;

/**
 * ModelsMappingTest.
 *
 * @author Aleksey_Brekhin
 * @since 8/17/21
 */
public class ModelsMappingTest {

    @Autowired
    private ModelsMapping modelsMapping = new ModelsMapping();

    @Test
    public void convertFromApplicationEntityToDtoTest() {
        GeneralApplicationEntity generalApplicationEntity = createGeneralApplicationEntity();

        GeneralApplicationDto generalApplicationDto = modelsMapping
                .map(generalApplicationEntity, GeneralApplicationDto.class);

        Assert.assertEquals(generalApplicationEntity.getId(), generalApplicationDto.getId());
        Assert.assertEquals(generalApplicationEntity.getDescription(), generalApplicationDto.getDescription());
        Assert.assertEquals(generalApplicationEntity.getLocation(), generalApplicationDto.getLocation());
        Assert.assertEquals(generalApplicationEntity.getSpecialization(), generalApplicationDto.getSpecialization());
        Assert.assertEquals(generalApplicationEntity.getSkills().size(), generalApplicationDto.getSkills().size());
    }

    @Test
    public void convertFromApplicationDtoToEntityTest() {
        GeneralApplicationDto generalApplicationDto = createGeneralApplicationDto();

        GeneralApplicationEntity generalApplicationEntity = modelsMapping
                .map(generalApplicationDto, GeneralApplicationEntity.class);

        Assert.assertEquals(generalApplicationDto.getId(), generalApplicationEntity.getId());
        Assert.assertEquals(generalApplicationDto.getDescription(), generalApplicationEntity.getDescription());
        Assert.assertEquals(generalApplicationDto.getLocation(), generalApplicationEntity.getLocation());
        Assert.assertEquals(generalApplicationDto.getSpecialization(), generalApplicationEntity.getSpecialization());
        Assert.assertEquals(generalApplicationDto.getSkills().size(), generalApplicationEntity.getSkills().size());
    }

    private GeneralApplicationEntity createGeneralApplicationEntity() {
        return new GeneralApplicationEntity()
                .setId(1L)
                .setDescription("setDescription")
                .setSpecialization("setProfessionEnum")
                .setSkills(List.of(
                        new SkillsEntity()
                                .setId(1L)
                                .setLabel("aaa")))
                .setLocation("setLocation");
    }

    private GeneralApplicationDto createGeneralApplicationDto() {
        return new GeneralApplicationDto()
                .setId(1L)
                .setDescription("setDescription")
                .setSpecialization("setProfessionEnum")
                .setSkills(List.of(
                        new SkillsDto()
                                .setId(1L)
                                .setLabel("aaa")))
                .setLocation("setLocation");
    }

}