package controls;

import models.Master;
import models.Zoo;
import models.enclosures.Enclosure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Command {
    private final Map<String, Method> commands = new HashMap<>();
    private String[] UserCommand;
    private Master master;
    private Zoo zoo;

    public Map<String, Method> getCommands() {
        return commands;
    }

    public Command(Master master, Zoo zoo) throws NoSuchMethodException {
        commands.put("check", Command.class.getMethod("check"));
        commands.put("clean", Command.class.getMethod("clean"));
        commands.put("feed", Command.class.getMethod("feed"));
        commands.put("transfer", Command.class.getMethod("transfer"));
        this.zoo = zoo;
        this.master = master;
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
                if (enclosure.getName().equals(UserCommand[1])){
                    master.examineEnclosure(enclosure);
                }
                else {
                    System.out.println("Il n'y a pas d'enclos nommé : " + UserCommand[1]);
                }
            }
        }
        else {
            System.out.println("Vous n'avez pas rentré le bon nombre d'agurment pour la commande");
        }
    }

    //Permet de nettoyer un enclos
    //Commande utilisateur : clean {nomEnclos}
    public void clean(){
        if (UserCommand.length == 1){
            System.out.print("Quel enclos voulez vous nettoyer ?");
        }
        if (UserCommand.length == 2){
            for (Enclosure enclosure : zoo.getEnclosurelist()){
                if (enclosure.getName().equals(UserCommand[1])){
                    master.cleanEnclosure(enclosure);
                }
                else {
                    System.out.println("Il n'y a pas d'enclos nommé : " + UserCommand[1]);
                }
            }
        }
        else {
            System.out.println("Vous n'avez pas rentré le bon nombre d'agurment pour la commande");
        }
    }

    //Permet de nourrir les animaux d'un enclos
    //Commande utilisateur : feed {nomEnclos}
    public void feed(){
        if (UserCommand.length == 1){
            System.out.print("De quel enclos voulez vous nourrir les créatures ?");
        }
        if (UserCommand.length == 2){
            for (Enclosure enclosure : zoo.getEnclosurelist()){
                if (enclosure.getName().equals(UserCommand[1])){
                    master.feedEnclosure(enclosure);
                }
                else {
                    System.out.println("Il n'y a pas d'enclos nommé : " + UserCommand[1]);
                }
            }
        }
        else {
            System.out.println("Vous n'avez pas rentré le bon nombre d'agurment pour la commande");
        }
    }

    //Permet de transferer une créature d'un enclos à un autre
    //Commande utilisateur : transfert {nomCreature} {nomEnclosSource} {nomEnclosDestination}
    public void transfer(){
        if (UserCommand.length == 1){
            System.out.print("Quel créature voulez-vous déplacez ?");
        }
        else if (UserCommand.length == 2){
            System.out.println("Dans quel enclos ?");
        }
        if (UserCommand.length == 3){

        }
        else {
            System.out.println("Vous n'avez pas rentré le bon nombre d'agurment pour la commande");
        }
    }
}