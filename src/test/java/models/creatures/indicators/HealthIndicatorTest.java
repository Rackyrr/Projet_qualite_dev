package models.creatures.indicators;

import models.creatures.Disease;
import models.items.Medecine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HealthIndicatorTest {
    @Test
    void construct() {
        HealthIndicator health = new HealthIndicator(100);
        assertEquals(health.getActualValue(), 100.0);
        assertEquals(health.getMaxValue(), 100.0);
        assertNull(health.getActualDisease());
    }

    @Test
    void sayIfHasDesease(){
        HealthIndicator health = new HealthIndicator(100);
        assertFalse(health.hasDisease());
        health.setActualDisease(new Disease("Fièvre incurable",false,0,10));
        assertTrue(health.hasDisease());
    }

    @Test
    void healthDoesNotDiminishWhenNoDisease(){
        HealthIndicator health = new HealthIndicator(100);
        health.refresh();
        assertEquals(health.getActualValue(),100.0);
    }

    @Test
    void healthDoesDiminishWhenDisease(){
        HealthIndicator health = new HealthIndicator(100);
        health.setActualDisease(new Disease("Fièvre incurable",false,0,10));
        health.refresh();
        assertEquals(health.getActualValue(),90.0);
    }

    @Test
    void diseaseCanCureItself(){
        HealthIndicator health = new HealthIndicator(100);
        health.setActualDisease(new Disease("Fièvre légère",true,2,3));
        health.refresh();
        assertTrue(health.hasDisease());
        health.refresh();
        assertFalse(health.hasDisease());
    }

    @Test
    void treatDiseaseWithMed(){
        HealthIndicator health = new HealthIndicator(100);
        health.setActualDisease(new Disease("Fièvre légère",true,2,3));
        assertTrue(health.hasDisease());
        Medecine med = new Medecine("Doliprane",5, new String[]{"Fièvre légère", "Fièvre modérée", "Migraine"});
        health.treatDisease(med);
        assertFalse(health.hasDisease());
    }

    @Test
    void death(){
        HealthIndicator health = new HealthIndicator(100);
        assertTrue(health.getState());
        health.setActualDisease(new Disease("Maladie foudroyant",false,0,100));
        health.refresh();
        assertFalse(health.getState());
    }
}
