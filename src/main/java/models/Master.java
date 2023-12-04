package models;
import models.creatures.Creature;
import models.creatures.Egg;
import models.creatures.Gender;
import models.enclosures.Enclosure;

import java.util.ArrayList;

public class Master {
    private String name;
    private int age;
    private Gender gender;
    public Master(String name, int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    private void examineEnclosure(Enclosure enclosure){

    }
}
