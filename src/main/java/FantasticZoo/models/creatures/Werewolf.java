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

    @Override
    public String getSpecieName() {
        return "Loup-Garou";
    }

    public Werewolf(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Loup-Garou", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure, GESTATIONTIME);
    }
    public Werewolf(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    public Werewolf(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

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

    @Override
    public String shout() {
        return String.format("%s hurle !",this.getName());
    }

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

    @Override
    public void run() {
        super.run();
    }
}