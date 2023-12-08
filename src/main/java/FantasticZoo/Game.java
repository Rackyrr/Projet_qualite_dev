package FantasticZoo;

import FantasticZoo.models.Master;
import FantasticZoo.models.Zoo;
import FantasticZoo.controls.Command;
import FantasticZoo.models.creatures.Gender;
import FantasticZoo.views.Menu;

import java.util.Scanner;

public class Game implements Menu {
    private static Master master;
    private static Zoo zoo;
    private static Command command;

    public static void main(String[] args) throws NoSuchMethodException {
        SetupGame();
    }

    public static void SetupGame() throws NoSuchMethodException {
        CreationMaster();
        CreationZoo();
        command = Command.getCommand(master, zoo);
    }

    public static void CreationMaster(){
        Menu.CreateMaster(1);
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int age;
        do {
            Menu.CreateMaster(2);
            String ageStr = scan.nextLine();
            try {
                age = Integer.parseInt(ageStr);
                break;
            } catch (NumberFormatException e) {
                Menu.CreateMaster(-2);
            }
        } while(true);
        Gender gender;
        do {
            Menu.CreateMaster(3);
            String GenderStr = scan.nextLine();
            if (GenderStr.equalsIgnoreCase("h")){
                gender = Gender.MALE;
                break;
            }
            else if (GenderStr.equalsIgnoreCase("f")) {
                 gender = Gender.FEMALE;
                 break;
            }
            else
                Menu.CreateMaster(-3);
        } while (true);
        master = Master.getMaster(name, age, gender);
    }

    //Changer NumberMaxEnclosure
    public static void CreationZoo(){
        Scanner scan = new Scanner(System.in);
        Menu.CreateZoo();
        String zooName = scan.nextLine();
        zoo = Zoo.getZoo(zooName, master, 10);
    }
}
