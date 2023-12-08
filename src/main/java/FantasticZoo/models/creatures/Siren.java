package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public class Siren extends Viviparous implements ISwimming{
    private final static int MIN_HEIGHT = 160;
    private final static int MAX_HEIGHT = 170;
    private final static int NATURALDEATHAGE = 80;
    private final static int NEEDMAXVALUE = 100;
    private final static int NEEDRATE = 5;
    private final static int MIN_WEIGHT = 60;
    private final static int MAX_WEIGHT = 80;
    private final static int GESTATIONTIME = 15;


    /**
     * Returns the name of the species of the creature.
     * @return the name of the species
     */
    @Override
    public String getSpecieName() {
        return "Sirène";
    }

    /**
     * Constructs a new Siren object for new born creatures.
     *
     * @param enclosure the enclosure where the Siren is located
     * @param newBornGender the gender of the new born Siren
     */
    public Siren(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Sirène", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    /**
     * Constructs a new Siren object.
     *
     * @param enclosure The enclosure where the Siren is located.
     * @param newBornGender The gender of the new born Siren.
     * @param name The name of the Siren.
     */
    public Siren(Enclosure enclosure,Gender newBornGender, String name) { // for newBorns
        super(name, MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    /**
     * Constructs a new Siren object with the given parameters.
     *
     * @param name the name of the Siren
     * @param weight the weight of the Siren
     * @param height the height of the Siren
     * @param age the age of the Siren
     * @param hunger the HungerIndicator of the Siren
     * @param sleep the SleepIndicator of the Siren
     * @param health the HealthIndicator of the Siren
     * @param NATURAL_DEATH_AGE the natural death age of the Siren
     * @param dead indicates whether the Siren is dead or alive
     * @param gender the gender of the Siren
     * @param actualEnclosure the actual enclosure where the Siren is located
     * @param GESTATION_TIME the gestation time of the Siren
     */
    public Siren(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    /**
     * Constructs a new Siren object with the given parameters.
     *
     * @param name               the name of the Siren
     * @param weight             the weight of the Siren
     * @param height             the height of the Siren
     * @param age                the age of the Siren
     * @param hungerMaxValue     the maximum value of hunger for the Siren
     * @param hungerRate         the rate at which hunger increases for the Siren
     * @param sleepMaxValue      the maximum value of sleep for the Siren
     * @param sleepRate          the rate at which sleep decreases for the Siren
     * @param healthMaxValue     the maximum value of health for the Siren
     * @param NATURAL_DEATH_AGE  the natural death age for the Siren
     * @param dead               indicates whether the Siren is dead or alive
     * @param gender             the gender of the Siren
     * @param actualEnclosure    the current enclosure where the Siren is located
     * @param GESTATION_TIME     the gestation time for the Siren
     */
    public Siren(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
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
            return "Cet sirène se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il " + canSwim();
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Cette sirène se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle " + canSwim();
        }
        return null;
    }

    /**
     * Gives birth to a new creature.
     *
     * @return true if the birth is successful, false otherwise
     */
    @Override
    public boolean giveBirth(){
        Siren newBorn;
        if (!getActualEnclosure().isFull()) {
            if (Math.random() <= 0.5) newBorn = new Siren(getActualEnclosure(), Gender.MALE);
            else newBorn = new Siren(getActualEnclosure(), Gender.FEMALE);
            return getActualEnclosure().AddCreature(newBorn);
        }
        return false;
    }

    /**
     * Produces a shout of the Siren.
     *
     * @return the shout of the Siren
     */
    @Override
    public String shout() {
        return String.format("%s chante !",this.getName());
    }

    /**
     * Runs the Siren's behavior.
     */
    @Override
    public void run() {
        super.run();
    }
}
