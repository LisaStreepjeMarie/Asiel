package asiel_project;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

public class Dier implements Serializable {

    @NotNull
    private Integer dierId;

    @NotNull @Size(max=25)
    private String naam;

    @Size(max=40)
    @NotNull
    private String soort;

    private LocalDate datumErin;

    private LocalDate datumBuiten;

    private Verblijf verblijf;

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

    public Verblijf getVerblijf() {
        return verblijf;
    }

    public void setVerblijf(Verblijf verblijf) {
        this.verblijf = verblijf;
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
                ", lastName='" + verblijf + '\'' +
                ", companyName='" + soort + '\'' +
                '}';
    }
}
