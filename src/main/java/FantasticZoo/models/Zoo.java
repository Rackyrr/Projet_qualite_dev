package FantasticZoo.models;

import FantasticZoo.models.creatures.Creature;
import FantasticZoo.models.creatures.Werewolf;
import FantasticZoo.models.enclosures.Enclosure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Zoo {
    private static Zoo zoo;

    private String name;

    private Master fantasticMaster;

    private int numberMaxEnclosure;

    private ArrayList<Enclosure> enclosurelist;


    private Zoo(String name, Master fantasticMaster, int numberMaxEnclosure) {
        this.name = name;
        this.fantasticMaster = fantasticMaster;
        this.enclosurelist = new ArrayList<>();
        this.numberMaxEnclosure = numberMaxEnclosure;
    }

    public static Zoo getZoo(String name, Master fantasticMaster, int numberMaxEnclosure) {
        if (zoo == null) {
            zoo = new Zoo(name, fantasticMaster, numberMaxEnclosure);
        }
        return zoo;
    }

    public void displayAllZooCreature(){
        int totalZooCreature = 0;
        for (Enclosure enclos : enclosurelist) {
            totalZooCreature += enclos.getCreatures().size() + enclos.getEggs().size() + enclos.getPregnancyNumber();
        }
        System.out.println("Nombres de créatures presentent dans le Zoo fantastique : " + totalZooCreature);

    }

    public ArrayList<Thread> getEnclosuresThreads(){
        ArrayList<Thread> threads = new ArrayList<>(enclosurelist.size());
        Enclosure[] eArray = enclosurelist.toArray(new Enclosure[0]);
        Iterator<Enclosure> e = Arrays.stream(eArray).iterator();
        while (e.hasNext()) {
            threads.add(new Thread(e.next()));
        }
        return threads;
    }

    public void displayEnclosureAllCreature(){
        int totalEnclosureCreature = 0;
        for (Enclosure enclos : enclosurelist){
            totalEnclosureCreature += enclos.getCreatures().size() + enclos.getEggs().size() + enclos.getPregnancyNumber();
        }
        System.out.println("Créatures de tous les enclos : " + totalEnclosureCreature);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Master getFantasticMaster() {
        return fantasticMaster;
    }

    public void setFantasticMaster(Master fantasticMaster) {
        this.fantasticMaster = fantasticMaster;
    }

    public int getNumberMaxEnclosure() {
        return numberMaxEnclosure;
    }

    public void setNumberMaxEnclosure(int numberMaxEnclosure) {
        this.numberMaxEnclosure = numberMaxEnclosure;
    }

    public ArrayList<Enclosure> getEnclosurelist() {
        return enclosurelist;
    }

    public void setEnclosurelist(ArrayList<Enclosure> enclosurelist) {
        this.enclosurelist = enclosurelist;
    }
}
