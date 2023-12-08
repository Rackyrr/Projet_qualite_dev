package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public class Werewolf extends Viviparous implements IRunning{
    private final static int MIN_HEIGHT = 180;
    private final static int MAX_HEIGHT = 240;

    private final static int NEEDMAXVALUE = 150;

    private final static int NATURALDEATHAGE = 80;
    private final static int NEEDRATE = 5;
    private final static int MIN_WEIGHT = 100;
    private final static int MAX_WEIGHT = 150;
    private final static int GESTATIONTIME = 15;

    /**
     * Retrieves the name of the specie.
     *
     * @return The name of the specie.
     */
    @Override
    public String getSpecieName() {
        return "Loup-Garou";
    }

    /**
     * Creates a new instance of the class Werewolf representing a newborn werewolf.
     *
     * @param enclosure The enclosure where the werewolf will be kept.
     * @param newBornGender The gender of the newborn werewolf.
     */
    public Werewolf(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Loup-Garou", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure, GESTATIONTIME);
    }

    /**
     * Creates a new instance of the Werewolf class representing a newborn werewolf.
     *
     * @param enclosure The enclosure where the werewolf will be kept.
     * @param newBornGender The gender of the newborn werewolf.
     * @param name The name of the newborn werewolf.
     */
    public Werewolf(Enclosure enclosure,Gender newBornGender, String name) { // for newBorns
        super(name, MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure, GESTATIONTIME);
    }

    /**
     * Constructs a new Werewolf object with the specified parameters.
     *
     * @param name The name of the werewolf.
     * @param weight The weight of the werewolf.
     * @param height The height of the werewolf.
     * @param age The age of the werewolf.
     * @param hunger The hunger level of the werewolf (HungerIndicator).
     * @param sleep The sleep level of the werewolf (SleepIndicator).
     * @param health The health level of the werewolf (HealthIndicator).
     * @param NATURAL_DEATH_AGE The natural death age of the werewolf.
     * @param dead Whether the werewolf is dead or alive.
     * @param gender The gender of the werewolf.
     * @param actualEnclosure The enclosure the werewolf is currently in.
     * @param GESTATION_TIME The gestation time of the werewolf.
     */
    public Werewolf(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    /**
     * Creates a new instance of the Werewolf class with the specified parameters.
     *
     * @param name              The name of the werewolf.
     * @param weight            The weight of the werewolf.
     * @param height            The height of the werewolf.
     * @param age               The age of the werewolf.
     * @param hungerMaxValue    The maximum value for the hunger level of the werewolf.
     * @param hungerRate        The rate at which the hunger level of the werewolf decreases.
     * @param sleepMaxValue     The maximum value for the sleep level of the werewolf.
     * @param sleepRate         The rate at which the sleep level of the werewolf decreases.
     * @param healthMaxValue    The maximum value for the health level of the werewolf.
     * @param NATURAL_DEATH_AGE The natural death age of the werewolf.
     * @param dead              Whether the werewolf is dead or alive.
     * @param gender            The gender of the werewolf.
     * @param actualEnclosure   The enclosure the werewolf is currently in.
     * @param GESTATION_TIME    The gestation time of the werewolf.
     */
    public Werewolf(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    /**
     * Retrieves the information of the werewolf creature.
     *
     * @return The information of the werewolf creature.
     */
    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce loup-garou se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut courir.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce loup-garou se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut courir.";
        }
        return null;
    }

    /**
     * Returns a formatted string representing the shout of a werewolf.
     *
     * @return A formatted string representing the shout of a werewolf.
     */
    @Override
    public String shout() {
        return String.format("%s hurle !",this.getName());
    }

    /**
     * This method simulates the process of a viviparous creature giving birth. It will create a new instance
     * of the Werewolf class representing the newborn creature, randomly assigning it a gender. After giving birth,
     * the pregnancy status of the creature will be set to false. If the enclosure where the creature is located
     * has enough space to accommodate the newborn, the newborn will be added to the enclosure and true will be returned.
     * Otherwise, the pregnancy status will be set back to true and false will be returned.
     *
     * @return true if the viviparous creature successfully gives birth and the newborn is added to the enclosure, false otherwise
     */
    @Override
    public boolean giveBirth(){
        Werewolf newBorn;
        if (Math.random() <= 0.5) newBorn = new Werewolf(getActualEnclosure(), Gender.MALE);
        else newBorn = new Werewolf(getActualEnclosure(), Gender.FEMALE);
        setPregnant(false);
        if (getActualEnclosure().AddCreature(newBorn))
            return true;
        else{
            setPregnant(true);
            return false;
        }
    }

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
    }
}
