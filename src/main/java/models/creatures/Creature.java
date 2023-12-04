package models.creatures;

import models.creatures.indicators.*;
import models.enclosures.Enclosure;
import models.items.Consumable;
import models.items.Food;
import models.items.Medecine;

public abstract class Creature implements Runnable {
    private String name;
    private int weight;
    private int height;
    private int age;
    private HungerIndicator hunger;
    private SleepIndicator sleep;
    private HealthIndicator health;
    private boolean sleeping;
    private Gender gender;
    private Enclosure actualEnclosure;
    public String getName() {
        return name;
    }

    public boolean use(Consumable c) { return c.useOn(this); }

    public boolean eat(Food food){ return hunger.replenish(food); }

    public boolean getTreated(Medecine med){ return health.treatDisease(med); }

    public void shout(){}

    public void wakeUp(){}
    public void growUp(){}
    public void die(){}
    public abstract String getSpecieName();

}
