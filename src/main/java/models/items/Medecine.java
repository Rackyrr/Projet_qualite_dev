package models.items;

import models.creatures.Disease;

import java.util.List;
import java.util.Arrays;

public class Medecine extends Item implements Consumable{
    private List<String> treatedDiseases;

    public Medecine(String name, double price, String[] treatedDiseases) {
        super(name, price);
        this.treatedDiseases = Arrays.asList(treatedDiseases);
    }

    public List<String> getTreatedDiseases() {
        return treatedDiseases;
    }

    public void setTreatedDiseases(List<String> treatedDiseases) {
        this.treatedDiseases = treatedDiseases;
    }
}
