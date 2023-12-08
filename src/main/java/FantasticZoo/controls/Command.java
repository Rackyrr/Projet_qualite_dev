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

    /**
     * Retrieves the map of commands.
     *
     * @return Returns a map of commands, where the keys are the command names and the values are the corresponding Method objects.
     */
    public Map<String, Method> getCommands() {
        return commands;
    }

    /**
     * Checks if the current command is an exit command.
     *
     * @return true if the command is an exit command, false otherwise
     */
    public boolean isExitCommand() {
        return ExitCommand;
    }

    /**
     * Represents a command that can be executed by the user in the zoo management system.
     * Each command is associated with a specific action and can be invoked by the user.
     *
     * @param master The master controlling the zoo.
     * @param zoo The zoo being managed.
     * @throws NoSuchMethodException If a specified method cannot be found.
     */
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

    /**
     * Retrieves the Command instance. If it does not exist, creates a new Command instance using the given Master and Zoo parameters.
     *
     * @param master The master controlling the zoo.
     * @param zoo The zoo being managed.
     * @return Returns the Command instance.
     * @throws NoSuchMethodException If a specified method cannot be found.
     */
    public static Command getCommand(Master master, Zoo zoo) throws NoSuchMethodException {
        if (command == null){
            command = new Command(master, zoo);
        }
        return command;
    }

    /**
     * Executes the user command and returns the result.
     *
     * @param userCommand The command provided by the user as an array of Strings. The first element of the array should be the command name.
     * @return true if the command was successfully executed, false otherwise.
     * @throws InvocationTargetException If the invoked command throws an exception.
     * @throws IllegalAccessException If the invoked command cannot be accessed.
     */
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

    /**
     * Examines an enclosure.
     * User command: check {enclosureName}
     */
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
            else {
                for (Enclosure enclosure : zoo.getEnclosurelist()){
                    if (enclosure.getName().equalsIgnoreCase(UserCommand[1])){
                        master.examineEnclosure(enclosure);
                    }
                    else {
                        Menu.enclosureNotFound(UserCommand[1]);
                    }
                }
            }
        }
        else {
            Menu.typo();
        }
    }


    /**
     * Cleans the zoo enclosures based on the user command.
     * If the command has one argument, it asks what enclosure to clean.
     * If the command has two arguments, it cleans the specified enclosure.
     * If the command has more than two arguments, it displays a typo message.
     * User command : clean {nomEnclos}
     */
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


    /**
     * Feeds the animals in the zoo.
     * If the user command has only one argument, it asks what enclosure to feed.
     * If the user command has two arguments, it feeds the specified enclosure.
     * If the user command has more than two arguments, it displays a typo message.
     * Commande utilisateur : feed {nomEnclos}
     */
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


    /**
     * Transfers a creature from one enclosure to another enclosure in the zoo.
     * This method handles the different cases based on the length of the user command array.
     * If the user command length is 1, it prompts the user to specify which creature to move.
     * If the user command length is 2, it prompts the user to specify the source enclosure.
     * If the user command length is 3, it prompts the user to specify the destination enclosure.
     * If the user command length is 4, it finds the source and destination enclosures,
     * and for specified creature in the source enclosure, it transfers the creature to the destination enclosure
     * using the master's transferCreature() method.
     * If the user command length is not within the above valid lengths, it displays a typo message.
     * Commande utilisateur : transfert {nomCreature} {nomEnclosSource} {nomEnclosDestination}
     */
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

    /**
     * Renames an enclosure or a creature in the zoo based on the user command.
     * If the user command has one argument, it prompts the user to specify what to rename.
     * If the user command has two arguments, it prompts the user to specify the new name.
     * If the user command has three arguments, it searches for the specified enclosure or creature
     * and renames it with the given new name.
     * If the user command has more than three arguments, it displays a typo message.
     * User command: rename {name} {newName}
     */
    public void rename() {
        if (UserCommand.length == 1) {
            System.out.print("Qu'est ce que vous voulez renommer ?");
        } else if (UserCommand.length == 2) {
            System.out.println("Quel nom voulez vous lui attribuer ?");
        } else if (UserCommand.length == 3) {
            Enclosure enclosureRename = null;
            Creature creatureRename = null;
            for (Enclosure enclosure : zoo.getEnclosurelist()) {
                if (enclosure.getName().equalsIgnoreCase(UserCommand[1])) {
                    enclosureRename = enclosure;
                    enclosureRename.setName((UserCommand[2]));
                    break;
                }
                for (Creature creature : enclosure.getCreatures()) {
                    if (creature.getName().equalsIgnoreCase(UserCommand[1])) {
                        creatureRename = creature;
                        creatureRename.setName(UserCommand[2]);
                        break;
                    }
                }
                if (creatureRename != null) {
                    creatureRename.setName(UserCommand[2]);
                    break;
                }
            }
        } else {
            Menu.typo();
        }
    }

    /**
     * Displays the available commands or prompts the user to fix a typo.
     * If the user command length is not equal to 1, it calls the typo method in the Menu class.
     * Otherwise, it calls the ShowCommandList method in the Menu class.
     */
    public void help(){
        if (UserCommand.length != 1){
            Menu.typo();
        }
        else {
            Menu.ShowCommandList();
        }
    }

    /**
     * Exits the zoo management system.
     * The method prompts the user with a confirmation message asking if they are sure they want to exit.
     * If the user enters 'Y' or 'y', the ExitCommand flag is set to true.
     */
    public void exit() {
        System.out.println("Êtes vous sûr de vouloir quitter ? \n" +
                "Votre progression ne sera pas sauvergardée (Y/N)");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            ExitCommand = true;
        }
    }

    /**
     * Executes the store command.
     * If the user command length is 1, it invokes the {@link Menu#ShowStore()} method to display the store.
     * If the user command length is not equal to 1, it displays a typo message using the {@link Menu#typo()} method.
     */
    public void store(){
        if (UserCommand.length == 1){
            Menu.ShowStore();
        }
        else {
            Menu.typo();
        }
    }


    /**
     * Executes the buy command, which allows the user to purchase creatures or enclosures in the zoo.
     * The method handles different cases based on the length of the user command array.
     * If the user command length is 2 and the specified item is a creature, it prompts the user to provide the necessary information and creates a new creature instance.
     * If the user command length is 2 and the specified item is not a creature, it prompts the user to provide the necessary information and creates a new enclosure instance.
     * If the user command length is not equal to 2, it displays a typo message.
     *
     * @throws InvocationTargetException
     *         If the invoked constructor throws an exception.
     * @throws InstantiationException
     *         If a new instance of the specified class cannot be created.
     * @throws IllegalAccessException
     *         If the constructor cannot be accessed.
     */
    public void buy() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        boolean CommandItemFound = false;
        if (UserCommand.length == 2) {
            for (Class item : BuyClass){
                if (UserCommand[1].equalsIgnoreCase(item.getSimpleName())){
                    if (zoo.getEnclosurelist().isEmpty() && Creature.class.isAssignableFrom(item)){
                        System.out.println("Vous n'avez aucun enclos pour pouvoir le mettre");
                        CommandItemFound = true;
                    }
                    else if (!zoo.getEnclosurelist().isEmpty() && Creature.class.isAssignableFrom(item)) {
                        Menu.Buying(1, Creature.class.isAssignableFrom(item));
                        String nameObject = scan.nextLine();
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
                                                + " qui est " + newCreature.getClass().getSimpleName());
                                        CommandItemFound = true;
                                        IsFound = true;
                                    } catch (NoSuchMethodException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                        }
                    }
                    if (!Creature.class.isAssignableFrom(item)){
                        Menu.Buying(1, Creature.class.isAssignableFrom(item));
                        String nameObject = scan.nextLine();
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