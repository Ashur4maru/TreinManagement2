import java.time.LocalDate;

public class Persoon {

    private String naam;
    private String familienaam;

    public Persoon(String naam, String familienaam) {
        this.naam = naam;
        this.familienaam = familienaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    @Override
    public String toString() {
        return naam + " " + familienaam;
    }

}
