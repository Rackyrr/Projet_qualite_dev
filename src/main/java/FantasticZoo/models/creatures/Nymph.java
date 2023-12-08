package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public class Nymph extends Viviparous implements IRebirth{
    private final static int MIN_HEIGHT = 160;
    private final static int MAX_HEIGHT = 170;
    private final static int NATURALDEATHAGE = 80;
    private final static int NEEDMAXVALUE = 100;
    private final static int NEEDRATE = 5;
    private final static int MIN_WEIGHT = 60;
    private final static int MAX_WEIGHT = 80;
    private final static int GESTATIONTIME = 15;

    /**
     * Retrieves the specific name of the species.
     *
     * @return the specific name of the species
     */
    @Override
    public String getSpecieName() {
        return "Nymphe";
    }

    /**
     * Constructor for creating a new Nymph instance.
     *
     * @param enclosure      The enclosure where the nymph will be placed.
     * @param newBornGender  The gender of the newly born nymph.
     *
     * @since version 1.0
     */
    public Nymph(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Nymphe", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    /**
     * Creates a new Nymph instance with the given parameters.
     *
     * @param enclosure         The enclosure where the nymph will be placed.
     * @param newBornGender     The gender of the newly born nymph.
     * @param name              The name of the nymph.
     *
     * @since version 1.0
     */
    public Nymph(Enclosure enclosure,Gender newBornGender, String name) { // for newBorns
        super(name, MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    /**
     * Creates a new Nymph instance with the given parameters.
     *
     * @param name The name of the nymph.
     * @param weight The weight of the nymph.
     * @param height The height of the nymph.
     * @param age The age of the nymph.
     * @param hunger The hunger indicator of the nymph.
     * @param sleep The sleep indicator of the nymph.
     * @param health The health indicator of the nymph.
     * @param NATURAL_DEATH_AGE The natural death age of the nymph.
     * @param dead The flag indicating if the nymph is dead.
     * @param gender The gender of the nymph.
     * @param actualEnclosure The enclosure where the nymph is placed.
     * @param GESTATION_TIME The gestation time of the nymph.
     */
    public Nymph(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    /**
     * Creates a new Nymph instance with the given parameters.
     *
     * @param name                The name of the nymph.
     * @param weight              The weight of the nymph.
     * @param height              The height of the nymph.
     * @param age                 The age of the nymph.
     * @param hungerMaxValue      The maximum hunger value of the nymph.
     * @param hungerRate          The hunger rate of the nymph.
     * @param sleepMaxValue       The maximum sleep value of the nymph.
     * @param sleepRate           The sleep rate of the nymph.
     * @param healthMaxValue      The maximum health value of the nymph.
     * @param NATURAL_DEATH_AGE   The natural death age of the nymph.
     * @param dead                The flag indicating if the nymph is dead.
     * @param gender              The gender of the nymph.
     * @param actualEnclosure     The enclosure where the nymph is placed.
     * @param GESTATION_TIME      The gestation time of the nymph.
     */
    public Nymph(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    /**
     * Retrieves the information about the creature.
     *
     * @return the information about the creature
     */
    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Cet nymphe se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Cette créature peut renaître après sa mort.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Cette nymphe se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Cette créature peut renaître après sa mort.";
        }
        return null;
    }

    /**
     * Rebirths the Nymph.
     *
     * This method sets the hunger, sleep, health, dead, age, and pregnant properties of the Nymph to their initial values.
     */
    @Override
    public void getReborn() {
        setHunger(new HungerIndicator(NEEDMAXVALUE,NEEDRATE));
        setSleep(new SleepIndicator(NEEDMAXVALUE,NEEDRATE));
        setHealth(new HealthIndicator(NEEDMAXVALUE));
        setDead(false);
        setAge(0);
        setPregnant(false);
    }

    /**
     * Returns true if the Nymph gives birth to a new Nymph, false otherwise.
     *
     * @return true if the Nymph gives birth, false otherwise
     */
    @Override
    public boolean giveBirth(){
        Nymph newBorn;
        if (!getActualEnclosure().isFull()) {
            if (Math.random() <= 0.5) newBorn = new Nymph(getActualEnclosure(), Gender.MALE);
            else newBorn = new Nymph(getActualEnclosure(), Gender.FEMALE);
            return getActualEnclosure().AddCreature(newBorn);
        }
        return false;
    }

    /**
     * Returns a string representing the shout of the creature.
     * The shout is in the format "{creature's name} chante !".
     *
     * @return the shout of the creature
     */
    @Override
    public String shout() {
        return String.format("%s chante !",this.getName());
    }

    /**
     * Runs the Nymph's behavior.
     *
     * This method overrides the run() method of the superclass Creature.
     * It first calls the run() method of the superclass to perform the general behavior of the creature.
     * Then, it checks if the nymph is dead using the isDead() method. If the nymph is dead,
     * it calls the getReborn() method to reset the properties of the nymph to their initial values.
     *
     * @see Creature#run()
     * @see #isDead()
     * @see #getReborn()
     */
    @Override
    public void run() {
        super.run();
        if (isDead())
            getReborn();
    }
}
