package models;
import models.creatures.Creature;
import models.creatures.Egg;
import models.creatures.Gender;
import models.enclosures.Enclosure;

import java.util.ArrayList;

public class Master {
    private String name;
    private int age;
    private Gender gender;
    public Master(String name, int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    private void examineEnclosure(Enclosure enclosure) {
        // Afficher les caractéristiques de l'enclos et la liste des créatures
        System.out.println("Caractéristiques de l'enclos:");
        System.out.println("Nom de l'enclos: " + enclosure.getName());
        System.out.println("Taille de l'enclos: " + enclosure.getArea());
        System.out.println("Liste des créatures:");
        for (Creature creature : enclosure.getCreatures()) {
            System.out.println(creature.getName() + " - " + creature.getSpecieName());
        }
    }
    private void cleanEnclosure(Enclosure enclosure){
        System.out.println("Nettoyer l'enclos: " + enclosure.getName());
    }
    private void feedCreature(Enclosure enclosure){
        System.out.println("Nourrir les créature de l'enclos: " + enclosure.getName());
    }
    private void transferCreature(Enclosure sourceEnclosure, Enclosure destinationEnclosure, Creature creature) {
        if (destinationEnclosure.getMAXIMUM_CREATURES() > destinationEnclosure.getCreatures().size()) {
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


}
