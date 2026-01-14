package Trein;

import Persoon.Personeel;
import Persoon.Reiziger;

import java.util.ArrayList;
import java.util.List;

/**
 * De klasse Trein.Trein representeert een trein die bestaat uit een locomotief, meerdere wagons,
 * een lijst van personeelsleden en reizigers, en een mogelijke toegewezen reis.
 */
public class Trein {

    private Locomotief locomotief;
    private List<Wagon> wagons;
    private List<Personeel> personeelsleden;
    private List<Reiziger> reizigers;
    private Reis reis;

    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
        this.wagons = new ArrayList<>();
        this.personeelsleden = new ArrayList<>();
        this.reizigers = new ArrayList<>();
    }

    public Locomotief getLocomotief() {
        return locomotief;
    }



    public List<Wagon> getWagons() {
        return wagons;
    }

    public void voegWagonToe(Wagon wagon) {
        wagons.add(wagon);
    }



    public List<Personeel> getPersoneelsleden() {
        return personeelsleden;
    }

    public void voegPersooneelToe(Personeel personeel) {
        if (!personeelsleden.contains(personeel)) {
            personeelsleden.add(personeel);
            if (personeel.getTrein() != this) {
                personeel.setTrein(this);
            }
        }
    }



    public List<Reiziger> getReizigers() {
        return reizigers;
    }

    public void voegReizigerToe(Reiziger reiziger) {
        if (!reizigers.contains(reiziger)) {
            reizigers.add(reiziger);
            if (reiziger.getTrein() != this) {
                reiziger.setTrein(this);
            }
        }
    }



    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
        if (reis != null && reis.getTrein() != this) {
            reis.setTrein(this);
        }
    }

    @Override
    public String toString() {
        return "Trein.Trein met " + locomotief + ", " + wagons.size() + " wagons, " +
                personeelsleden.size() + " personeelsleden, " + reizigers.size() + " reizigers";
    }
}
