package models.creatures;

import models.creatures.indicators.HealthIndicator;
import models.creatures.indicators.HungerIndicator;
import models.creatures.indicators.SleepIndicator;
import models.enclosures.Enclosure;

public class Dragon extends Oviparous implements IRunning, IFlying{
    public Dragon(String name, int weight, int height, int age, HungerIndicator hunger, SleepIndicator sleep, HealthIndicator health, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hunger, sleep, health, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
    }

    public Dragon(String name, int weight, int height, int age, double hungerMaxValue, double hungerRate, double sleepMaxValue, double sleepRate, double healthMaxValue, int NATURAL_DEATH_AGE, boolean dead, Gender gender, Enclosure actualEnclosure) {
        super(name, weight, height, age, hungerMaxValue, hungerRate, sleepMaxValue, sleepRate, healthMaxValue, NATURAL_DEATH_AGE, dead, gender, actualEnclosure);
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

    }

    @Override
    public String shout() {
        return String.format("%s rugit !",this.getName());
    }

}
