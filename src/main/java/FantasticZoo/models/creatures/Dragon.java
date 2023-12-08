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

    public Dragon(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Dragon", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }


    public Dragon(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    public Dragon(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    @Override
    public int getINCUBATION_TIME() {
        return INCUBATION_TIME;
    }

    @Override
    public Class getSpeciesClass() {
        return this.getClass();
    }

    @Override
    public String getSpecieName() {
        return "Dragon";
    }

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

    @Override
    public void run() {
        super.run();
    }

    @Override
    public String shout() {
        return String.format("%s rugit !",this.getName());
    }

}