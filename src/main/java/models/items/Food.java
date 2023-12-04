package models.items;

import models.creatures.Creature;

public class Food extends Item implements Consumable{
    private int hungerRestore;

    public Food(String name, double price, int hungerRestore) {
        super(name, price);
        this.hungerRestore = hungerRestore;
    }

    public int getHungerRestore() {
        return hungerRestore;
    }

    public void setHungerRestore(int hungerRestore) {
        this.hungerRestore = hungerRestore;
    }

    @Override
    public boolean useOn(Creature c) {
        return c.eat(this);
    }
}
