package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public abstract class Viviparous extends Creature{
    private boolean pregnant = false;
    private int actualGestationTime = 0;
    private final int GESTATION_TIME;

    public Viviparous(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
        this.GESTATION_TIME = GESTATION_TIME;
    }

    public Viviparous(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
        this.GESTATION_TIME = GESTATION_TIME;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public int getActualGestationTime() {
        return actualGestationTime;
    }

    public void setActualGestationTime(int actualGestationTime) {
        this.actualGestationTime = actualGestationTime;
    }

    public int getGESTATION_TIME() {
        return GESTATION_TIME;
    }

    public boolean reproduce(Viviparous mate) {
        if (canMateWith(mate)) {
            Viviparous female;
            Viviparous male;
            if (this.getGender() == Gender.FEMALE) {
                female = this;
                male = mate;
            } else {
                female = mate;
                male = this;
            }
            if (!female.pregnant && !female.getActualEnclosure().isFull())
                return female.pregnant = true;
        }
        return false;
    }

    public void refreshPregnancy(){
        ++actualGestationTime;
        if (actualGestationTime >= GESTATION_TIME) giveBirth();
    }

    public abstract boolean giveBirth();

    @Override
    public void run() {
        super.run();
        if (!getSleep().getState() && Math.random() <= 0.1) {
            Viviparous mate = (Viviparous) getActualEnclosure().getRandomCreatureInEnclosure();
            if (mate != null) reproduce(mate);
        }
        if(pregnant) refreshPregnancy();
    }
}
