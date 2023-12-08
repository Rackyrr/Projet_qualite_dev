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

    public Kraken(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Kraken", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure);
    }

    public Kraken(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    public Kraken(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
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
    public String getSpecieName() {return "Kraken";}

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

    @Override
    public String shout() {
        return String.format("%s crie !",this.getName());
    }

    @Override
    public void run() {
        super.run();
    }
}
