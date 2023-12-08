package FantasticZoo.models.creatures.indicators;

public class SleepIndicator extends NeedIndicator{
    private double sleepRate;
    private boolean state = false; // sleeping = true

    /**
     * Constructs a SleepIndicator object with the specified maximum value and sleep rate.
     *
     * @param maxValue the maximum value for the SleepIndicator
     * @param sleepRate the rate at which the sleep value changes
     */
    public SleepIndicator(double maxValue, double sleepRate) {
        super(maxValue);
        this.sleepRate = sleepRate;
    }

    /**
     * Returns the state of the SleepIndicator.
     *
     * @return the state of the SleepIndicator
     */
    @Override
    public boolean getState() {
        return this.state;
    }

    /**
     * Returns the sleep rate of the SleepIndicator.
     *
     * @return the sleep rate of the SleepIndicator
     */
    public double getSleepRate() {
        return sleepRate;
    }

    /**
     * Sets the sleep rate of the SleepIndicator.
     *
     * This method sets the sleep rate of the SleepIndicator. The sleep rate represents the rate at which the sleep value changes. By providing a new sleep rate, you can control the
     *
     * speed at which the sleep value increases or decreases. The sleep rate should be a positive value.
     *
     * @param sleepRate the new sleep rate for the SleepIndicator
     */
    public void setSleepRate(double sleepRate) {
        this.sleepRate = sleepRate;
    }

    /**
     * Refreshes the SleepIndicator.
     *
     * This method updates the state of the SleepIndicator based on the current value and sleep rate.
     * If the SleepIndicator is not sleeping (state = false), it removes the sleep rate from the actual value.
     * If the resulting actual value is 0, it changes the state to true, indicating that the SleepIndicator is going to sleep.
     *
     * If the SleepIndicator is sleeping (state = true), it adds the sleep rate to the actual value.
     * If the actual value is equal to the maximum value, or if it is greater than half of the maximum value and a random number between 0 and 1 is less than or equal to 0.1,
     * it changes the state to false, indicating that the SleepIndicator is waking up.
     *
     * @see #removeValue(double)
     * @see #addValue(double)
     * @see #getActualValue()
     * @see #getMaxValue()
     */
    @Override
    public void refresh(){
        boolean isNotSleeping = !state;
        if(isNotSleeping){
            removeValue(sleepRate);
            state = (getActualValue() == 0); // going to sleep if 0
        } else {
            addValue(sleepRate);
            boolean isWakingUp = (getActualValue() == getMaxValue()) || ((getActualValue() > getMaxValue()/2) && (Math.random() <= 0.1)); // wakes up randomly when sleep value half full or value full
            state = !isWakingUp;
        }
    }
}
