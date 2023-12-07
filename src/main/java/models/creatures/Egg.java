package models.creatures;

import models.enclosures.Enclosure;

public class Egg implements Runnable{
    private final Class SPECIES_CLASS;
    private final int INCUBATION_TIME;
    private int actualIncubationTime = 0;

    private Enclosure actualEnclosure;

    public Egg(Class SPECIES_CLASS, int INCUBATION_TIME) {
        this.SPECIES_CLASS = SPECIES_CLASS;
        this.INCUBATION_TIME = INCUBATION_TIME;
    }

    public void refresh() {
        ++actualIncubationTime;
        if (actualIncubationTime >= INCUBATION_TIME) {
        }
    }

    @Override
    public void run() {
    }
}
