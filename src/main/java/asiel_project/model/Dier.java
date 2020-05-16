package asiel_project.model;


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

    private LocalDate datumErin;

    private LocalDate datumBuiten;



    public Dier() {
        // needed for EJB
    }

    public Dier(Integer contactId, String naam, String soort) {
        this.dierId = contactId;
        this.naam = naam;
        this.soort = soort;
    }

    public LocalDate getDatumErin() {
        return datumErin;
    }

    public void setDatumErin(LocalDate datumErin) {
        this.datumErin = datumErin;
    }

    public LocalDate getDatumBuiten() {
        return datumBuiten;
    }

    public void setDatumBuiten(LocalDate datumBuiten) {
        this.datumBuiten = datumBuiten;
    }

    public Integer getContactId() {
        return dierId;
    }

    public void setContactId(Integer contactId) {
        this.dierId = contactId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
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
