package asiel_project.mapper;

import asiel_project.dto.VerblijfDTO;
import asiel_project.dto.VerblijfDierenDTO;
import asiel_project.entity.Dier;
import asiel_project.entity.Verblijf;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-31T15:59:53+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class VerblijfMapperImpl implements VerblijfMapper {

    private final DierMapper dierMapper = Mappers.getMapper( DierMapper.class );

    @Override
    public VerblijfDTO toDTO(Verblijf verblijf) {
        if ( verblijf == null ) {
            return null;
        }

        VerblijfDTO verblijfDTO = new VerblijfDTO();

        verblijfDTO.setVerblijfId( verblijf.getVerblijfId() );
        verblijfDTO.setNaam( verblijf.getNaam() );
        verblijfDTO.setDieren( dierListToVerblijfDierenDTOList( verblijf.getDieren() ) );
        verblijfDTO.setPlekkenTotaal( verblijf.getPlekkenTotaal() );
        verblijfDTO.setVerblijfSoort( verblijf.getVerblijfSoort() );

        return verblijfDTO;
    }

    protected List<VerblijfDierenDTO> dierListToVerblijfDierenDTOList(List<Dier> list) {
        if ( list == null ) {
            return null;
        }

        List<VerblijfDierenDTO> list1 = new ArrayList<VerblijfDierenDTO>( list.size() );
        for ( Dier dier : list ) {
            list1.add( dierMapper.toVerblijfDierDTO( dier ) );
        }

        return list1;
    }
}
