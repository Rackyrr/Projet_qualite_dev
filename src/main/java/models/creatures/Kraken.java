package models.creatures;

import models.creatures.indicators.HealthIndicator;
import models.creatures.indicators.HungerIndicator;
import models.creatures.indicators.SleepIndicator;
import models.enclosures.Enclosure;

public class Kraken extends Oviparous implements ISwimming{
    public Kraken(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    public Kraken(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
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

    }
}
