package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public class Kraken extends Oviparous implements ISwimming{
    private final static int MIN_HEIGHT = 1500;
    private final static int MAX_HEIGHT = 2500;

    private final static int NEEDMAXVALUE = 300;

    private final static int NATURALDEATHAGE = 175;
    private final static int NEEDRATE = 25;
    private final static int MIN_WEIGHT = 350000;
    private final static int MAX_WEIGHT = 400000;
    private final int INCUBATION_TIME = 35;

    /**
     * Initializes a new instance of the Kraken class for newborns.
     *
     * @param enclosure The enclosure where the Kraken will be placed.
     * @param newBornGender The gender of the newborn Kraken.
     */
    public Kraken(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Kraken", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }

    /**
     * Initializes a new instance of the Kraken class for newborns.
     *
     * @param enclosure The enclosure where the Kraken will be placed.
     * @param newBornGender The gender of the newborn Kraken.
     * @param name The name of the newborn Kraken.
     */
    public Kraken(Enclosure enclosure,Gender newBornGender, String name) { // for newBorns
        super(name, MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }

    /**
     * Initializes a new instance of the Kraken class with the specified parameters.
     *
     * @param name            the name of the Kraken
     * @param weight          the weight of the Kraken
     * @param height          the height of the Kraken
     * @param age             the age of the Kraken
     * @param hunger          the hunger indicator of the Kraken
     * @param sleep           the sleep indicator of the Kraken
     * @param health          the health indicator of the Kraken
     * @param NATURAL_DEATH_AGE the natural death age of the Kraken
     * @param dead            the flag indicating if the Kraken is dead
     * @param gender          the gender of the Kraken
     * @param actualEnclosure the actual enclosure where the Kraken is placed
     */
    public Kraken(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     * Initializes a new instance of the Kraken class with the specified parameters.
     *
     * @param name              the name of the Kraken
     * @param weight            the weight of the Kraken
     * @param height            the height of the Kraken
     * @param age               the age of the Kraken
     * @param hungerMaxValue    the maximum value of hunger indicator for the Kraken
     * @param hungerRate        the rate at which the hunger indicator decreases for the Kraken
     * @param sleepMaxValue     the maximum value of sleep indicator for the Kraken
     * @param sleepRate         the rate at which the sleep indicator decreases for the Kraken
     * @param healthMaxValue    the maximum value of health indicator for the Kraken
     * @param NATURAL_DEATH_AGE the natural death age of the Kraken
     * @param dead              the flag indicating if the Kraken is dead
     * @param gender            the gender of the Kraken
     * @param actualEnclosure   the actual enclosure where the Kraken is placed
     */
    public Kraken(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     * Returns the incubation time of the oviparous creature.
     *
     * @return The incubation time in milliseconds.
     */
    @Override
    public int getINCUBATION_TIME() {
        return INCUBATION_TIME;
    }

    /**
     * Returns the species class of the creature.
     *
     * @return The species class of the creature.
     */
    @Override
    public Class getSpeciesClass() {
        return this.getClass();
    }

    /**
     * Returns the species name of the creature.
     *
     * @return The species name of the creature.
     */
    @Override
    public String getSpecieName() {return "Kraken";}

    /**
     * Retrieves information about a creature.
     *
     * @return A string representing the creature's information.
     */
    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce Kraken se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut nager.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce Kraken se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut nager.";
        }
        return null;
    }

    /**
     * Returns the shout of the creature.
     *
     * @return the shout of the creature
     */
    @Override
    public String shout() {
        return String.format("%s crie !",this.getName());
    }

    /**
     * Runs the Kraken's action sequence.
     *
     * This method is called when the Kraken's thread is started. It first calls the superclass's run method to execute the default behavior for all oviparous creatures.
     * Additionally, there is a 10% chance that the Kraken will attempt to reproduce if it is not sleeping. If the reproduction attempt is successful, a new egg is laid in the current
     * enclosure.
     *
     */
    @Override
    public void run() {
        super.run();
    }
}
