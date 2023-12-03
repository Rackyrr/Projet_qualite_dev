package models.creatures.indicators;

public class SleepIndicator extends NeedIndicator{
    private int sleepRate;
    private boolean state; // sleeping = true

    public SleepIndicator(int maxValue, int sleepRate) {
        super(maxValue);
        this.sleepRate = sleepRate;
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    public int getSleepRate() {
        return sleepRate;
    }

    public void setSleepRate(int sleepRate) {
        this.sleepRate = sleepRate;
    }

    public void refresh(){
        boolean isGonnaSleep = (getActualValue() == 0);
        if (isGonnaSleep) {
            state = true;
            addValue(sleepRate);
            return;
        }
        boolean hasSleptEnough = (getActualValue() > getMaxValue()/2) && state;
        if (hasSleptEnough)
            state = false;
        removeValue(sleepRate);
    }
}
