public class Ticket {

    private String ticketNummer;
    private double prijs;
    private Reiziger reiziger;
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
