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

    @Override
    public String getSpecieName() {
        return "Nymphe";
    }

    public Nymph(Enclosure enclosure,Gender newBornGender) { // for newBorns
        super("Nymphe", MIN_WEIGHT + (int) (Math.random() * MAX_WEIGHT), MIN_HEIGHT + (int) (Math.random() * MAX_HEIGHT), 0,
                NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NEEDRATE, NEEDMAXVALUE, NATURALDEATHAGE, false, newBornGender, enclosure,GESTATIONTIME);
    }

    public Nymph(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

    public Nymph(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure, int GESTATION_TIME) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure, GESTATION_TIME);
    }

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

    @Override
    public void getReborn() {
        setHunger(new HungerIndicator(NEEDMAXVALUE,NEEDRATE));
        setSleep(new SleepIndicator(NEEDMAXVALUE,NEEDRATE));
        setHealth(new HealthIndicator(NEEDMAXVALUE));
        setDead(false);
        setAge(0);
        setPregnant(false);
    }

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

    @Override
    public String shout() {
        return String.format("%s chante !",this.getName());
    }

    @Override
    public void run() {
        super.run();
        if (isDead())
            getReborn();
    }
}
