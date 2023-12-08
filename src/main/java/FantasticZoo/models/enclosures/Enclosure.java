package FantasticZoo.models.enclosures;

import FantasticZoo.models.creatures.Creature;
import FantasticZoo.models.creatures.Egg;
import FantasticZoo.models.items.Food;
import FantasticZoo.models.creatures.Viviparous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Enclosure implements Runnable {
    private final Class AUTHORIZED_ANIMAL;
    private String name;
    private double area;
    private final static int MAX_AREA = 100;
    private CleanlinessLevel cleanlinessLevel = CleanlinessLevel.DECENT;
    private final int MAXIMUM_CREATURES;
    private ArrayList<Creature> creatures;
    private ArrayList<Egg> eggs;

    /**
     * Retrieves the class representing the type of animal authorized to be kept in this enclosure.
     * This method is used to get the authorized animal class.
     *
     * @return the class representing the authorized animal
     */
    public Class getAUTHORIZED_ANIMAL() {
        return AUTHORIZED_ANIMAL;
    }

    /**
     * Retrieves the name of the enclosing instance.
     *
     * @return the name of the enclosing instance
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the enclosing instance.
     *
     * @param name the new name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the area of the enclosure.
     *
     * @return the area of the enclosure
     */
    public double getArea() {
        return area;
    }

    /**
     * Sets the area of the enclosure.
     *
     * @param area the new area to be set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Retrieves the maximum number of creatures that can be kept in the enclosure.
     * This method is used to get the maximum capacity of the enclosure for creatures.
     *
     * @return the maximum number of creatures that can be kept in the enclosure
     */
    public int getMAXIMUM_CREATURES() {
        return MAXIMUM_CREATURES;
    }

    /**
     * Retrieves the list of creatures in the enclosure.
     *
     * @return the list of creatures in the enclosure as an ArrayList
     */
    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    /**
     * Sets the list of creatures in the enclosure.
     *
     * @param creatures the new list of creatures to be set in the enclosure
     */
    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    /**
     * Retrieves the list of eggs in the enclosure.
     *
     * @return the list of eggs in the enclosure as an ArrayList of Eggs
     */
    public ArrayList<Egg> getEggs() {
        return eggs;
    }

    /**
     * Sets the list of eggs in the enclosure.
     *
     * @param eggs the new list of eggs to be set in the enclosure
     */
    public void setEggs(ArrayList<Egg> eggs) {
        this.eggs = eggs;
    }

    /**
     * Retrieves the cleanliness level of the enclosure.
     *
     * @return the cleanliness level of the enclosure
     */
    public CleanlinessLevel getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    /**
     * Sets the cleanliness level of the enclosure.
     *
     * @param cleanlinessLevel the new cleanliness level to be set
     */
    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    /**
     * Constructs a new Enclosure object with the specified authorized animal class, name, area, and maximum creatures count.
     * The Enclosure is a type of enclosure in the zoo where creatures can be kept.
     *
     * @param AUTHORIZED_ANIMAL   the class representing the type of animal authorized to be kept in this Enclosure
     * @param name               the name of the Enclosure
     * @param area               the area of the Enclosure
     * @param MAXIMUM_CREATURES  the maximum number of creatures that can be kept in the Enclosure
     */
    //Modifier constructeur pour mettre degré de propreté par défaut
    public Enclosure(Class AUTHORIZED_ANIMAL, String name, double area, int MAXIMUM_CREATURES) {
        this.AUTHORIZED_ANIMAL = AUTHORIZED_ANIMAL;
        this.name = name;
        this.area = area;
        this.creatures = new ArrayList<>(MAXIMUM_CREATURES);
        this.eggs = new ArrayList<>(MAXIMUM_CREATURES);
        this.MAXIMUM_CREATURES = MAXIMUM_CREATURES;
    }

    /**
     * Constructs a new Enclosure object with the specified authorized animal class and name.
     * The Enclosure is a type of enclosure in the zoo where creatures can be kept.
     *
     * @param AUTHORIZED_ANIMAL the class representing the type of animal authorized to be kept in this Enclosure
     * @param name the name of the Enclosure
     */
    public Enclosure(Class AUTHORIZED_ANIMAL, String name) {
        this.AUTHORIZED_ANIMAL = AUTHORIZED_ANIMAL;
        this.name = name;
        this.area = (int) (Math.random() * MAX_AREA);
        this.MAXIMUM_CREATURES = 15;
        this.creatures = new ArrayList<>(MAXIMUM_CREATURES);
        this.eggs = new ArrayList<>(MAXIMUM_CREATURES);
    }


    /**
     * Returns a string representation of the Enclosure object.
     * The string includes the name of the enclosure, its area, the number of creatures,
     * and the number of eggs in the enclosure.
     *
     * @return a string representation of the Enclosure object
     */
    @Override
    public String toString() {
        return "L'enclos " + name + "a une surface de " + area + " m², il y a " + creatures.size() + AUTHORIZED_ANIMAL.getSimpleName()
                + " et " + eggs.size() + " oeufs";
    }

    /**
     * Retrieves information about the creatures in the enclosure.
     * This method prints the information about each creature present in the enclosure.
     */
    public void getCreaturesInfo(){
        System.out.println("Voici les créatures présentes dans l'enclos :");
        creatures.forEach(creature -> {
            System.out.println(creature.getCreatureInfo());
        });
    }

    /**
     * Retrieves the number of creatures in the enclosure that are currently pregnant.
     *
     * @return the number of pregnant creatures in the enclosure
     */
    public int getPregnancyNumber(){
        int nb = 0;
        if (AUTHORIZED_ANIMAL.getSuperclass().equals(Viviparous.class)) {
            for (Creature creature : creatures){
                Viviparous viviparous = (Viviparous) creature;
                if (viviparous.isPregnant()) nb += 1;
            }
        }
        return nb;
    }

    /**
     * Determines if the given creature is an authorized animal to be kept in the enclosure.
     * An authorized animal refers to a creature whose class matches the authorized animal class of the enclosure.
     *
     * @param creature the creature to check if it is an authorized animal
     * @return true if the creature is an authorized animal, false otherwise
     */
    public boolean IsAuhorizedAnimal(Creature creature){
        return AUTHORIZED_ANIMAL.isInstance(creature);
    }

    /**
     * Adds a Creature to the Enclosure.
     *
     * @param creature the Creature to be added
     * @return true if the Creature is successfully added, false otherwise
     */
    public boolean AddCreature(Creature creature){
        boolean isAdded;
        if (IsAuhorizedAnimal(creature) ){
            if (!isFull()){
                creature.setActualEnclosure(this);
                creatures.add(creature);
                isAdded = true;
            }
            else {
                System.err.println("Il n'y a plus de place dans cet enclos.");
                isAdded = false;
            }
            return isAdded;
        }
        else {
            System.err.println("Cette créature ne peut pas aller dans cet enclos, elle ne serait pas avec son espèce. \n" +
                    "Trouvez un enclos qui contient la même espèce que cette créature.");
            return false;
        }
    }

    /**
     * Adds an egg to the enclosure if it is authorized and there is enough space.
     *
     * @param egg the egg to be added to the enclosure
     * @return true if the egg is successfully added, false otherwise
     */
    public boolean AddEgg(Egg egg){
        boolean isAdded;
        if (AUTHORIZED_ANIMAL == egg.getSPECIES_CLASS()){
            if (!isFull()){
                egg.setActualEnclosure(this);
                eggs.add(egg);
                isAdded = true;
            }
            else {
                System.err.println("Il n'y a plus de place dans cet enclos.");
                isAdded = false;
            }
            return isAdded;
        }
        else {
            System.err.println("Cet oeuf ne peut pas aller dans cet enclos, il ne serait pas avec son espèce.");
            return false;
        }
    }

    /**
     * Determines whether the enclosure is full or not.
     *
     * @return true if the enclosure is full, false otherwise
     */
    public boolean isFull() {
        return (creatures.size() + eggs.size() + getPregnancyNumber()) >= MAXIMUM_CREATURES;
    }

    /**
     * Removes the given creature from the enclosure.
     *
     * @param creature the creature to be removed
     * @return the removed creature, or null if the creature is not found in the enclosure
     */
    public Creature RemoveCreature(Creature creature){
        if (creatures.contains(creature)){
            creature.setActualEnclosure(null);
            creatures.remove(creature);
            return creature;
        }
        else {
            System.out.println("Cette créature n'est pas dans cette enclos");
            return null;
        }
    }

    /**
     * Removes the given egg from the enclosure.
     *
     * @param egg the egg to be removed from the enclosure
     * @return true if the egg is successfully removed, false if the egg is not found in the enclosure
     */
    public boolean RemoveEgg(Egg egg){
        if (eggs.contains(egg)){
            egg.setActualEnclosure(null);
            eggs.remove(egg);
            return true;
        }
        else {
            System.out.println("Cet oeuf n'est pas dans cette enclos");
            return false;
        }
    }

    /**
     * Feeds a specific creature with the specified food.
     * If the creature is in the enclosure, attempts to feed the creature with the provided food.
     * If the creature successfully eats the food, prints a message stating that the creature has eaten.
     * If the creature is not hungry, prints a message stating that the creature is no longer hungry.
     * If the creature is not in the enclosure, prints a message stating that the creature cannot be fed.
     *
     * @param creature the creature to be fed
     * @param food the food to feed the creature with
     * @return true if the creature is successfully fed, false otherwise
     */
    public boolean FeedSpecificCreature(Creature creature, Food food){
        boolean isFed = false;
        if (creatures.contains(creature)){
            if (creature.eat(food)){
                System.out.println(creature.getName() + "a mangé.");
                isFed = true;
            }
            else {
                System.out.println(creature.getName() + "n'a plus faim.");            }
        }
        else {
            System.out.println("Cette créature n'est pas dans cette enclos, on ne peut donc pas le nourrir.");
        }
        return isFed;
    }

    /**
     * Feeds all creatures in the enclosure with the given food.
     * If a creature is successfully fed, it increments the number of fed creatures.
     * Prints the number of creatures fed out of the total creatures in the enclosure.
     *
     * @param food the food to feed the creatures with
     */
    public void FeedAllCreatures(Food food){
        int numberCreatureFed = 0;
        boolean tmpCreatureStatus;
        for (Creature creature : creatures) {
            tmpCreatureStatus = FeedSpecificCreature(creature, food);
            if (tmpCreatureStatus) {
                numberCreatureFed += 1;
            }
        }
        System.out.println(numberCreatureFed + " sur " + creatures.size() + " ont été nourris");
    }

    /**
     * Checks the cleanliness level of the enclosure.
     *
     * @return an integer representing the cleanliness level:
     *         - 2 if the cleanliness level is GREAT
     *         - 1 if the cleanliness level is DECENT
     *         - 0 if the cleanliness level is POOR
     *         - -1 if the cleanliness level is unknown
     */
    public int CheckCleanlinessLevel(){
        if (cleanlinessLevel.equals(CleanlinessLevel.GREAT)){
            System.out.println("L'enclos est propre, il n'a pas besoin d'être nettoyé.");
            return 2;
        }
        else if (cleanlinessLevel.equals(CleanlinessLevel.DECENT)){
            System.out.println("L'enclos n'est pas très sale, mais il faudra le nettoyer dans pas longtemps.");
            return 1;
        }
        else if (cleanlinessLevel.equals(CleanlinessLevel.POOR)){
            System.out.println("l'enclos est très sale, il a besoin d'être nettoyé.");
            return 0;
        }
        return -1;
    }

    /**
     * Cleans the enclosure. If there are creatures in the enclosure, it prints a message indicating
     * that the enclosure cannot be cleaned until all creatures are removed. If the cleanliness level
     * is already at level 2 (GREAT), it prints a message indicating that the enclosure is already clean.
     * Otherwise, it sets the cleanliness level to level 2 (GREAT) and prints a message indicating that
     * the enclosure has been cleaned and is now in a very good state.
     */
    public void CleanEnclosure(){
        if (!creatures.isEmpty()){
            System.out.println("On ne peut pas nettoyer l'enclos, il reste des créatures dedans. \n" +
                    "Enlevez toutes les créatures pour nettoyer l'enclos.");
        }
        else {
            if (CheckCleanlinessLevel() == 2){
                System.out.println("L'enclos est déjà propre, le nettoyer serait inutile.");
            }
            cleanlinessLevel = CleanlinessLevel.GREAT;
            System.out.println("L'enclos a été nettoyé, il est maintenant dans un très bon état.");
        }
    }

    /**
     * Retrieves a random creature from the enclosure.
     *
     * @return a random creature from the enclosure, or null if no creatures are present
     */
    public Creature getRandomCreatureInEnclosure(){
        if (creatures.size() == 0) return null;
        int randomIndex = (int) (Math.random() * creatures.size());
        return creatures.get(randomIndex);
    }

    /**
     * Executes the logical functionality of the Enclosure.
     * This method iterates over the creatures in the enclosure and calls their run() method.
     * If a creature is dead, it prints a death message and removes the creature from the enclosure.
     * If a creature is hungry, it prints a message indicating that the creature needs to be fed.
     * If a creature is sleeping, it prints a message indicating that the creature is sleeping.
     * After processing all creatures, it iterates over the eggs and calls their run() method.
     */
    @Override
    public void run() {
        Creature[] cArray = creatures.toArray(new Creature[0]);
        Iterator<Creature> c = Arrays.stream(cArray).iterator();
        while (c.hasNext()){
            Creature creature = c.next();
            creature.run();
            if (creature.isDead()) {
                System.out.println(String.format("%s est mort !",creature.getName()));
                RemoveCreature(creature);
            } else {
                if (creature.getHunger().getState()) System.out.println(String.format("%s dans l'enclos %s a faim ! Nourrissez-le !", creature.getName(),getName()));
                if (creature.getSleep().getState()) System.out.println(String.format("%s dans l'enclos %s dort !", creature.getName(),getName()));
            }
        }
        Egg[] eArray = eggs.toArray(new Egg[0]);
        Iterator<Egg> e = Arrays.stream(eArray).iterator();
        while (e.hasNext()){
            e.next().run();
        }
    }
}
