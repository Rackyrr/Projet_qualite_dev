package FantasticZoo.models.enclosure;

import FantasticZoo.models.creatures.*;
import FantasticZoo.models.enclosures.Enclosure;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class EnclosureTest {
    @Test
    void construct(){
        assertDoesNotThrow(() -> new Enclosure(Werewolf.class,"Enclos des méga loup garou",250,8));
    }

    @Test
    void addACreatureOfAuthorizedSpecies(){
        Enclosure wEnclosure = new Enclosure(Werewolf.class,"Enclos des méga loup garou",250,8);
        Werewolf werewolf = new Werewolf(null, Gender.MALE);
        assertTrue(wEnclosure.AddCreature(werewolf));
        assertEquals(1,wEnclosure.getCreatures().size());
        assertEquals(werewolf,wEnclosure.getCreatures().get(0));
        assertEquals(wEnclosure,wEnclosure.getCreatures().get(0).getActualEnclosure());
    }

    @Test
    void cantAddCreatureOfNonAuthorizedSpecies(){
        Enclosure wEnclosure = new Enclosure(Werewolf.class,"Enclos des méga loup garou",250,8);
        Dragon dragon = new Dragon(null, Gender.MALE);
        assertFalse(wEnclosure.AddCreature(dragon));
    }

    @Test
    void getPregnancyNumber(){
        Enclosure wEnclosureWithPregnancy = new Enclosure(Werewolf.class,"Enclos des loup garous",250,5);
        Werewolf werewolf1 = new Werewolf(null, Gender.FEMALE);
        werewolf1.setPregnant(true);
        Werewolf werewolf2 = new Werewolf(null, Gender.FEMALE);
        werewolf2.setPregnant(true);
        Werewolf werewolf3 = new Werewolf(null, Gender.FEMALE);
        werewolf3.setPregnant(true);
        wEnclosureWithPregnancy.AddCreature(werewolf1);
        wEnclosureWithPregnancy.AddCreature(werewolf2);
        wEnclosureWithPregnancy.AddCreature(werewolf3);
        assertEquals(3,wEnclosureWithPregnancy.getPregnancyNumber());
    }

    @Test
    void isFull(){
        Enclosure pEnclosureWithEgg = new Enclosure(Phoenix.class,"Enclos des phénix",250,2);
        Phoenix phoenix1 = new Phoenix(null, Gender.FEMALE);
        Egg egg = new Egg(Phoenix.class,10,null);
        assertTrue(pEnclosureWithEgg.AddCreature(phoenix1));
        assertFalse(pEnclosureWithEgg.isFull());
        assertTrue(pEnclosureWithEgg.AddEgg(egg));
        assertTrue(pEnclosureWithEgg.isFull());
        Enclosure wEnclosureWithPregnancy = new Enclosure(Werewolf.class,"Enclos des loup garous",250,2);
        Werewolf werewolf1 = new Werewolf(null, Gender.FEMALE);
        werewolf1.setPregnant(true);
        assertTrue(wEnclosureWithPregnancy.AddCreature(werewolf1));
        assertEquals(1,wEnclosureWithPregnancy.getPregnancyNumber());
        assertTrue(wEnclosureWithPregnancy.isFull());
    }

    @Test
    void cantAddCreatureWhenFull(){
        Enclosure wEnclosure = new Enclosure(Werewolf.class,"Enclos des méga loup garou",250,2);
        Werewolf werewolf1 = new Werewolf(null, Gender.MALE);
        Werewolf werewolf2 = new Werewolf(null, Gender.FEMALE);
        Werewolf werewolf3 = new Werewolf(null, Gender.MALE);
        assertTrue(wEnclosure.AddCreature(werewolf1));
        assertTrue(wEnclosure.AddCreature(werewolf2));
        assertFalse(wEnclosure.AddCreature(werewolf3));
    }

    @Test
    void viviparousCanGiveBirth(){
        Enclosure wEnclosure = new Enclosure(Werewolf.class,"Enclos des méga loup garou",250,3);
        Werewolf werewolf1 = new Werewolf(null, Gender.MALE);
        Werewolf werewolf2 = new Werewolf(null, Gender.FEMALE);
        wEnclosure.AddCreature(werewolf1);
        wEnclosure.AddCreature(werewolf2);
        assertFalse(wEnclosure.isFull());
        werewolf2.setPregnant(true);
        assertTrue(wEnclosure.isFull());
        assertTrue(werewolf2.giveBirth());
    }

    @Test
    void oviparousCanLayEggsInEnclosure(){
        Enclosure wEnclosure = new Enclosure(Phoenix.class,"Enclos des p",250,2);
        Phoenix p1 = new Phoenix(null, Gender.FEMALE);
        wEnclosure.AddCreature(p1);
        Egg egg = p1.layEgg();
        assertNotNull(egg);
        assertEquals(Phoenix.class,egg.getSPECIES_CLASS());
        assertEquals(p1.getINCUBATION_TIME(),egg.getINCUBATION_TIME());
        assertEquals(0,egg.getActualIncubationTime());
        assertEquals(p1.getActualEnclosure(),egg.getActualEnclosure());
    }

    @Test
    void eggCanHatch() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Enclosure wEnclosure = new Enclosure(Phoenix.class,"Enclos des p",250,3);
        Phoenix p1 = new Phoenix(null, Gender.MALE);
        Phoenix p2 = new Phoenix(null, Gender.FEMALE);
        wEnclosure.AddCreature(p1);
        wEnclosure.AddCreature(p2);
        assertFalse(wEnclosure.isFull());
        Egg egg = p2.layEgg();
        assertTrue(wEnclosure.isFull());
        Creature newBorn = egg.hatch();
        assertNotNull(newBorn);
        assertTrue(wEnclosure.getCreatures().contains(newBorn));
    }

    @Test
    void getRandomCreatureInEnclosure(){
        Enclosure wEnclosure = new Enclosure(Phoenix.class,"Enclos des p",250,3);
        Phoenix p1 = new Phoenix(null, Gender.MALE);
        Phoenix p2 = new Phoenix(null, Gender.FEMALE);
        assertTrue(wEnclosure.AddCreature(p1));
        assertEquals(p1,wEnclosure.getRandomCreatureInEnclosure());
        assertTrue(wEnclosure.AddCreature(p2));
        System.out.println(wEnclosure.getRandomCreatureInEnclosure().getGender());
    }

    @Test
    void run(){
        assertDoesNotThrow(() -> {
            Enclosure wEnclosure = new Enclosure(Werewolf.class,"Enclos des loup-garous",250,3);
            Werewolf p1 = new Werewolf(null, Gender.MALE);
            p1.setName("Chichi");
            Werewolf p2 = new Werewolf(null, Gender.FEMALE);
            wEnclosure.AddCreature(p1);
            wEnclosure.AddCreature(p2);
            for (int i = 0;i < 100;++i){
                System.out.println(String.format("Tour %d : il y a %d créatures",i,wEnclosure.getCreatures().size()));
                wEnclosure.run();
            }
        });
    }
}
