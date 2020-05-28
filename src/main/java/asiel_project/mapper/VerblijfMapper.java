package asiel_project.mapper;

import asiel_project.dto.VerblijfDTO;
import asiel_project.entity.Verblijf;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DierMapper.class)
public interface VerblijfMapper {

    VerblijfMapper INSTANCE = Mappers.getMapper(VerblijfMapper.class);

    VerblijfDTO toDTO(Verblijf verblijf);
}
