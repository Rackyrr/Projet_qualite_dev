package FantasticZoo.models.creatures;

import FantasticZoo.models.creatures.indicators.HealthIndicator;
import FantasticZoo.models.creatures.indicators.HungerIndicator;
import FantasticZoo.models.creatures.indicators.SleepIndicator;
import FantasticZoo.models.enclosures.Enclosure;

public abstract class Oviparous extends Creature{


    public Oviparous(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    public Oviparous(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    public abstract int getINCUBATION_TIME();

    public abstract Class getSpeciesClass();

    public boolean reproduce(Oviparous mate) {
        if (canMateWith(mate)) {
            Oviparous female;
            Oviparous male;
            if (this.getGender() == Gender.FEMALE) {
                female = this;
                male = mate;
            } else {
                female = mate;
                male = this;
            }
            if (!female.getActualEnclosure().isFull())
                return female.layEgg() != null;
        }
        return false;
    }

    public Egg layEgg(){
        Egg egg = new Egg(getSpeciesClass(),getINCUBATION_TIME(),getActualEnclosure());
        if (getActualEnclosure().AddEgg(egg))
            return egg;
        return null;
    }

    @Override
    public void run() {
        super.run();
        if(Math.random() <= 0.1){
            Oviparous mate = (Oviparous) getActualEnclosure().getRandomCreatureInEnclosure();
            if(mate != null) reproduce(mate);
        }
    }
}
