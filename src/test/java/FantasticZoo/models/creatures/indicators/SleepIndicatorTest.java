package FantasticZoo.models.creatures.indicators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SleepIndicatorTest {
    @Test
    void construct(){
        SleepIndicator sleep = new SleepIndicator(100,2);
        assertEquals(sleep.getActualValue(),100.0);
        assertEquals(sleep.getMaxValue(),100.0);
        assertEquals(sleep.getSleepRate(),2.0);
    }

    @Test
    void sleepDiminishOnRefresh(){
        SleepIndicator sleep = new SleepIndicator(100,2);
        sleep.refresh();
        assertEquals(sleep.getActualValue(),98.0);
    }

    @Test
    void sleepingWhenValueIsEqualToZero(){
        SleepIndicator sleep = new SleepIndicator(100,100);
        assertFalse(sleep.getState()); // not sleeping right now
        sleep.refresh();
        assertEquals(sleep.getActualValue(),0);
        assertTrue(sleep.getState());
    }

    @Test
    void randomlyWakingUpWhenValueHalfFull(){
        SleepIndicator sleep = new SleepIndicator(100,100);
        sleep.refresh();
        assertTrue(sleep.getState()); // is sleeping
        sleep.setSleepRate(50);
        sleep.refresh();
        sleep.setSleepRate(1);
        while(sleep.getState())
            sleep.refresh();
        System.out.println(sleep.getActualValue());
        assertTrue(sleep.getActualValue() < 100);
    }

    @Test
    void WakingUpWhenValueFull(){
        SleepIndicator sleep = new SleepIndicator(100,100);
        sleep.refresh();
        assertTrue(sleep.getState()); // is sleeping
        sleep.setSleepRate(50);
        sleep.refresh();
        sleep.refresh();
        assertFalse(sleep.getState()); // is not sleeping
    }

    @Test
    void sleepDoesNotGoBelowZero(){
        SleepIndicator sleep = new SleepIndicator(100,150);
        sleep.refresh();
        assertEquals(sleep.getActualValue(),0);
    }
}
