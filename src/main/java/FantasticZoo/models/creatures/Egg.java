package FantasticZoo.models.creatures;

import FantasticZoo.models.enclosures.Enclosure;

import java.lang.reflect.InvocationTargetException;

public class Egg implements Runnable{
    private final Class SPECIES_CLASS;
    private final int INCUBATION_TIME;
    private int actualIncubationTime = 0;

    private Enclosure actualEnclosure;

    public Egg(Class SPECIES_CLASS, int INCUBATION_TIME, Enclosure enclosure) {
        this.SPECIES_CLASS = SPECIES_CLASS;
        this.INCUBATION_TIME = INCUBATION_TIME;
        this.actualEnclosure = enclosure;
    }

    public void refresh() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ++actualIncubationTime;
        if (actualIncubationTime >= INCUBATION_TIME) {
            this.hatch();
        }
    }

    public Creature hatch() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object newBorn = SPECIES_CLASS.getConstructor(Enclosure.class, Gender.class).newInstance(actualEnclosure, Gender.MALE);
        Enclosure enclosure = actualEnclosure;
        if (actualEnclosure.RemoveEgg(this)){
            enclosure.AddCreature((Creature) newBorn);
            return (Creature) newBorn;
        }
        return null;
    }

    public Class getSPECIES_CLASS() {
        return SPECIES_CLASS;
    }

    public int getINCUBATION_TIME() {
        return INCUBATION_TIME;
    }

    public int getActualIncubationTime() {
        return actualIncubationTime;
    }

    public void setActualIncubationTime(int actualIncubationTime) {
        this.actualIncubationTime = actualIncubationTime;
    }

    public Enclosure getActualEnclosure() {
        return actualEnclosure;
    }

    public void setActualEnclosure(Enclosure actualEnclosure) {
        this.actualEnclosure = actualEnclosure;
    }

    @Override
    public void run() {
        try {
            refresh();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
