package models.creatures.indicators;

import models.items.Food;

public class HungerIndicator extends NeedIndicator{
    private double hungerRate;
    private boolean starvedState = false;

    public HungerIndicator(int maxValue, int hungerRate) {
        super(maxValue);
        this.hungerRate = hungerRate;
    }
    @Override
    public boolean getState() {
        return this.getActualValue() <= this.getMaxValue()/2;
    }

    public double getHungerRate() {
        return hungerRate;
    }

    public void setHungerRate(double hungerRate) {
        this.hungerRate = hungerRate;
    }

    public boolean getStarvedState() {
        return starvedState;
    }

    public void setStarvedState(boolean starvedState) {
        this.starvedState = starvedState;
    }
    @Override
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
