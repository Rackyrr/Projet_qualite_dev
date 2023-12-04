package models.creatures.indicators;

import static org.junit.jupiter.api.Assertions.*;

import models.items.Food;
import org.junit.jupiter.api.*;

public class HungerIndicatorTest {
    @Test
    void construct(){
        HungerIndicator hunger = new HungerIndicator(100,2);
        assertEquals(hunger.getActualValue(),100.0);
        assertEquals(hunger.getMaxValue(),100.0);
        assertEquals(hunger.getHungerRate(),2.0);
    }

    @Test
    void hungerDiminishOnRefresh(){
        HungerIndicator hunger = new HungerIndicator(100,2);
        hunger.refresh();
        assertEquals(hunger.getActualValue(),98.0);
    }

    @Test
    void hungerReplenishWhenEating(){
        HungerIndicator hunger = new HungerIndicator(100,5);
        hunger.refresh();
        Food food = new Food("Burger",5,5);
        hunger.replenish(food);
        assertEquals(hunger.getActualValue(),hunger.getMaxValue());
    }

    @Test
    void hungerDoesNotGoBelowZero(){
        HungerIndicator hunger = new HungerIndicator(100,150);
        hunger.refresh();
        assertEquals(hunger.getActualValue(),0);
    }

    @Test
    void hungerDoesNotGoAboveMaxValue(){
        HungerIndicator hunger = new HungerIndicator(100,5);
        hunger.refresh();
        Food food = new Food("Burger",5,10);
        hunger.replenish(food);
        assertEquals(hunger.getActualValue(),hunger.getMaxValue());
    }

    @Test
    void hungerState(){
        HungerIndicator hunger = new HungerIndicator(100,26);
        assertFalse(hunger.getState());
        hunger.refresh();
        hunger.refresh();
        assertTrue(hunger.getState());
    }

    @Test
    void starvedState(){
        HungerIndicator hunger = new HungerIndicator(100,51);
        assertFalse(hunger.getStarvedState());
        hunger.refresh();
        hunger.refresh();
        assertEquals(hunger.getActualValue(),0);
        assertTrue(hunger.getStarvedState());
    }
}
