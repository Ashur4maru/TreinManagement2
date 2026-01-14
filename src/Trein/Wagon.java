package Trein;

/**
 * Deze klasse bevat de gegevens van een wagon.
 *
 */

public class Wagon {

    private TypeKlasse typeKlasse;
    private int capaciteit;

    public Wagon(TypeKlasse typeKlasse, int capaciteit) {
        this.typeKlasse = typeKlasse;
        this.capaciteit = capaciteit;
    }

    public TypeKlasse getTypeKlasse() {
        return typeKlasse;
    }

    public void setTypeKlasse(TypeKlasse typeKlasse) {
        this.typeKlasse = typeKlasse;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    @Override
    public String toString() {
        return "Trein.Trein.Wagon (" + typeKlasse + ", capaciteit: " + capaciteit + ")";
    }
}
