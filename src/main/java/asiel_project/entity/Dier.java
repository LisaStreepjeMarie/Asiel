package asiel_project.entity;


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

    @Size(max=40)
    @NotNull
    private String soort;

    @ManyToOne
    private Verblijf verblijf;

    private String datumErin;

    private String datumBuiten;

    public Dier() {
        // needed for EJB
    }

    public Dier(String naam, String soort) {
        this.naam = naam;
        this.soort = soort;

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

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + dierId +
                ", firstName='" + naam + '\'' +

                ", companyName='" + soort + '\'' +
                '}';
    }

}
