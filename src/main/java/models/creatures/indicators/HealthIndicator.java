package models.creatures.indicators;

import models.creatures.Disease;

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
}
