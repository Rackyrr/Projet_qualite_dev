package views;

import controls.Command;
import models.Master;

import java.util.Scanner;

public interface Menu {
    public default void promptMenu(){
        System.out.println("=== Menu ===");
        System.out.println("1. Examiner les caractéristiques d'un enclos");
        System.out.println("2. Nettoyer un enclos");
        System.out.println("3. Nourrir les créatures d'un enclos");
        System.out.println("4. Transférer une créature");
        System.out.println("5. Quitter");
    }

}
