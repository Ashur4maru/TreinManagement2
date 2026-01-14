package Trein;

import Persoon.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Representeert een specifieke treinreis tussen twee stations.
 * Deze klasse houdt de trajectgegevens bij en beheert de koppelingen
 * met de ingezette trein en de verkochte tickets.
 */

public class Reis {

    private String vertrekStation;
    private String aankomstStation;
    private String vertrekTijd;
    private String aankomstTijd;

    /**
     * De specifieke trein die voor deze reis wordt gebruikt.
     */
    private Trein trein;
    /**
     * Een lijst van alle tickets die voor deze reis zijn verkocht.
     */
    private List<Ticket> tickets;

    public Reis(String vertrekStation, String aankomstStation, String vertrekTijd, String aankomstTijd) {
        this.vertrekStation = vertrekStation;
        this.aankomstStation = aankomstStation;
        this.vertrekTijd = vertrekTijd;
        this.aankomstTijd = aankomstTijd;
        this.tickets = new ArrayList<>();
    }

    public String getVertrekStation() {
        return vertrekStation;
    }

    public void setVertrekStation(String vertrekStation) {
        this.vertrekStation = vertrekStation;
    }

    public String getAankomstStation() {
        return aankomstStation;
    }

    public void setAankomstStation(String aankomstStation) {
        this.aankomstStation = aankomstStation;
    }

    public String getVertrekTijd() {
        return vertrekTijd;
    }

    public void setVertrekTijd(String vertrekTijd) {
        this.vertrekTijd = vertrekTijd;
    }

    public String getAankomstTijd() {
        return aankomstTijd;
    }

    public void setAankomstTijd(String aankomstTijd) {
        this.aankomstTijd = aankomstTijd;
    }

    /**
     * Haalt de treinen die aan deze reis zijn gekoppeld
     */
    public Trein getTrein() {
        return trein;
    }

    /**
     * Koppelt een trein aan deze reis.
     * @param trein de trein die de reis doet
     */
    public void setTrein(Trein trein) {
        this.trein = trein;
        if (trein != null && trein.getReis() != this) {
            trein.setReis(this);
        }
    }

    /**
     * Geeft de lijst met de verkochte tickets terug
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void voegTicketToe(Ticket ticket) {
        if (!tickets.contains(ticket)) {
            tickets.add(ticket);
            if (ticket.getReis() != this) {
                ticket.setReis(this);
            }
        }
    }

    public void verwijderTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    @Override
    public String toString() {
        return "Trein.Reis van " + vertrekStation + " naar " + aankomstStation +
                " (" + vertrekTijd + " - " + aankomstTijd + ")";
    }
}
