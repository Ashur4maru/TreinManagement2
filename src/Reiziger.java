public class Reiziger extends Persoon{

    private Ticket ticket;
    private Trein trein;

    public Reiziger(String naam, String familienaam) {
        super(naam, familienaam);
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
        if (ticket != null && ticket.getReiziger() != this) {
            ticket.setReiziger(this);
        }
    }

    public Trein getTrein() {
        return trein;
    }

    public void setTrein(Trein trein) {
        this.trein = trein;
        if (trein != null && !trein.getReizigers().contains(this)) {
            trein.voegReizigerToe(this);
        }
    }

    @Override
    public String toString() {
        return "Reiziger: " + super.toString();
    }
}
