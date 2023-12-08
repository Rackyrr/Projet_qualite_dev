package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public class Phoenix extends Oviparous implements IFlying, IRebirth{
    private final static int MIN_HEIGHT = 66;
    private final static int MAX_HEIGHT = 100;

    private final static int NEEDMAXVALUE = 75;

    private final static int NATURALDEATHAGE = 50;
    private final static int NEEDRATE = 3;
    private final static int MIN_WEIGHT = 3;
    private final static int MAX_WEIGHT = 7;
    private final int INCUBATION_TIME = 8;

    /**
     *
     * @param enclosure
     * @param newBornGender
     */
    public Phoenix(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Phénix", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }

    /**
     * Creates a new Phoenix object for newborns.
     *
     * @param enclosure The enclosure where the Phoenix will be placed.
     * @param newBornGender The gender of the newborn Phoenix.
     * @param name The name of the newborn Phoenix.
     */
    public Phoenix(Enclosure enclosure,Gender newBornGender, String name) { // for newBorns
        super(name, MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }

    /**
     * Constructs a new Phoenix object with the specified parameters.
     *
     * @param name             the name of the Phoenix
     * @param weight           the weight of the Phoenix
     * @param height           the height of the Phoenix
     * @param age              the age of the Phoenix
     * @param hunger           the HungerIndicator of the Phoenix
     * @param sleep            the SleepIndicator of the Phoenix
     * @param health           the HealthIndicator of the Phoenix
     * @param NATURAL_DEATH_AGE the natural death age of the Phoenix
     * @param dead             the dead state of the Phoenix
     * @param gender           the gender of the Phoenix
     * @param actualEnclosure  the Enclosure where the Phoenix is located
     */
    public Phoenix(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     * Constructs a new Phoenix object with the specified parameters.
     *
     * @param name             the name of the Phoenix
     * @param weight           the weight of the Phoenix
     * @param height           the height of the Phoenix
     * @param age              the age of the Phoenix
     * @param hungerMaxValue   the maximum value of hunger for the Phoenix
     * @param hungerRate       the rate at which the Phoenix's hunger decreases
     * @param sleepMaxValue    the maximum value of sleep for the Phoenix
     * @param sleepRate        the rate at which the Phoenix's sleep decreases
     * @param healthMaxValue   the maximum value of health for the Phoenix
     * @param NATURAL_DEATH_AGE
     * @param dead
     * @param gender
     * @param actualEnclosure*/
    public Phoenix(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     * Returns the incubation time for the Phoenix.
     *
     * @return the incubation time
     */
    @Override
    public int getINCUBATION_TIME() {
        return INCUBATION_TIME;
    }

    /**
     * Returns the class object of the species.
     *
     * @return the class object of the species.
     */
    @Override
    public Class getSpeciesClass() {
        return this.getClass();
    }

    /**
     * Returns the species name of the Phoenix.
     *
     * @return the species name of the Phoenix
     */
    @Override
    public String getSpecieName() {
        return "Phénix";
    }

    /**
     * Returns the information about the creature.
     *
     * @return the information about the creature
     */
    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce phénix se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut voler et renaître après sa mort.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce phénix se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut voler et renaître après sa mort.";
        }
        return null;
    }

    /**
     * Reborns the Phoenix by setting its hunger, sleep, health, dead state, and age to default values.
     * This method is used to reset the Phoenix object after it has died.
     */
    @Override
    public void getReborn() {
        setHunger(new HungerIndicator(NEEDMAXVALUE,NEEDRATE));
        setSleep(new SleepIndicator(NEEDMAXVALUE,NEEDRATE));
        setHealth(new HealthIndicator(NEEDMAXVALUE));
        setDead(false);
        setAge(0);
    }

    /**
     *
     * Returns a string representing the shout of the Phoenix.
     *
     * @return the shout of the Phoenix
     */
    @Override
    public String shout() {
        return String.format("%s gazouille !",this.getName());
    }

    /**
     * Runs the Phoenix by calling the super class's run method and checking if it is dead.
     * If the Phoenix is dead, it will be reborn.
     */
    @Override
    public void run() {
        super.run();
        if (isDead())
            getReborn();
    }
}
