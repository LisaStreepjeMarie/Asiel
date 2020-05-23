package asiel_project.dto;

import asiel_project.enums.Soort;
import asiel_project.entity.Verblijf;

import java.io.Serializable;

public class DierDTO implements Serializable {

    private Integer dierId;

    private String naam;

    private Soort soort;

    private Verblijf verblijf;

    private String datumErin;

    private String datumBuiten;

    public DierDTO() {
    }

    public Integer getDierId() {
        return dierId;
    }

    public void setDierId(Integer dierId) {
        this.dierId = dierId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Soort getSoort() {
        return soort;
    }

    public void setSoort(Soort soort) {
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
}
