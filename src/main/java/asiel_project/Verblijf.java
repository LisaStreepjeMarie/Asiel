package asiel_project;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Verblijf {

    @NotNull
    private Integer verblijfId;

    @NotNull @Size(max=25)
    private String naam;
    
    private List<Dier> dieren;

    private Integer plekkenTotaal;

    private Integer plekkenBezet;

    public Verblijf() {
    }

    public Verblijf(Integer verblijfId, String naam, Integer plekkenTotaal) {
        this.verblijfId = verblijfId;
        this.naam = naam;
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
}
