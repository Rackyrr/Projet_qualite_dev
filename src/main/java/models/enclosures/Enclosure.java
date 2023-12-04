package models.enclosures;

import models.creatures.Creature;
import models.creatures.Egg;

import java.util.ArrayList;

public class Enclosure {
    private final Class AUTHORIZED_ANIMAL;
    private String name;
    private double area;
    private CleanlinessLevel cLeanlinessLevel;
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

    public CleanlinessLevel getCLeanlinessLevel() {
        return cLeanlinessLevel;
    }

    public void setCLeanlinessLevel(CleanlinessLevel cLeanlinessLevel) {
        this.cLeanlinessLevel = cLeanlinessLevel;
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
        return "Enclosure{" +
                "AUTHORIZED_ANIMAL=" + AUTHORIZED_ANIMAL +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", MAXIMUM_CREATURES=" + MAXIMUM_CREATURES +
                ", creatures=" + creatures +
                ", eggs=" + eggs +
                '}';
    }

    public boolean IsAuhorizedAnimal(Creature creature){
        return AUTHORIZED_ANIMAL.isInstance(creature);
    }

    public void AddCreature(Creature creature){
        if (IsAuhorizedAnimal(creature) ){
            if (creatures.size() < MAXIMUM_CREATURES){
                creatures.add(creature);
            }
            else {
                System.out.println("Il n'y a plus de place dans cette enclos");
            }
        }
        else {
            System.out.println("Cette créature ne peut pas aller dans cette, elle ne serait pas avec son espèce. \n" +
                    "Trouvez un enclos qui contient la même espèce que cette créature.");
        }
    }

    public Creature RemoveCreature(Creature creature){
        if (creatures.contains(creature)){
            creatures.remove(creature);
            return creature;
        }
        else {
            System.out.println("Cette créature n'est pas dans cette enclos");
            return null;
        }
    }
    //A faire
    public void FeedAllCreatures(){}
    //A faire
    public void FeedSpecificCreature(Creature creature){}

    public int CheckCleanlinessLevel(){
        if (cLeanlinessLevel.equals(CleanlinessLevel.GREAT)){
            System.out.println("L'enclos est propre, il n'a pas besoin d'être nettoyé.");
            return 2;
        }
        else if (cLeanlinessLevel.equals(CleanlinessLevel.DECENT)){
            System.out.println("L'enclos n'est pas très sale, mais il faudra le nettoyer dans pas longtemps.");
            return 1;
        }
        else if (cLeanlinessLevel.equals(CleanlinessLevel.POOR)){
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
            cLeanlinessLevel = CleanlinessLevel.GREAT;
            System.out.println("L'enclos a été nettoyé, il est maintenant dans un très bon état.");
        }
    }
}
