package models.creatures.indicators;

import models.creatures.Disease;
import models.items.Medecine;

public class HealthIndicator extends NeedIndicator {
    private Disease actualDisease = null;

    public HealthIndicator(int MAX_VALUE) {
        super(MAX_VALUE);
    }

    public Disease getActualDisease() {
        return actualDisease;
    }

    public void setActualDisease(Disease actualDisease) {
        this.actualDisease = actualDisease;
    }

    public boolean hasDisease(){
        return actualDisease != null;
    }

    @Override
    public boolean getState() { // alive == true
        return getActualValue() > 0;
    }

    @Override
    public void refresh() {
        if (hasDisease())
            removeValue(actualDisease.getDamageToHealth());
    }

    public boolean treatDisease(Medecine med){
        if (med.getTreatedDiseases().contains(actualDisease.getName())){
            actualDisease = null;
            return true;
        }
        return false;
    }
}
