package models.creatures.indicators;

import models.creatures.Disease;
import models.items.Medecine;

import java.util.Objects;

public class HealthIndicator extends NeedIndicator {
    private Disease actualDisease = null;
    private int nbOfTurnsWithDisease = 0;

    public HealthIndicator(double MAX_VALUE) {
        super(MAX_VALUE);
    }

    public Disease getActualDisease() {
        return actualDisease;
    }

    public void setActualDisease(Disease actualDisease) {
        this.actualDisease = actualDisease;
    }

    public boolean hasDisease(){
        return !Objects.isNull(actualDisease);
    }

    @Override
    public boolean getState() { // alive == true
        return getActualValue() > 0;
    }

    @Override
    public void refresh() {
        if (hasDisease()) {
            removeValue(actualDisease.getDamageToHealth());
            ++nbOfTurnsWithDisease;
            if (actualDisease.isCurableByItself() && (nbOfTurnsWithDisease >= actualDisease.getNaturalHealingTime())) {
                setActualDisease(null);
                nbOfTurnsWithDisease = 0;
            }
        }
    }

    public boolean treatDisease(Medecine med){
        if (med.getTreatedDiseases().contains(actualDisease.getName())){
            actualDisease = null;
            return true;
        }
        return false;
    }
}
