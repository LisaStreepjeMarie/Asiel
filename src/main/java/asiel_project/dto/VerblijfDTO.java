package asiel_project.dto;

import asiel_project.enums.Soort;
import asiel_project.entity.Dier;

import java.io.Serializable;
import java.util.List;

public class VerblijfDTO implements Serializable {

    private Integer verblijfId;

    private String naam;

    private List<Dier> dieren;

    private Integer plekkenTotaal;

    private Integer plekkenBezet;

    private Soort verblijfSoort;

    public VerblijfDTO(Integer verblijfId) {
        this.verblijfId = verblijfId;
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

    public List<Dier> getDieren() {
        return dieren;
    }

    public void setDieren(List<Dier> dieren) {
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

    public Soort getVerblijfSoort() {
        return verblijfSoort;
    }

    public void setVerblijfSoort(Soort verblijfSoort) {
        this.verblijfSoort = verblijfSoort;
    }
}
