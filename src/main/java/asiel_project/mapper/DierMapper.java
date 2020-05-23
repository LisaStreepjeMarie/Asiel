package asiel_project.mapper;

import asiel_project.dto.DierDTO;
import asiel_project.entity.Dier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DierMapper {

    DierMapper INSTANCE = Mappers.getMapper(DierMapper.class);

    DierDTO toDTO(Dier dier);
}
