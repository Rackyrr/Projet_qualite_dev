package models.creatures.indicators;

public class SleepIndicator extends NeedIndicator{
    private double sleepRate;
    private boolean state = false; // sleeping = true

    public SleepIndicator(double maxValue, double sleepRate) {
        super(maxValue);
        this.sleepRate = sleepRate;
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    public double getSleepRate() {
        return sleepRate;
    }

    public void setSleepRate(double sleepRate) {
        this.sleepRate = sleepRate;
    }
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
