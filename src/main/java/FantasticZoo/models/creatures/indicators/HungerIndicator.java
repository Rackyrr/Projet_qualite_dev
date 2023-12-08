package FantasticZoo.models.creatures.indicators;

import FantasticZoo.models.items.Food;

public class HungerIndicator extends NeedIndicator{
    private double hungerRate;
    private boolean starvedState = false;

    /**
     * Constructs a HungerIndicator object with the specified maximum value and hunger rate.
     *
     * @param maxValue the maximum value of the hunger indicator
     * @param hungerRate the rate at which the hunger indicator decreases over time
     */
    public HungerIndicator(double maxValue, double hungerRate) {
        super(maxValue);
        this.hungerRate = hungerRate;
    }

    /**
     * Determines the state of the HungerIndicator.
     *
     * @return {@code true} if the actual value is less than or equal to half of the maximum value, {@code false} otherwise.
     */
    @Override
    public boolean getState() {
        return this.getActualValue() <= this.getMaxValue()/2;
    }

    /**
     * Retrieves the current hunger rate.
     *
     * @return the rate at which the hunger indicator decreases over time
     */
    public double getHungerRate() {
        return hungerRate;
    }

    /**
     * Sets the hunger rate of the HungerIndicator.
     *
     * @param hungerRate the rate at which the hunger indicator decreases over time
     */
    public void setHungerRate(double hungerRate) {
        this.hungerRate = hungerRate;
    }

    /**
     * Retrieves the current starved state of the HungerIndicator.
     *
     * @return true if the HungerIndicator is in a starved state, false otherwise
     */
    public boolean getStarvedState() {
        return starvedState;
    }

    /**
     * Sets the starved state of the HungerIndicator.
     *
     * @param starvedState the flag indicating the starved state of the HungerIndicator
     */
    public void setStarvedState(boolean starvedState) {
        this.starvedState = starvedState;
    }

    /**
     * Refreshes the HungerIndicator.
     *
     * This method decreases the actual value of the HungerIndicator by the hunger rate if the HungerIndicator is not in a starved state.
     *
     * The HungerIndicator is considered to be in a starved state if the actual value is equal to zero.
     *
     * @see HungerIndicator#removeValue(double)
     * @see HungerIndicator#getActualValue()
     */
    @Override
    public void refresh(){
        if(!starvedState) {
            this.removeValue(hungerRate);
            starvedState = getActualValue() == 0;
        }
    }

    /**
     * Replenishes the hunger indicator with the specified food.
     *
     * @param food the food to replenish the hunger indicator
     * @return true if the hunger indicator was replenished, false otherwise
     */
    public boolean replenish(Food food){
        if(isAtMaxValue())
            return false;
        else {
            this.addValue(food.getHungerRestore());
            return true;
        }
    }
}
