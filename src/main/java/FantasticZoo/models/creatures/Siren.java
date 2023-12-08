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


    @Override
    public String getSpecieName() {
        return "Sirène";
    }

    public Siren(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Sirène", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    public Siren(Enclosure enclosure,Gender newBornGender, String name) { // for newBorns
        super(name, MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    public Siren(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    public Siren(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

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

    @Override
    public String shout() {
        return String.format("%s chante !",this.getName());
    }

    @Override
    public void run() {
        super.run();
    }
}
