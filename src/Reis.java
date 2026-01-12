import java.util.ArrayList;
import java.util.List;

public class Reis {

    private String vertrekStation;
    private String aankomstStation;
    private String vertrekTijd;
    private String aankomstTijd;
    private Trein trein;
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

    public Trein getTrein() {
        return trein;
    }

    public void setTrein(Trein trein) {
        this.trein = trein;
        if (trein != null && trein.getReis() != this) {
            trein.setReis(this);
        }
    }

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
        return "Reis van " + vertrekStation + " naar " + aankomstStation +
                " (" + vertrekTijd + " - " + aankomstTijd + ")";
    }
}
