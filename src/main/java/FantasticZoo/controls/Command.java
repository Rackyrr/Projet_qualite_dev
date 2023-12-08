package FantasticZoo.controls;

import FantasticZoo.models.Master;
import FantasticZoo.models.Zoo;
import FantasticZoo.models.creatures.Creature;
import FantasticZoo.models.enclosures.Enclosure;
import FantasticZoo.views.Menu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Command implements Menu {
    private static Command command;
    private final Map<String, Method> commands = new HashMap<>();
    private String[] UserCommand;
    private Master master;
    private Zoo zoo;

    public Map<String, Method> getCommands() {
        return commands;
    }

    private Command(Master master, Zoo zoo) throws NoSuchMethodException {
        commands.put("check", Command.class.getMethod("check"));
        commands.put("clean", Command.class.getMethod("clean"));
        commands.put("feed", Command.class.getMethod("feed"));
        commands.put("transfer", Command.class.getMethod("transfer"));
        commands.put("rename", Command.class.getMethod("rename"));
        commands.put("help", Command.class.getMethod("help"));
        this.zoo = zoo;
        this.master = master;
    }

    public static Command getCommand(Master master, Zoo zoo) throws NoSuchMethodException {
        if (command == null){
            command = new Command(master, zoo);
        }
        return command;
    }

    public void processCommand(String[] userCommand) throws InvocationTargetException, IllegalAccessException {
        if (commands.containsKey(userCommand[0])){
            UserCommand = userCommand;
            commands.get(userCommand[0]).invoke(null);
        }
        else {
            System.out.println("Cette commande n'existe pas. \n" +
                    "Tapez List_command pour avoir toutes les commandes disponibles");
        }
    }

    //Permet d'examiner un enclos
    //Commande utilisateur : check {nomEnclos}
    public void check(){
        if (UserCommand.length == 1){
            System.out.print("Quel enclos voulez vous examiner ?");
        }
        if (UserCommand.length == 2){
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
        if (UserCommand.length == 2){
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

}