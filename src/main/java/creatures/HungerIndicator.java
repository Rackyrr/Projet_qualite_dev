package creatures;

import items.Food;

public class HungerIndicator extends NeedIndicator{
    private int hungerRate;
    private boolean starvedState = false;

    public HungerIndicator(int maxValue, int hungerRate) {
        super(maxValue);
        this.hungerRate = hungerRate;
    }

    public boolean getHungerState() {
        return this.getActualValue() <= this.getMaxValue()/2;
    }

    public int getHungerRate() {
        return hungerRate;
    }

    public void setHungerRate(int hungerRate) {
        this.hungerRate = hungerRate;
    }

    public boolean getStarvedState() {
        return starvedState;
    }

    public void setStarvedState(boolean starvedState) {
        this.starvedState = starvedState;
    }

    public void refresh(){
        boolean isStarved = (this.getActualValue() == 0);
        if (isStarved)
            this.starvedState = true;
        else
            this.removeValue(hungerRate);
    }

    public boolean replenish(Food food){
        boolean isIndicatorAtMaxValue = (this.getActualValue() == this.getMaxValue());
        if(isIndicatorAtMaxValue)
            return false;
        else {
            this.addValue(food.getHungerRestore());
            return true;
        }
    }
}
