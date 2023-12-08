package FantasticZoo.models.creatures.indicators;

public abstract class NeedIndicator {
    private double maxValue;
    private double actualValue;

    public abstract boolean getState();

    public abstract void refresh();

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getActualValue() {
        return actualValue;
    }

    public void setActualValue(double actualValue) {
        this.actualValue = actualValue;
    }

    public NeedIndicator(double MAX_VALUE) {
        this.maxValue = MAX_VALUE;
        this.actualValue = MAX_VALUE;
    }

    public void addValue(double amount){
        this.actualValue = Math.min(actualValue+amount,this.maxValue);
    }

    public void removeValue(double amount){
        this.actualValue = Math.max(actualValue-amount,0);
    }

    public boolean isAtMaxValue(){
        return getActualValue() == getMaxValue();
    }
}
