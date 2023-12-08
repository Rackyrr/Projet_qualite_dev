package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public class Unicorn extends Viviparous implements IRunning{
    private final static int MIN_HEIGHT = 140;
    private final static int MAX_HEIGHT = 160;
    private final static int NATURALDEATHAGE = 75;
    private final static int NEEDMAXVALUE = 150;
    private final static int NEEDRATE = 10;
    private final static int MIN_WEIGHT = 600;
    private final static int MAX_WEIGHT = 800;
    private final static int GESTATIONTIME = 20;


    /**
     * This method returns the name of the species of the unicorn.
     *
     * @return the name of the species
     */
    @Override
    public String getSpecieName() {
        return "Licorne";
    }

    /**
     * Creates a new Unicorn with the given attributes.
     *
     * @param enclosure The enclosure where the unicorn will be placed.
     * @param newBornGender The gender of the new born unicorn.
     */
    public Unicorn(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Licorne", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    /**
     * Creates a new Unicorn with the given attributes.
     *
     * @param enclosure The enclosure where the unicorn will be placed.
     * @param newBornGender The gender of the new born unicorn.
     * @param name The name of the unicorn.
     */
    public Unicorn(Enclosure enclosure,Gender newBornGender, String name) { // for newBorns
        super(name, MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    /**
     * Constructs a Unicorn object with the given attributes.
     *
     * @param name The name of the unicorn.
     * @param weight The weight of the unicorn.
     * @param height The height of the unicorn.
     * @param age The age of the unicorn.
     * @param hunger The hunger indicator of the unicorn.
     * @param sleep The sleep indicator of the unicorn.
     * @param health The health indicator of the unicorn.
     * @param NATURAL_DEATH_AGE The natural death age of the unicorn.
     * @param dead The death state of the unicorn.
     * @param gender The gender of the unicorn.
     * @param actualEnclosure The enclosure where the unicorn is placed.
     * @param GESTATION_TIME The gestation time of the unicorn.
     */
    public Unicorn(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    /**
     * Constructs a Unicorn object with the given attributes.
     *
     * @param name              The name of the unicorn.
     * @param weight            The weight of the unicorn.
     * @param height            The height of the unicorn.
     * @param age               The age of the unicorn.
     * @param hungerMaxValue    The maximum value for hunger indicator.
     * @param hungerRate        The rate at which hunger indicator changes.
     * @param sleepMaxValue     The maximum value for sleep indicator.
     * @param sleepRate         The rate at which sleep indicator changes.
     * @param healthMaxValue    The maximum value for health indicator.
     * @param NATURAL_DEATH_AGE The natural death age of the unicorn.
     * @param dead              The death state of the unicorn.
     * @param gender            The gender of the unicorn.
     * @param actualEnclosure   The enclosure where the unicorn is placed.
     * @param GESTATION_TIME    The gestation time of the unicorn.
     */
    public Unicorn(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    /**
     * Method to give birth to a new unicorn.
     *
     * @return true if the birth was successful, false otherwise
     */
    @Override
    public boolean giveBirth(){
        Unicorn newBorn;
        if (!getActualEnclosure().isFull()) {
            if (Math.random() <= 0.5) newBorn = new Unicorn(getActualEnclosure(), Gender.MALE);
            else newBorn = new Unicorn(getActualEnclosure(), Gender.FEMALE);
            return getActualEnclosure().AddCreature(newBorn);
        }
        return false;
    }

    /**
     * Returns the information about the creature.
     *
     * @return the information about the creature
     */
    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Cet licorne se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + "kg et il mesure " + this.getHeight() + "cm. Il a " + this.getAge()
                    + "ans, et c'est un mâle. Il peut courir.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Cette licorne se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + "kg et elle mesure " + this.getHeight() + "cm. elle a " + this.getAge()
                    + "ans, et c'est une femele. Elle peut courir.";
        }
        return null;
    }

    /**
     * Returns a string representation of the shout made by the unicorn.
     *
     * @return the shout made by the unicorn
     */
    @Override
    public String shout() {
        return String.format("%s hennit !",this.getName());
    }

    /**
     * Runs the `run` method of the superclass `Creature` and performs additional actions specific to the `Unicorn` class.
     * <p>
     * Overrides the `run` method from the superclass, allowing the `Unicorn` to run.
     * The method first calls the `run` method of the superclass `Creature` to perform the default running behavior.
     * Then, if the `Unicorn` is not asleep and a random number is less than or equal to 0.1,
     * it attempts to find a random mate within its enclosure and initiate reproduction.
     * If the `Unicorn` is pregnant, it updates the gestation time.
     * </p>
     */
    @Override
    public void run() {
        super.run();
    }
}
