package models.enclosures;

import models.creatures.Creature;
import models.creatures.Egg;

import java.util.ArrayList;

public class Enclosure {
    private final Class AUTHORIZED_ANIMAL;
    private String name;
    private double area;
    private final int MAXIMUM_CREATURES;
    private ArrayList<Creature> creatures;
    private ArrayList<Egg> eggs;

    public Class getAUTHORIZED_ANIMAL() {
        return AUTHORIZED_ANIMAL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getMAXIMUM_CREATURES() {
        return MAXIMUM_CREATURES;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    public ArrayList<Egg> getEggs() {
        return eggs;
    }

    public void setEggs(ArrayList<Egg> eggs) {
        this.eggs = eggs;
    }

    public Enclosure(Class AUTHORIZED_ANIMAL, String name, double area, int MAXIMUM_CREATURES) {
        this.AUTHORIZED_ANIMAL = AUTHORIZED_ANIMAL;
        this.name = name;
        this.area = area;
        this.MAXIMUM_CREATURES = MAXIMUM_CREATURES;
        this.creatures = new ArrayList<>(this.MAXIMUM_CREATURES);
        this.eggs = new ArrayList<>(this.MAXIMUM_CREATURES);
    }


}
