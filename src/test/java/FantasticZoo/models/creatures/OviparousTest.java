package FantasticZoo.models.creatures;

import FantasticZoo.models.enclosures.Enclosure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OviparousTest {
    private Enclosure mockEnclosure = mock(Enclosure.class);

    @Test
    void constructForNewborns(){
        assertDoesNotThrow(() -> new Dragon(mockEnclosure,Gender.MALE));
    }

    @Test
    void goingToDieWhenDeathAgeReached(){
        Dragon dragon = new Dragon("Lougarouman",95,186,0,150,5,120,8, 150,1,false,Gender.MALE,null);
        dragon.growUp();
        assertEquals(dragon.getAge(),dragon.getNATURAL_DEATH_AGE());
        while (!dragon.isDead())
            dragon.growUp();
        assertTrue(dragon.isDead());
    }

    @Test
    void maleCanMateWithFemaleButNotWithMale(){
        Dragon dragonman = new Dragon("Dragonman",95,186,0,150,5,120,8,
                150,50,false,Gender.MALE,null);
        Dragon dragonman1 = new Dragon("Loulou",95,186,0,150,5,120,8,
                150,50,false,Gender.MALE,null);
        Dragon dragonwoman = new Dragon("Dragonwoman",95,186,0,150,5,120,8,
                150,75,false,Gender.FEMALE,null);
        assertFalse(dragonman.canMateWith(dragonman1));
        assertTrue(dragonman.canMateWith(dragonwoman));
    }

    @Test
    void run(){
        Dragon dragon = new Dragon("Dragon",95,186,0,150,5,120,8, 150,1,false,Gender.MALE,mockEnclosure);
        when(mockEnclosure.getRandomCreatureInEnclosure()).thenReturn(dragon);
        dragon.run();
        assertEquals(dragon.getAge(),dragon.getNATURAL_DEATH_AGE());
    }
}
