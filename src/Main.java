//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Maak een locomotief
        Locomotief loc = new Locomotief("Elektrisch");

        // Maak wagons
        Wagon wagon1 = new Wagon(TypeKlasse.BUSINESS, 50);
        Wagon wagon2 = new Wagon(TypeKlasse.ECONOMIE, 100);
        Wagon wagon3 = new Wagon(TypeKlasse.ECONOMIE, 100);

        // Maak een trein
        Trein trein = new Trein(loc);
        trein.voegWagonToe(wagon1);
        trein.voegWagonToe(wagon2);
        trein.voegWagonToe(wagon3);

        // Maak personeel
        Personeel machinist = new Personeel("Jan", "Janssen", "Machinist", "Certificaat A");
        Personeel conducteur = new Personeel("Piet", "Pieters", "Conducteur", "Certificaat B");

        machinist.setTrein(trein);
        conducteur.setTrein(trein);

        // Maak een reis
        Reis reis = new Reis("Brussel", "Amsterdam", "10:00", "13:30");
        reis.setTrein(trein);

        // Maak reizigers met tickets
        Reiziger reiziger1 = new Reiziger("Marie", "Dupont");
        Ticket ticket1 = new Ticket("T001", 45.50);
        ticket1.setReiziger(reiziger1);
        ticket1.setReis(reis);
        reiziger1.setTrein(trein);

        Reiziger reiziger2 = new Reiziger("Tom", "De Vries");
        Ticket ticket2 = new Ticket("T002", 45.50);
        ticket2.setReiziger(reiziger2);
        ticket2.setReis(reis);
        reiziger2.setTrein(trein);

        // Print informatie
        System.out.println(trein);
        System.out.println(reis);
        System.out.println("\nPersoneel:");
        for (Personeel p : trein.getPersoneelsleden()) {
            System.out.println("  " + p);
        }
        System.out.println("\nReizigers:");
        for (Reiziger r : trein.getReizigers()) {
            System.out.println("  " + r + " met " + r.getTicket());
        }

    }
}