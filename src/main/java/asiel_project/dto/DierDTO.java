package asiel_project.dto;

import asiel_project.enums.Soort;

import java.io.Serializable;

public class DierDTO implements Serializable {

    private Integer dierId;

    private String naam;

    private Soort soort;

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

}
