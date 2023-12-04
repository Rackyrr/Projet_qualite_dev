package models.enclosures;

import models.creatures.Creature;
import models.creatures.IFlying;
import models.creatures.ISwimming;

public class Aquarium extends Enclosure{
    private double Depth;
    private CleanlinessLevel CleanLevelWater;

    public double getDepth() {
        return Depth;
    }

    public void setDepth(double depth) {
        Depth = depth;
    }

    public CleanlinessLevel getCleanLevelWater() {
        return CleanLevelWater;
    }

    public void setCleanLevelWater(CleanlinessLevel cleanLevelWater) {
        CleanLevelWater = cleanLevelWater;
    }

    public Aquarium(Class AUTHORIZED_ANIMAL, String name, double area, int MAXIMUM_CREATURES, double depth) {
        super(AUTHORIZED_ANIMAL, name, area, MAXIMUM_CREATURES);
        this.Depth = depth;
    }

    @Override
    public String toString() {
        return "L'aquarium " + this.getName() + "a une surface de " + this.getArea() + " m² et une profondeur de "+
                Depth + "m, il y a " + this.getCreatures().size() + this.getAUTHORIZED_ANIMAL().getName() + " et "
                + this.getEggs().size() + " oeufs";
    }

    @Override
    public boolean AddCreature(Creature creature){
        if (IsAuhorizedAnimal(creature) && creature instanceof ISwimming){
            if (this.getCreatures().size() < this.getMAXIMUM_CREATURES()){
                this.getCreatures().add(creature);
                return true;
            }
            else {
                System.out.println("Il n'y a plus de place dans cet aquarium");
                return false;
            }
        }
        else {
            System.out.println("Cette créature ne peut pas aller dans cet aquarium, elle ne serait pas avec son espèce. \n" +
                    "Trouvez un aquarium qui contient la même espèce que cette créature.");
            return false;
        }
    }

    @Override
    public int CheckCleanlinessLevel(){
        if (getCleanlinessLevel().equals(CleanlinessLevel.GREAT)){
            System.out.println("Le bassin est propre, il n'a pas besoin d'être nettoyé.");
            return 2;
        }
        else if (getCleanlinessLevel().equals(CleanlinessLevel.DECENT)){
            System.out.println("Le bassin n'est pas très sale, mais il faudra le nettoyer dans pas longtemps.");
            return 1;
        }
        else if (getCleanlinessLevel().equals(CleanlinessLevel.POOR)){
            System.out.println("Le bassin est très sale, il a besoin d'être nettoyé.");
            return 0;
        }
        return -1;
    }

    public int CheckCleanlinessLevelOfWater(){
        if (CleanLevelWater.equals(CleanlinessLevel.GREAT)){
            System.out.println("L'eau du bassin est propre, elle n'a pas besoin d'être nettoyée.");
            return 2;
        }
        else if (CleanLevelWater.equals(CleanlinessLevel.DECENT)){
            System.out.println("L'eau du bassin pas très sale, mais il faudra la nettoyer dans pas longtemps.");
            return 1;
        }
        else if (CleanLevelWater.equals(CleanlinessLevel.POOR)){
            System.out.println("L'eau du bassin est très sale, il a besoin d'être nettoyée.");
            return 0;
        }
        return -1;
    }

    @Override
    public void CleanEnclosure() {
        if (!getCreatures().isEmpty()) {
            System.out.println("On ne peut pas nettoyer l'aquarium, il reste des créatures dedans. \n" +
                    "Enlevez toutes les créatures pour nettoyer l'aquarium.");
        } else {
            if (CheckCleanlinessLevel() == 2) {
                System.out.println("Le bassin est déjà propre, le nettoyer serait inutile.");
            } else {
                setCleanlinessLevel(CleanlinessLevel.GREAT);
                System.out.println("Le bassin a été nettoyée, il est maintenant dans un très bon état.");
            }
            if (CheckCleanlinessLevelOfWater() == 2){
                System.out.println("Le bassin est déjà propre, le nettoyer serait inutile.");
            }
            else {
                setCleanLevelWater(CleanlinessLevel.GREAT);
                System.out.println("Le bassin à été nettoyé, il est maintenant dans un très bon état. ");
            }
        }
    }
}
