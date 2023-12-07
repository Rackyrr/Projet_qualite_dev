package models;
import models.creatures.Creature;
import models.creatures.Egg;
import models.creatures.Gender;
import models.enclosures.Enclosure;

import java.util.ArrayList;

public class Master {
    private static Master master;
    private String name;
    private int age;
    private Gender gender;
    private Master(String name, int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static Master getMaster(String name, int age, Gender gender){
        if (master == null){
            master = new Master(name, age, gender);
        }
        return master;
    }

    public void examineEnclosure(Enclosure enclosure) {
        // Afficher les caractéristiques de l'enclos et la liste des créatures
        System.out.println("Caractéristiques de l'enclos:");
        System.out.println(enclosure.toString());
        System.out.println("Liste des créatures:");
        enclosure.getCreaturesInfo();
    }

    public void cleanEnclosure(Enclosure enclosure){
        System.out.println("Nettoyer l'enclos: " + enclosure.getName());
    }
    public void feedEnclosure(Enclosure enclosure){
        System.out.println("Nourrir les créature de l'enclos: " + enclosure.getName());
    }
    public void transferCreature(Enclosure sourceEnclosure, Enclosure destinationEnclosure, Creature creature) {
        if (sourceEnclosure.getCreatures().contains(creature)) {
            if (destinationEnclosure.isFull()) {
                System.out.println("Transférer la créature " + creature.getName() + " de l'enclos "
                        + sourceEnclosure.getName() + " à l'enclos " + destinationEnclosure.getName());

                Creature removedCreature = sourceEnclosure.RemoveCreature(creature);

                if (removedCreature != null) {
                    destinationEnclosure.AddCreature(removedCreature);
                }
            } else {
                System.out.println("Impossible de transférer la créature. L'enclos de destination est plein.");
            }
        }
        else {
            System.out.println("Impossible de transférer la créature. La créature ne se trouve pas dans l'enclos sélectionné");
        }
    }
    public String getName() {
        return name;
    }
}
