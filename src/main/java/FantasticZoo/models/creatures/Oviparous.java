package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public abstract class Oviparous extends Creature{


    /**
     * Represents an Oviparous creature.
     */
    public Oviparous(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     * Represents an oviparous creature.
     *
     * @param name                 the name of the creature
     * @param weight               the weight of the creature
     * @param height               the height of the creature
     * @param age                  the age of the creature
     * @param hungerMaxValue       the maximum value of the hunger indicator
     * @param hungerRate           the rate at which the hunger indicator decreases
     * @param sleepMaxValue        the maximum value of the sleep indicator
     * @param sleepRate            the rate at which the sleep indicator decreases
     * @param healthMaxValue       the maximum value of the health indicator
     * @param NATURAL_DEATH_AGE    the natural death age for the creature
     * @param dead                 indicates whether the creature is dead or not
     * @param gender               the gender of the creature (MALE or FEMALE)
     * @param actualEnclosure      the enclosure in which the creature resides
     */
    public Oviparous(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     * Returns the incubation time for the Phoenix.
     *
     * @return the incubation time
     */
    public abstract int getINCUBATION_TIME();

    /**
     * Retrieves the species class of the creature.
     *
     * @return the species class
     */
    public abstract Class getSpeciesClass();

    /**
     * Determines whether this creature can reproduce with the given mate.
     *
     * @param mate The mate to reproduce with
     * @return true if the creature can reproduce with the mate, false otherwise
     */
    public boolean reproduce(Oviparous mate) {
        if (canMateWith(mate)) {
            Oviparous female;
            Oviparous male;
            if (this.getGender() == Gender.FEMALE) {
                female = this;
                male = mate;
            } else {
                female = mate;
                male = this;
            }
            if (!female.getActualEnclosure().isFull())
                return female.layEgg() != null;
        }
        return false;
    }

    /**
     * This method is used to lay an egg.
     *
     * @return the newly laid egg if it is successfully added to the enclosure, otherwise null
     */
    public Egg layEgg(){
        Egg egg = new Egg(getSpeciesClass(),getINCUBATION_TIME(),getActualEnclosure());
        if (getActualEnclosure().AddEgg(egg))
            return egg;
        return null;
    }

    /**
     * Runs the lifecycle of the Oviparous creature by performing necessary actions such as growing up, refreshing sleep,
     * hunger, and health indicators, and checking for death conditions. Additionally, there is a 10% chance that the creature
     * will attempt to reproduce if it is not sleeping. If the reproduction attempt is successful, a new egg is laid in the current
     * enclosure.
     */
    @Override
    public void run() {
        super.run();
        if(!getSleep().getState() && Math.random() <= 0.1){
            Oviparous mate = (Oviparous) getActualEnclosure().getRandomCreatureInEnclosure();
            if(mate != null) reproduce(mate);
        }
    }
}
