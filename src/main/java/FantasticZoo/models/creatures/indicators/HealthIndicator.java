package FantasticZoo.models.creatures.indicators;

import FantasticZoo.models.creatures.Disease;
import FantasticZoo.models.items.Medecine;

import java.util.Objects;

public class HealthIndicator extends NeedIndicator {
    private Disease actualDisease = null;
    private int nbOfTurnsWithDisease = 0;

    /**
     * Constructs a new HealthIndicator object with the specified maximum value.
     *
     * @param MAX_VALUE the maximum value for the health indicator
     */
    public HealthIndicator(double MAX_VALUE) {
        super(MAX_VALUE);
    }

    /**
     * Retrieves the actual disease that the HealthIndicator is currently afflicted with.
     *
     * @return the actual disease of the HealthIndicator
     */
    public Disease getActualDisease() {
        return actualDisease;
    }

    /**
     * Sets the actual disease that the HealthIndicator is currently afflicted with.
     *
     * @param actualDisease the actual disease to be set
     */
    public void setActualDisease(Disease actualDisease) {
        this.actualDisease = actualDisease;
    }

    /**
     * Checks if the HealthIndicator has an actual disease.
     *
     * @return true if the HealthIndicator has a disease, false otherwise
     */
    public boolean hasDisease(){
        return !Objects.isNull(actualDisease);
    }

    /**
     * Retrieves the state of the HealthIndicator.
     *
     * @return true if the HealthIndicator's value is greater than 0, false otherwise
     */
    @Override
    public boolean getState() { // alive == true
        return getActualValue() > 0;
    }

    /**
     * Refreshes the state of the HealthIndicator. If the HealthIndicator has a disease,
     * it reduces the health value by the damage caused by the disease. It also
     * increments the number of turns with the disease. If the disease is curable
     * by itself and the number of turns with the disease exceeds its natural
     * healing time, the actual disease is set to null and the number of turns is
     * reset to 0.
     */
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

    /**
     * Treats the disease of the HealthIndicator with the given medicine.
     *
     * @param med the medicine used to treat the disease
     * @return true if the disease is treated successfully, false otherwise
     */
    public boolean treatDisease(Medecine med){
        if (med.getTreatedDiseases().contains(actualDisease.getName())){
            actualDisease = null;
            return true;
        }
        return false;
    }
}
