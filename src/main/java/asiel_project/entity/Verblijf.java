package asiel_project.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Verblijf.findAll", query = "SELECT t FROM Verblijf t")
})
public class Verblijf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer verblijfId;

    @NotNull @Size(max=25)
    private String naam;

    @OneToMany(mappedBy="verblijf", fetch = FetchType.EAGER)
    private List<Dier> dieren;

    private Integer plekkenTotaal;

    private String verblijfSoort;

    private Boolean verblijfVol;

    public Boolean getVerblijfVol() {
        if (this.dieren != null){
            return this.dieren.size() == this.plekkenTotaal;
        }
        return false;
    }

    public void setVerblijfVol(Boolean verblijfVol) {
        verblijfVol = verblijfVol;
    }

    public Verblijf() {
    }

    public String getVerblijfSoort() {
        return verblijfSoort;
    }

    public void setVerblijfSoort(String verblijfSoort) {
        this.verblijfSoort = verblijfSoort;
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
        this.dieren = new ArrayList<>(dieren);
    }

    public Integer getPlekkenTotaal() {
        return plekkenTotaal;
    }

    public void setPlekkenTotaal(Integer plekkenTotaal) {
        this.plekkenTotaal = plekkenTotaal;
    }

}
