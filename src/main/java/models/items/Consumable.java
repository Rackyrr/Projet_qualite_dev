package models.items;

import models.creatures.Creature;

public interface Consumable {
    boolean useOn(Creature c);
}
