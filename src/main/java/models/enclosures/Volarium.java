package models.enclosures;

import models.creatures.Creature;
import models.creatures.IFlying;

import java.util.ArrayList;

public class Volarium extends Enclosure {
    private double Height;
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

    public Volarium(Class AUTHORIZED_ANIMAL, String name, double area, int MAXIMUM_CREATURES, double Height) {
        super(AUTHORIZED_ANIMAL, name, area, MAXIMUM_CREATURES);
        this.Height = Height;
        this.setCreatures(new ArrayList<>(this.getMAXIMUM_CREATURES()));
        this.setEggs(new ArrayList<>(this.getMAXIMUM_CREATURES()));
    }

    @Override
    public void AddCreature(Creature creature){
        if (IsAuhorizedAnimal(creature) && creature instanceof IFlying){
            if (this.getCreatures().size() < this.getMAXIMUM_CREATURES()){
            this.getCreatures().add(creature);
            }
            else {
                System.out.println("Il n'y a plus de place dans cette volière");
            }
        }
        else {
            System.out.println("Cette créature ne peut pas aller dans cette volière, elle ne serait pas avec son espèce. \n" +
                "Trouvez une volière qui contient la même espèce que cette créature.");
        }
    }

    @Override
    public int CheckCleanlinessLevel(){
        if (getCLeanlinessLevel().equals(CleanlinessLevel.GREAT)){
            System.out.println("La volière est propre, elle n'a pas besoin d'être nettoyée.");
            return 2;
        }
        else if (getCLeanlinessLevel().equals(CleanlinessLevel.DECENT)){
            System.out.println("La volière n'est pas très sale, mais il faudra la nettoyer dans pas longtemps.");
            return 1;
        }
        else if (getCLeanlinessLevel().equals(CleanlinessLevel.POOR)){
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
                setCLeanlinessLevel(CleanlinessLevel.GREAT);
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