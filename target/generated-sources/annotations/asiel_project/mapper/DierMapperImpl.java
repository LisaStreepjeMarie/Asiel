package asiel_project.mapper;

import asiel_project.dto.DierDTO;
import asiel_project.entity.Dier;
import asiel_project.enums.Soort;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-23T17:07:52+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class DierMapperImpl implements DierMapper {

    @Override
    public DierDTO toDTO(Dier dier) {
        if ( dier == null ) {
            return null;
        }

        DierDTO dierDTO = new DierDTO();

        dierDTO.setDierId( dier.getDierId() );
        dierDTO.setNaam( dier.getNaam() );
        if ( dier.getSoort() != null ) {
            dierDTO.setSoort( Enum.valueOf( Soort.class, dier.getSoort() ) );
        }
        dierDTO.setVerblijf( dier.getVerblijf() );
        dierDTO.setDatumErin( dier.getDatumErin() );
        dierDTO.setDatumBuiten( dier.getDatumBuiten() );

        return dierDTO;
    }
}
