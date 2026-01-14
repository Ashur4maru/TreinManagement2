import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * @author Rakim Benkirane
 * @version 2.0
 *
 * Hoofdklasse voor het Treinmanagementsysteem.
 * Deze klasse fungeert als de controller die gebruikersinvoer verwerkt
 * en de interactie tussen treinen, reizen, reizigers en personeel beheert.
 */

public class Main {

    //statische lijsten die als tijdelijke database werken
    private static List<Trein> treinen = new ArrayList<>();
    private static List<Reis> reizen = new ArrayList<>();
    private static List<Reiziger> reizigers = new ArrayList<>();
    private static List<Personeel> personeelsleden = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        //Hoofdloop van de applicatie
        while (running) {
            toonHoofdMenu();
            int keuze = leesInt();

            switch (keuze) {
                case 1:
                    treinMenu();
                    break;
                case 2:
                    reisMenu();
                    break;
                case 3:
                    reizigerMenu();
                    break;
                case 4:
                    personeelMenu();
                    break;
                case 5:
                    ticketMenu();
                    break;
                case 6:
                    toonAlleInformatie();
                    break;
                case 7:
                    drukBoardingLijstAf();
                    break;
                case 0:
                    System.out.println("Programma wordt afgesloten...");
                    running = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
        scanner.close();
    }


    /**
     *Toont de hoofdmenu in de console
     *
     */
    private static void toonHoofdMenu() {
        System.out.println("\n========== TREINMANAGEMENTSYSTEEM ==========");
        System.out.println("1. Trein beheer");
        System.out.println("2. Reis beheer");
        System.out.println("3. Reiziger beheer");
        System.out.println("4. Personeel beheer");
        System.out.println("5. Ticket beheer");
        System.out.println("6. Toon alle informatie");
        System.out.println("7. Boarding lijst afdrukken (txt)");
        System.out.println("0. Afsluiten");
        System.out.print("Kies een optie: ");
    }

    // ========== TREIN MENU ==========

    /**
     * Toont de trein menu in de console
     */
    private static void treinMenu() {
        System.out.println("\n--- TREIN BEHEER ---");
        System.out.println("1. Nieuwe trein aanmaken");
        System.out.println("2. Wagon toevoegen aan trein");
        System.out.println("3. Toon alle treinen");
        System.out.println("0. Terug naar hoofdmenu");
        System.out.print("Kies een optie: ");

        int keuze = leesInt();

        switch (keuze) {
            case 1:
                maakNieuweTrein();
                break;
            case 2:
                voegWagonToe();
                break;
            case 3:
                toonAlleTreinen();
                break;
        }
    }


    /**
     * Maakt een nieuwe trein aan en voegt het toe aan de lijst met treinen
     */
    private static void maakNieuweTrein() {
        System.out.print("Type motor (bijv. Elektrisch, Diesel): ");
        String typeMotor = scanner.nextLine();


        //Object-georienteerd opbouw: een trein heeft een locomotief nodige
        Locomotief loc = new Locomotief(typeMotor);
        Trein trein = new Trein(loc);
        treinen.add(trein);

        System.out.println("Trein succesvol aangemaakt! (Trein #" + treinen.size() + ")");

        System.out.print("Wil je nu wagons toevoegen? (j/n): ");
        if (scanner.nextLine().equalsIgnoreCase("j")) {
            boolean doorgaan = true;
            while (doorgaan) {
                System.out.print("Wagon klasse (1=BUSINESS, 2=ECONOMIE): ");
                int klasseKeuze = leesInt();
                TypeKlasse klasse = (klasseKeuze == 1) ? TypeKlasse.BUSINESS : TypeKlasse.ECONOMIE;

                System.out.print("Capaciteit: ");
                int capaciteit = leesInt();

                Wagon wagon = new Wagon(klasse, capaciteit);
                trein.voegWagonToe(wagon);
                System.out.println("Wagon toegevoegd!");

                System.out.print("Nog een wagon toevoegen? (j/n): ");
                doorgaan = scanner.nextLine().equalsIgnoreCase("j");
            }
        }
    }

    /**
     * Voegt een wagon toe aan een trein
     */
    private static void voegWagonToe() {
        if (treinen.isEmpty()) {
            System.out.println("Geen treinen beschikbaar. Maak eerst een trein aan.");
            return;
        }

        toonAlleTreinen();
        System.out.print("Kies trein nummer: ");
        int treinIndex = leesInt() - 1;

        if (treinIndex < 0 || treinIndex >= treinen.size()) {
            System.out.println("Ongeldige treinnummer.");
            return;
        }

        System.out.print("Wagon klasse (1=BUSINESS, 2=ECONOMIE): ");
        int klasseKeuze = leesInt();
        TypeKlasse klasse = (klasseKeuze == 1) ? TypeKlasse.BUSINESS : TypeKlasse.ECONOMIE;

        System.out.print("Capaciteit: ");
        int capaciteit = leesInt();

        Wagon wagon = new Wagon(klasse, capaciteit);
        treinen.get(treinIndex).voegWagonToe(wagon);
        System.out.println("Wagon succesvol toegevoegd!");
    }

    private static void toonAlleTreinen() {
        if (treinen.isEmpty()) {
            System.out.println("Geen treinen beschikbaar.");
            return;
        }

        System.out.println("\n--- ALLE TREINEN ---");
        for (int i = 0; i < treinen.size(); i++) {
            System.out.println((i + 1) + ". " + treinen.get(i));
        }
    }

    // ========== REIS MENU ==========
    private static void reisMenu() {
        System.out.println("\n--- REIS BEHEER ---");
        System.out.println("1. Nieuwe reis aanmaken");
        System.out.println("2. Trein koppelen aan reis");
        System.out.println("3. Toon alle reizen");
        System.out.println("0. Terug naar hoofdmenu");
        System.out.print("Kies een optie: ");

        int keuze = leesInt();

        switch (keuze) {
            case 1:
                maakNieuweReis();
                break;
            case 2:
                koppelTreinAanReis();
                break;
            case 3:
                toonAlleReizen();
                break;
        }
    }

    private static void maakNieuweReis() {
        System.out.print("Vertrekstation: ");
        String vertrek = scanner.nextLine();

        System.out.print("Aankomststation: ");
        String aankomst = scanner.nextLine();

        System.out.print("Vertrektijd (bijv. 10:00): ");
        String vertrekTijd = scanner.nextLine();

        System.out.print("Aankomsttijd (bijv. 13:30): ");
        String aankomstTijd = scanner.nextLine();

        Reis reis = new Reis(vertrek, aankomst, vertrekTijd, aankomstTijd);
        reizen.add(reis);

        System.out.println("Reis succesvol aangemaakt! (Reis #" + reizen.size() + ")");
    }


    /**
     * Koppelt een trein aan een reis.
     */
    private static void koppelTreinAanReis() {
        if (treinen.isEmpty() || reizen.isEmpty()) {
            System.out.println("Zorg dat er treinen en reizen beschikbaar zijn.");
            return;
        }

        toonAlleReizen();
        System.out.print("Kies reis nummer: ");
        int reisIndex = leesInt() - 1;

        toonAlleTreinen();
        System.out.print("Kies trein nummer: ");
        int treinIndex = leesInt() - 1;

        if (reisIndex >= 0 && reisIndex < reizen.size() &&
                treinIndex >= 0 && treinIndex < treinen.size()) {
            reizen.get(reisIndex).setTrein(treinen.get(treinIndex));
            System.out.println("Trein succesvol gekoppeld aan reis!");
        } else {
            System.out.println("Ongeldige keuze.");
        }
    }

    private static void toonAlleReizen() {
        if (reizen.isEmpty()) {
            System.out.println("Geen reizen beschikbaar.");
            return;
        }

        System.out.println("\n--- ALLE REIZEN ---");
        for (int i = 0; i < reizen.size(); i++) {
            System.out.println((i + 1) + ". " + reizen.get(i));
        }
    }

    // ========== REIZIGER MENU ==========
    private static void reizigerMenu() {
        System.out.println("\n--- REIZIGER BEHEER ---");
        System.out.println("1. Nieuwe reiziger aanmaken");
        System.out.println("2. Reiziger koppelen aan trein");
        System.out.println("3. Toon alle reizigers");
        System.out.println("0. Terug naar hoofdmenu");
        System.out.print("Kies een optie: ");

        int keuze = leesInt();

        switch (keuze) {
            case 1:
                maakNieuweReiziger();
                break;
            case 2:
                koppelReizigerAanTrein();
                break;
            case 3:
                toonAlleReizigers();
                break;
        }
    }

    private static void maakNieuweReiziger() {
        System.out.print("Voornaam: ");
        String naam = scanner.nextLine();

        System.out.print("Familienaam: ");
        String familienaam = scanner.nextLine();

        Reiziger reiziger = new Reiziger(naam, familienaam);
        reizigers.add(reiziger);

        System.out.println("Reiziger succesvol aangemaakt! (Reiziger #" + reizigers.size() + ")");
    }

    private static void koppelReizigerAanTrein() {
        if (reizigers.isEmpty() || treinen.isEmpty()) {
            System.out.println("Zorg dat er reizigers en treinen beschikbaar zijn.");
            return;
        }

        toonAlleReizigers();
        System.out.print("Kies reiziger nummer: ");
        int reizigerIndex = leesInt() - 1;

        toonAlleTreinen();
        System.out.print("Kies trein nummer: ");
        int treinIndex = leesInt() - 1;

        if (reizigerIndex >= 0 && reizigerIndex < reizigers.size() &&
                treinIndex >= 0 && treinIndex < treinen.size()) {
            reizigers.get(reizigerIndex).setTrein(treinen.get(treinIndex));
            System.out.println("Reiziger succesvol gekoppeld aan trein!");
        } else {
            System.out.println("Ongeldige keuze.");
        }
    }

    private static void toonAlleReizigers() {
        if (reizigers.isEmpty()) {
            System.out.println("Geen reizigers beschikbaar.");
            return;
        }

        System.out.println("\n--- ALLE REIZIGERS ---");
        for (int i = 0; i < reizigers.size(); i++) {
            System.out.println((i + 1) + ". " + reizigers.get(i));
        }
    }

    // ========== PERSONEEL MENU ==========
    private static void personeelMenu() {
        System.out.println("\n--- PERSONEEL BEHEER ---");
        System.out.println("1. Nieuw personeelslid aanmaken");
        System.out.println("2. Personeelslid koppelen aan trein");
        System.out.println("3. Toon alle personeelsleden");
        System.out.println("0. Terug naar hoofdmenu");
        System.out.print("Kies een optie: ");

        int keuze = leesInt();

        switch (keuze) {
            case 1:
                maakNieuwPersoneel();
                break;
            case 2:
                koppelPersoneelAanTrein();
                break;
            case 3:
                toonAllePersoneel();
                break;
        }
    }

    private static void maakNieuwPersoneel() {
        System.out.print("Voornaam: ");
        String naam = scanner.nextLine();

        System.out.print("Familienaam: ");
        String familienaam = scanner.nextLine();

        System.out.print("Functie (bijv. Machinist, Conducteur): ");
        String functie = scanner.nextLine();

        System.out.print("Certificaat: ");
        String certificaat = scanner.nextLine();

        Personeel personeel = new Personeel(naam, familienaam, functie, certificaat);
        personeelsleden.add(personeel);

        System.out.println("Personeelslid succesvol aangemaakt! (Personeel #" + personeelsleden.size() + ")");
    }

    private static void koppelPersoneelAanTrein() {
        if (personeelsleden.isEmpty() || treinen.isEmpty()) {
            System.out.println("Zorg dat er personeelsleden en treinen beschikbaar zijn.");
            return;
        }

        toonAllePersoneel();
        System.out.print("Kies personeelslid nummer: ");
        int personeelIndex = leesInt() - 1;

        toonAlleTreinen();
        System.out.print("Kies trein nummer: ");
        int treinIndex = leesInt() - 1;

        if (personeelIndex >= 0 && personeelIndex < personeelsleden.size() &&
                treinIndex >= 0 && treinIndex < treinen.size()) {
            personeelsleden.get(personeelIndex).setTrein(treinen.get(treinIndex));
            System.out.println("Personeelslid succesvol gekoppeld aan trein!");
        } else {
            System.out.println("Ongeldige keuze.");
        }
    }

    private static void toonAllePersoneel() {
        if (personeelsleden.isEmpty()) {
            System.out.println("Geen personeelsleden beschikbaar.");
            return;
        }

        System.out.println("\n--- ALLE PERSONEELSLEDEN ---");
        for (int i = 0; i < personeelsleden.size(); i++) {
            System.out.println((i + 1) + ". " + personeelsleden.get(i));
        }
    }

    // ========== TICKET MENU ==========
    private static void ticketMenu() {
        System.out.println("\n--- TICKET BEHEER ---");
        System.out.println("1. Nieuw ticket aanmaken en koppelen");
        System.out.println("2. Toon alle tickets");
        System.out.println("0. Terug naar hoofdmenu");
        System.out.print("Kies een optie: ");

        int keuze = leesInt();

        switch (keuze) {
            case 1:
                maakNieuwTicket();
                break;
            case 2:
                toonAlleTickets();
                break;
        }
    }

    private static void maakNieuwTicket() {
        if (reizigers.isEmpty() || reizen.isEmpty()) {
            System.out.println("Zorg dat er reizigers en reizen beschikbaar zijn.");
            return;
        }

        System.out.print("Ticketnummer: ");
        String ticketNummer = scanner.nextLine();

        System.out.print("Prijs (€): ");
        double prijs = scanner.nextDouble();
        scanner.nextLine();

        Ticket ticket = new Ticket(ticketNummer, prijs);

        toonAlleReizigers();
        System.out.print("Kies reiziger nummer: ");
        int reizigerIndex = leesInt() - 1;

        toonAlleReizen();
        System.out.print("Kies reis nummer: ");
        int reisIndex = leesInt() - 1;

        if (reizigerIndex >= 0 && reizigerIndex < reizigers.size() &&
                reisIndex >= 0 && reisIndex < reizen.size()) {
            ticket.setReiziger(reizigers.get(reizigerIndex));
            ticket.setReis(reizen.get(reisIndex));
            System.out.println("Ticket succesvol aangemaakt en gekoppeld!");
        } else {
            System.out.println("Ongeldige keuze.");
        }
    }

    private static void toonAlleTickets() {
        System.out.println("\n--- ALLE TICKETS ---");
        boolean heeftTickets = false;

        for (Reiziger r : reizigers) {
            if (r.getTicket() != null) {
                System.out.println(r + " -> " + r.getTicket());
                heeftTickets = true;
            }
        }

        if (!heeftTickets) {
            System.out.println("Geen tickets beschikbaar.");
        }
    }

    // ========== ALGEMENE INFORMATIE ==========
    private static void toonAlleInformatie() {
        System.out.println("\n========== VOLLEDIGE OVERZICHT ==========");

        toonAlleTreinen();
        toonAlleReizen();
        toonAlleReizigers();
        toonAllePersoneel();
        toonAlleTickets();
    }

    // ========== BOARDING LIJST ==========

    /**
     * Exporteert alle relevante informatie van een geselecteerde trein naar een tekstbestand.
     * Inclusief locomotief-details, wagon-indeling en passagierslijst.
     */
    private static void drukBoardingLijstAf() {
        if (treinen.isEmpty()) {
            System.out.println("Geen treinen beschikbaar.");
            return;
        }

        toonAlleTreinen();
        System.out.print("Kies trein nummer voor boarding lijst: ");
        int treinIndex = leesInt() - 1;

        if (treinIndex < 0 || treinIndex >= treinen.size()) {
            System.out.println("Ongeldige treinnummer.");
            return;
        }

        Trein trein = treinen.get(treinIndex);

        System.out.print("Bestandsnaam (bijv. boarding_lijst.txt): ");
        String bestandsnaam = scanner.nextLine();


        // Try-with-resources blok zorgt voor automatische sluiting van de writer
        try (PrintWriter writer = new PrintWriter(new FileWriter(bestandsnaam))) {
            // Header
            writer.println("═══════════════════════════════════════════════════════");
            writer.println("              BOARDING LIJST - PASSAGIERS              ");
            writer.println("═══════════════════════════════════════════════════════");
            writer.println();

            // Trein informatie
            writer.println("TREIN INFORMATIE:");
            writer.println("─────────────────────────────────────────────────────");
            writer.println("Locomotief: " + trein.getLocomotief().getTypeMotor());
            writer.println("Aantal wagons: " + trein.getWagons().size());
            writer.println();

            // Wagon details
            writer.println("WAGONS:");
            for (int i = 0; i < trein.getWagons().size(); i++) {
                Wagon w = trein.getWagons().get(i);
                writer.println("  Wagon " + (i + 1) + ": " + w.getTypeKlasse() +
                        " (Capaciteit: " + w.getCapaciteit() + ")");
            }
            writer.println();

            // Reis informatie
            if (trein.getReis() != null) {
                Reis reis = trein.getReis();
                writer.println("REIS INFORMATIE:");
                writer.println("─────────────────────────────────────────────────────");
                writer.println("Van: " + reis.getVertrekStation());
                writer.println("Naar: " + reis.getAankomstStation());
                writer.println("Vertrek: " + reis.getVertrekTijd());
                writer.println("Aankomst: " + reis.getAankomstTijd());
                writer.println();
            }

            // Passagiers lijst
            writer.println("PASSAGIERS:");
            writer.println("─────────────────────────────────────────────────────");

            if (trein.getReizigers().isEmpty()) {
                writer.println("Geen passagiers aan boord.");
            } else {
                writer.println(String.format("%-5s %-20s %-20s %-15s %-10s",
                        "Nr.", "Voornaam", "Familienaam", "Ticket Nr.", "Prijs"));
                writer.println("─────────────────────────────────────────────────────");

                int nr = 1;
                for (Reiziger r : trein.getReizigers()) {
                    String ticketNr = (r.getTicket() != null) ? r.getTicket().getTicketNummer() : "N/A";
                    String prijs = (r.getTicket() != null) ? "€" + r.getTicket().getPrijs() : "N/A";

                    writer.println(String.format("%-5d %-20s %-20s %-15s %-10s",
                            nr, r.getNaam(), r.getFamilienaam(), ticketNr, prijs));
                    nr++;
                }
                writer.println();
                writer.println("Totaal aantal passagiers: " + trein.getReizigers().size());
            }

            writer.println();
            writer.println("═══════════════════════════════════════════════════════");
            writer.println("         Gegenereerd door Treinmanagementsysteem       ");
            writer.println("═══════════════════════════════════════════════════════");

            System.out.println("\nBoarding lijst succesvol opgeslagen in: " + bestandsnaam);

        } catch (IOException e) {
            System.out.println("Fout bij het schrijven naar bestand: " + e.getMessage());
        }
    }

    // ========== HULPMETHODES ==========

    /**
     * Leest een integer in en vangt foutieve invoer (zoals letters) af.
     * Voorkomt de bekende Scanner 'skipping' bug door nextLine() aan te roepen.
     * @return Een geldig ingevoerd getal.
     */
    private static int leesInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Voer een geldig nummer in: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    //De overige methode(reisMenu, reizigerMenu, personeelMenu, ticketMenu, toonAlleInformatie,....) volgen altijd dezelfde patroon.
}