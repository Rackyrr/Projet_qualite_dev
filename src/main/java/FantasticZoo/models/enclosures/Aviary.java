package FantasticZoo.models.enclosures;

import FantasticZoo.models.creatures.Creature;
import FantasticZoo.models.creatures.IFlying;

import java.util.ArrayList;

public class Aviary extends Enclosure {
    private double Height;
    private final static int MAX_HEIGHT = 250;
    private CleanlinessLevel CleanLevelRoof;

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public CleanlinessLevel getCleanLevelRoof() {
        return CleanLevelRoof;
    }

    public void setCleanLevelRoof(CleanlinessLevel cleanLevelRoof) {
        CleanLevelRoof = cleanLevelRoof;
    }


    public Aviary(Class AUTHORIZED_ANIMAL, String name) {
        super(AUTHORIZED_ANIMAL, name);
        this.Height = (int) (Math.random()*MAX_HEIGHT);
        this.setCreatures(new ArrayList<>(this.getMAXIMUM_CREATURES()));
        this.setEggs(new ArrayList<>(this.getMAXIMUM_CREATURES()));
    }

    public Aviary(Class AUTHORIZED_ANIMAL, String name, double area, int MAXIMUM_CREATURES, double Height) {
        super(AUTHORIZED_ANIMAL, name, area, MAXIMUM_CREATURES);
        this.Height = Height;
        this.setCreatures(new ArrayList<>(this.getMAXIMUM_CREATURES()));
        this.setEggs(new ArrayList<>(this.getMAXIMUM_CREATURES()));
    }

    @Override
    public String toString() {
        return "La volière " + this.getName() + " a une surface de " + this.getArea() + " m² et une hauteur de "+
                Height + "m, il y a " + this.getCreatures().size() + this.getAUTHORIZED_ANIMAL().getSimpleName() + " et "
                + this.getEggs().size() + " oeufs";
    }

    @Override
    public boolean AddCreature(Creature creature){
        if (IsAuhorizedAnimal(creature) && creature instanceof IFlying){
            if (this.getCreatures().size() < this.getMAXIMUM_CREATURES()){
                this.getCreatures().add(creature);
                return true;
            }
            else {
                System.out.println("Il n'y a plus de place dans cette volière");
                return false;
            }
        }
        else {
            System.out.println("Cette créature ne peut pas aller dans cette volière, elle ne serait pas avec son espèce. \n" +
                "Trouvez une volière qui contient la même espèce que cette créature.");
            return false;
        }
    }

    @Override
    public int CheckCleanlinessLevel(){
        if (getCleanlinessLevel().equals(CleanlinessLevel.GREAT)){
            System.out.println("La volière est propre, elle n'a pas besoin d'être nettoyée.");
            return 2;
        }
        else if (getCleanlinessLevel().equals(CleanlinessLevel.DECENT)){
            System.out.println("La volière n'est pas très sale, mais il faudra la nettoyer dans pas longtemps.");
            return 1;
        }
        else if (getCleanlinessLevel().equals(CleanlinessLevel.POOR)){
            System.out.println("La volière est très sale, elle a besoin d'être nettoyée.");
            return 0;
        }
        return -1;
    }

    public int CheckCleanlinessLevelOfRoof(){
        if (CleanLevelRoof.equals(CleanlinessLevel.GREAT)){
            System.out.println("Le toit de la voilière est propre, il n'a pas besoin d'être nettoyé.");
            return 2;
        }
        else if (CleanLevelRoof.equals(CleanlinessLevel.DECENT)){
            System.out.println("Le toit de la voilière pas très sale, mais il faudra le nettoyer dans pas longtemps.");
            return 1;
        }
        else if (CleanLevelRoof.equals(CleanlinessLevel.POOR)){
            System.out.println("Le toit de la voilière est très sale, il a besoin d'être nettoyé.");
            return 0;
        }
        return -1;
    }

    @Override
    public void CleanEnclosure(){
        if (!getCreatures().isEmpty()){
            System.out.println("On ne peut pas nettoyer la volière, il reste des créatures dedans. \n" +
                    "Enlevez toutes les créatures pour nettoyer la volière.");
        }
        else {
            if (CheckCleanlinessLevel() == 2){
                System.out.println("La volière est déjà propre, la nettoyer serait inutile.");
            }
            else {
                setCleanlinessLevel(CleanlinessLevel.GREAT);
                System.out.println("La volière a été nettoyée, elle est maintenant dans un très bon état.");
            }
            if (CheckCleanlinessLevelOfRoof() == 2){
                System.out.println("Le toit de la volière est déjà propre, le nettoyer serait inutile.");
            }
            else {
                setCleanLevelRoof(CleanlinessLevel.GREAT);
                System.out.println("Le toit de la volière à été nettoyé, il est maintenant dans un très bon état. ");
            }
        }
    }
}