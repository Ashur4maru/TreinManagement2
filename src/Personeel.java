public class Personeel extends Persoon{

    private String functie;
    private String certificaat;
    private Trein trein;

    public Personeel(String naam, String familienaam, String functie, String certificaat) {
        super(naam, familienaam);
        this.functie = functie;
        this.certificaat = certificaat;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getCertificaat() {
        return certificaat;
    }

    public void setCertificaat(String certificaat) {
        this.certificaat = certificaat;
    }

    public Trein getTrein() {
        return trein;
    }

    public void setTrein(Trein trein) {
        this.trein = trein;
        if (trein != null && !trein.getPersoneelsleden().contains(this)) {
            trein.voegPersooneelToe(this);
        }
    }

    @Override
    public String toString() {
        return "Personeel: " + super.toString() + " (" + functie + ", " + certificaat + ")";
    }
}
