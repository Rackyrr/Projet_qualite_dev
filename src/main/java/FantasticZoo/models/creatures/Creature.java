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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HungerIndicator getHunger() {
        return hunger;
    }

    public void setHunger(HungerIndicator hunger) {
        this.hunger = hunger;
    }

    public SleepIndicator getSleep() {
        return sleep;
    }

    public void setSleep(SleepIndicator sleep) {
        this.sleep = sleep;
    }

    public HealthIndicator getHealth() {
        return health;
    }

    public void setHealth(HealthIndicator health) {
        this.health = health;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Enclosure getActualEnclosure() {
        return actualEnclosure;
    }

    public void setActualEnclosure(Enclosure actualEnclosure) {
        this.actualEnclosure = actualEnclosure;
    }

    public boolean use(Consumable c) { return c.useOn(this); }

    public boolean eat(Food food){ return hunger.replenish(food); }

    public boolean getTreated(Medecine med){ return health.treatDisease(med); }

    public abstract String shout();

    public void growUp(){
        ++age;
        if(age >= NATURAL_DEATH_AGE && (Math.random() <= 0.2)) setDead(true);
    }

    public int getNATURAL_DEATH_AGE() {
        return NATURAL_DEATH_AGE;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

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

    public boolean canMateWith(Creature mate){
        return (this.gender == Gender.MALE && mate.gender == Gender.FEMALE) || (this.gender == Gender.FEMALE && mate.gender == Gender.MALE);
    }
    public abstract String getSpecieName();
    public abstract String getCreatureInfo();
}
