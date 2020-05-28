package asiel_project.dto;

public class VerblijfDierenDTO {

    private Integer dierId;

    private String naam;

    private String soort;

    public VerblijfDierenDTO() {
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
}
