package creatures;

public abstract class NeedIndicator {
    private int maxValue;
    private int actualValue;

    public abstract boolean getState();

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    public NeedIndicator(int MAX_VALUE) {
        this.maxValue = MAX_VALUE;
        this.actualValue = MAX_VALUE;
    }

    public void addValue(int amount){
        this.actualValue = Math.min(actualValue+amount,this.maxValue);
    }

    public void removeValue(int amount){
        this.actualValue = Math.max(actualValue-amount,0);
    }
}
