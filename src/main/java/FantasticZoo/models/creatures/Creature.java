package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.*;
import FantasticZoo.models.enclosures.Enclosure;
import FantasticZoo.models.items.Consumable;
import FantasticZoo.models.items.Food;
import FantasticZoo.models.items.Medecine;

public abstract class Creature implements Runnable {
    private String name;
    private int weight;
    private int height;
    private int age;
    private HungerIndicator hunger;
    private SleepIndicator sleep;
    private HealthIndicator health;
    private final int NATURAL_DEATH_AGE;
    private boolean dead = false;
    private Gender gender;
    private Enclosure actualEnclosure;

    /**
     * Creates a new instance of the Creature class with the specified parameters.
     *
     * @param name the name of the creature
     * @param weight the weight of the creature
     * @param height the height of the creature
     * @param age the age of the creature
     * @param hunger the hunger indicator of the creature
     * @param sleep the sleep indicator of the creature
     * @param health the health indicator of the creature
     * @param NATURAL_DEATH_AGE the natural death age of the creature
     * @param dead the dead state of the creature
     * @param gender the gender of the creature
     * @param actualEnclosure the actual enclosure where the creature is located
     */
    public Creature(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.hunger = hunger;
        this.sleep = sleep;
        this.health = health;
        this.NATURAL_DEATH_AGE = NATURAL_DEATH_AGE;
        this.dead = dead;
        this.gender = gender;
        this.actualEnclosure = actualEnclosure;
    }

    /**
     * The Creature class represents a creature in an enclosure.
     * It has various attributes such as name, weight, height, age, and indicators for hunger, sleep, and health.
     * The class also includes information about the creature's natural death age, gender, and the enclosure it occupies.
     *
     * @param name The name of the creature.
     * @param weight The weight of the creature.
     * @param height The height of the creature.
     * @param age The age of the creature.
     * @param hungerMaxValue The maximum value for the hunger indicator.
     * @param hungerRate The rate at which the hunger indicator decreases.
     * @param sleepMaxValue The maximum value for the sleep indicator.
     * @param sleepRate The rate at which the sleep indicator decreases.
     * @param healthMaxValue The maximum value for the health indicator.
     * @param NATURAL_DEATH_AGE The natural death age of the creature.
     * @param dead The current dead state of the creature.
     * @param gender The gender of the creature.
     * @param actualEnclosure The enclosure in which the creature is located.
     */
    public Creature(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.hunger = new HungerIndicator(hungerMaxValue,hungerRate);
        this.sleep = new SleepIndicator(sleepMaxValue,sleepRate);
        this.health = new HealthIndicator(healthMaxValue);
        this.NATURAL_DEATH_AGE = NATURAL_DEATH_AGE;
        this.dead = dead;
        this.gender = gender;
        this.actualEnclosure = actualEnclosure;
    }

    /**
     * Returns the name of the creature.
     *
     * @return the name of the creature
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the creature.
     *
     * @param name The new name of the creature.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the weight of the creature.
     *
     * @return the weight of the creature
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the creature.
     *
     * @param weight the new weight of the creature
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Returns the height of the creature.
     *
     * @return the height of the creature
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the creature.
     *
     * @param height the new height of the creature
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns the age of the creature.
     *
     * @return the age of the creature
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the creature.
     *
     * @param age the new age of the creature
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Retrieves the hunger indicator of the creature.
     *
     * @return the hunger indicator of the creature
     */
    public HungerIndicator getHunger() {
        return hunger;
    }

    /**
     * Sets the hunger indicator of the creature.
     *
     * @param hunger the hunger indicator to set
     */
    public void setHunger(HungerIndicator hunger) {
        this.hunger = hunger;
    }

    /**
     * Returns the sleep indicator of the creature.
     *
     * @return the sleep indicator of the creature
     */
    public SleepIndicator getSleep() {
        return sleep;
    }

    /**
     * Sets the sleep indicator of the creature.
     *
     * @param sleep the sleep indicator to set
     */
    public void setSleep(SleepIndicator sleep) {
        this.sleep = sleep;
    }

    /**
     * Retrieves the health indicator of the creature.
     *
     * @return the health indicator of the creature
     */
    public HealthIndicator getHealth() {
        return health;
    }

    /**
     * Sets the health indicator of the creature.
     *
     * @param health the health indicator to set
     */
    public void setHealth(HealthIndicator health) {
        this.health = health;
    }

    /**
     * Returns the gender of the creature.
     *
     * @return the gender of the creature
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the creature.
     *
     * @param gender the gender to set for the creature
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Returns the actual enclosure where the creature is located.
     *
     * @return the actual enclosure where the creature is located
     */
    public Enclosure getActualEnclosure() {
        return actualEnclosure;
    }

    /**
     * Sets the actual enclosure where the creature is located.
     *
     * @param actualEnclosure the actual enclosure where the creature is located.
     */
    public void setActualEnclosure(Enclosure actualEnclosure) {
        this.actualEnclosure = actualEnclosure;
    }

    /**
     * Uses the given Consumable on the Creature.
     *
     * @param c the Consumable to use on the Creature
     * @return true if the Consumable was successfully used on the Creature, false otherwise
     */
    public boolean use(Consumable c) { return c.useOn(this); }

    /**
     * Replenishes the hunger indicator of the creature with the specified food.
     *
     * @param food the food to replenish the hunger indicator
     * @return true if the hunger indicator was replenished, false otherwise
     */
    public boolean eat(Food food){ return hunger.replenish(food); }

    /**
     * Retrieves the treatment status of the given medicine for the creature.
     *
     * @param med the medicine to check for treatment
     * @return true if the medicine successfully treats the disease, false otherwise
     */
    public boolean getTreated(Medecine med){ return health.treatDisease(med); }

    /**
     * Returns a string representing the shout made by the creature.
     *
     * @return the shout made by the creature
     */
    public abstract String shout();

    /**
     * Increases the age of the creature by 1. If the age reaches the natural death age and a random number between 0 and 1 is less than or equal to 0.2, the creature is set to dead
     *.
     */
    public void growUp(){
        ++age;
        if(age >= NATURAL_DEATH_AGE && (Math.random() <= 0.2)) setDead(true);
    }

    /**
     * Retrieves the natural death age of the creature.
     *
     * @return the natural death age of the creature
     */
    public int getNATURAL_DEATH_AGE() {
        return NATURAL_DEATH_AGE;
    }

    /**
     * Checks if the creature is dead.
     *
     * @return true if the creature is dead, false otherwise
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * Sets the dead state of the creature.
     *
     * @param dead the dead state to set for the creature
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }


    /**
     * Runs the lifecycle of the creature by performing necessary actions such as growing up,
     * refreshing sleep, hunger, and health indicators, and checking for death conditions.
     */
    @Override
    public void run() {
        growUp();
        sleep.refresh();
        if (!sleep.getState()) {
            hunger.refresh();
            health.refresh();
        }
        dead = dead || hunger.getStarvedState() || !health.getState();
    }

    /**
     * Determines whether this creature can mate with the given mate.
     *
     * @param mate The mate to check compatibility with
     * @return true if this creature and the mate have compatible genders, false otherwise
     */
    public boolean canMateWith(Creature mate){
        return (this.gender == Gender.MALE && mate.gender == Gender.FEMALE) || (this.gender == Gender.FEMALE && mate.gender == Gender.MALE);
    }

    /**
     * Retrieves the name of the species that the creature belongs to.
     *
     * @return the name of the species
     */
    public abstract String getSpecieName();

    /**
     * Returns information about the creature.
     *
     * @return a String containing information about the creature
     */
    public abstract String getCreatureInfo();
}
