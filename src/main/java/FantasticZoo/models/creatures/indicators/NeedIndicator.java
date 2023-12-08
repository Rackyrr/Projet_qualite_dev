package FantasticZoo.models.creatures.indicators;

public abstract class NeedIndicator {
    private double maxValue;
    private double actualValue;

    /**
     * Returns the state of the NeedIndicator.
     *
     * @return the state of the NeedIndicator
     */
    public abstract boolean getState();

    /**
     * Refreshes the state of the NeedIndicator.
     *
     * This method is responsible for refreshing the state of the NeedIndicator. It updates the actual value of the indicator based on its specific logic and conditions. The implementation
     * of this method should be provided by the sub-classes of NeedIndicator.
     *
     * Note that this method is abstract and does not contain any implementation. Each sub-class should provide their own implementation in order to refresh the state of the Need
     *Indicator accordingly.
     */
    public abstract void refresh();

    /**
     * Retrieves the maximum value of the NeedIndicator.
     *
     * This method returns the maximum value of the NeedIndicator. The maximum value represents the upper limit of the indicator's value. It is a constant value that is set during
     * the
     * initialization of the NeedIndicator. The maximum value remains unchanged throughout the lifetime of the NeedIndicator.
     *
     * @return the maximum value of the NeedIndicator
     */
    public double getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the maximum value of the NeedIndicator.
     *
     * This method sets the maximum value of the NeedIndicator. The maximum value represents the upper limit of the indicator's value. It should be called during the initialization
     * of the NeedIndicator
     * or whenever there is a need to change the maximum value. The maximum value should be a constant that remains unchanged throughout the lifetime of the NeedIndicator.
     *
     * @param maxValue the new maximum value for the NeedIndicator
     */
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Retrieves the actual value of the NeedIndicator.
     *
     * This method returns the current actual value of the NeedIndicator. The actual value represents the current state or level of the indicator's value. It may change over time
     * and is
     * updated by calling the appropriate methods like addValue() or removeValue(). The actual value can range between 0 and the maximum value of the indicator.
     *
     * @return the actual value of the NeedIndicator
     */
    public double getActualValue() {
        return actualValue;
    }

    /**
     * Sets the actual value of the NeedIndicator.
     *
     * This method sets the actual value of the NeedIndicator. The actual value represents the current state or level of the indicator's value. It should be called when there is a
     * need
     * to update the actual value of the indicator.
     *
     * @param actualValue the new actual value for the NeedIndicator
     */
    public void setActualValue(double actualValue) {
        this.actualValue = actualValue;
    }

    /**
     * Constructs a NeedIndicator object with the specified maximum value.
     *
     * @param MAX_VALUE the maximum value for the NeedIndicator
     *
     * @see NeedIndicator#getMaxValue()
     * @see NeedIndicator#getActualValue()
     * @see NeedIndicator#setActualValue(double)
     */
    public NeedIndicator(double MAX_VALUE) {
        this.maxValue = MAX_VALUE;
        this.actualValue = MAX_VALUE;
    }

    /**
     * Adds the specified amount to the actual value of the NeedIndicator.
     *
     * This method increases the actual value of the NeedIndicator by the specified amount. If the resulting actual value exceeds the maximum value of the NeedIndicator,
     * it will be capped at the maximum value.
     *
     * @param amount the amount to be added*/
    public void addValue(double amount){
        this.actualValue = Math.min(actualValue+amount,this.maxValue);
    }

    /**
     * Removes the specified amount from the actual value of the NeedIndicator.
     * If the resulting actual value would be less than zero, it is capped at zero.
     *
     * @param amount the amount to be removed from the actual value
     */
    public void removeValue(double amount){
        this.actualValue = Math.max(actualValue-amount,0);
    }

    /**
     * Determines whether the actual value of the NeedIndicator is equal to the maximum value.
     *
     * This method compares the actual value of the NeedIndicator with the maximum value. If the actual value is equal to the maximum value, it implies that the NeedIndicator is at
     * its maximum value limit.
     *
     * @return true if the actual value is equal to the maximum value, false otherwise
     */
    public boolean isAtMaxValue(){
        return getActualValue() == getMaxValue();
    }
}
