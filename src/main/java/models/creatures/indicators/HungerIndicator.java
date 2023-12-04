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
        if(!starvedState) {
            this.removeValue(hungerRate);
            starvedState = getActualValue() == 0;
        }
    }

    public boolean replenish(Food food){
        if(isAtMaxValue())
            return false;
        else {
            this.addValue(food.getHungerRestore());
            return true;
        }
    }
}
