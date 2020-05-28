package asiel_project.dto;

import asiel_project.enums.Soort;

import java.io.Serializable;

public class DierDTO implements Serializable {

    private Integer dierId;

    private String naam;

    private String soort;

    private String verblijfNaam;

    private String datumErin;

    private String datumBuiten;

    private Integer verblijfId;

    public DierDTO() {
    }

    public String getVerblijfNaam() {
        return verblijfNaam;
    }

    public void setVerblijfNaam(String verblijfNaam) {
        this.verblijfNaam = verblijfNaam;
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

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public Integer getVerblijfId() {
        return verblijfId;
    }

    public void setVerblijfId(Integer verblijfId) {
        this.verblijfId = verblijfId;
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
