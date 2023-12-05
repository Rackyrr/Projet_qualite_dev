package models.creatures;

public class Egg {
    private final Class SPECIES_CLASS;
    private final int INCUBATION_TIME;
    private int actualEncubationTime = 0;

    public Egg(Class SPECIES_CLASS, int INCUBATION_TIME) {
        this.SPECIES_CLASS = SPECIES_CLASS;
        this.INCUBATION_TIME = INCUBATION_TIME;
    }
}
