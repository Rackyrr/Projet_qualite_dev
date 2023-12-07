package models.creatures;

import models.creatures.indicators.HealthIndicator;
import models.creatures.indicators.HungerIndicator;
import models.creatures.indicators.SleepIndicator;
import models.enclosures.Enclosure;

public class Unicorn extends Viviparous implements IRunning{
    private final static int MIN_HEIGHT = 140;
    private final static int MAX_HEIGHT = 160;
    private final static int NATURALDEATHAGE = 75;
    private final static int NEEDMAXVALUE = 150;
    private final static int NEEDRATE = 10;
    private final static int MIN_WEIGHT = 600;
    private final static int MAX_WEIGHT = 800;
    private final static int GESTATIONTIME = 20;


    @Override
    public String getSpecieName() {
        return "Licorne";
    }

    public Unicorn(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Licorne", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    public Unicorn(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    public Unicorn(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

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

    @Override
    public String shout() {
        return String.format("%s hennit !",this.getName());
    }

    @Override
    public void run() {
        super.run();
    }
}
