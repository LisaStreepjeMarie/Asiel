package asiel_project.entity;


import asiel_project.Enums.Soort;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Dier.findAll", query = "SELECT t FROM Dier t")
})
public class Dier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dierId;

    @NotNull @Size(max=25)
    private String naam;

    @NotNull
    private Soort soort;

    @ManyToOne
    private Verblijf verblijf;

    private String datumErin;

    private String datumBuiten;

    public Dier() {
        // needed for EJB
    }

    public Verblijf getVerblijf() {
        return verblijf;
    }

    public void setVerblijf(Verblijf verblijf) {
        this.verblijf = verblijf;
    }

    public String getDatumErin() {
        return datumErin;
    }

    public void setDatumErin(String datumErin) {
        this.datumErin = datumErin;
    }

    public String getDatumBuiten() {
        return datumBuiten;
    }

    public void setDatumBuiten(String datumBuiten) {
        this.datumBuiten = datumBuiten;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getDierId() {
        return dierId;
    }

    public void setDierId(Integer dierId) {
        this.dierId = dierId;
    }

    public void setSoort(Soort soort) {
        this.soort = soort;
    }

    public Soort getSoort() {
        return soort;
    }
}
