package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public class Dragon extends Oviparous implements IRunning, IFlying{
    private final static int MIN_HEIGHT = 1500;
    private final static int MAX_HEIGHT = 2500;

    private final static int NEEDMAXVALUE = 300;

    private final static int NATURALDEATHAGE = 175;
    private final static int NEEDRATE = 25;
    private final static int MIN_WEIGHT = 350000;
    private final static int MAX_WEIGHT = 400000;
    private final int INCUBATION_TIME = 35;

    /**
     * Constructs a new Dragon object for newBorns.
     * A Dragon is a type of creature with specific characteristics.
     *
     * @param enclosure      the enclosure where the Dragon will be placed
     * @param newBornGender  the gender of the newBorn Dragon
     */
    public Dragon(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Dragon", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }

    /**
     * Constructs a new Dragon object for newBorns.
     * A Dragon is a type of creature with specific characteristics.
     *
     * @param enclosure      the enclosure where the Dragon will be placed
     * @param newBornGender  the gender of the newBorn Dragon
     * @param name           the name of the Dragon
     */
    public Dragon(Enclosure enclosure,Gender newBornGender, String name) { // for newBorns
        super(name, MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }


    /**
     * Represents a Dragon, a type of creature with specific characteristics.
     */
    public Dragon(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     * Constructs a Dragon with the given characteristics.
     *
     * @param name             the name of the Dragon
     * @param weight           the weight of the Dragon
     * @param height           the height of the Dragon
     * @param age              the age of the Dragon
     * @param hungerMaxValue   the maximum hunger value of the Dragon
     * @param hungerRate       the hunger rate of the Dragon
     * @param sleepMaxValue    the maximum sleep value of the Dragon
     * @param sleepRate        the sleep rate of the Dragon
     * @param healthMaxValue   the maximum health value of the Dragon
     * @param NATURAL_DEATH_AGE the natural death age of the Dragon
     * @param dead             the status of the Dragon (dead or alive)
     * @param gender           the gender of the Dragon
     * @param actualEnclosure  the enclosure where the Dragon is placed
     */
    public Dragon(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     * Retrieves the incubation time of the oviparous creature.
     *
     * @return the incubation time
     */
    @Override
    public int getINCUBATION_TIME() {
        return INCUBATION_TIME;
    }

    /**
     * Retrieves the species class of the creature.
     *
     * @return the class representing the species of the creature
     */
    @Override
    public Class getSpeciesClass() {
        return this.getClass();
    }

    /**
     * Retrieves the species name of the creature.
     *
     * @return the species name of the creature
     */
    @Override
    public String getSpecieName() {
        return "Dragon";
    }

    /**
     * Retrieves the information of the creature.
     *
     * @return the information of the creature as a string
     */
    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce Dragon se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut voler.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce Dragon se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut voler.";
        }
        return null;
    }

    /**
     * Runs the dragon.
     */
    @Override
    public void run() {
        super.run();
    }

    /**
     * Returns a string representing the shout of the creature.
     *
     * @return the shout of the creature
     */
    @Override
    public String shout() {
        return String.format("%s rugit !",this.getName());
    }

}
