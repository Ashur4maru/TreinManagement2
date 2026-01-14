package Trein;

/**
 * Deze klasse bevat de gegevens van een locomotief.
 */

public class Locomotief {

    private String typeMotor;

    public Locomotief(String typeMotor) {
        this.typeMotor = typeMotor;
    }

    public String getTypeMotor() {
        return typeMotor;
    }


    @Override
    public String toString() {
        return "Trein.Trein.Locomotief (motor: " + typeMotor + ")";
    }
}
