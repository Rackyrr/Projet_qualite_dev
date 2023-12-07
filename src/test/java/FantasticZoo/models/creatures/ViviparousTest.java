package FantasticZoo.models.creatures;

import FantasticZoo.models.enclosures.Enclosure;
import org.easymock.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ViviparousTest {
    private Enclosure mockEnclosure = EasyMock.createMock(Enclosure.class);

    @Test
    void construct(){
        Werewolf werewolf = new Werewolf("Lougarouman",95,186,0,150,5,120,8,
                150,55,false,Gender.MALE,null,9);
        assertEquals("Lougarouman",werewolf.getName());
        assertEquals(95,werewolf.getWeight());
        assertEquals(186,werewolf.getHeight());
        assertEquals(0,werewolf.getAge());
        assertEquals(150,werewolf.getHunger().getMaxValue());
        assertEquals(5,werewolf.getHunger().getHungerRate());
        assertEquals(120,werewolf.getSleep().getMaxValue());
        assertEquals(8,werewolf.getSleep().getSleepRate());
        assertEquals(150,werewolf.getHealth().getMaxValue());
        assertEquals(55,werewolf.getNATURAL_DEATH_AGE());
        assertEquals(false,werewolf.isDead());
        assertEquals(Gender.MALE,werewolf.getGender());
        assertEquals(null,werewolf.getActualEnclosure());
        assertEquals(9,werewolf.getGESTATION_TIME());
    }

    @Test
    void constructForNewborns(){
        assertDoesNotThrow(() -> new Werewolf(mockEnclosure,Gender.MALE));
    }

    @Test
    void goingToDieWhenDeathAgeReached(){
        Werewolf werewolf = new Werewolf("Lougarouman",95,186,0,150,5,120,8,
                150,1,false,Gender.MALE,null,9);
        werewolf.growUp();
        assertEquals(werewolf.getAge(),werewolf.getNATURAL_DEATH_AGE());
        while (!werewolf.isDead())
            werewolf.growUp();
        assertTrue(werewolf.isDead());
        System.out.println(werewolf.getAge());
    }

    @Test
    void maleCanMateWithFemaleButNotWithMale(){
        Werewolf werewolfman = new Werewolf("Lougarouman",95,186,0,150,5,120,8,
                150,50,false,Gender.MALE,null,9);
        Werewolf werewolfman1 = new Werewolf("Loulou",95,186,0,150,5,120,8,
                150,50,false,Gender.MALE,null,9);
        Werewolf werewolfwoman = new Werewolf("Lougarouwoman",95,186,0,150,5,120,8,
                150,75,false,Gender.FEMALE,null,9);
        assertFalse(werewolfman.canMateWith(werewolfman1));
        assertTrue(werewolfman.canMateWith(werewolfwoman));
    }

    @Test
    void femaleGetPregnantAfterMating(){
        EasyMock.expect(mockEnclosure.isFull()).andReturn(true);
        Werewolf werewolfwoman = new Werewolf("Lougarouwoman",95,186,0,150,5,120,8,
                150,75,false,Gender.FEMALE,mockEnclosure,9);
        Werewolf werewolfman = new Werewolf("Lougarouman",95,186,0,150,5,120,8,
                150,50,false,Gender.MALE,mockEnclosure,9);
        assertFalse(werewolfwoman.isPregnant());
        werewolfman.reproduce(werewolfwoman);
        assertTrue(werewolfwoman.isPregnant());
    }
}
