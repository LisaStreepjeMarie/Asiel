package asiel_project.mapper;

import asiel_project.dto.DierDTO;
import asiel_project.dto.VerblijfDierenDTO;
import asiel_project.entity.Dier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DierMapper {

    DierMapper INSTANCE = Mappers.getMapper(DierMapper.class);

    VerblijfDierenDTO toVerblijfDierDTO(Dier dier);

    @Mapping(source = "verblijf.naam", target = "verblijfNaam")
    @Mapping(source = "verblijf.verblijfId", target = "verblijfId")
    DierDTO toDierDto(Dier dier);
}
