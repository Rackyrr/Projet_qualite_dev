package controls;

import java.util.HashMap;
import java.util.Map;

public class Command {
    private Map<String,Runnable> commands = new HashMap<>();

    public void processCommand(String[] userCommand){
        if (commands.containsKey(userCommand[0])){
            //
        }
        else {
            System.out.println("Cette commande n'existe pas. \n" +
                    "Tapez List_command pour avoir toutes les commandes disponibles");
        }
    }

    public void check(){}
    public void clean(String enclosureName){}
    public void feed(){}
    public void transfer(){}
}