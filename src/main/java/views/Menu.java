package views;

import controls.Command;
import models.Master;
import models.enclosures.Aquarium;
import models.enclosures.CleanlinessLevel;

import java.util.Scanner;

public interface Menu {
    public static void promptMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Examiner les caractéristiques d'un enclos");
        System.out.println("2. Nettoyer un enclos");
        System.out.println("3. Nourrir les créatures d'un enclos");
        System.out.println("4. Transférer une créature");
        System.out.println("5. Quitter");
    }

    public static void enclosureNotFound(String enclosureName) {
        System.out.println("Il n'y a pas d'enclos nommé : " + enclosureName);
    }

    public static void typo() {
        System.out.println("Vous n'avez pas rentré le bon nombre d'agurment pour la commande");
    }

    public static void feedEnclosureMessage() {
        System.out.print("Dans quel enclos voulez vous nourrir les créatures ?");
    }

    public static void cleanEnclosureMessage() {
        System.out.print("Quel enclos voulez vous nettoyer ?");
    }

    public static void CheckCleanlinessLevelMessage(CleanlinessLevel cleanlinessLevel, Class typeEnclos) {
        if (typeEnclos.getClass().getName().equals("Enclosure")) {
            if (cleanlinessLevel.equals(CleanlinessLevel.GREAT)) {
                System.out.println("L'enclos est propre, il n'a pas besoin d'être nettoyé.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.DECENT)) {
                System.out.println("L'enclos n'est pas très sale, mais il faudra le nettoyer dans pas longtemps.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.POOR)) {
                System.out.println("l'enclos est très sale, il a besoin d'être nettoyé.");
            }
        }
        if (typeEnclos.getClass().getName().equals("Aquarium")) {
            if (cleanlinessLevel.equals(CleanlinessLevel.GREAT)) {
                System.out.println("Le bassin est propre, il n'a pas besoin d'être nettoyé.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.DECENT)) {
                System.out.println("Le bassin n'est pas très sale, mais il faudra le nettoyer dans pas longtemps.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.POOR)) {
                System.out.println("Le bassin est très sale, il a besoin d'être nettoyé.");
            }
        }
        if (typeEnclos.getClass().getName().equals("Aviary")) {
            if (cleanlinessLevel.equals(CleanlinessLevel.GREAT)) {
                System.out.println("Le bassin est propre, il n'a pas besoin d'être nettoyé.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.DECENT)) {
                System.out.println("Le bassin n'est pas très sale, mais il faudra le nettoyer dans pas longtemps.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.POOR)) {
                System.out.println("Le bassin est très sale, il a besoin d'être nettoyé.");
            }
        }
    }

    public static void confirmRename(boolean ObjectRename) {
        if (ObjectRename) {
            //enclos
        } else {
            //Creature
        }
    }

    public static void enclosureFull() {
        System.out.println("Il n'y a plus de place dans cet enclos");
    }

    public static void creatureNotSameSpecie(Class typeEnclos) {
        if (typeEnclos.getClass().getName().equals("Enclosure")) {
            System.out.println("Cette créature ne peut pas aller dans cet enclos, elle ne serait pas avec son espèce. \n" +
                    "Trouvez un enclos qui contient la même espèce que cette créature.");
        }
        if (typeEnclos.getClass().getName().equals("Aquarium")) {
            System.out.println("Cette créature ne peut pas aller dans cet aquarium, elle ne serait pas avec son espèce. \n" +
                    "Trouvez un aquarium qui contient la même espèce que cette créature.");
        }
        if (typeEnclos.getClass().getName().equals("Aviary")) {
            System.out.println("Cette créature ne peut pas aller dans cette volière, elle ne serait pas avec son espèce. \n" +
                    "Trouvez une volière qui contient la même espèce que cette créature.");
        }
    }
}