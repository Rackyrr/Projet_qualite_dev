package FantasticZoo.controls;

import FantasticZoo.models.Master;
import FantasticZoo.models.Zoo;
import FantasticZoo.models.creatures.*;
import FantasticZoo.models.enclosures.Aquarium;
import FantasticZoo.models.enclosures.Aviary;
import FantasticZoo.models.enclosures.Enclosure;
import FantasticZoo.views.Menu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Command implements Menu {
    private static Command command;
    private final Map<String, Method> commands = new HashMap<>();
    private String[] UserCommand;
    private Master master;
    private Zoo zoo;
    private Scanner scan;
    private ArrayList<Class> BuyClass;
    private boolean ExitCommand;

    public Map<String, Method> getCommands() {
        return commands;
    }

    public boolean isExitCommand() {
        return ExitCommand;
    }

    private Command(Master master, Zoo zoo) throws NoSuchMethodException {
        //ajout des commandes dans l'arrayList
        commands.put("check", Command.class.getMethod("check"));
        commands.put("clean", Command.class.getMethod("clean"));
        commands.put("feed", Command.class.getMethod("feed"));
        commands.put("transfer", Command.class.getMethod("transfer"));
        commands.put("rename", Command.class.getMethod("rename"));
        commands.put("help", Command.class.getMethod("help"));
        commands.put("store", Command.class.getMethod("store"));
        commands.put("buy", Command.class.getMethod("buy"));
        commands.put("exit", Command.class.getMethod("exit"));
        this.zoo = zoo;
        this.master = master;
        this.ExitCommand = false;
        this.scan = new Scanner(System.in);
        //Ajout de toutes les classes dans l'arraylist BuyClass
        BuyClass = new ArrayList<>();
        BuyClass.add(Enclosure.class);
        BuyClass.add(Aviary.class);
        BuyClass.add(Aquarium.class);
        BuyClass.add(Dragon.class);
        BuyClass.add(Kraken.class);
        BuyClass.add(Megalodon.class);
        BuyClass.add(Nymph.class);
        BuyClass.add(Phoenix.class);
        BuyClass.add(Siren.class);
        BuyClass.add(Unicorn.class);
        BuyClass.add(Werewolf.class);

    }

    public static Command getCommand(Master master, Zoo zoo) throws NoSuchMethodException {
        if (command == null){
            command = new Command(master, zoo);
        }
        return command;
    }

    public boolean processCommand(String[] userCommand) throws InvocationTargetException, IllegalAccessException {
        if (commands.containsKey(userCommand[0])){
            UserCommand = userCommand;
            commands.get(userCommand[0]).invoke(command);
            return true;
        }
        else {
            Menu.commandNotFound();
            return false;
        }
    }

    //Permet d'examiner un enclos
    //Commande utilisateur : check {nomEnclos}
    public void check(){
        if (UserCommand.length == 1){
            System.out.print("Quel enclos voulez vous examiner ? \n");
        }
        else if (UserCommand.length == 2){
            if (UserCommand[1].equalsIgnoreCase("all")){
                if (zoo.getEnclosurelist().isEmpty()){
                    Menu.NoEnclosure();
                }
                for (Enclosure enclosure : zoo.getEnclosurelist()){
                    System.out.println(enclosure.getName());
                }
            }
            for (Enclosure enclosure : zoo.getEnclosurelist()){
                if (enclosure.getName().equalsIgnoreCase(UserCommand[1])){
                    master.examineEnclosure(enclosure);
                }
                else {
                    Menu.enclosureNotFound(UserCommand[1]);
                }
            }
        }
        else {
            Menu.typo();
        }
    }

    //Permet de nettoyer un enclos
    //Commande utilisateur : clean {nomEnclos}
    public void clean(){
        if (UserCommand.length == 1){
            Menu.cleanEnclosureMessage();
        }
        else if (UserCommand.length == 2){
            for (Enclosure enclosure : zoo.getEnclosurelist()){
                if (enclosure.getName().equalsIgnoreCase(UserCommand[1])){
                    master.cleanEnclosure(enclosure);
                }
                else {
                    Menu.enclosureNotFound(UserCommand[1]);
                }
            }
        }
        else {
            Menu.typo();
        }
    }

    //Permet de nourrir les animaux d'un enclos
    //Commande utilisateur : feed {nomEnclos}
    public void feed(){
        if (UserCommand.length == 1){
            Menu.feedEnclosureMessage();
        }
        if (UserCommand.length == 2){
            for (Enclosure enclosure : zoo.getEnclosurelist()){
                if (enclosure.getName().equalsIgnoreCase(UserCommand[1])){
                    master.feedEnclosure(enclosure);
                }
                else {
                    Menu.enclosureNotFound(UserCommand[1]);
                }
            }
        }
        else {
            Menu.typo();
        }
    }

    //Permet de transferer une créature d'un enclos à un autre
    //Commande utilisateur : transfert {nomCreature} {nomEnclosSource} {nomEnclosDestination}
    public void transfer(){
        if (UserCommand.length == 1){
            System.out.print("Quel créature voulez-vous déplacez ?");
        }
        else if (UserCommand.length == 2){
            System.out.println("De quel enclos ?");
        }
        else if (UserCommand.length == 3){
            System.out.println("Dans quel enclos ?");
        }
        else if (UserCommand.length == 4){
            Enclosure enclosSource = null;
            Enclosure enclosDest = null;
            for (Enclosure enclosure : zoo.getEnclosurelist()){
                if (enclosure.getName().equalsIgnoreCase(UserCommand[2])){
                    enclosSource = enclosure;
                }
                else {
                    Menu.enclosureNotFound(UserCommand[2]);
                }
                if (enclosure.getName().equalsIgnoreCase(UserCommand[3])){
                    enclosDest = enclosSource;
                }
                else {
                    Menu.enclosureNotFound(UserCommand[3]);
                }
                if (enclosSource != null && enclosDest != null){
                    for (Creature creature : enclosSource.getCreatures()){
                        if (creature.getName().equalsIgnoreCase(UserCommand[1])){
                            master.transferCreature(enclosSource, enclosDest, creature);
                        }
                        else {
                            System.out.println("Il n'a pas de créature nommée " + UserCommand[1]
                                    + " dans l'enclos " + enclosSource.getName());
                        }
                    }
                }
            }
        }
        else {
            Menu.typo();
        }
    }

    //Permet de renommer une créature
    //Commande utilisateur : rename {NomCreature/Enclos} {NewName}
    public void rename(){
        if (UserCommand.length == 1){
            System.out.print("Qu'est ce que vous voulez renommer ?");
        }
        else if (UserCommand.length == 2){
            System.out.println("Quel nom voulez vous lui attribuer ?");
        }
        else if (UserCommand.length == 3){
            Enclosure enclosureRename = null;
            Creature creatureRename = null;
            for (Enclosure enclosure : zoo.getEnclosurelist()){
                if (enclosure.getName().equalsIgnoreCase(UserCommand[1])){
                    enclosureRename = enclosure;
                    enclosureRename.setName((UserCommand[2]));
                    break;
                }
                for (Creature creature : enclosure.getCreatures()){
                    if (creature.getName().equalsIgnoreCase(UserCommand[1])){
                        creatureRename = creature;
                        creatureRename.setName(UserCommand[2]);
                        break;
                    }
                }
                if (creatureRename != null){
                    creatureRename.setName(UserCommand[2]);
                    break;
                }
            }
        }
        else {
            Menu.typo();
        }
    }

    //Permet d'afficher toutes les commandes disponibles
    //Commande utilisateur : help
    public void help(){
        if (UserCommand.length != 1){
            Menu.typo();
        }
        else {
            Menu.ShowCommandList();
        }
    }

    //Permet de quitter le jeu :
    public void exit() {
        System.out.println("Êtes vous sûr de vouloir quitter ? \n" +
                "Votre progression ne sera pas sauvergardée (Y/N)");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            ExitCommand = true;
        }
    }

    public void store(){
        if (UserCommand.length == 1){
            Menu.ShowStore();
        }
        else {
            Menu.typo();
        }
    }


    public void buy() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        boolean CommandItemFound = false;
        if (UserCommand.length == 2) {
            for (Class item : BuyClass){
                if (UserCommand[1].equalsIgnoreCase(item.getSimpleName())){
                    Menu.Buying(1, Creature.class.isAssignableFrom(item));
                    String nameObject = scan.nextLine();
                    if (Creature.class.isAssignableFrom(item)){
                        if (!zoo.getEnclosurelist().isEmpty()){
                            Menu.Buying(2, Creature.class.isAssignableFrom(item));
                            Gender gender;
                            do {
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
                            Menu.Buying(3, Creature.class.isAssignableFrom(item));
                            Menu.AllEnclosure(zoo);
                            boolean IsFound = false;
                            while (!IsFound){
                                String EnclosName = scan.nextLine();
                                for (Enclosure enclosure : zoo.getEnclosurelist()){
                                    if (EnclosName.equalsIgnoreCase(enclosure.getName())){
                                        try {
                                            Constructor constructor = item.getDeclaredConstructor(Enclosure.class,Gender.class, String.class);
                                            Creature newCreature = (Creature) constructor.newInstance(enclosure, gender, nameObject);
                                            enclosure.AddCreature(newCreature);
                                            System.out.println("Vous avez bien acheté la créature " + newCreature.getName()
                                                    + " qui est " + newCreature.getClass().getName());
                                            CommandItemFound = true;
                                            IsFound = true;
                                        } catch (NoSuchMethodException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            System.out.println("Vous n'avez pas encore d'enclos où mettre vos créatures.");
                        }
                    }
                    else if (!Creature.class.isAssignableFrom(item)){
                        Menu.Buying(2,Creature.class.isAssignableFrom(item));
                        String NomCreature = scan.nextLine();
                        for (Class classs : BuyClass){
                            if (classs.getSimpleName().equalsIgnoreCase("Enclosure")
                                    || classs.getSimpleName().equalsIgnoreCase("Aquarium")
                                    || classs.getSimpleName().equalsIgnoreCase("Aviary")){
                                continue;
                            }
                            else {
                                if (classs.getSimpleName().equalsIgnoreCase(NomCreature)){
                                    try {
                                        Constructor constructor = item.getDeclaredConstructor(Class.class, String.class);
                                        Enclosure newEnclosure = (Enclosure) constructor.newInstance(classs, nameObject);
                                        zoo.getEnclosurelist().add(newEnclosure);
                                        System.out.println("Vous avez bien acheté l'enclos " + newEnclosure.getName()
                                                + " qui contient des " + newEnclosure.getAUTHORIZED_ANIMAL().getSimpleName());
                                        CommandItemFound = true;
                                    } catch (NoSuchMethodException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }

                        }
                    }
                }
            }
            if (!CommandItemFound){
                System.out.println("Ce que vous voulez acheter n'existe pas");
            }
        }
        else {
            Menu.typo();
        }
    }
}