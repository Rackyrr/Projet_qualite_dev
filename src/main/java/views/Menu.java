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
        if (typeEnclos.getName().equals("Enclosure")) {
            if (cleanlinessLevel.equals(CleanlinessLevel.GREAT)) {
                System.out.println("L'enclos est propre, il n'a pas besoin d'être nettoyé.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.DECENT)) {
                System.out.println("L'enclos n'est pas très sale, mais il faudra le nettoyer dans pas longtemps.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.POOR)) {
                System.out.println("l'enclos est très sale, il a besoin d'être nettoyé.");
            }
        }
        if (typeEnclos.getName().equals("Aquarium")) {
            if (cleanlinessLevel.equals(CleanlinessLevel.GREAT)) {
                System.out.println("Le bassin est propre, il n'a pas besoin d'être nettoyé.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.DECENT)) {
                System.out.println("Le bassin n'est pas très sale, mais il faudra le nettoyer dans pas longtemps.");
            } else if (cleanlinessLevel.equals(CleanlinessLevel.POOR)) {
                System.out.println("Le bassin est très sale, il a besoin d'être nettoyé.");
            }
        }
        if (typeEnclos.getName().equals("Aviary")) {
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
        if (typeEnclos.getName().equals("Enclosure")) {
            System.out.println("Cette créature ne peut pas aller dans cet enclos, elle ne serait pas avec son espèce. \n" +
                    "Trouvez un enclos qui contient la même espèce que cette créature.");
        }
        if (typeEnclos.getName().equals("Aquarium")) {
            System.out.println("Cette créature ne peut pas aller dans cet aquarium, elle ne serait pas avec son espèce. \n" +
                    "Trouvez un aquarium qui contient la même espèce que cette créature.");
        }
        if (typeEnclos.getName().equals("Aviary")) {
            System.out.println("Cette créature ne peut pas aller dans cette volière, elle ne serait pas avec son espèce. \n" +
                    "Trouvez une volière qui contient la même espèce que cette créature.");
        }
    }

    public static void ShowCommandList(){
        System.out.println(
                """
                        Voici toutes les commandes à votre disposition :
                        
                        -check : Pour examiner un enclos
                            Utilisation : check <NomEnclos>
                            
                        -clean : Pour nettoyer un enclos
                            Utilisation : clean <NomEnclos>
                            
                        -feed : Pour nourrir toutes les créatures d'un enclos
                            Utilisation : feed <NomEnclos
                            
                        -transfer : Pour transferer une créature d'un enclos à un autre
                            Utilisation : transfer <NomCreature> <NomEnclosSource> <NomEnclosDestination>
                            
                        -rename : Pour renommer une créature ou un enclos
                            Utilisation : rename <NomCreatureActuel> <NouveauNom>
                            
                        -help : Pour afficher toute les commandes disponibles
                            Utilisation : help""");
    }

    public static void IntroCreateMaster(){
        System.out.println(
                """
                    Bienvenue dans votre nouveau zoo fantastique !
                    Veuillez entrer plusieurs information pour que nous puissions créer votre personnage :
                    Quelle est votre :
                    Nom     Âge     Sexe(0/1)
                    """);
    }

    public static void CreateZoo(){
        System.out.println("Maintenant, quel nom voulez vous donner à votre zoo fanstastique ?");
    }
}