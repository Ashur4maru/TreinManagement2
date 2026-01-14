/**
 * De klasse Ticket vertegenwoordigt een vervoersbewijs dat wordt gekoppeld aan een reiziger en een specifieke reis.
 * Het bevat informatie zoals het ticketnummer en de prijs.
 */

public class Ticket {

    private String ticketNummer;
    private double prijs;

    /**
     * Verwijzing naar een Reiziger die gekoppeld is aan dit ticket.
     * Een Reiziger vertegenwoordigt de persoon die gebruikmaakt van het ticket.
     */
    private Reiziger reiziger;
    /**
     * Verwijzing naar een specifieke reis waaraan het ticket gekoppeld is.
     * Een Reis vertegenwoordigt een treinreis tussen twee stations, inclusief
     * gegevens over vertrek- en aankomststations, tijden, en de lijst met
     * gekoppelde tickets.
     */
    private Reis reis;

    public Ticket(String ticketNummer, double prijs) {
        this.ticketNummer = ticketNummer;
        this.prijs = prijs;
    }

    public String getTicketNummer() {
        return ticketNummer;
    }

    public void setTicketNummer(String ticketNummer) {
        this.ticketNummer = ticketNummer;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
        if (reiziger != null && reiziger.getTicket() != this) {
            reiziger.setTicket(this);
        }
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
        if (reis != null && !reis.getTickets().contains(this)) {
            reis.voegTicketToe(this);
        }
    }

    @Override
    public String toString() {
        return "Ticket " + ticketNummer + " (€" + prijs + ")";
    }
}
