package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public abstract class Viviparous extends Creature{
    private boolean pregnant = false;
    private int actualGestationTime = 0;
    private final int GESTATION_TIME;

    /**
     * Represents a viviparous creature. Inherits from the Creature class.
     */
    public Viviparous(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
        this.GESTATION_TIME = GESTATION_TIME;
    }

    /**
     * Represents a viviparous creature. Inherits from the Creature class.
     *
     * @param name              the name of the viviparous creature
     * @param weight            the weight of the viviparous creature
     * @param height            the height of the viviparous creature
     * @param age               the age of the viviparous creature
     * @param hungerMaxValue    the maximum value for the hunger indicator of the viviparous creature
     * @param hungerRate        the rate at which the hunger indicator decreases for the viviparous creature
     * @param sleepMaxValue     the maximum value for the sleep indicator of the viviparous creature
     * @param sleepRate         the rate at which the sleep indicator decreases for the viviparous creature
     * @param healthMaxValue    the maximum value for the health indicator of the viviparous*/
    public Viviparous(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
        this.GESTATION_TIME = GESTATION_TIME;
    }

    /**
     * Determines if the viviparous creature is pregnant.
     *
     * @return true if the viviparous creature is pregnant, false otherwise
     */
    public boolean isPregnant() {
        return pregnant;
    }

    /**
     * Sets the pregnancy status of the viviparous creature.
     *
     * @param pregnant true if the viviparous creature is pregnant, false otherwise
     */
    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    /**
     * Retrieves the actual gestation time of a viviparous creature.
     *
     * @return The actual gestation time.
     */
    public int getActualGestationTime() {
        return actualGestationTime;
    }

    /**
     * Sets the actual gestation time of a viviparous creature.
     *
     * @param actualGestationTime the actual gestation time to be set
     */
    public void setActualGestationTime(int actualGestationTime) {
        this.actualGestationTime = actualGestationTime;
    }

    /**
     * Retrieves the gestation time of a viviparous creature.
     *
     * @return The gestation time.
     */
    public int getGESTATION_TIME() {
        return GESTATION_TIME;
    }

    /**
     * Determines if the creature can reproduce with the given mate.
     * The creature must have a compatible gender with the mate in order to reproduce.
     * Once mating is successful, the female creature becomes pregnant if it is not already pregnant
     * and the actual enclosure where the female creature is located must not be full.
     *
     * @param mate The mate to reproduce with
     * @return true if the creature successfully reproduces, false otherwise
     */
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

    /**
     * Refreshes the pregnancy of the viviparous creature by incrementing the actual gestation time.
     * If the actual gestation time reaches or exceeds the defined gestation time, the creature gives birth.
     */
    public void refreshPregnancy(){
        ++actualGestationTime;
        if (actualGestationTime >= GESTATION_TIME) giveBirth();
    }

    /**
     * Gives birth to a new creature.
     *
     * @return true if the birth is successful and the new creature is added to the enclosure, false otherwise
     */
    public abstract boolean giveBirth();

    /**
     * Runs the lifecycle of the creature by performing necessary actions such as growing up,
     * refreshing sleep, hunger, and health indicators, and checking for death conditions.
     * Additionally, it checks if the creature can mate with another viviparous creature randomly
     * and calls the reproduce method if the conditions are met.
     * Finally, it refreshes the pregnancy of the viviparous creature, if it is pregnant.
     */
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
