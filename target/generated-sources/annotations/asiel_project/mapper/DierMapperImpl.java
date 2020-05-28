package asiel_project.mapper;

import asiel_project.dto.DierDTO;
import asiel_project.dto.VerblijfDierenDTO;
import asiel_project.entity.Dier;
import asiel_project.entity.Verblijf;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-27T21:01:37+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class DierMapperImpl implements DierMapper {

    @Override
    public VerblijfDierenDTO toVerblijfDierDTO(Dier dier) {
        if ( dier == null ) {
            return null;
        }

        VerblijfDierenDTO verblijfDierenDTO = new VerblijfDierenDTO();

        verblijfDierenDTO.setDierId( dier.getDierId() );
        verblijfDierenDTO.setNaam( dier.getNaam() );
        verblijfDierenDTO.setSoort( dier.getSoort() );

        return verblijfDierenDTO;
    }

    @Override
    public DierDTO toDierDto(Dier dier) {
        if ( dier == null ) {
            return null;
        }

        DierDTO dierDTO = new DierDTO();

        dierDTO.setVerblijfId( dierVerblijfVerblijfId( dier ) );
        dierDTO.setVerblijfNaam( dierVerblijfNaam( dier ) );
        dierDTO.setDierId( dier.getDierId() );
        dierDTO.setNaam( dier.getNaam() );
        dierDTO.setSoort( dier.getSoort() );
        dierDTO.setDatumErin( dier.getDatumErin() );
        dierDTO.setDatumBuiten( dier.getDatumBuiten() );

        return dierDTO;
    }

    private Integer dierVerblijfVerblijfId(Dier dier) {
        if ( dier == null ) {
            return null;
        }
        Verblijf verblijf = dier.getVerblijf();
        if ( verblijf == null ) {
            return null;
        }
        Integer verblijfId = verblijf.getVerblijfId();
        if ( verblijfId == null ) {
            return null;
        }
        return verblijfId;
    }

    private String dierVerblijfNaam(Dier dier) {
        if ( dier == null ) {
            return null;
        }
        Verblijf verblijf = dier.getVerblijf();
        if ( verblijf == null ) {
            return null;
        }
        String naam = verblijf.getNaam();
        if ( naam == null ) {
            return null;
        }
        return naam;
    }
}
