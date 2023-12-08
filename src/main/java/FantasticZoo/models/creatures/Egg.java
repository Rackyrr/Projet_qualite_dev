package FantasticZoo.models.creatures;

import FantasticZoo.models.enclosures.Enclosure;

import java.lang.reflect.InvocationTargetException;

public class Egg implements Runnable{
    private final Class SPECIES_CLASS;
    private final int INCUBATION_TIME;
    private int actualIncubationTime = 0;

    private Enclosure actualEnclosure;

    /**
     * Egg class represents an egg of a certain species. It contains information about the species,
     * incubation time, and the enclosure where it is located.
     */
    public Egg(Class SPECIES_CLASS, int INCUBATION_TIME, Enclosure enclosure) {
        this.SPECIES_CLASS = SPECIES_CLASS;
        this.INCUBATION_TIME = INCUBATION_TIME;
        this.actualEnclosure = enclosure;
    }

    /**
     * Increment the actual incubation time of the egg. If the actual incubation time exceeds the specified incubation time, the egg will hatch and a new creature will be created
     *.
     *
     * @throws NoSuchMethodException if the specified constructor does not exist
     * @throws InvocationTargetException if the underlying constructor throws an exception
     * @throws InstantiationException if the class that declares the underlying constructor represents an abstract class
     * @throws IllegalAccessException if the specified constructor is inaccessible
     */
    public void refresh() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ++actualIncubationTime;
        if (actualIncubationTime >= INCUBATION_TIME) {
            this.hatch();
        }
    }

    /**
     * Hatch the egg and create a new creature.
     *
     * @return the newly hatched creature or null if the egg fails to hatch
     * @throws NoSuchMethodException if the specified constructor does not exist
     * @throws InvocationTargetException if the underlying constructor throws an exception
     * @throws InstantiationException if the class that declares the underlying constructor represents an abstract class
     * @throws IllegalAccessException if the specified constructor is inaccessible
     */
    public Creature hatch() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object newBorn = SPECIES_CLASS.getConstructor(Enclosure.class, Gender.class).newInstance(actualEnclosure, Gender.MALE);
        Enclosure enclosure = actualEnclosure;
        if (actualEnclosure.RemoveEgg(this)){
            enclosure.AddCreature((Creature) newBorn);
            return (Creature) newBorn;
        }
        return null;
    }

    /**
     * Retrieves the species class of the egg.
     *
     * @return the species class of the egg
     */
    public Class getSPECIES_CLASS() {
        return SPECIES_CLASS;
    }

    /**
     * Retrieves the incubation time of the egg.
     *
     * @return the incubation time of the egg
     */
    public int getINCUBATION_TIME() {
        return INCUBATION_TIME;
    }

    /**
     * Retrieves the actual incubation time of the egg.
     *
     * @return the actual incubation time of the egg
     */
    public int getActualIncubationTime() {
        return actualIncubationTime;
    }

    /**
     * Sets the actual incubation time of the egg.
     *
     * @param actualIncubationTime the actual incubation time to set for the egg
     */
    public void setActualIncubationTime(int actualIncubationTime) {
        this.actualIncubationTime = actualIncubationTime;
    }

    /**
     * Retrieves the actual enclosure where the egg is located.
     *
     * @return the actual enclosure of the egg
     */
    public Enclosure getActualEnclosure() {
        return actualEnclosure;
    }

    /**
     * Sets the actual enclosure where the egg is located.
     *
     * @param actualEnclosure the actual enclosure to set for the egg
     */
    public void setActualEnclosure(Enclosure actualEnclosure) {
        this.actualEnclosure = actualEnclosure;
    }

    /**
     * Executes the run method of the Runnable interface.
     *
     * The run method increments the actual incubation time of the egg. If the actual incubation time
     * exceeds the specified incubation time, the egg will hatch and a new creature will be created.
     *
     * @throws RuntimeException if an error occurs while performing the refresh operation, such as NoSuchMethodException,
     *                          InvocationTargetException, InstantiationException, or IllegalAccessException
     */
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
