package asiel_project.entity;

import asiel_project.enums.Soort;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @OneToMany(mappedBy="verblijf")
    private List<Dier> dieren;

    private Integer plekkenTotaal;

    private Integer plekkenBezet;


    private String verblijfSoort;

    public Verblijf() {
    }

    public String getVerblijfSoort() {
        return verblijfSoort;
    }

    public void setVerblijfSoort(String verblijfSoort) {
        this.verblijfSoort = verblijfSoort;
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
        this.dieren = new ArrayList<>(dieren);
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
        this.plekkenBezet += plekkenBezet;
    }
}
