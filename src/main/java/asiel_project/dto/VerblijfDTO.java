package asiel_project.dto;

import asiel_project.enums.Soort;
import asiel_project.entity.Dier;

import java.io.Serializable;
import java.util.List;

public class VerblijfDTO implements Serializable {

    private Integer verblijfId;

    private String naam;

    private List<DierDTO> dieren;

    private Integer plekkenTotaal;

    private Integer plekkenBezet;

    private String verblijfSoort;

    public VerblijfDTO() {
    }

    public Integer getVerblijfId() {
        return verblijfId;
    }

    public void setVerblijfId(Integer verblijfId) {
        this.verblijfId = verblijfId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<DierDTO> getDieren() {
        return dieren;
    }

    public void setDieren(List<DierDTO> dieren) {
        this.dieren = dieren;
    }

    public Integer getPlekkenTotaal() {
        return plekkenTotaal;
    }

    public void setPlekkenTotaal(Integer plekkenTotaal) {
        this.plekkenTotaal = plekkenTotaal;
    }

    public Integer getPlekkenBezet() {
        return plekkenBezet;
    }

    public void setPlekkenBezet(Integer plekkenBezet) {
        this.plekkenBezet = plekkenBezet;
    }

    public String getVerblijfSoort() {
        return verblijfSoort;
    }

    public void setVerblijfSoort(String verblijfSoort) {
        this.verblijfSoort = verblijfSoort;
    }
}
