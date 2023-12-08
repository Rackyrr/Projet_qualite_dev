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
    private CleanlinessLevel cleanlinessLevel = CleanlinessLevel.DECENT;
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

    public CleanlinessLevel getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    //Modifier constructeur pour mettre degré de propreté par défaut
    public Enclosure(Class AUTHORIZED_ANIMAL, String name, double area, int MAXIMUM_CREATURES) {
        this.AUTHORIZED_ANIMAL = AUTHORIZED_ANIMAL;
        this.name = name;
        this.area = area;
        this.MAXIMUM_CREATURES = MAXIMUM_CREATURES;
        this.creatures = new ArrayList<>(this.MAXIMUM_CREATURES);
        this.eggs = new ArrayList<>(this.MAXIMUM_CREATURES);
    }

    //A modifier pour afficher les caractèristiques des créatures de l'enclos
    //Modifier aussi pour que ce soit mieux pour l'utilisateur
    @Override
    public String toString() {
        return "L'enclos " + name + "a une surface de " + area + " m², il y a " + creatures.size() + AUTHORIZED_ANIMAL.getSimpleName()
                + " et " + eggs.size() + " oeufs";
    }

    public void getCreaturesInfo(){
        System.out.println("Voici les créatures présentes dans l'enclos :");
        creatures.forEach(creature -> {
            System.out.println(creature.getCreatureInfo());
        });
    }

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
    public boolean IsAuhorizedAnimal(Creature creature){
        return AUTHORIZED_ANIMAL.isInstance(creature);
    }

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

    public boolean isFull() {
        return (creatures.size() + eggs.size() + getPregnancyNumber()) >= MAXIMUM_CREATURES;
    }

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

    //A mettre à jour, ne correspond pas à la classe Food
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

    public Creature getRandomCreatureInEnclosure(){
        if (creatures.size() == 0) return null;
        int randomIndex = (int) (Math.random() * creatures.size());
        return creatures.get(randomIndex);
    }

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