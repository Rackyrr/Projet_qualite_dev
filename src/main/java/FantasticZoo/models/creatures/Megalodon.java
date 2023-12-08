package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public class Megalodon extends Oviparous implements ISwimming{
    private final static int MIN_HEIGHT = 140;
    private final static int MAX_HEIGHT = 160;

    private final static int NEEDMAXVALUE = 200;

    private final static int NATURALDEATHAGE = 90;
    private final static int NEEDRATE = 20;
    private final static int MIN_WEIGHT = 350000;
    private final static int MAX_WEIGHT = 400000;
    private final int INCUBATION_TIME = 20;

    /**
     * Creates a new Megalodon for newborns.
     *
     * @param enclosure The enclosure where the Megalodon will be placed.
     * @param newBornGender The gender of the newborn Megalodon.
     */
    public Megalodon(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Mégalodon", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }

    /**
     * Creates a new Megalodon for newborns.
     *
     * @param enclosure The enclosure where the Megalodon will be placed.
     * @param newBornGender The gender of the newborn Megalodon.
     * @param name The name of the newborn Megalodon.
     */
    public Megalodon(Enclosure enclosure,Gender newBornGender, String name) { // for newBorns
        super(name, MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }

    /**
     * Creates a new Megalodon with the given parameters.
     *
     * @param name The name of the Megalodon.
     * @param weight The weight of the Megalodon.
     * @param height The height of the Megalodon.
     * @param age The age of the Megalodon.
     * @param hunger The hunger indicator of the Megalodon.
     * @param sleep The sleep indicator of the Megalodon.
     * @param health The health indicator of the Megalodon.
     * @param NATURAL_DEATH_AGE The natural death age of the Megalodon.
     * @param dead The flag indicating the death state of the Megalodon.
     * @param gender The gender of the Megalodon.
     * @param actualEnclosure The actual enclosure where the Megalodon is placed.
     */
    public Megalodon(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     *
     * @param name
     * @param weight
     * @param height
     * @param age
     * @param hungerMaxValue
     * @param hungerRate
     * @param sleepMaxValue
     * @param sleepRate
     * @param healthMaxValue
     * @param NATURAL_DEATH_AGE
     * @param dead
     * @param gender
     * @param actualEnclosure
     */
    public Megalodon(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    /**
     *
     * @return INCUBATION_TIME
     */
    @Override
    public int getINCUBATION_TIME() {
        return INCUBATION_TIME;
    }

    /**
     *
     * @return Class
     */
    @Override
    public Class getSpeciesClass() {
        return this.getClass();
    }

    /**
     *
     * @return String
     */
    @Override
    public String getSpecieName() {
        return "Megalodon";
    }

    /**
     * Retrieves the information about the creature.
     *
     * @return the creature's information as a string
     */
    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce Megalodon se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il " + canSwim();
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce Megalodon se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle " + canSwim();
        }
        return null;
    }

    /**
     * Returns a shout message specific to the creature.
     * The shout message includes the creature's name and the action it is performing.
     *
     * @return the shout message of the creature
     */
    @Override
    public String shout() {
        return String.format("%s fait de petites bulles !",this.getName());
    }

    /**
     * Runs the Megalodon.
     *
     * This method overrides the run() method of the super class Creature. It performs the following actions:
     * 1. Calls the run() method of the super class to perform the default run behavior.
     * 2. Checks if the Megalodon is not sleeping and generates a random number between 0 and 1.
     *    If the random number is less than or equal to 0.1, it proceeds with mating.
     * 3. Selects a random Oviparous creature from the Megalodon's enclosure.
     * 4. Checks if the selected creature is not null and mates with it.
     *    - If mating is possible (male and female Oviparous creatures), it lays an egg and returns true.
     *    - If the female Oviparous's enclosure is not full, it tries to lay an egg and returns true if successful.
     * 5. Returns false if mating is not possible or if the egg cannot be laid due to a full enclosure.
     *
     * @see Creature#run()
     */
    @Override
    public void run() {
        super.run();
    }
}
